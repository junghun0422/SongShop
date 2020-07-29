package com.song.shop.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;

@Target( ElementType.METHOD )			// 어노테이션을 메소드에 사용한다는 설정.
@Retention( RetentionPolicy.RUNTIME )	// 어노테이션이 RUNTIME까지 유지되도록 설정
public @interface LogExecutionTime { }
