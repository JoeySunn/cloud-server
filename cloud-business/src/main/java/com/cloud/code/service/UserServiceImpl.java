package com.cloud.code.service;

import com.cloud.code.dao.UserDao;
import com.cloud.code.model.user.QUser;
import com.cloud.code.model.user.User;
import com.cloud.code.model.user.UserDTO;
import com.cloud.enums.StatusEnum;
import com.cloud.result.ResultBean;
import com.querydsl.jpa.impl.JPAQuery;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 作用描述
 *
 * @ProjectName: cloud-server
 * @Package: com.cloud.code.service
 * @Description: 作用描述
 * @Author: 钱佳豪
 * @CreateDate: 2018/2/9 15:08
 * @UpdateDate: 2018/2/9 15:08
 * @UpdateRemark: The modified content
 * @Version: 1.0
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    private  BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(15);

    @Resource
    private UserDao userDao;

    @PersistenceContext
    private EntityManager entityManager;

    private QUser qUser = QUser.user;

    /**
     * 验证用户名密码
     *
     * @param userName
     * @param passWord
     * @return
     */
    @Override
    public UserDTO validate(String userName, String passWord) {
        UserDTO userDTO = new UserDTO();
        JPAQuery<User> jpaQuery = new JPAQuery<>(entityManager);
        User user = jpaQuery.select(qUser)
                .from(qUser)
                .where(
                        qUser.userName.eq(userName),
                        qUser.state.ne(StatusEnum.DELETE.getIndex())
                )
                .fetchOne();
        if (user != null && encoder.matches(user.getPassWord(), passWord)) {
            BeanUtils.copyProperties(user, userDTO);
        }
        return userDTO;
    }

    /**
     * 添加一个用户
     *
     * @param user
     * @return
     */
    @Override
    public User addUser(User user) {
        user.setPassWord(encoder.encode(user.getPassWord()));
        return userDao.save(user);
    }

    /**
     * 用户名查询用户
     * @param name
     * @return
     */
    @Override
    public User findUserByName(String name){
        JPAQuery<User> jpaQuery = new JPAQuery<>(entityManager);
        User user=jpaQuery.from(qUser)
                .where(
                        qUser.state.ne(StatusEnum.DELETE.getIndex()),
                        qUser.userName.eq(name)
                )
                .fetchOne();
        if(user==null){
            return null;
        }
        return user;
    }
}
