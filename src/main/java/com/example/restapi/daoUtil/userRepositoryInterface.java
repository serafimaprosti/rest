package com.example.restapi.daoUtil;

import com.example.restapi.entities.user;

import java.util.List;

public interface userRepositoryInterface {
    List<user> findAllUsers();
    void saveNewUser(user user);
    user findById(Long userToEditId);
    void saveChangesUser(user changedUser);
    void deleteUser(Long userToDeleteId);
}
