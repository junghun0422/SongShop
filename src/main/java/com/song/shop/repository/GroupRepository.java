package com.song.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.song.shop.entity.GroupEntity;

/**
 * 기본 JPA Interface
 * @author Song
 */
public interface GroupRepository extends JpaRepository<GroupEntity, Long> { }
