package com.yundong.common.vo;

import java.util.List;

public class ClassifyVo {
    private Integer id;
    private String sort;
    private boolean ischild;
    private List<ClassifyItem> childs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public boolean isIschild() {
        return ischild;
    }

    public void setIschild(boolean ischild) {
        this.ischild = ischild;
    }

    public List<ClassifyItem> getChilds() {
        return childs;
    }

    public void setChilds(List<ClassifyItem> childs) {
        this.childs = childs;
    }
    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        if (obj instanceof ClassifyVo) {
            ClassifyVo mo = (ClassifyVo) obj;
            return this.id == mo.getId();
        }else {
            return false;
        }
    }
}
