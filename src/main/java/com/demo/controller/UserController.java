package com.demo.controller;


import com.demo.dao.model.User;
import com.demo.dto.ResponseBean;
import com.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 唐耀
 * @since 2020-10-17
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户接口")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/{id}")
    @ApiOperation("获取用户列表")
    public ResponseBean<User> getUser(@PathVariable("id") int id){
        return ResponseBean.createBySuccess(service.getUser(id));
    }
}
