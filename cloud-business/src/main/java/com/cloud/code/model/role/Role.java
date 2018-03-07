package com.cloud.code.model.role;

import com.cloud.model.BaseDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Date;

/**
 * 作用描述
 *
 * @ProjectName: cloud-server
 * @Package: com.cloud.code.model.role
 * @Description: 作用描述
 * @Author: 钱佳豪
 * @CreateDate: 2018/2/9 15:21
 * @UpdateDate: 2018/2/9 15:21
 * @UpdateRemark: The modified content
 * @Version: 1.0
 **/
@Entity
@Table(name = "role")
@ApiModel(description = "角色模型")
public class Role  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "用户Id")
    private Integer id;

    @Column(name = "create_time")
    @ApiModelProperty(value = "实体创建时间")
    private Date createTime;

    @Column(name = "state")
    @ApiModelProperty(value = "实体状态 0-正常 1-删除 2-禁用")
    private Integer state;

    @Column(name = "role_name")
    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @Column(name = "role_type")
    @ApiModelProperty(value = "角色类型")
    private Integer roleType;

    @Column(name = "description")
    @ApiModelProperty(value = "角色描述")
    private String description;

    @Column(name = "role_code")
    @ApiModelProperty(value = "权限Code")
    private String roleCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getRoleType() {
        return roleType;
    }

    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", state=" + state +
                ", roleName='" + roleName + '\'' +
                ", roleType=" + roleType +
                ", description='" + description + '\'' +
                ", roleCode='" + roleCode + '\'' +
                '}';
    }
}
