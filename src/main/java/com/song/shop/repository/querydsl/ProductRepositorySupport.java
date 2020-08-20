package com.song.shop.repository.querydsl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.song.shop.entity.CategoryEntity;
import com.song.shop.entity.ProductEntity;
import com.song.shop.entity.QCategoryEntity;
import com.song.shop.entity.QProductEntity;

/**
 * Product QueryDsl
 * @author Song
 */
@Repository
public class ProductRepositorySupport extends QuerydslRepositorySupport
{
	private static Logger log = LoggerFactory.getLogger( ProductRepositorySupport.class );
	
	@Autowired
	private JPAQueryFactory jpaQuery;
	
	@Autowired
	private EntityManager em;

	public ProductRepositorySupport( JPAQueryFactory jpaQuery ) 
	{
		super( ProductEntity.class );
		this.jpaQuery = jpaQuery;
	}
	
	// querydsl
	public List<ProductEntity> findByRegisterId( String registerId )
	{
		QCategoryEntity categroy = QCategoryEntity.categoryEntity;
		QProductEntity product = QProductEntity.productEntity;

		return jpaQuery
				.selectFrom( product )
				.leftJoin( product.category, categroy )
				.where( product.registerId.eq( registerId ) )
				.orderBy( categroy.categoryCode.desc() )
				.fetch();
	}	
	
	// jpql
	public String jpqlTest( String registerId )
	{
		CriteriaBuilder builder = em.getCriteriaBuilder();
		
		CriteriaQuery<Tuple> query = builder.createTupleQuery();
		
		Root<ProductEntity> root = query.from( ProductEntity.class );

		// JPQL에서 조인구문과 연관 엔티티의 별칭.
		Join<CategoryEntity, ProductEntity> c = root.join( "category", JoinType.INNER );
		
		query
			.multiselect( root.alias( "p" ), c.alias("c") )
			// root.get param은 Entity param 명대로.
			.where( builder.equal( root.get( "registerId" ), registerId ) ); 
		
		TypedQuery<Tuple> queryString = em.createQuery( query );
		List<Tuple> resultList = queryString.getResultList();
		System.out.println( " size :: " + resultList.size() );
		
		resultList.forEach( ( x ) -> System.out.println( x ) );
		
		resultList.forEach(System.out::println);
		
		return "TEST";
	}
}
