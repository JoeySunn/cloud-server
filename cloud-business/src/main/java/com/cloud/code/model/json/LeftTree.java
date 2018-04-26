package com.cloud.code.model.json;

import java.util.ArrayList;
import java.util.List;

/**
 * 作用描述
 *
 * @ProjectName: cloud-server
 * @Package: com.cloud.code.model.json
 * @Description: 所有侧边栏权限
 *
 * @Author: 钱佳豪
 * @CreateDate: 2018/3/21 14:04
 * @UpdateDate: 2018/3/21 14:04
 * @UpdateRemark: The modified content
 * @Version: 1.0
 **/
public class LeftTree {
    private String title;

    private String fcode;

    private String funname;

    private List<LeftTree> tree=new ArrayList<>();

    private String type;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFcode() {
        return fcode;
    }

    public void setFcode(String fcode) {
        this.fcode = fcode;
    }

    public String getFunname() {
        return funname;
    }

    public void setFunname(String funname) {
        this.funname = funname;
    }

    public List<LeftTree> getTree() {
        return tree;
    }

    public void setTree(List<LeftTree> tree) {
        this.tree = tree;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
