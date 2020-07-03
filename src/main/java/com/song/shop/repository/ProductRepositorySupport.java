package com.song.shop.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.song.shop.entity.ProductEntity;

@Repository // 사용해보자이
public class ProductRepositorySupport extends QuerydslRepositorySupport
{
	private final JPAQueryFactory jpaQueryFactory;
	
	public ProductRepositorySupport(JPAQueryFactory jpaQueryFactory)
	{
		super(ProductEntity.class);
		this.jpaQueryFactory = jpaQueryFactory;
	}
	
	public List<ProductEntity> findByRegisterId(String register_id)
	{
		List<ProductEntity> list = new ArrayList<>();
		
		
		
		return list;
	}
	
}
