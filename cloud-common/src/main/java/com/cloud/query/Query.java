package com.cloud.query;

import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作用描述
 *
 * @ProjectName: cloud-server
 * @Package: com.cloud.query
 * @Description: 条件查询类（Jpa CriteriaQuery）
 * @Author: 钱佳豪
 * @CreateDate: 2018/2/12 14:01
 * @UpdateDate: 2018/2/12 14:01
 * @UpdateRemark: The modified content
 * @Version: 1.0
 **/
@SuppressWarnings({"unused", "unchecked", "rawtypes", "null", "hiding"})
public class Query<T> implements Serializable {

    private Class<?> clazz;


    private EntityManagerFactory entityManagerFactory;

    private CriteriaBuilder builder;

    private CriteriaQuery criteriaQuery;

    private Root from;

    private List<Predicate> predicates;

    private List<Order> orders;

    private Map<Object, Object> propertyMap = new HashMap<Object, Object>();

    public Query() {
        ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
        this.clazz = (Class<T>) (parameterizedType.getActualTypeArguments()[0]);
        this.builder = entityManagerFactory.getCriteriaBuilder();
        this.criteriaQuery = builder.createQuery(this.clazz);
        this.from = criteriaQuery.from(this.clazz);
        this.predicates = new ArrayList();
        this.orders = new ArrayList();
    }

    public T getResult() {
        T data;
        try {
            for (Predicate predicate : predicates) {
                criteriaQuery.where(predicate);
            }
            TypedQuery<T> typedQuery = entityManagerFactory.createEntityManager().createQuery(criteriaQuery);
            data = typedQuery.getSingleResult();
        } catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        }
        return data;
    }

    public List<T> list() {
        List<T> list;
        try {
            for (Predicate predicate : predicates) {
                criteriaQuery.where(predicate);
            }
            TypedQuery<T> typedQuery = entityManagerFactory.createEntityManager().createQuery(criteriaQuery);
            return typedQuery.getResultList();
        } catch (NullPointerException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void andEquals(String key, Object val) {
        this.predicates.add(builder.equal(from.get(key), val));
    }

    public void notEquals(String key, Object val) {
        this.predicates.add(builder.notEqual(from.get(key), val));
    }

    public void like(String key, Object val) {
        this.predicates.add(builder.like(from.get(key), val.toString()));
    }
}
