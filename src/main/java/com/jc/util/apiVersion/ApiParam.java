package com.jc.util.apiVersion;

import java.lang.annotation.*;

/**
 * 处理方法的参数注解
 * Created by jasonzhu on 2016/11/30.
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiParam {
    /**
     * 参数名
     */
    String value();

    /**
     * 是否必须有值 默认必须有
     */
    boolean required() default true;

    /**
     * 值非必须时 如果未传值 默认值
     */
    DefaultValueEnum defaultValue() default DefaultValueEnum.DEFAULT;
}
