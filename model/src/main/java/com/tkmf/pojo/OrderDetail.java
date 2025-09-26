package com.tkmf.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Table(name = "hanma_order_detail")
public class OrderDetail {
    /**
     * 订单详情编号
     */
    @Id
    @Column(name = "detail_id")
    private String detailId;

    /**
     * 订单号
     */
    @Column(name = "order_no")
    private String orderNo;

    /**
     * 商品ID
     */
    @Column(name = "product_id")
    private Integer productId;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 购买价格，当前价格,单位分
     */
    private BigDecimal price;

    /**
     * 购买数量
     */
    private Integer quantity;

    /**
     * 商品图片
     */
    @Column(name = "img_url")
    private String imgUrl;

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