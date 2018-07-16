package com.lanzhu.ssp.entities;

import java.math.BigDecimal;

public class OrderDetail {
    private Integer id;

    private Integer orderId;

    private Integer goodsId;

    private BigDecimal superPrice;

    private BigDecimal lowPrice;

    private Integer buyQuantity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public BigDecimal getSuperPrice() {
        return superPrice;
    }

    public void setSuperPrice(BigDecimal superPrice) {
        this.superPrice = superPrice;
    }

    public BigDecimal getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(BigDecimal lowPrice) {
        this.lowPrice = lowPrice;
    }

    public Integer getBuyQuantity() {
        return buyQuantity;
    }

    public void setBuyQuantity(Integer buyQuantity) {
        this.buyQuantity = buyQuantity;
    }
}