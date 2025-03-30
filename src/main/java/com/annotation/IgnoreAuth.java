package com.annotation;

import java.lang.annotation.*;

/**
 * 用于忽略 Token 验证的自定义注解。
 * 在需要进行身份验证的系统中
 * 通常会要求用户提供有效的 Token 来验证其身份。
 */
@Target(ElementType.METHOD)//表明该注解只能用于方法上。当一个方法被 @IgnoreAuth 注解标记时，表示在调用该方法时不需要进行 Token 验证。
@Retention(RetentionPolicy.RUNTIME)//表示该注解在运行时仍然可用，以便在程序运行时通过反射机制判断某个方法是否需要忽略 Token 验证。
@Documented//表示该注解会被包含在 JavaDoc 中。
public @interface IgnoreAuth {

}
