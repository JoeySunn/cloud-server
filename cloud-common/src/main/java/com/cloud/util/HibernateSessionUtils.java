package com.cloud.util;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * 作用描述
 *
 * @ProjectName: cloud-server
 * @Package: com.cloud.util
 * @Description: 作用描述
 * @Author: 钱佳豪
 * @CreateDate: 2018/2/11 13:59
 * @UpdateDate: 2018/2/11 13:59
 * @UpdateRemark: The modified content
 * @Version: 1.0
 **/
public class HibernateSessionUtils {
    private static final SessionFactory sessionFactory=buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        Configuration configuration = new Configuration().configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

        return configuration.buildSessionFactory(serviceRegistry);
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }



}
