package com.sea.gateway.filter.global;

import com.sea.framework.enums.ErrorCodeEnum;
import com.sea.gateway.utils.GatewayResponseUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @ClassName
 * @Description TODO
 * @Author lvhaizhen
 * @Date 2020/9/7 下午3:02
 * @Version 1.0
 */
@Component
public class GlobalTokenValidateGatewayFilter implements GlobalFilter, Ordered {

  private static final String TOKEN = "token";

  private static final String[] NOT_NEED_LOGIN_URL = {"/doLogin"};

  @Override
  public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

    ServerHttpRequest request = exchange.getRequest();
    if(isInNotNeedLoginUrl(request.getPath().value())){
      return chain.filter(exchange);
    }

    HttpHeaders headers = request.getHeaders();

    String token = headers.getFirst(TOKEN);
    if(StringUtils.isBlank(token)){
      token = request.getQueryParams().getFirst(TOKEN);
    }
    ServerHttpResponse response = exchange.getResponse();
    if(StringUtils.isBlank(token)){
      response.setStatusCode(HttpStatus.OK);
      DataBuffer result = GatewayResponseUtil.getDataBuffer(response,com.sea.framework.entity.Response.valueOf(ErrorCodeEnum.NEED_LOGIN.getCode(),ErrorCodeEnum.NEED_LOGIN.getMessage(),null));
      return response.writeWith(Flux.just(result));
    }
    return chain.filter(exchange);
  }

  private void addPublicHeaders(HttpHeaders headers){
    headers.add("Content-Type", "text/plain;charset=UTF-8");
  }
  private Boolean isInNotNeedLoginUrl(String url){
    for(String  str: NOT_NEED_LOGIN_URL){
      if(url.contains(str)){
        return Boolean.TRUE;
      }
    }
    return Boolean.FALSE;
  }

  @Override
  public int getOrder() {
    return 0;
  }
}
