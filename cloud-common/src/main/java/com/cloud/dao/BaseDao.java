package com.cloud.dao;

import org.hibernate.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * 作用描述
 *
 * @ProjectName: cloud-server
 * @Package: com.cloud.dao
 * @Description: 作用描述
 * @Author: 钱佳豪
 * @CreateDate: 2018/3/13 11:33
 * @UpdateDate: 2018/3/13 11:33
 * @UpdateRemark: The modified content
 * @Version: 1.0
 **/
@NoRepositoryBean
public interface BaseDao<T> extends JpaRepository<T,Integer>,JpaSpecificationExecutor<T> {
}
