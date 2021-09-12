package com.perficient.mtp.commons.logging;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LoggingExecutionTimeAspect {

  	@Value("${spring.application.name}")
  	private String appName;

  	@Around("@annotation(com.perficient.mtp.commons.logging.LogExecutionTime)")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
  	    long start = System.currentTimeMillis();

  	    Object proceed = joinPoint.proceed();

  	    long executionTime = System.currentTimeMillis() - start;

		String methodName = joinPoint.getSignature().toShortString();
		Object[] args = joinPoint.getArgs();
		log.info(appName + ".trace." + methodName + ":" + Arrays.toString(args) + " (" + executionTime + "ms)");
		
  	    return proceed;
	}
}
