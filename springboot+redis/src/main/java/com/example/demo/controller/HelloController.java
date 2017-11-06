package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Lenovo on 2017/11/3.
 */
@Controller
public class HelloController {
    @Autowired
    Dao dao;
    @RequestMapping("/set")
    @ResponseBody
    public void set() {
        dao.set("key", "value");
    }

    @RequestMapping("/get")
    @ResponseBody
    public String get() {
        return dao.get("key");
    }
    @RequestMapping("/setuser")
    @ResponseBody
    public void setUser() {
        User user = new User();
        user.setId("1");
        user.setUsername("深圳");
        user.setPassword("sang");
        dao.set(user);
    }

    @RequestMapping(value = "/getuser")
    @ResponseBody
    public String getUser() {
        User user = new User();
        user.setId("1");
        return dao.get(user);
    }

}
