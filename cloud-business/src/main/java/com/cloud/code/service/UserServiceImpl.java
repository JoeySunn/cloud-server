package com.cloud.code.service;

import com.cloud.code.dao.UserDao;
import com.cloud.code.model.role.Role;
import com.cloud.code.model.user.User;
import com.cloud.enums.StatusEnum;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

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

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

    @Resource
    private UserDao userDao;



    /**
     * 验证用户名密码
     *
     * @param userName
     * @param passWord
     * @return
     */
    @Override
    public User validate(String userName, String passWord) {
        User user = userDao.findOne(new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Join<User, Role> join = root.join("role", JoinType.LEFT);
                criteriaQuery.where(criteriaBuilder.and(
                        criteriaBuilder.equal(root.get("userName"), userName),
                        criteriaBuilder.notEqual(root.get("state"), StatusEnum.DELETE.getIndex()),
                        criteriaBuilder.notEqual(root.get("role").get("state"), StatusEnum.DELETE.getIndex()),
                        criteriaBuilder.equal(join.get("id"), root.get("role").get("id"))
                ));
                return criteriaQuery.getRestriction();
            }
        });
        if (user == null) {
            return null;
        }
        if (encoder.matches( user.getPassWord(),passWord)) {
            return user;
        } else {
            //密码不正确的状态
            user.setState(3);
            return user;
        }
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
     *
     * @param name
     * @return
     */
    @Override
    public User findUserByName(String name) {
        User user=userDao.findOne(new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if(!"".equals(name)){
                    predicates.add(criteriaBuilder.equal(root.get("userName"), name));
                }
                predicates.add(criteriaBuilder.notEqual(root.get("state"), StatusEnum.DELETE.getIndex()));
                Predicate[] p = new Predicate[predicates.size()];
                return criteriaBuilder.and(predicates.toArray(p));
            }
        });
        if (user == null) {
            return null;
        }
        return user;
    }

    @Override
    public User findUserById(Integer id) {
        return userDao.findOne(id);
    }
}
