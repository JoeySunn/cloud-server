package com.cloud.enums;

import io.swagger.models.auth.In;

import java.util.List;

/**
 * 作用描述
 *
 * @ProjectName: cloud-server
 * @Package: com.cloud.enums
 * @Description: 作用描述
 * @Author: 钱佳豪
 * @CreateDate: 2018/3/5 13:45
 * @UpdateDate: 2018/3/5 13:45
 * @UpdateRemark: The modified content
 * @Version: 1.0
 **/
public enum RoleTypeEnums {

    COMPANY_A(0,"保险公司"),
    COMPANY_B(1,"经纪公司"),
    COMPANY_C(2,"平台运营"),
    COMPANY_D(3,"销售渠道");

    private Integer index;

    private String companyName;

    /**
     * 构造
     */
    RoleTypeEnums(int index, String companyName) {
        this.index = index;
        this.companyName = companyName;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

}
