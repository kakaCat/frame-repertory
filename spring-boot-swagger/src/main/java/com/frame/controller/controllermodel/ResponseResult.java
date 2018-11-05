package com.frame.controller.controllermodel;

import java.util.UUID;

public class ResponseResult<T> {

    /** 请求ID, UUID, 用于确定请求唯一标识 */
    private String requestId;
    /** 请求成功与否 */
    private boolean success;
    /** 请求返回对象数据 */
    private T data;
    /**  请求响应码 */
    private String apiCode;
    /** 请求响应信息 */
    private String apiMessage;
    /** 服务器时间 默认返回当前时间戳 */
    private long serverTime = System.currentTimeMillis();
    /** 接口调用花费时间 */
    private long processTime;

    public static <T> ResponseResult<T> success(T data) {
        return new ResponseResult<T>(data);
    }

    public static <T> ResponseResult<T> success(String requestId, T data) {
        ResponseResult<T> result = new ResponseResult<>(requestId, true);
        result.setData(data);
        return result;
    }

    public static ResponseResult<Void> failure() {
        return new ResponseResult<Void>(false);
    }

    public static ResponseResult<Void> failure(String requestId) {
        return new ResponseResult<Void>(requestId, false);
    }

    public ResponseResult() {
        this(true);
    }

    public ResponseResult(T data) {
        this(true);
        this.data = data;
    }

    public ResponseResult(boolean success) {
        this(UUID.randomUUID().toString(), success);
    }

    public ResponseResult(String requestId, boolean success) {
        this.requestId = requestId;
        this.success = success;
    }

    public String getRequestId() {
        return requestId;
    }

    public ResponseResult<T> setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }

    public boolean isSuccess() {
        return success;
    }

    public ResponseResult<T> setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResponseResult<T> setData(T data) {
        this.data = data;
        return this;
    }

    public String getApiCode() {
        return apiCode;
    }

    public ResponseResult<T> setApiCode(String apiCode) {
        this.apiCode = apiCode;
        return this;
    }

    public String getApiMessage() {
        return apiMessage;
    }

    public ResponseResult<T> setApiMessage(String apiMessage) {
        this.apiMessage = apiMessage;
        return this;
    }

    public ResponseResult<T> setApiCodeMessage(String apiCode, String apiMessage) {
        return setApiCode(apiCode).setApiMessage(apiMessage);
    }

    /**
     * 默认返回当前时间戳
     *
     * @return
     */
    public long getServerTime() {
        return this.serverTime;
    }

    public void setServerTime(long serverTime) {
        this.serverTime = serverTime;
    }

    public long getProcessTime() {
        return processTime;
    }

    public void setProcessTime(long processTime) {
        this.processTime = processTime;
    }

}
