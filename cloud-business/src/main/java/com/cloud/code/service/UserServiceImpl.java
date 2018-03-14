package com.cloud.code.service;

import com.cloud.code.dao.UserDao;
import com.cloud.code.model.user.User;
import org.hibernate.SessionFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
 * @CreateDate: 2018/2/9 15:08
 * @UpdateDate: 2018/2/9 15:08
 * @UpdateRemark: The modified content
 * @Version: 1.0
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(15);

    @Resource
    private UserDao userDao;

    private SessionFactory sessionFactory;





    /**
     * 验证用户名密码
     *
     * @param userName
     * @param passWord
     * @return
     */
//    @Override
//    public User validate(String userName, String passWord) {
//        QRole role=QRole.role;
//        User user = new JPAQuery<User>(entityManager)
//                .from(qUser,role)
//                .leftJoin(role)
//                .on(qUser.role.id.eq(role.id))
//                .where(
//                        qUser.userName.eq(userName),
//                        qUser.state.ne(StatusEnum.DELETE.getIndex())
//                )
//                .fetchOne();
//        if(user==null){
//            return null;
//        }
//        if (encoder.matches(passWord,user.getPassWord())) {
//          return user;
//        }else{
//            //密码不正确的状态
//            user.setState(3);
//            return user;
//        }
//        return null;
//    }

    /**
     * 验证用户名密码
     *
     * @param userName
     * @param passWord
     * @return
     */


    @Override
    public User validate(String userName, String passWord) {
        return null;
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
        return new User();
    }

    /**
     * 用户名查询用户
     * @param name
     * @return
     */
    @Override
    public User findUserByName(String name) {
//        JPAQuery<User> jpaQuery = new JPAQuery<>(entityManager);
//        User user = jpaQuery.from(qUser)
//                .where(
//                        qUser.state.ne(StatusEnum.DELETE.getIndex()),
//                        qUser.userName.eq(name)
//                )
//                .fetchOne();
//        if (user == null) {
//            return null;
//        }
//        return user;
        return null;
    }

    @Override
    public User findUserById(Integer id) {
        return userDao.findById(id);
    }
}
