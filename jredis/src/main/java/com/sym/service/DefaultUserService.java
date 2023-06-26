package com.sym.service;

import com.hemalh.session.SqlSession;
import com.sym.SqlSessionUnits;
import com.sym.mapper.UserMapper;
import com.sym.pojo.User;
import org.junit.Test;


import java.util.List;

public class DefaultUserService implements UserService{
    @Override
    public List<User> selectAll() {
        SqlSession session = SqlSessionUnits.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> result = mapper.selectAll("");
        return result;
    }

    @Override
    public int deleteById(int userId) {
        SqlSession session = SqlSessionUnits.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        return mapper.delete(userId);
    }

    @Test
    public void test(){
       selectAll();
    }
}
