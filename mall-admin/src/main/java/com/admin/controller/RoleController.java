package com.admin.controller;

import com.admin.pojo.Role;
import com.admin.service.RoleService;
import com.common.api.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 后台用户角色表 前端控制器
 * </p>
 *
 * @author yuan
 * @since 2022-09-03
 */
@RestController
@Api(tags = "UmsRoleController", description = "后台用户角色管理")
@RequestMapping("/role")
public class RoleController {
    @Resource
    private RoleService roleService;

    @ApiOperation("添加角色")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public CommonResult create(@RequestBody Role role) {
        boolean success = roleService.create(role);
        if (success) {
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取所有角色")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<Role>> listAll() {
        List<Role> roleList = roleService.list();
        return CommonResult.success(roleList);
    }
}
