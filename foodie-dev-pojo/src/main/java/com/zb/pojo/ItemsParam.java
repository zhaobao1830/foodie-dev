package com.zb.pojo;

import java.util.Date;

public class ItemsParam {
    private String id;

    private String itemId;

    private String producPlace;

    private String footPeriod;

    private String brand;

    private String factoryName;

    private String factoryAddress;

    private String packagingMethod;

    private String weight;

    private String storageMethod;

    private String eatMethod;

    private Date createdTime;

    private Date updatedTime;

    public ItemsParam(String id, String itemId, String producPlace, String footPeriod, String brand, String factoryName, String factoryAddress, String packagingMethod, String weight, String storageMethod, String eatMethod, Date createdTime, Date updatedTime) {
        this.id = id;
        this.itemId = itemId;
        this.producPlace = producPlace;
        this.footPeriod = footPeriod;
        this.brand = brand;
        this.factoryName = factoryName;
        this.factoryAddress = factoryAddress;
        this.packagingMethod = packagingMethod;
        this.weight = weight;
        this.storageMethod = storageMethod;
        this.eatMethod = eatMethod;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
    }

    public ItemsParam() {
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

    public String getProducPlace() {
        return producPlace;
    }

    public void setProducPlace(String producPlace) {
        this.producPlace = producPlace == null ? null : producPlace.trim();
    }

    public String getFootPeriod() {
        return footPeriod;
    }

    public void setFootPeriod(String footPeriod) {
        this.footPeriod = footPeriod == null ? null : footPeriod.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName == null ? null : factoryName.trim();
    }

    public String getFactoryAddress() {
        return factoryAddress;
    }

    public void setFactoryAddress(String factoryAddress) {
        this.factoryAddress = factoryAddress == null ? null : factoryAddress.trim();
    }

    public String getPackagingMethod() {
        return packagingMethod;
    }

    public void setPackagingMethod(String packagingMethod) {
        this.packagingMethod = packagingMethod == null ? null : packagingMethod.trim();
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight == null ? null : weight.trim();
    }

    public String getStorageMethod() {
        return storageMethod;
    }

    public void setStorageMethod(String storageMethod) {
        this.storageMethod = storageMethod == null ? null : storageMethod.trim();
    }

    public String getEatMethod() {
        return eatMethod;
    }

    public void setEatMethod(String eatMethod) {
        this.eatMethod = eatMethod == null ? null : eatMethod.trim();
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