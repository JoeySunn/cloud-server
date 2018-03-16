package com.cloud.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cloud.constant.MessageConstant;
import com.cloud.result.ResultBean;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * 作用描述
 *
 * @ProjectName: cloud-manager
 * @Package: com.cloud.util
 * @Description: JSON转换工具类
 * @Author: 钱佳豪
 * @CreateDate: 2018/1/23 16:31
 * @UpdateDate: 2018/1/23 16:31
 * @UpdateRemark: The modified content
 * @Version: 1.0
 **/
public class JSONUtil {
    /**
     * @param resultBean
     * @param size
     * @return
     */
    public static JSONObject paseResultBeanList(ResultBean<?> resultBean, int size) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("result", resultBean.getData());
        hashMap.put("size", size);
        hashMap.put("status", resultBean.isStatus());
        hashMap.put("message", resultBean.getMessage());
        return strParseJSONObject(JSON.toJSONString(hashMap));
    }

    /**
     * 自定义转换json格式（对象）
     *
     * @param bean
     * @return
     */
    public static JSONObject parseResultBean(ResultBean bean) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("result", bean.getData());
        hashMap.put("size", " ");
        hashMap.put("message", bean.getMessage());
        hashMap.put("status", bean.isStatus());
        return strParseJSONObject(JSON.toJSONString(hashMap));
    }

    /**
     * 字符串转换JSONObject
     *
     * @param str
     * @return
     */
    public static JSONObject strParseJSONObject(String str) {
        return JSON.parseObject(str);
    }

    /**
     * 将对象转换为JSON对象
     *
     * @param data
     * @return
     */
    public JSONObject parseJSONObject(Object data) {
        return JSON.parseObject(parseJSONString(data));
    }

    /**
     * 转换JSONString
     *
     * @param data
     * @return
     */
    public String parseJSONString(Object data) {
        if (!Objects.nonNull(data)) {
            return null;
        }
        return JSON.toJSONString(data);
    }

    /**
     * 封装转换JSON对象步骤s
     * @param t
     * @param message
     * @param state
     * @param <T>
     * @return
     */
    public static <T> JSONObject finalData(T t, String message, Boolean state) {
        ResultBean<Object> resultBean = new ResultBean<>();
        return JSONUtil.parseResultBean(resultBean.content(t, message, state));
    }

    /**
     * 错误消息返回
     * @param message
     * @return
     */
    public static JSONObject errorData(String message){
        ResultBean<Object> resultBean = new ResultBean<>();
        return JSONUtil.parseResultBean(resultBean.content(new Object(), message, false));
    }

    /**
     * 没有错误，返回查询到的实体
     * @param t
     * @param <T>
     * @return
     */
    public static<T> JSONObject successData(T t){
        ResultBean<Object> resultBean = new ResultBean<>();
        return JSONUtil.parseResultBean(resultBean.content(new Object(), MessageConstant.SUCCESS, MessageConstant.NO));
    }


}
