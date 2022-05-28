package com.maiyeuem.tdsports.entity;

import com.maiyeuem.tdsports.entity.base.BaseEntity;
import com.maiyeuem.tdsports.entity.myenum.CategoryStatus;
import com.maiyeuem.tdsports.entity.myenum.ProductStatus;

import java.time.LocalDateTime;

public class Category extends BaseEntity {
    private int id;//nen de String id UUID
    private  String name;
    private CategoryStatus status;

    public Category() {
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
        this.status= CategoryStatus.ACTIVE;
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
        this.status=CategoryStatus.ACTIVE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryStatus getStatus() {
        return status;
    }

    public void setStatus(CategoryStatus status) {
        this.status = status;
    }
}
