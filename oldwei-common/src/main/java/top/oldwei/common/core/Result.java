package top.oldwei.common.core;

import lombok.Data;
import top.oldwei.common.constant.ResponseCode;

import java.io.Serializable;

/**
 * @Author:weizd
 * @Date:20-1-16
 */
@Data
public class Result<T> implements Serializable {


    private T data;

    private String msg;

    private Integer code;

    private Result(String msg,Integer code,T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private Result(String msg,Integer code){
        this.code = code;
        this.msg = msg;
    }

    private Result(){}

    public static Result fail(String msg){
        Result result = new Result(msg, ResponseCode.ERROR);
        return  result;
    }

    public static <D> Result<D> success(String msg){
        return  success(msg,null);
    }


    public static <D> Result<D> success(String msg,D data){
        Result result = new Result(msg, ResponseCode.SUCCESS,data);
        return  result;
    }


    public static <D> Result<D> r(String msg,D data){
        Result result = new Result(msg, ResponseCode.SUCCESS,data);
        return  result;
    }







}
