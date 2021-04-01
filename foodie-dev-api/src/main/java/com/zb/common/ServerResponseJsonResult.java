package com.zb.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Author: zhaobao1830
 * @Date: 2021/4/1 14:53
 * @Description: 自定义响应数据结构
 * 				本类可提供给 H5/ios/安卓/公众号/小程序 使用
 * 				前端接受此类数据（json object)后，可自行根据业务去实现相关功能
 *
 * 				200：表示成功
 * 				500：表示错误，错误信息在msg字段中
 * 				501：bean验证错误，不管多少个错误都以map形式返回
 * 				502：拦截器拦截到用户token出错
 * 				555：异常抛出信息
 * 				556: 用户qq校验异常
 */
public class ServerResponseJsonResult {
    /**
     *  定义jackson对象(我还没有搞懂这行代码是干什么)
     */
    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * 响应业务状态
     */
    private Integer status;

    /**
     * 响应信息
     */
    private String msg;

    /**
     * 响应数据
     */
    private Object data;

    /**
     *  不在json结果中显示
     */
    @JsonIgnore
    private String ok;

    public static ServerResponseJsonResult ok(Object data) {
        return new ServerResponseJsonResult(data);
    }

    public static ServerResponseJsonResult ok() {
        return new ServerResponseJsonResult(null);
    }

    public static ServerResponseJsonResult errorMsg(String msg) {
        return new ServerResponseJsonResult(500, msg, null);
    }

    public static ServerResponseJsonResult errorMap(Object data) {
        return new ServerResponseJsonResult(501, "error", data);
    }

    public static ServerResponseJsonResult errorTokenMsg(String msg) {
        return new ServerResponseJsonResult(502, msg, null);
    }

    public static ServerResponseJsonResult errorException(String msg) {
        return new ServerResponseJsonResult(555, msg, null);
    }

    public static ServerResponseJsonResult errorUserQQ(String msg) {
        return new ServerResponseJsonResult(556, msg, null);
    }

    public ServerResponseJsonResult() { }

    public ServerResponseJsonResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public ServerResponseJsonResult(Integer status, String msg, Object data, String ok) {
        this.status = status;
        this.msg = msg;
        this.data = data;
        this.ok = ok;
    }

    public ServerResponseJsonResult(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    public Boolean isOK() {
        return this.status == 200;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }
}
