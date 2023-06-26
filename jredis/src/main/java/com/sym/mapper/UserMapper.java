package com.sym.mapper;

import com.hemalh.annotate.Param;
import com.sym.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> selectAll(@Param("")String id);
    int delete(@Param("userId") int userId);
}
