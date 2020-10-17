package com.demo.service;

import com.demo.dao.model.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 唐耀
 * @since 2020-10-17
 */
public interface UserService extends IService<User> {

    User getUser(int id);
}
