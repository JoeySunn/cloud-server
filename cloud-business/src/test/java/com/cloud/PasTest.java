package com.cloud;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cloud.code.model.json.LeftTree;
import com.cloud.code.service.UserService;
import com.cloud.enums.CharseNameEnum;
import com.cloud.exception.CloudException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.ResourceUtils;

import javax.annotation.Resource;
import java.io.*;
import java.net.URL;
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

    @Test
    public void findByUser() {

        //System.out.println(getFileContent(path));
//        String code = "company";
////        List<RoleTree> roleList = new ArrayList<>();
//        User user = userService.findUserById(1);
////        List<LeftTree> leftTrees = getLeftTree(code, (JSONArray) JSON.parse(user.getRole().getRoleCode()), roles);
//        getLeftTree(code, (JSONArray) JSON.parse(user.getRole().getRoleCode()));
//        System.out.println("----------------------------------------" + leftTrees);
//        Assert.assertNotNull(leftTrees);
    }


    /**
     * 获取文件内容
     * @param path
     * @return
     */
    public String getFileContent(String path){
        ClassPathResource classPathResource=new ClassPathResource("properties/powerTree.json");
        InputStream inputStream=null;
        BufferedReader bufferedReader=null;
        String b ;
        StringBuffer stringBuffer=new StringBuffer();
        try {
            inputStream= classPathResource.getInputStream();
            bufferedReader=  new BufferedReader(new InputStreamReader(inputStream,CharseNameEnum.UTF_8.getCharName()));
            while ((b=bufferedReader.readLine())!=null){
                stringBuffer.append(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(inputStream!=null){
                    inputStream.close();
                }
                if(bufferedReader!=null){
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        System.out.println(stringBuffer);
        return "";
    }


    /**
     * 获得用户对应的权限
     *
     * @return
     */
    private void getLeftTree(String code, Object roleObj) {
        //第一步，取到标题级
        JSONArray jsonArray = (JSONArray) roleObj;
        //第二步，进行遍历
        for (Object obj : jsonArray) {
            JSONObject jsonObject = (JSONObject) obj;
            /*
             *在遍历中进行判断是否和Code值相等(这里的Code是前端传来的标题级的fcode，
             */
            if (code.equals(jsonObject.getString("fcode"))) {
                /*
                 *如果比对上，说明就是这一级，然后再进行遍历,从大标题下取得这个角色
                 *左侧有多少个LeftMenu),这里可以直接传标题下的tree，转换成一个JSON
                 *数组
                 */
                leftTrees(JSON.parseArray(jsonObject.getString("tree")));
            }
        }
    }

    private void leftTrees(Object object) {
        //这里取到的就是标题级下的JSON数组，可以进行递归遍历
        JSONArray jsonArray = (JSONArray) object;
        for (Object obj : jsonArray) {
            JSONObject jsonObject = (JSONObject) obj;
            leftTrees.add(setTree(jsonObject));
            addTree(jsonObject, leftTrees);
            if (haveTree(jsonObject) != null) {
                leftTrees(JSON.parseArray(jsonObject.getString("tree")));
            }
        }

    }

    void addTree(JSONObject jsonObject, List<LeftTree> trees) {

    }


    void setLeftMenu(String code, List<LeftTree> trees) {
        for (LeftTree leftTree : trees) {
            if (leftTree.getFcode().equals(code)) {
                leftTree.getTree().add(leftTree);
            } else {
                setLeftMenu(code, leftTree.getTree());
            }
        }

    }


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
