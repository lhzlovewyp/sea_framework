package com.sea.gateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @ClassName
 * @Description TODO
 * @Author lvhaizhen
 * @Date 2020/9/4 下午5:59
 * @Version 1.0
 */
public class SignValidateFilter implements GatewayFilter, Ordered {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  private static final String ELAPSED_TIME_BEGIN = "elapsedTimeBegin";



  @Override
  public int getOrder() {
    return 0;
  }

  @Override
  public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
    exchange.getAttributes().put(ELAPSED_TIME_BEGIN, System.currentTimeMillis());
    return chain.filter(exchange).then(
        Mono.fromRunnable(() -> {
          Long startTime = exchange.getAttribute(ELAPSED_TIME_BEGIN);
          if (startTime != null) {
            System.out.println(exchange.getRequest().getURI().getRawPath() + ": " + (System.currentTimeMillis() - startTime) + "ms");
          }
        })
    );
  }
}
