package com.jc.util.apiVersion;

import java.lang.annotation.*;

/**
 * 需要拦截的API接口方法
 * Created by jasonzhu on 2016/11/28.
 */

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiVersion {
    /**
     * 指定执行操作的类名
     */
    Class targetClass();

    /**
     * 指定执行操作的方法名前缀
     */
    String methodPreName() default "";

}
