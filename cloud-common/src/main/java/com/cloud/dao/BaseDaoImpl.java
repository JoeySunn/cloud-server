package com.cloud.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

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
@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> implements BaseDao<T> {
    //实现类
    private Class<T> clazz;

    @Resource
    private SessionFactory sessionFactory;

    private Session session;

    /**
     * 通过构造方法指定DAO的具体实现类
     */
    public BaseDaoImpl(){
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        clazz = (Class) params[0];
        this.session=sessionFactory.getCurrentSession();
        //System.out.println("DAO的真实实现类是："+this.clazz.getName());
    }

    /**
     * 获取当前工作的Session
     */
    protected Session getSession(){
        return session;
    }

    public T findById(Serializable id){
        return session.load(clazz,id);
    }

    public Integer save(Object object){
       return (Integer) session.save(object);
    }


}