package com.cloud.code.controller;

import com.alibaba.fastjson.JSONObject;
import com.cloud.code.model.role.Role;
import com.cloud.code.service.RoleService;
import com.cloud.constant.MessageConstant;
import com.cloud.util.JSONUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 作用描述
 *
 * @ProjectName: cloud-server
 * @Package: com.cloud.code.controller
 * @Description: 作用描述
 * @Author: 钱佳豪
 * @CreateDate: 2018/3/5 10:02
 * @UpdateDate: 2018/3/5 10:02
 * @UpdateRemark: The modified content
 * @Version: 1.0
 **/
@RestController
@RequestMapping("role")
@Api(value = "RoleController",description = "角色控制层")
public class RoleController {
    @Resource
    private RoleService roleService;


    @ApiOperation(value = "添加角色")
    @PostMapping("add_role")
    @ResponseBody
    public JSONObject addRole(
            @ApiParam(name = "role",value = "用户角色")
            @RequestBody Role role){
        if(roleService.addRole(role)!=null){
            return JSONUtil.finalData(new Role(), MessageConstant.INSERT_MESSAGE_OK, MessageConstant.OK);
        }
        return JSONUtil.finalData(null, MessageConstant.INSERT_MESSAGE_ERROR, MessageConstant.NO);
    }

    @ApiOperation(value = "修改角色")
    @PostMapping("update_role")
    @ResponseBody
    public JSONObject updateRole(@ApiParam(name = "role",value = "用户角色")
                                 @RequestBody Role role){

        return null;
    }
}
