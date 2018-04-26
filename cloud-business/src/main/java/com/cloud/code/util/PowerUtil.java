package com.cloud.code.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cloud.code.model.json.LeftTree;

/**
 * 作用描述
 *
 * @ProjectName: cloud-server
 * @Package: com.cloud.code.util
 * @Description: 作用描述
 * @Author: 钱佳豪
 * @CreateDate: 2018/4/26 13:30
 * @UpdateDate: 2018/4/26 13:30
 * @UpdateRemark: The modified content
 * @Version: 1.0
 **/
public class PowerUtil {

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

}
