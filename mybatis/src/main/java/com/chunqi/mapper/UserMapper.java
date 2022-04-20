package com.chunqi.mapper;

import com.chunqi.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> selectAll();

    User selectById(int id);
}
