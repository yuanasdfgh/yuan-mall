package com.admin.service;

import com.admin.pojo.Role;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 后台用户角色表 服务类
 * </p>
 *
 * @author yuan
 * @since 2022-09-03
 */
public interface RoleService extends IService<Role> {

    /**
     * 添加角色
     */
    boolean create(Role role);
}
