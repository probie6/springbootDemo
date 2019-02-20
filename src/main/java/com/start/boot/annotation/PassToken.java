package com.start.boot.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD,ElementType.TYPE})//此注解用在方法，接口，类，枚举，注解上
@Retention(RetentionPolicy.RUNTIME) //注解在运行时保留
public @interface PassToken {
    boolean required() default true;
}
