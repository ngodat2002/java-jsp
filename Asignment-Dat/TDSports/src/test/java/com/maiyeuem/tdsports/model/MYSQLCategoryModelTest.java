package com.maiyeuem.tdsports.model;

import com.maiyeuem.tdsports.entity.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MYSQLCategoryModelTest {
private MYSQLCategoryModel model;
    @BeforeEach
    void setUp() {
        model = new MYSQLCategoryModel();
    }

    @Test
    void save() {
        Category category3 = new Category();
        category3.setName("New Balance");
        model.save(category3);
        Category category4 = new Category();
        category4.setName("Gucci");
        model.save(category4);

        assertEquals( 4 ,model.findAll().size());
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void update() {
     Category category = model.findById(2);
     assertNotEquals(null,category);

    }

    @Test
    void delete() {
        model.delete(2);
        assertNotEquals(2,model.findAll().size());

    }
}