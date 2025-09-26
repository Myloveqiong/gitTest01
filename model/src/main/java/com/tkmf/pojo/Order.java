package com.tkmf.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Table(name = "hanma_order")
public class Order {
    /**
     * 订单号
     */
    @Id
    @Column(name = "order_no")
    private String orderNo;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 用户名字
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 用户电话
     */
    @Column(name = "user_phone")
    private String userPhone;

    /**
     * 用户地址
     */
    @Column(name = "user_address")
    private String userAddress;

    /**
     * 用户微信openid
     */
    @Column(name = "user_openid")
    private String userOpenid;

    /**
     * 商铺id
     */
    @Column(name = "shop_id")
    private Integer shopId;

    /**
     * 商铺名称
     */
    @Column(name = "shop_name")
    private String shopName;

    /**
     * 订单总金额
     */
    @Column(name = "order_amount")
    private BigDecimal orderAmount;

    /**
     * 支付时间
     */
    @Column(name = "pay_time")
    private String payTime;

    /**
     * 0等待支付 1支付成功
     */
    @Column(name = "pay_status")
    private Integer payStatus;

    /**
     * 0未支付 1已支付  2已取消  3未发货  4已发货  
     */
    @Column(name = "order_status")
    private Integer orderStatus;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;


}