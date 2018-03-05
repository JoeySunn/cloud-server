package com.cloud.code.service;

import com.cloud.code.dao.RoleDao;
import com.cloud.code.model.role.Role;
import com.cloud.service.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 作用描述
 *
 * @ProjectName: cloud-server
 * @Package: com.cloud.code.service
 * @Description: 作用描述
 * @Author: 钱佳豪
 * @CreateDate: 2018/3/2 14:25
 * @UpdateDate: 2018/3/2 14:25
 * @UpdateRemark: The modified content
 * @Version: 1.0
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class RoleServiceImpl extends BaseService<Role> implements RoleService {

    @Resource
    private RoleDao roleDao;


    /**
     * @param id
     * @return
     */
    @Override
    public Role findById(Integer id) {
        return roleDao.getOne(id);
    }
}
