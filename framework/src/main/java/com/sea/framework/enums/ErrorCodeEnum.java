package com.sea.framework.enums;

/**
 * @ClassName
 * @Description 异常code编码.
 * @Author lvhaizhen
 * @Date 2020/9/7 下午2:49
 * @Version 1.0
 */
public enum  ErrorCodeEnum {

  SYSTEM_ERROR("-1","系统异常"),
  SUCCESS("0","操作成功"),
  SIGN_ERROR("-10001","签名失败"),
  NEED_LOGIN("10001","请登录")
  ;
  private String code;

  private String message;

  private ErrorCodeEnum(String code, String message){
    this.code = code;
    this.message = message;
  }

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
}
