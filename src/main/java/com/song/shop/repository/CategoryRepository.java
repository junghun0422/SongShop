package com.song.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.song.shop.entity.CategoryEntity;

/**
 * 기본 JPA Interface
 * @author Song
 */
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> { }
