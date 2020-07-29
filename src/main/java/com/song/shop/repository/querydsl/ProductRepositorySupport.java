package com.song.shop.repository.querydsl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.song.shop.entity.ProductEntity;
import com.song.shop.entity.QCategoryEntity;
import com.song.shop.entity.QProductEntity;

@Repository
public class ProductRepositorySupport extends QuerydslRepositorySupport
{
	private static Logger log = LoggerFactory.getLogger( ProductRepositorySupport.class );
	
	@Autowired
	private JPAQueryFactory query;

	public ProductRepositorySupport( JPAQueryFactory query ) 
	{
		super( ProductEntity.class );
		this.query = query;
	}
	
	public List<ProductEntity> findByRegisterId( String registerId )
	{
		QCategoryEntity categroy = QCategoryEntity.categoryEntity;
		QProductEntity product = QProductEntity.productEntity;

		return query
				.selectFrom( product )
				.leftJoin( product.category, categroy )
				.where( product.registerId.eq( registerId ) )
				.orderBy( categroy.categoryCode.desc() )
				.fetch();
	}	
}
