package com.cloud.result;

import java.util.List;

/**
 * 作用描述
 *
 * @ProjectName: cloud-manager
 * @Package: com.cloud.result
 * @Description: 作用描述
 * @Author: 钱佳豪
 * @CreateDate: 2018/1/18 15:36
 * @UpdateDate: 2018/1/18 15:36
 * @UpdateRemark: The modified content
 * @Version: 1.0
 **/
public class ResultBean<T> extends BaseResult {
    protected T data;

    protected List<T> lists;

    protected boolean status = true;

    public ResultBean(T data, boolean status) {
        this.data = data;
        this.status = status;
    }

    public ResultBean() {
    }

    public ResultBean lists(List<T> list) {
        this.setLists(list);
        return this;
    }

    public ResultBean data(T data) {
        this.setData(data);
        return this;
    }

    public ResultBean status(Boolean status) {
        this.setStatus(status);
        return this;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<T> getLists() {
        return lists;
    }

    public void setLists(List<T> lists) {
        this.lists = lists;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public ResultBean content(T data, String message, boolean status) {
        this.setData(data);
        this.setStatus(status);
        this.setMessage(message);
        return this;
    }

    public ResultBean messageAndState(String message,Boolean state){
        this.setMessage(message);
        this.setStatus(state);
        return this;
    }



}
