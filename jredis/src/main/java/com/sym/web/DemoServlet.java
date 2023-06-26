package com.sym.web;

import com.alibaba.fastjson.JSON;
import com.sym.JedisPollUnits;
import com.sym.pojo.User;
import com.sym.service.DefaultUserService;
import com.sym.service.UserService;
import redis.clients.jedis.Jedis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/demo/*")
public class DemoServlet extends BaseServlet{
    private UserService service = new DefaultUserService();
    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<User> users = service.selectAll();
        String jsonString = JSON.toJSONString(users);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }
    public String selectByRedis(){
        Jedis jedis = JedisPollUnits.open();
        //1.先从缓存中拿
        String result = jedis.get("userList");

        //2.没有则从数据库查询并放入缓存
        if (result==null || result.length()==0) {
            List<User> userList = service.selectAll();
            result = JSON.toJSONString(userList);
            jedis.set("userList",result);
        }
        jedis.close();
        return result;
    }
}
