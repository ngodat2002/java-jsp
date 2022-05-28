package com.maiyeuem.tdsports.model;


import com.maiyeuem.tdsports.entity.User;

import java.util.List;

public interface UserModel {
    User save(User user);
    List<User> findAll();
    User findById(int id);
    User update(int id,User updateUser);
    boolean delete(int id);
}
