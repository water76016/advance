package com.water76016.advance.aop.demo;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @program: advance
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2023-05-07 00:20
 **/
@Component
@Aspect
public class UserServiceAop {
    @Pointcut("execution(* com.water76016.advance.aop.demo.UserServiceImpl.* (..))")
    public void userCut(){}

    @Before(value = "userCut()")
    public void before(){
        System.out.println("我是before，在方法执行之前执行");
    }

    @After(value = "userCut()")
    public void after(){
        System.out.println("我是after，在方法执行之后执行");
    }

    @AfterReturning(value = "userCut()", returning = "returnObject")
    public void afterReturning(Object returnObject){
        System.out.println("我是afterReturning，我可以获取方法的返回值，该方法的返回值为：" + returnObject.toString());
    }

}
