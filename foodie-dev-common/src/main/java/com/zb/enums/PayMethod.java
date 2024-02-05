package com.zb.enums;

/**
 * @Author: zhaobao1830
 * @Date: 2024-02-05 11:49
 * @Description: 支付方式枚举
 */

public enum PayMethod {

    WEIXIN(1, "微信"),
    ALIPAY(2, "支付宝");

    public final Integer type;
    public final String value;

    PayMethod(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}
