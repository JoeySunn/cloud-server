package com.cloud.code.dao;


import com.cloud.code.model.user.User;
import com.cloud.dao.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * 作用描述
 *
 * @ProjectName: cloud-server
 * @Package: com.cloud.code.dao
 * @Description: 作用描述
 * @Author: 钱佳豪
 * @CreateDate: 2018/2/11 13:21
 * @UpdateDate: 2018/2/11 13:21
 * @UpdateRemark: The modified content
 * @Version: 1.0
 **/
@Repository
public interface UserDao extends BaseDao<User> {
    /**
     *
     * @param userName
     * @return
     */
    User findUserByName(String userName);

}
