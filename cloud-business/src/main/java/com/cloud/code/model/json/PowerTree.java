package com.cloud.code.model.json;

import java.util.ArrayList;
import java.util.List;

/**
 * 作用描述
 *
 * @ProjectName: cloud-server
 * @Package: com.cloud.code.model.json
 * @Description: 作用描述
 * @Author: 钱佳豪
 * @CreateDate: 2018/5/3 14:27
 * @UpdateDate: 2018/5/3 14:27
 * @UpdateRemark: The modified content
 * @Version: 1.0
 **/
public class PowerTree {
    /**
     * 标题
     */
    private String title;

    /**
     * fcode
     */
    private String fcode;

    /**
     * 下级页面权限
     */
    private List<PowerTree> powerTrees=new ArrayList<>();

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

    public List<PowerTree> getPowerTrees() {
        return powerTrees;
    }

    public void setPowerTrees(List<PowerTree> powerTrees) {
        this.powerTrees = powerTrees;
    }
}
