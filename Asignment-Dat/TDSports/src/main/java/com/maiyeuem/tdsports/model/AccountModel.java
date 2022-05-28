package com.maiyeuem.tdsports.model;

import com.maiyeuem.tdsports.entity.Account;
import com.maiyeuem.tdsports.entity.Account;

import java.util.List;

public interface AccountModel {
    Account save(Account obj); // lưu thông tin.

    List<Account> findAll();

    Account findById(int id);

    Account findByUsername(String username);

    Account findByEmail(String email);

    Account update(int id, Account updateObj);

    boolean delete(int id);
}
