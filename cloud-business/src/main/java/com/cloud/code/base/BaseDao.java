package com.cloud.code.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

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
public interface BaseDao<T> extends JpaRepository<T, Integer>{

}
