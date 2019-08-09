package com.ktjr.service.fallback;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 路由失败时的 降级/熔断 逻辑
 *
 * @author jianglongtao
 */
@Component
public class MyFallbackProvider implements FallbackProvider {


    @Override
    public String getRoute() {
        /**
         * 表明为哪个微服务提供回退
         * return "*" 或 null 代表为所有微服务提供fallback
         */
//      return "service-feign";
        return null;
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {
            /**
             * 网关向api服务请求是失败了，但是消费者客户端向网关发起的请求是OK的，
             * 不应该把api的404,500等问题抛给客户端
             * 网关和api服务集群对于客户端来说是黑盒子
             */
            @Override
            public HttpStatus getStatusCode() throws IOException {
                // 获取状态码(200,OK)
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                // 返回数字状态码
                return HttpStatus.OK.value();
            }

            @Override
            public String getStatusText() throws IOException {
                // 返回字母状态码
                return HttpStatus.OK.getReasonPhrase();
            }

            @Override
            public void close() {

            }

            /**
             * 返回给客户端的消息体
             */
            @Override
            public InputStream getBody() throws IOException {
                Map<String, String> result = new HashMap<>();
                result.put("code", "1000");
                result.put("msg", "服务连接异常,请稍后再试.");

                ObjectMapper mapper = new ObjectMapper();
                String json = mapper.writeValueAsString(result);
                return new ByteArrayInputStream(json.getBytes("UTF-8"));
            }

            /**
             * 返回时的Header体
             */
            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
                return headers;
            }
        };
    }
}
