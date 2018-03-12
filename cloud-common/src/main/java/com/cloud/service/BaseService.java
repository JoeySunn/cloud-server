package com.cloud.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;

/**
 * 作用描述
 *
 * @ProjectName: cloud-server
 * @Package: com.cloud.service
 * @Description: 作用描述
 * @Author: 钱佳豪
 * @CreateDate: 2018/2/22 9:59
 * @UpdateDate: 2018/2/22 9:59
 * @UpdateRemark: The modified content
 * @Version: 1.0
 **/
public class BaseService<T> {
    private Class<?> clazz;


    public BaseService(){
        ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
        clazz=(Class<T>) (parameterizedType.getActualTypeArguments()[0]);
    }
}
