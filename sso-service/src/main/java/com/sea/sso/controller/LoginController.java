package com.sea.sso.controller;

import com.sea.framework.entity.Response;
import com.sea.framework.enums.ErrorCodeEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName
 * @Description TODO
 * @Author lvhaizhen
 * @Date 2020/9/7 下午5:37
 * @Version 1.0
 */
@RestController
public class LoginController {

  @GetMapping("/doLogin")
  public Response<String> doLogin(String username, String password){
    if("test".equals(username) && "test".equals(password)){
      return Response.valueOf(ErrorCodeEnum.SUCCESS.getCode(),ErrorCodeEnum.SUCCESS.getMessage(),null);
    }
    return Response.valueOf(ErrorCodeEnum.NEED_LOGIN.getCode(),ErrorCodeEnum.NEED_LOGIN.getMessage(),null);
  }
}
