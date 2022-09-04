package com.admin.service.impl;

import cn.hutool.core.util.StrUtil;
import com.admin.pojo.Role;
import com.admin.dao.RoleDao;
import com.admin.service.RoleService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 后台用户角色表 服务实现类
 * </p>
 *
 * @author yuan
 * @since 2022-09-03
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleDao, Role> implements RoleService {


    @Override
    public boolean create(Role role) {
        role.setAdminCount(0);
        role.setSort(0);
        return save(role);
    }
    @Override
    public Page<Role> list(String keyword, Integer pageSize, Integer pageNum) {
        Page<Role> page = new Page<>(pageNum,pageSize);
        QueryWrapper<Role> wrapper = new QueryWrapper<>();
        LambdaQueryWrapper<Role> lambda = wrapper.lambda();
        if(StrUtil.isNotEmpty(keyword)){
            lambda.like(Role::getName,keyword);
        }
        return page(page,wrapper);
    }
}
