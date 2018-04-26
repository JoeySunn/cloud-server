package com.cloud;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cloud.code.model.json.LeftTree;
import com.cloud.code.model.user.User;
import com.cloud.code.service.UserService;
import com.cloud.util.FileUtil;
import com.cloud.util.JSONUtil;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 作用描述
 *
 * @ProjectName: cloud-server
 * @Package: com.cloud
 * @Description: 作用描述
 * @Author: 钱佳豪
 * @CreateDate: 2018/4/25 16:33
 * @UpdateDate: 2018/4/25 16:33
 * @UpdateRemark: The modified content
 * @Version: 1.0
 **/
public class RoleTest extends BaseJunit {

    @Resource
    private UserService userService;

    private List<LeftTree> leftTrees = new ArrayList<LeftTree>();

    @Test
    public void findByUser() {
        String content = FileUtil.getFileContent("properties/powerTree.json");
        String code = "company";
        String code1 = "order";
        String code2 = "product";
        String code3 = "statements";
        String code4 = "config";
        User user = userService.findUserById(1);
        List<LeftTree> trees=getLeftMenu(code, JSONUtil.getJSONArray(user.getRole().getRoleCode()), JSONUtil.getJSONArray(content));
        System.out.println(trees);
    }

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
                leftTree = setTree(jsonObject);
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

    public LeftTree setTree(JSONObject jsonObject) {
        LeftTree leftTree = new LeftTree();
        if (!"".equals(jsonObject.getString("fcode"))) {
            leftTree.setFcode(jsonObject.getString("fcode"));
        }
        if (!"".equals(jsonObject.getString("funname"))) {
            leftTree.setFunname(jsonObject.getString("funname"));
        }
        if (!"".equals(jsonObject.getString("type"))) {
            leftTree.setType(jsonObject.getString("type"));
        }
        if (!"".equals(jsonObject.getString("title"))) {
            leftTree.setTitle(jsonObject.getString("title"));
        }
        return leftTree;
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
