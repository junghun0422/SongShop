package com.song.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.song.shop.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> 
{

}
