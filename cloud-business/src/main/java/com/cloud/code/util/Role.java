package com.cloud.code.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cloud.code.model.json.LeftTree;
import com.cloud.code.model.user.User;
import com.cloud.code.service.UserService;
import com.cloud.util.FileUtil;
import com.cloud.util.JSONUtil;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 作用描述
 *
 * @ProjectName: cloud-server
 * @Package: com.cloud.code.util
 * @Description: 作用描述
 * @Author: 钱佳豪
 * @CreateDate: 2018/4/25 16:31
 * @UpdateDate: 2018/4/25 16:31
 * @UpdateRemark: The modified content
 * @Version: 1.0
 **/
public class Role {

    @Resource
    private UserService userService;

    private List<LeftTree> leftTrees = new ArrayList<LeftTree>();

    private PowerUtil powerUtil=new PowerUtil();


    public void findByUser() {
        String content = FileUtil.getFileContent("properties/powerTree.json");
        String code = "company";
        String code1 = "order";
        String code2 = "product";
        String code3 = "statements";
        String code4 = "config";
//        List<RoleTree> roleList = new ArrayList<>();
        User user = userService.findUserById(1);
//        List<LeftTree> leftTrees = getLeftTree(code, (JSONArray) JSON.parse(user.getRole().getRoleCode()), roles);
        getLeftTree(code, JSONUtil.getJSONArray(user.getRole().getRoleCode()));
    }

    /**
     * 获得用户对应的权限
     *
     * @return
     */
    void getLeftTree(String code, Object object) {
        JSONArray jsonArray = (JSONArray) object;
        for (Object obj : jsonArray) {
            JSONObject jsonObject = (JSONObject) obj;
            if (code.equals(getCode(jsonObject))) {
                setLeftMenu(getTree(jsonObject));
                break;
            }
        }
    }

    void setLeftMenu(JSONArray jsonArray) {
        for (Object object : jsonArray) {
            JSONObject jsonObject = (JSONObject) object;
            leftTrees.add(powerUtil.setTree(jsonObject));
        }
        addTee(leftTrees, jsonArray);

    }

    void addTee(List<LeftTree> trees, JSONArray jsonArray) {
        for (LeftTree tree : trees) {
            /*
             *这里应该是要传入一个fcode，然后返回这个fcode对应的JSONObject
             * jsonObject下有对应的Trees或者没有下一级权限
             */
            getContentObject(tree, jsonArray);
        }
    }

    void getContentObject(LeftTree leftTree, JSONArray jsonArray) {
        for (Object object : jsonArray) {
            JSONObject jsonObject = (JSONObject) object;
            if (leftTree.getFcode().equals(getCode(jsonObject))) {
                if (getTree(jsonObject) != null) {
                    for (Object o : getTree(jsonObject)) {
                        checkTree(o, leftTree, jsonObject);
                    }
                }
                if (getPower(jsonObject) != null && !leftTree.getFcode().equals(getCode(jsonObject))) {
                    leftTree.getTree().add(powerUtil.setTree(jsonObject));
                }
            }
        }
    }

    void checkTree(Object object, LeftTree leftTree, JSONObject parentJson) {
        JSONObject tree = (JSONObject) object;
        LeftTree leftTree1 = powerUtil.setTree(tree);
        leftTree.getTree().add(leftTree1);
        getContentObject(leftTree1, JSON.parseArray(parentJson.getString("tree")));
    }

    String getCode(JSONObject jsonObject) {
        return jsonObject.getString("tree");
    }

    JSONArray getPower(JSONObject jsonObject) {
        return JSON.parseArray(jsonObject.getString("power"));
    }

    JSONArray getTree(JSONObject jsonObject) {
        return JSON.parseArray(jsonObject.getString("tree"));
    }





}
