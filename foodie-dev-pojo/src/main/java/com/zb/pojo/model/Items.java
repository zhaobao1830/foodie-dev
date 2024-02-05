package com.zb.pojo.model;

import java.util.Date;

public class Items {
    private String id;

    private String itemName;

    private Integer catId;

    private Integer rootCatId;

    private Integer sellCounts;

    private Integer onOffStatus;

    private Date createdTime;

    private Date updatedTime;

    private String content;

    public Items(String id, String itemName, Integer catId, Integer rootCatId, Integer sellCounts, Integer onOffStatus, Date createdTime, Date updatedTime, String content) {
        this.id = id;
        this.itemName = itemName;
        this.catId = catId;
        this.rootCatId = rootCatId;
        this.sellCounts = sellCounts;
        this.onOffStatus = onOffStatus;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
        this.content = content;
    }

    public Items() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public Integer getRootCatId() {
        return rootCatId;
    }

    public void setRootCatId(Integer rootCatId) {
        this.rootCatId = rootCatId;
    }

    public Integer getSellCounts() {
        return sellCounts;
    }

    public void setSellCounts(Integer sellCounts) {
        this.sellCounts = sellCounts;
    }

    public Integer getOnOffStatus() {
        return onOffStatus;
    }

    public void setOnOffStatus(Integer onOffStatus) {
        this.onOffStatus = onOffStatus;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}