package com.song.shop.repository.querydsl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPADeleteClause;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import com.song.shop.entity.CategoryEntity;
import com.song.shop.entity.ProductEntity;
import com.song.shop.entity.QCategoryEntity;
import com.song.shop.entity.QProductEntity;

@Repository
public class ProductRepositorySupport extends QuerydslRepositorySupport
{
	@Autowired
	private JPAQueryFactory query;

	public ProductRepositorySupport(JPAQueryFactory query) 
	{
		super(ProductEntity.class);
		this.query = query;
	}
	
	@SuppressWarnings("unchecked")
	public List<ProductEntity> findByRegisterId(String registerId)
	{
		QCategoryEntity categroy = QCategoryEntity.categoryEntity;
		QProductEntity product = QProductEntity.productEntity;

		// SELECT LIST
		return (List<ProductEntity>) query	
				.selectFrom(categroy).join(categroy)
				.on(categroy.category_seq.eq(product.category.category_seq))
				.where(categroy.registor_id.eq(registerId));
	}	
	
	public void insertCategory(CategoryEntity category)
	{
		
	}
	
	public void insertProduct(ProductEntity product)
	{
		
	}
}
