package com.cloud.enums;

/**
 * 作用描述
 *
 * @ProjectName: cloud-manager
 * @Package: com.cloud.enums
 * @Description: 状态枚举类
 * @Author: 钱佳豪
 * @CreateDate: 2018/1/19 15:56
 * @UpdateDate: 2018/1/19 15:56
 * @UpdateRemark: The modified content
 * @Version: 1.0
 **/
public enum StatusEnum {
    ENABLE(0,"正常"),
    DELETE(1,"删除"),
    DISABLE(2,"禁用");

    private int index;

    private String message;

    StatusEnum(int index, String message) {
        this.index = index;
        this.message = message;
    }

    public static StatusEnum getCode(String message){
        for (StatusEnum statusEnum : StatusEnum.values()) {
            if (statusEnum.getMessage().equals(message)) {
                return statusEnum;
            }
        }
        return null;
    }

    StatusEnum(int index){
        this.index=index;
    }

    StatusEnum(String message){
        this.message=message;
    }


    public int getIndex() {
        return index;
    }

    public String getMessage() {
        return message;
    }
}
