package com.cloud.code.service;

import com.cloud.code.model.user.User;
import com.cloud.code.model.user.UserDTO;
import com.cloud.result.ResultBean;
import com.cloud.service.BaseSevice;

/**
 * 作用描述
 *
 * @ProjectName: cloud-server
 * @Package: com.cloud.code.service
 * @Description: 作用描述
 * @Author: 钱佳豪
 * @CreateDate: 2018/2/9 15:06
 * @UpdateDate: 2018/2/9 15:06
 * @UpdateRemark: The modified content
 * @Version: 1.0
 **/
public interface UserService extends BaseSevice<User>{
    /**
     * 验证用户名密码
     * @param userName
     * @param passWord
     * @return
     */
    UserDTO validate(String userName, String passWord);

    /**
     * 添加一个用户
     * @param user
     * @return
     */
   User addUser(User user);

    /**
     * 是否用相同姓名的用户
     * @return
     */
   User findUserByName(String name);
}
