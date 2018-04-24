package com.cloud.enums;

/**
 * 作用描述
 *
 * @ProjectName: cloud-server
 * @Package: com.cloud.enums
 * @Description: 作用描述
 * @Author: 钱佳豪
 * @CreateDate: 2018/4/23 16:59
 * @UpdateDate: 2018/4/23 16:59
 * @UpdateRemark: The modified content
 * @Version: 1.0
 **/
public enum CharseNameEnum {
    UTF_8(0,"UTF-8"),
    ISO8859_1(1,"ISO8859-1"),
    ANSI(2,"ANSI"),
    GBK(3,"GBK"),
    UNICODE(4,"UniCode");

    private Integer index;

    private String CharName;

    CharseNameEnum(Integer index, String charName) {
        this.index = index;
        CharName = charName;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getCharName() {
        return CharName;
    }

    public void setCharName(String charName) {
        CharName = charName;
    }
}
