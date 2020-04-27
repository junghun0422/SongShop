package com.song.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.song.shop.entity.GroupEntity;

public interface GroupRepository extends JpaRepository<GroupEntity, Long> { }
