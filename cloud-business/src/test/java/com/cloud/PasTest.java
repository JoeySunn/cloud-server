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
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作用描述
 *
 * @ProjectName: cloud-server
 * @Package: com.cloud
 * @Description: 作用描述
 * @Author: 钱佳豪
 * @CreateDate: 2018/3/15 14:25
 * @UpdateDate: 2018/3/15 14:25
 * @UpdateRemark: The modified content
 * @Version: 1.0
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PasTest {
    @Resource
    private UserService userService;

    private List<LeftTree> leftTrees = new ArrayList<LeftTree>();

    private Map<String, String> codeMap = new HashMap<>();

    private String code = "";

    private LeftTree leftTree;

    private JSONObject contentObject;

    @Test
    public void findByUser() {
        String content = FileUtil.getFileContent("properties/powerTree.json");
        String code = "company";
        String code1="order";
        String code2="product";
        String code3="statements";
        String code4="config";
//        List<RoleTree> roleList = new ArrayList<>();
        User user = userService.findUserById(1);
//        List<LeftTree> leftTrees = getLeftTree(code, (JSONArray) JSON.parse(user.getRole().getRoleCode()), roles);
        getLeftTree(code, JSONUtil.getJSONArray(user.getRole().getRoleCode()));
        Assert.assertNotNull(leftTrees);
    }


    /**
     * 获得用户对应的权限
     *
     * @return
     */
    private void getLeftTree(String code, Object object) {
        JSONArray jsonArray = (JSONArray) object;
        for (Object obj : jsonArray) {
            JSONObject jsonObject = (JSONObject) obj;
            if (code.equals(jsonObject.getString("fcode"))) {
                setLeftMenu(JSON.parseArray(jsonObject.getString("tree")));
                break;
            }
        }
    }

    void setLeftMenu(JSONArray jsonArray) {
         for(Object object: jsonArray){
             JSONObject jsonObject= (JSONObject) object;
             leftTrees.add(setTree(jsonObject));
         }
        addTee(leftTrees,jsonArray);

    }

    void addTee(List<LeftTree> trees,JSONArray jsonArray){
         for(LeftTree tree:trees){
             /*
              *这里应该是要传入一个fcode，然后返回这个fcode对应的JSONObject
              * jsonObject下有对应的Trees或者没有下一级权限
              */
             getContentObject(tree,jsonArray);
         }
    }

    void getContentObject(LeftTree leftTree,JSONArray jsonArray){
        for(Object object:jsonArray){
            JSONObject jsonObject= (JSONObject) object;
            if(leftTree.getFcode().equals(jsonObject.getString("fcode"))){
                 if(JSON.parseArray(jsonObject.getString("tree"))!=null){
                     for(Object o: JSON.parseArray(jsonObject.getString("tree"))){
                         JSONObject tree= (JSONObject) o;
                         LeftTree leftTree1=setTree(tree);
                         leftTree.getTree().add(leftTree1);
                         getContentObject(leftTree1,JSON.parseArray(jsonObject.getString("tree")));
                     }
                 }
                 if(JSON.parseArray(jsonObject.getString("power"))!=null && !leftTree.getFcode().equals(jsonObject.getString("fcode"))){
                     leftTree.getTree().add(setTree(jsonObject));
                 }
            }
        }
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


    //private void leftTrees(Object object) {
    //    JSONArray jsonArray = (JSONArray) object;
    //    for (Object obj : jsonArray) {
    //        JSONObject jsonObject = (JSONObject) obj;
    //        setLeftMenu(jsonObject, null);
    //        if (haveTree(jsonObject) != null) {
    //            leftTrees(JSON.parseArray(jsonObject.getString("tree")));
    //        }
    //    }
    //    ////这里取到的就是标题级下的JSON数组，可以进行递归遍历
    //    //JSONArray jsonArray = (JSONArray) object;
    //    //List<LeftTree> lefts=new ArrayList<>();
    //    //for (Object obj : jsonArray) {
    //    //    JSONObject jsonObject = (JSONObject) obj;
    //    //    lefts.add(setTree(jsonObject));
    //    //    addTree(jsonObject, lefts);
    //    //    if (haveTree(jsonObject) != null) {
    //    //        codeMap.put("fcode",jsonObject.getString("fcode"));
    //    //        leftTrees(JSON.parseArray(jsonObject.getString("tree")));
    //    //    }
    //    //}
    //}


    //void addTree(JSONObject jsonObject, List<LeftTree> trees) {
    //    String code = codeMap.get("fcode");
    //    //如果这里是Null,那么说明没有Tree，这个JSONObject所处层级就是最后一级
    //    if (code != null) {
    //        //比对Fcode
    //        for (LeftTree leftTree : leftTrees) {
    //            if (code.equals(leftTree.getFcode())) {
    //                leftTree.getTree().add(setTree(jsonObject));
    //            } else {
    //                addTree(jsonObject, leftTree.getTree());
    //            }
    //        }
    //    }
    //
    //}


//    List<LeftTree> leftTrees(JSONObject object) {
//        JSONArray jsonArray=JSON.parseArray(object.getString("tree"));
//        //两个Code进行比对，如果对上了->设置值 这里可以进行一个判断，在这个leftTrees里面进行遍历，
//        //如果找到相同的fcode，则说明这个JSONObject是下面的tree的上级，插入到它的下面
//        if(code.equals(codeMap.get("fcode"))){
//            setTree(object);
//
//        }
//        for (Object obj:jsonArray){
//            JSONObject jsonObject= (JSONObject) obj;
//            if(jsonObject.getString("power")!=null){
//                leftTrees.add(setTree(jsonObject));
//            }
//            if(jsonObject.getString("tree")!=null){
//                codeMap.put("fcode",jsonObject.getString("fcode"));
//                leftTrees(jsonObject);
//            }
//        }
//        return leftTrees;
//    }


    /**
     * 设置LeftTree
     *
     * @param jsonObject
     * @return
     */
     LeftTree setTree(JSONObject jsonObject) {
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

    /**
     * 判断是否还有下一层
     *
     * @param jsonObject
     * @return
     */
    JSONArray haveTree(JSONObject jsonObject) {
        return JSON.parseArray(jsonObject.getString("tree"));
    }


}
