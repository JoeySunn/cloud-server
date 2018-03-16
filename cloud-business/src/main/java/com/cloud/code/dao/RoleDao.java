package com.cloud.code.dao;

import com.cloud.code.model.role.Role;
import com.cloud.dao.BaseDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 作用描述
 *
 * @ProjectName: cloud-server
 * @Package: com.cloud.code.dao
 * @Description: 作用描述
 * @Author: 钱佳豪
 * @CreateDate: 2018/3/2 14:28
 * @UpdateDate: 2018/3/2 14:28
 * @UpdateRemark: The modified content
 * @Version: 1.0
 **/
@Repository
public interface RoleDao extends BaseDao<Role> {
}
