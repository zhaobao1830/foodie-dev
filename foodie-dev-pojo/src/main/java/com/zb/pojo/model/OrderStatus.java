package com.zb.pojo.model;

import java.util.Date;

public class OrderStatus {
    private String orderId;

    private Integer orderStatus;

    private Date createdTime;

    private Date payTime;

    private Date deliverTime;

    private Date successTime;

    private Date closeTime;

    private Date commentTime;

    public OrderStatus(String orderId, Integer orderStatus, Date createdTime, Date payTime, Date deliverTime, Date successTime, Date closeTime, Date commentTime) {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
        this.createdTime = createdTime;
        this.payTime = payTime;
        this.deliverTime = deliverTime;
        this.successTime = successTime;
        this.closeTime = closeTime;
        this.commentTime = commentTime;
    }

    public OrderStatus() {
        super();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getDeliverTime() {
        return deliverTime;
    }

    public void setDeliverTime(Date deliverTime) {
        this.deliverTime = deliverTime;
    }

    public Date getSuccessTime() {
        return successTime;
    }

    public void setSuccessTime(Date successTime) {
        this.successTime = successTime;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }
}