package com.cloud.code.base;

import org.hibernate.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * 作用描述
 *
 * @ProjectName: cloud-server
 * @Package: com.cloud.code.base
 * @Description: 作用描述
 * @Author: 钱佳豪
 * @CreateDate: 2018/2/26 15:45
 * @UpdateDate: 2018/2/26 15:45
 * @UpdateRemark: The modified content
 * @Version: 1.0
 **/
@NoRepositoryBean
public interface BaseDao<T>{

    /**
     * 得到一个Hibernate session
     * @return
     */
    Session getSession();

    Integer save(Object object);

    /**
     * 获得一个泛型类
     * @param id
     * @return
     */
    T findById(Serializable id);
}
