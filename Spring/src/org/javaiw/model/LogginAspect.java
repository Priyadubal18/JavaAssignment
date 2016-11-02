package org.javaiw.model;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LogginAspect {
	
	
	@Before("execution(public * *(..))")
	public void logAdvice(){
		System.out.println("Log advice running");
	}

}
