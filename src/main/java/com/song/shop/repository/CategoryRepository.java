package com.song.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.song.shop.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer>
{

}
