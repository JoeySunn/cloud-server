package com.cloud;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cloud.code.model.json.PowerTree;
import com.cloud.code.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
 * @CreateDate: 2018/5/3 14:25
 * @UpdateDate: 2018/5/3 14:25
 * @UpdateRemark: The modified content
 * @Version: 1.0
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PowerTest {

    @Resource
    private UserService userService;


    @Test
    public void testPower() {
        String rule="^2016\\d{8}$";
        String obdId="201612345678";
        System.out.println(obdId.matches(rule));
        //String code="insInBrokers";
        //String roleCode = userService.findUserById(1).getRole().getRoleCode();
        //getPower(code,roleCode);

    }


    List<PowerTree> getPower(String code, Object content) {
        JSONArray jsonArray = (JSONArray) content;
        List<PowerTree> trees=new ArrayList<>();
        for (Object object : jsonArray) {
            JSONObject jsonObject= (JSONObject) object;
            if(getPowerArray(jsonObject)==null){
                getPower(code,getPowerArray(jsonObject));
            }else{
                if(code.equals(jsonObject.getString("fcode"))){
                    for(Object powerObject: getPowerArray(jsonObject)){
                        JSONObject jsonPower= (JSONObject) powerObject;
                        PowerTree powerTree=setPower(jsonPower);
                        trees.add(powerTree);
                        if(getPowerArray(jsonPower)!=null){
                            getRightMenu(powerTree,jsonPower);
                        }
                    }
                }
            }
        }
        return trees;
    }

    void getRightMenu(PowerTree powerTree,JSONObject jsonObject){
        for(Object object:getPowerArray(jsonObject)){
            JSONObject powerObject= (JSONObject) object;
            PowerTree power=setPower(jsonObject);
            powerTree.getPowerTrees().add(power);
            if(getPowerArray(powerObject)!=null){
                getRightMenu(power,powerObject);
            }
        }
    }


    PowerTree setPower(JSONObject jsonObject){
        PowerTree powerTree=new PowerTree();
        powerTree.setFcode(jsonObject.getString("fcode"));
        powerTree.setTitle(jsonObject.getString("title"));
        return powerTree;
    }

    JSONArray getPowerArray(JSONObject jsonObject){
        return JSON.parseArray(jsonObject.getString("power"));
    }



}
