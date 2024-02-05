package com.zb.pojo.model;

import java.util.Date;

public class ItemsComments {
    private String id;

    private String userId;

    private String itemId;

    private String itemName;

    private String itemSpecId;

    private String sepcName;

    private Integer commentLevel;

    private String content;

    private Date createdTime;

    private Date updatedTime;

    public ItemsComments(String id, String userId, String itemId, String itemName, String itemSpecId, String sepcName, Integer commentLevel, String content, Date createdTime, Date updatedTime) {
        this.id = id;
        this.userId = userId;
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemSpecId = itemSpecId;
        this.sepcName = sepcName;
        this.commentLevel = commentLevel;
        this.content = content;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
    }

    public ItemsComments() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId == null ? null : itemId.trim();
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public String getItemSpecId() {
        return itemSpecId;
    }

    public void setItemSpecId(String itemSpecId) {
        this.itemSpecId = itemSpecId == null ? null : itemSpecId.trim();
    }

    public String getSepcName() {
        return sepcName;
    }

    public void setSepcName(String sepcName) {
        this.sepcName = sepcName == null ? null : sepcName.trim();
    }

    public Integer getCommentLevel() {
        return commentLevel;
    }

    public void setCommentLevel(Integer commentLevel) {
        this.commentLevel = commentLevel;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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