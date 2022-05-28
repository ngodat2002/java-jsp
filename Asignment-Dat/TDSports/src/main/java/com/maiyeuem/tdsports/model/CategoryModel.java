package com.maiyeuem.tdsports.model;

import com.maiyeuem.tdsports.entity.Category;

import java.util.List;

public interface CategoryModel {
    Category save(Category category);
    List<Category> findAll();
    Category findById(int id);
    Category update(int id,Category updateObj);
    boolean delete(int id);
}
