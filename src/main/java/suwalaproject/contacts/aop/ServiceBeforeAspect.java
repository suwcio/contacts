package suwalaproject.contacts.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class ServiceBeforeAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* suwalaproject.contacts.services.impl.*.*(..))")
    public void before(JoinPoint joinPoint){
        logger.info("Check for services access");
        logger.info("Allowed execution for {}", joinPoint.toString());
    }
}
