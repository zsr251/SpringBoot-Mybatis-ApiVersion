package com.jc.util.apiVersion;

/**
 * 默认参数值
 * Created by jasonzhu on 2016/11/30.
 */
public enum DefaultValueEnum {
    /**
     * 按照类型赋默认值
     * String ""
     * Boolean false
     * Integer 0
     * Long 0
     * 其他 null
     */
    DEFAULT,
    NULL,
    STRING_EMPTY,
    ZERO,
    FALSE,
    TRUE
}
