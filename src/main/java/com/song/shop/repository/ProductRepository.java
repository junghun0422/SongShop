package com.song.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.song.shop.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> 
{

}
