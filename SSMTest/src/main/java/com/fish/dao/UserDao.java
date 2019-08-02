package com.fish.dao;

import com.fish.model.UserModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    List<UserModel> getAllUsers();
    UserModel getUser(String id);
    UserModel getUserByAccount(@Param("account") String account, @Param("password") String password);
    boolean addUser(UserModel userModel);
    boolean updateUser(String id, String name);
    boolean deleteUser(String id);
}
