package com.song.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.song.shop.entity.ProductEntity;

/**
 * 기본 JPA Interface
 * @author Song
 */
public interface ProductRepository extends JpaRepository<ProductEntity, Long> 
{
	List<ProductEntity> findByRegisterId( String registerId );
}
