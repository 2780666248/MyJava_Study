package com.sym.service;

import com.sym.pojo.User;

import java.util.List;

public interface UserService {
    List<User> selectAll();
    int deleteById(int userId);
}
