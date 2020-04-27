package com.song.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.song.shop.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> { }
