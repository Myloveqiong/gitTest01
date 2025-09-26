package com.hanma.pojo;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

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
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取订单详情编号
     *
     * @return detail_id - 订单详情编号
     */
    public String getDetailId() {
        return detailId;
    }

    /**
     * 设置订单详情编号
     *
     * @param detailId 订单详情编号
     */
    public void setDetailId(String detailId) {
        this.detailId = detailId;
    }

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
     * 获取商品ID
     *
     * @return product_id - 商品ID
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 设置商品ID
     *
     * @param productId 商品ID
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 获取商品名称
     *
     * @return name - 商品名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置商品名称
     *
     * @param name 商品名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取购买价格，当前价格,单位分
     *
     * @return price - 购买价格，当前价格,单位分
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置购买价格，当前价格,单位分
     *
     * @param price 购买价格，当前价格,单位分
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取购买数量
     *
     * @return quantity - 购买数量
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * 设置购买数量
     *
     * @param quantity 购买数量
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * 获取商品图片
     *
     * @return img_url - 商品图片
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * 设置商品图片
     *
     * @param imgUrl 商品图片
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
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