package com.zb.enums;

/**
 * @Author: zhaobao1830
 * @Date: 2021/4/1 16:35
 */
public enum YesOrNo {
    NO(0, "否"),
    YES(1, "是");

    public final Integer type;
    public final String value;

    YesOrNo(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}
