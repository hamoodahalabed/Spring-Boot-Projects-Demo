package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(
            ProceedingJoinPoint theproceedingJoinPoint) throws Throwable {


        String method = theproceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>>> executing @Around on method: " + method);

        Long begin = System.currentTimeMillis();

        Object result = null;

        try {
            result = theproceedingJoinPoint.proceed(); //execute target method
        }
        catch (Exception exc) {
            System.out.println(exc.getMessage());

            //result = "Major accident! But no worries, your private AOP helicopter is on the way!";
            throw exc;
        }
        Long end = System.currentTimeMillis();

        Long duration = end - begin;

        System.out.println("\n=======> Duration: " + duration / 1000 + " Seconds");

        return result;
    }

    @After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountAdvice(JoinPoint theJoinPoint) {

        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>>> executing @After (finally) on method: " + method);

    }

    @AfterThrowing (
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc")
    public void afterThrowingFindAccountAdvice (
            JoinPoint theJoinPoint, Throwable theExc) {

        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>>> executing @AfterThrowing on method: " + method);

        System.out.println("\n=====>>>> the exception is: " + theExc);

    }

    @AfterReturning(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>>>> executing @AfterReturning on method: " + method);

        System.out.println("\n=====>>>> result is: " + result);

        convertAcountNameToUpperCase(result);
    }

    private void convertAcountNameToUpperCase(List<Account> result) {

        for(Account tempAccount: result) {
            String theUpperCase = tempAccount.getName().toUpperCase();
            tempAccount.setName(theUpperCase);
        }
    }


    @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoSetterAndGetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {

        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();

        System.out.println("Method: " + methodSignature);

        Object[] args = theJoinPoint.getArgs();

        for (Object tempArg : args) {
            System.out.println(tempArg);

            if (tempArg instanceof Account) {
                Account theAccount = (Account) tempArg;

                System.out.println("account name: " + theAccount.getName());
                System.out.println("account level: " + theAccount.getLevel());
            }
        }

    }



}
