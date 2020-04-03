package work.timer.context.foundation;

import java.io.Serializable;

/**
 * @Author DaiMao
 * 个人qq: 12636993
 * @Date 2020/3/23 0023 21:05
 * TODO: (这里用一句话描述这个类的作用)
 */
public class Result<T extends Serializable> implements Serializable {
    private int restCode;
    private String restInfo;
    private T data;

    public static <W extends Serializable> Result success() {
        return new Result<>(200, "登录成功");
    }

    public static <W extends Serializable> Result success(W data) {
        return new Result<>(200, data);
    }

    public static <W extends Serializable> Result success(String restInfo, W data) {
        return new Result<>(restInfo, data);
    }

    public static <W extends Serializable> Result success(int code, String restInfo, W data) {
        return new Result<>(code, restInfo, data);
    }

    public static <W extends Serializable> Result failed() {
        return new Result(500);
    }

    public static <W extends Serializable> Result failed(String restInfo) {
        return new Result(500, restInfo);
    }

    public static <w extends Serializable> Result failed(int code, String restInfo) {
        return new Result(code, restInfo);
    }

    public Result(String restInfo, T data) {
        this.restInfo = restInfo;
        this.data = data;
    }

    public Result(int restCode, T data) {
        this.restCode = restCode;
        this.data = data;
    }

    public int getRestCode() {
        return restCode;
    }

    public void setRestCode(int restCode) {
        this.restCode = restCode;
    }

    public String getRestInfo() {
        return restInfo;
    }

    public void setRestInfo(String restInfo) {
        this.restInfo = restInfo;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Result(int restCode, String restInfo, T data) {
        this.restCode = restCode;
        this.restInfo = restInfo;
        this.data = data;
    }

    public Result(int restCode, String restInfo) {
        this.restCode = restCode;
        this.restInfo = restInfo;
    }

    public Result(int restCode) {
        this.restCode = restCode;
    }
}
