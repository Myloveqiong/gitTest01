package com.hanma.pojo;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

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
    private Boolean payStatus;

    /**
     * 0未支付 1已支付  2已取消  3未发货  4已发货  
     */
    @Column(name = "order_status")
    private Boolean orderStatus;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取订单号
     *
     * @return order_no - 订单号
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 设置订单号
     *
     * @param orderNo 订单号
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取用户名字
     *
     * @return user_name - 用户名字
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名字
     *
     * @param userName 用户名字
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取用户电话
     *
     * @return user_phone - 用户电话
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * 设置用户电话
     *
     * @param userPhone 用户电话
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    /**
     * 获取用户地址
     *
     * @return user_address - 用户地址
     */
    public String getUserAddress() {
        return userAddress;
    }

    /**
     * 设置用户地址
     *
     * @param userAddress 用户地址
     */
    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    /**
     * 获取用户微信openid
     *
     * @return user_openid - 用户微信openid
     */
    public String getUserOpenid() {
        return userOpenid;
    }

    /**
     * 设置用户微信openid
     *
     * @param userOpenid 用户微信openid
     */
    public void setUserOpenid(String userOpenid) {
        this.userOpenid = userOpenid;
    }

    /**
     * 获取商铺id
     *
     * @return shop_id - 商铺id
     */
    public Integer getShopId() {
        return shopId;
    }

    /**
     * 设置商铺id
     *
     * @param shopId 商铺id
     */
    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    /**
     * 获取商铺名称
     *
     * @return shop_name - 商铺名称
     */
    public String getShopName() {
        return shopName;
    }

    /**
     * 设置商铺名称
     *
     * @param shopName 商铺名称
     */
    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    /**
     * 获取订单总金额
     *
     * @return order_amount - 订单总金额
     */
    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    /**
     * 设置订单总金额
     *
     * @param orderAmount 订单总金额
     */
    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    /**
     * 获取支付时间
     *
     * @return pay_time - 支付时间
     */
    public String getPayTime() {
        return payTime;
    }

    /**
     * 设置支付时间
     *
     * @param payTime 支付时间
     */
    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    /**
     * 获取0等待支付 1支付成功
     *
     * @return pay_status - 0等待支付 1支付成功
     */
    public Boolean getPayStatus() {
        return payStatus;
    }

    /**
     * 设置0等待支付 1支付成功
     *
     * @param payStatus 0等待支付 1支付成功
     */
    public void setPayStatus(Boolean payStatus) {
        this.payStatus = payStatus;
    }

    /**
     * 获取0未支付 1已支付  2已取消  3未发货  4已发货  
     *
     * @return order_status - 0未支付 1已支付  2已取消  3未发货  4已发货  
     */
    public Boolean getOrderStatus() {
        return orderStatus;
    }

    /**
     * 设置0未支付 1已支付  2已取消  3未发货  4已发货  
     *
     * @param orderStatus 0未支付 1已支付  2已取消  3未发货  4已发货  
     */
    public void setOrderStatus(Boolean orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     *
     * @return update_time - 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}