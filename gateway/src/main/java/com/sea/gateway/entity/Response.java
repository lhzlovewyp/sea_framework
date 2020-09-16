package com.sea.gateway.entity;

import java.io.Serializable;

/**
 * @ClassName
 * @Description TODO
 * @Author lvhaizhen
 * @Date 2020/9/7 下午2:38
 * @Version 1.0
 */
public class Response implements Serializable {

  private String code;

  private String message;

  private String Data;

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getData() {
    return Data;
  }

  public void setData(String data) {
    Data = data;
  }
}
