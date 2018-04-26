package com.cloud.code.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cloud.code.model.json.LeftTree;
import com.cloud.util.JSONUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 作用描述
 *
 * @ProjectName: cloud-server
 * @Package: com.cloud.code.util
 * @Description: 作用描述
 * @Author: 钱佳豪
 * @CreateDate: 2018/4/26 13:23
 * @UpdateDate: 2018/4/26 13:23
 * @UpdateRemark: The modified content
 * @Version: 1.0
 **/
public class CloudRole {

   private PowerUtil powerUtil=new PowerUtil();


    /**
     * 循环遍历JSON文件内容，code是头部点击的Fcode jsonArray是
     * 存储的json，content是json文件中所有json
     * 调用：cloudRole.getLeftMenu(
     *                      code,
     *                      JSONUtil.getJSONArray(user.getRole().getRoleCode()),
     *                      JSONUtil.getJSONArray(content));
     * @param code
     * @param jsonArray
     * @param content
     * @return
     */
    List<LeftTree> getLeftMenu(String code, JSONArray jsonArray, Object content) {
        for (Object object : jsonArray) {
            JSONObject jsonObject = (JSONObject) object;
            if (code.equals(getCode(jsonObject))) {
                return setLeftMenu(jsonObject, eachContent(code, content));
            }
        }
        return null;
    }


    List<LeftTree> setLeftMenu(JSONObject jsonObject, JSONObject contentObject) {
        List<LeftTree> tree = new ArrayList<>();
        for (Object object : getTree(jsonObject)) {
            JSONObject o = (JSONObject) object;
            tree.add(findLeftTree(o,contentObject));
        }
        return tree;
    }

    LeftTree findLeftTree(JSONObject roleObject, JSONObject content) {
        LeftTree leftTree=new LeftTree();
        for (Object object : getTree(content)) {
            JSONObject jsonObject = (JSONObject) object;
            if (getCode(jsonObject).equals(getCode(roleObject))) {
                leftTree = powerUtil.setTree(jsonObject);
                if(getTree(roleObject)!=null){
                    for(Object o:getTree(roleObject)){
                        leftTree.getTree().add(findLeftTree((JSONObject) o,jsonObject));
                    }
                }
            }
        }
        return leftTree;
    }



    private JSONObject eachContent(String code, Object object) {
        JSONArray jsonArray = (JSONArray) object;
        for (Object leftObj : jsonArray) {
            JSONObject jsonObject = (JSONObject) leftObj;
            if (code.equals(jsonObject.getString("fcode"))) {
                return jsonObject;
            }
        }
        return null;
    }




    String getCode(JSONObject jsonObject) {
        return jsonObject.getString("fcode");
    }

    JSONArray getPower(JSONObject jsonObject) {
        return JSON.parseArray(jsonObject.getString("power"));
    }

    JSONArray getTree(JSONObject jsonObject) {
        return JSON.parseArray(jsonObject.getString("tree"));
    }
}
