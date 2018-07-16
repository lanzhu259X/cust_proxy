package com.lanzhu.ssp.entities;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private Integer id;

    private String orderNo;

    private Integer makeUserId;

    private Integer superUserId;

    private Integer lowUserId;

    private BigDecimal paySuperAmount;

    private BigDecimal payLowAmount;

    private String recieveAddrass;

    private Boolean superPayStatus;

    private Boolean lowPayStatus;

    private String status;

    private String comment;

    private Integer fileId;

    private String createdBy;

    private String updatedBy;

    private Date createdTime;

    private Date updatedTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Integer getMakeUserId() {
        return makeUserId;
    }

    public void setMakeUserId(Integer makeUserId) {
        this.makeUserId = makeUserId;
    }

    public Integer getSuperUserId() {
        return superUserId;
    }

    public void setSuperUserId(Integer superUserId) {
        this.superUserId = superUserId;
    }

    public Integer getLowUserId() {
        return lowUserId;
    }

    public void setLowUserId(Integer lowUserId) {
        this.lowUserId = lowUserId;
    }

    public BigDecimal getPaySuperAmount() {
        return paySuperAmount;
    }

    public void setPaySuperAmount(BigDecimal paySuperAmount) {
        this.paySuperAmount = paySuperAmount;
    }

    public BigDecimal getPayLowAmount() {
        return payLowAmount;
    }

    public void setPayLowAmount(BigDecimal payLowAmount) {
        this.payLowAmount = payLowAmount;
    }

    public String getRecieveAddrass() {
        return recieveAddrass;
    }

    public void setRecieveAddrass(String recieveAddrass) {
        this.recieveAddrass = recieveAddrass == null ? null : recieveAddrass.trim();
    }

    public Boolean getSuperPayStatus() {
        return superPayStatus;
    }

    public void setSuperPayStatus(Boolean superPayStatus) {
        this.superPayStatus = superPayStatus;
    }

    public Boolean getLowPayStatus() {
        return lowPayStatus;
    }

    public void setLowPayStatus(Boolean lowPayStatus) {
        this.lowPayStatus = lowPayStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}