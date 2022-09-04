package com.admin.service;

import com.admin.pojo.Admin;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author yuan
 * @since 2022-09-03
 */
public interface AdminService extends IService<Admin> {


    /**
     * 获取用户信息
     */
    UserDetails loadUserByUsername(String username);

}
