package com.zb.pojo.vo;

import java.util.List;

public class CategoryVO {

    private Integer id;
    private String name;
    private String type;
    private Integer fatherId;

    // 三级分类vo list
    private List<SubCategoryVO> subCategoryVOList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getFatherId() {
        return fatherId;
    }

    public void setFatherId(Integer fatherId) {
        this.fatherId = fatherId;
    }

    public List<SubCategoryVO> getSubCategoryVOList() {
        return subCategoryVOList;
    }

    public void setSubCategoryVOList(List<SubCategoryVO> subCategoryVOList) {
        this.subCategoryVOList = subCategoryVOList;
    }
}
