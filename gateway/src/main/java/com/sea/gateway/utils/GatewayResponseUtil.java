package com.sea.gateway.utils;

import com.alibaba.fastjson.JSONObject;
import java.io.Serializable;
import org.springframework.cloud.contract.spec.internal.Response;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.server.reactive.ServerHttpResponse;

/**
 * @ClassName
 * @Description TODO
 * @Author lvhaizhen
 * @Date 2020/9/7 下午3:36
 * @Version 1.0
 */
public class GatewayResponseUtil {

  public static DataBuffer getDataBuffer(ServerHttpResponse response,Serializable t){
    return response.bufferFactory().wrap(JSONObject.toJSON(t).toString().getBytes());
  }
}
