package com.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 登录用户信息
 * 一个自定义注解，用于标记方法参数。
 * 当一个方法的参数被 @APPLoginUser 注解标记时，
 * 通常表示该参数需要注入当前登录用户的信息。
 */
//这是一个自定义注解，用于标记方法参数。当一个方法的参数被 @APPLoginUser 注解标记时，通常表示该参数需要注入当前登录用户的信息。
@Target(ElementType.PARAMETER)  //表明该注解只能用于方法的参数上。
@Retention(RetentionPolicy.RUNTIME)  //表示该注解在运行时仍然可用，这样可以在程序运行时通过反射机制获取该注解信息。
public @interface APPLoginUser {

}
