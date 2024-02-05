package com.zb.pojo.vo;

/**
 * @Author：zhaobao1830
 * @Date：2024-02-05 17:45
 * @Description: 用户中心，我的订单列表里的商品
 */
public class MySubOrderItemVO {

    private String itemId;
    private String itemSpecId;
    private String itemImg;
    private String itemName;
    private String itemSpecName;
    private Integer buyCounts;
    private Integer price;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemSpecId() {
        return itemSpecId;
    }

    public void setItemSpecId(String itemSpecId) {
        this.itemSpecId = itemSpecId;
    }

    public String getItemImg() {
        return itemImg;
    }

    public void setItemImg(String itemImg) {
        this.itemImg = itemImg;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemSpecName() {
        return itemSpecName;
    }

    public void setItemSpecName(String itemSpecName) {
        this.itemSpecName = itemSpecName;
    }

    public Integer getBuyCounts() {
        return buyCounts;
    }

    public void setBuyCounts(Integer buyCounts) {
        this.buyCounts = buyCounts;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
