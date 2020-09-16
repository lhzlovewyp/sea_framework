package com.sea.framework.entity;

import com.sea.framework.enums.ErrorCodeEnum;
import java.io.Serializable;

/**
 * @ClassName
 * @Description 网关统一返回对象.
 * @Author lvhaizhen
 * @Date 2020/9/7 下午3:28
 * @Version 1.0
 */
public class Response<T> implements Serializable {

  private static final long serialVersionUID = -5095262943060939321L;
  private String code;

  private String msg;

  private T data;

  public Response(String code,String msg,T data){
    this.code = code;
    this.msg = msg;
    this.data = data;
  }
  public static <T> Response<T> valueOf(String code,String msg,T data){
    return new Response<T>(code,msg,data);
  }
  public static <T> Response<T> valueOf(ErrorCodeEnum errorCodeEnum,T data){
    return new Response<T>(errorCodeEnum.getCode(),errorCodeEnum.getMessage(),data);
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }
}
