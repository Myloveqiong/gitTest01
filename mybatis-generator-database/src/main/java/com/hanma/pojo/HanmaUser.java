package com.hanma.pojo;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "hanma_user")
public class HanmaUser {
    @Id
    private Integer id;

    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 微信标识openid
     */
    private String openid;

    /**
     * ID编号
     */
    private String numbers;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 手机
     */
    private String mobile;

    /**
     * 红包
     */
    private BigDecimal money;

    /**
     * 优惠券
     */
    private Byte coupons;

    /**
     * 金币
     */
    private BigDecimal gold;

    /**
     * 白条
     */
    private BigDecimal iou;

    /**
     * 0禁止 1正常
     */
    private Boolean status;

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
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取账号
     *
     * @return username - 账号
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置账号
     *
     * @param username 账号
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取微信标识openid
     *
     * @return openid - 微信标识openid
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * 设置微信标识openid
     *
     * @param openid 微信标识openid
     */
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    /**
     * 获取ID编号
     *
     * @return numbers - ID编号
     */
    public String getNumbers() {
        return numbers;
    }

    /**
     * 设置ID编号
     *
     * @param numbers ID编号
     */
    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    /**
     * 获取昵称
     *
     * @return nickname - 昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置昵称
     *
     * @param nickname 昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取手机
     *
     * @return mobile - 手机
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机
     *
     * @param mobile 手机
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取红包
     *
     * @return money - 红包
     */
    public BigDecimal getMoney() {
        return money;
    }

    /**
     * 设置红包
     *
     * @param money 红包
     */
    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    /**
     * 获取优惠券
     *
     * @return coupons - 优惠券
     */
    public Byte getCoupons() {
        return coupons;
    }

    /**
     * 设置优惠券
     *
     * @param coupons 优惠券
     */
    public void setCoupons(Byte coupons) {
        this.coupons = coupons;
    }

    /**
     * 获取金币
     *
     * @return gold - 金币
     */
    public BigDecimal getGold() {
        return gold;
    }

    /**
     * 设置金币
     *
     * @param gold 金币
     */
    public void setGold(BigDecimal gold) {
        this.gold = gold;
    }

    /**
     * 获取白条
     *
     * @return iou - 白条
     */
    public BigDecimal getIou() {
        return iou;
    }

    /**
     * 设置白条
     *
     * @param iou 白条
     */
    public void setIou(BigDecimal iou) {
        this.iou = iou;
    }

    /**
     * 获取0禁止 1正常
     *
     * @return status - 0禁止 1正常
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置0禁止 1正常
     *
     * @param status 0禁止 1正常
     */
    public void setStatus(Boolean status) {
        this.status = status;
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