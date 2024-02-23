package malgepav.dz6basic.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class Logger {
    @AfterReturning(value = "@annotation(TrackUserAction)", returning = "returning")
    public void logMethodCall(JoinPoint joinPoint, Object returning) {
        System.out.printf("Method %s was called. Returned %s\n",
                joinPoint.getSignature().getName(),
                returning.getClass());
    }

    @AfterThrowing(value = "@annotation(TrackUserAction)", throwing = "e")
    public void logExceptionThrowing(JoinPoint joinPoint, Exception e) {
        System.out.printf("Method %s threw an exception: %s: %s",
                joinPoint.getSignature().getName(),
                e.getClass(),
                e.getMessage());
    }

}
