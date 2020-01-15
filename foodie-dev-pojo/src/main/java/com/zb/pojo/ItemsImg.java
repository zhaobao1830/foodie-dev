package com.zb.pojo;

import java.util.Date;

public class ItemsImg {
    private String id;

    private String itemId;

    private String url;

    private Integer sort;

    private Integer isMain;

    private Date createdTime;

    private Date updatedTime;

    public ItemsImg(String id, String itemId, String url, Integer sort, Integer isMain, Date createdTime, Date updatedTime) {
        this.id = id;
        this.itemId = itemId;
        this.url = url;
        this.sort = sort;
        this.isMain = isMain;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
    }

    public ItemsImg() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId == null ? null : itemId.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getIsMain() {
        return isMain;
    }

    public void setIsMain(Integer isMain) {
        this.isMain = isMain;
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