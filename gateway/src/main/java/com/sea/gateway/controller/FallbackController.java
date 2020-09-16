package com.sea.gateway.controller;

import com.sea.gateway.entity.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @ClassName
 * @Description TODO
 * @Author lvhaizhen
 * @Date 2020/9/7 下午2:36
 * @Version 1.0
 */
@RestController
public class FallbackController {
  @GetMapping("/fallback")
  public Mono<Response> fallback() {
    Response response = new Response();
    response.setCode("100");
    response.setMessage("服务暂时不可用");
    return Mono.just(response);
  }
}
