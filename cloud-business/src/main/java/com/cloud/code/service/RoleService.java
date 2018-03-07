package com.cloud.code.service;

import com.cloud.code.model.role.Role;

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
public interface RoleService {

    /**
     * @param id
     * @return
     */
    Role findById(Integer id);

    /**
     * 添加一个角色
     * @param role
     * @return
     */
    Role addRole(Role role);
}
