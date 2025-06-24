package com.tkmf.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Data
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


}