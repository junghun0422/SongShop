package com.song.shop.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class LogAspect 
{
	private static Logger log = LoggerFactory.getLogger( LogAspect.class );
	
	@Around( "@annotation(LogExecutionTime)" )
	public Object logExecutionTime( ProceedingJoinPoint joinPoint ) throws Throwable
	{
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		// @LogExecutionTime 어노테이션이 붙어있는 타겟 메서트 실행.
		Object proceed = joinPoint.proceed();
		
		stopWatch.stop();
		
		log.info( stopWatch.prettyPrint() );
		
		return proceed;
	}
}
