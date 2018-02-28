package com.cloud.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import java.util.Date;

/**
 * @ProjectName: cloud-server
 * @Package: com.cloud.model
 * @Description: 继承持久化类
 * @Author: 钱佳豪
 * @CreateDate: 2018/2/9 15:15
 * @UpdateDate: 2018/2/9 15:15
 * @UpdateRemark: The modified content
 * @Version: 1.0
 **/
public class BaseDO {

    @Column(name = "create_time")
    @ApiModelProperty(value = "实体创建时间")
    protected Date createTime;

    @Column(name = "state")
    @ApiModelProperty(value = "实体状态 0-正常 1-删除 2-禁用")
    protected Integer state;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}

