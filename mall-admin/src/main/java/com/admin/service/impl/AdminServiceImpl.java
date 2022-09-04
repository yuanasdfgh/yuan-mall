package com.admin.service.impl;

import com.admin.pojo.Admin;
import com.admin.dao.AdminDao;
import com.admin.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.security.util.JwtTokenUtil;
import org.mybatis.logging.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author yuan
 * @since 2022-09-03
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminDao, Admin> implements AdminService {
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(AdminServiceImpl.class);
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UmsAdminMapper adminMapper;
    @Autowired
    private UmsAdminRoleRelationMapper adminRoleRelationMapper;
    @Autowired
    private UmsAdminRoleRelationDao adminRoleRelationDao;
    @Autowired
    private UmsAdminLoginLogMapper loginLogMapper;

    @Override
    public Admin getAdminByUsername(String username) {
        Admin admin = getCacheService().getAdmin(username);
        if(admin!=null) return  admin;
        UmsAdminExample example = new UmsAdminExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<UmsAdmin> adminList = adminMapper.selectByExample(example);
        if (adminList != null && adminList.size() > 0) {
            admin = adminList.get(0);
            getCacheService().setAdmin(admin);
            return admin;
        }
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username){
        //获取用户信息
        Admin admin = getAdminByUsername(username);
        if (admin != null) {
            List<UmsResource> resourceList = getResourceList(admin.getId());
            return new AdminUserDetails(admin,resourceList);
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    }
}
