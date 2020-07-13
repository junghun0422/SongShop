package com.song.shop.repository.querydsl;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.song.shop.entity.ProductEntity;
import com.song.shop.entity.QProductEntity;

@Repository
public class ProductRepositorySupport extends QuerydslRepositorySupport
{
	private final JPAQueryFactory query;

	public ProductRepositorySupport(JPAQueryFactory query) 
	{
		super(ProductEntity.class);
		this.query = query;
	}
	
	public List<ProductEntity> findByRegisterId(String registerId)
	{
//		return queryFactory
//				.select((Projections.fields(ProductEntity.class, CategoryEntity.class, )))
//				.from(product)

//		List<ProductEntity> list = queryFactory
//				.selectFrom(category)
//				.leftJoin()

		return null;
		
	}
	
}
