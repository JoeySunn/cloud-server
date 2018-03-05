package com.cloud.code.model.user;

import com.cloud.code.model.role.Role;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 作用描述
 *
 * @ProjectName: cloud-server
 * @Package: com.cloud.code.model.user
 * @Description: 用户持久类
 * @Author: 钱佳豪
 * @CreateDate: 2018/2/11 13:22
 * @UpdateDate: 2018/2/11 13:22
 * @UpdateRemark: The modified content
 * @Version: 1.0
 **/
@Entity
@Table(name = "user")
@ApiModel(description = "用户模型")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(value = "用户Id")
    private Integer id;

    @Column(name = "user_name")
    @ApiModelProperty(value = "用户名")
    private String userName;

    @Column(name = "name")
    @ApiModelProperty(value = "真实姓名")
    private String name;

    @Column(name = "mobile")
    @ApiModelProperty(value = "手机号")
    private String mobile;

    @Column(name = "pass_word")
    @ApiModelProperty(value = "密码")
    private String passWord;

    @Column(name = "create_time")
    @ApiModelProperty(value = "实体创建时间")
    private Date createTime;

    @Column(name = "state")
    @ApiModelProperty(value = "实体状态 0-正常 1-删除 2-禁用")
    private Integer state;

    @ManyToOne(cascade={CascadeType.PERSIST,CascadeType.REMOVE, CascadeType.MERGE}, fetch=FetchType.EAGER)
    @JoinColumn(name = "role_id")
    @ApiModelProperty(value = "对应角色")
    private Role role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", passWord='" + passWord + '\'' +
                ", createTime=" + createTime +
                ", state=" + state +
                ", role=" + role +
                '}';
    }
}
