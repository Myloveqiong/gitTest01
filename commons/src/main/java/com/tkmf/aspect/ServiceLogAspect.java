package com.tkmf.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceLogAspect {
    public static final Logger log = LoggerFactory.getLogger(ServiceLogAspect.class);

    @Around("execution(* com.tkmf.*.service.impl.*.*(..))")
    public Object recordTimeLog(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("开始执行");
        joinPoint.getTarget();
        joinPoint.getSignature();

        //记录开始时间
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        if(totalTime > 3000){
            log.error("执行结束，耗时{}",totalTime);
        } else if (totalTime > 2000) {
            log.warn("执行结束，耗时{}",totalTime);
        }else {
            log.info("执行结束，耗时{}",totalTime);
        }
        return result;

    }
}
