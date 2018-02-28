package com.cloud.code.model.user;

import com.cloud.code.model.role.Role;
import com.cloud.model.BaseModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 作用描述
 *
 * @ProjectName: cloud-server
 * @Package: com.cloud.code.model
 * @Description: 作用描述
 * @Author: 钱佳豪
 * @CreateDate: 2018/2/9 15:06
 * @UpdateDate: 2018/2/9 15:06
 * @UpdateRemark: The modified content
 * @Version: 1.0
 **/
public class UserDTO extends BaseModel{

    @ApiModelProperty(value = "实体Id")
    private Integer id;

    @ApiModelProperty(value = "实体创建时间")
    private Date createTime;

    @ApiModelProperty(value = "实体状态 0-正常 1-删除 2-禁用")
    private Integer state;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "密码")
    private String passWord;

    @ApiModelProperty(value = "用户真实姓名")
    private String name;

    @ApiModelProperty(value = "手机号码")
    private String mobile;

    @ApiModelProperty(value = "用户所属角色")
    private Role role;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", role=" + role +
                ", id=" + id +
                ", createTime=" + createTime +
                ", state=" + state +
                '}';
    }
}
