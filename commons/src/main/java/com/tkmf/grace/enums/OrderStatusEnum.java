package com.tkmf.grace.enums;

import lombok.Data;
import lombok.Getter;

@Getter
public enum OrderStatusEnum {
    NOT_PAY(0,"未支付"),
    YES_PAY(1,"已支付"),
    CANCEL(2,"已取消"),
    NO_SEND(3,"未发货"),
    YES_SEND(4,"已发货"),
    ACCEPT_OK(5,"已接单"),
    ORDER_FINISH(6,"已签收");
    private Integer status;
    private String message;
    OrderStatusEnum(Integer status, String message) {
        this.status = status;
        this.message = message;
    }


}
