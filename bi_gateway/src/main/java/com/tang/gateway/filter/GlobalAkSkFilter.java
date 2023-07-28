package com.tang.gateway.filter;


import com.alibaba.fastjson.JSON;
import com.tang.gateway.common.ErrorCode;
import com.tang.gateway.common.ResultUtils;
import com.tang.gateway.constants.GatewayRouteConstants;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;


/**
 * 全局过滤
 *
 * @author huoyouri
 */
@Component
public class GlobalAkSkFilter implements WebFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String path = request.getPath().value();
        ServerHttpResponse response = exchange.getResponse();
        if(GatewayRouteConstants.LOGIN_ADDRESS.equals(path) || GatewayRouteConstants.REGISTER_ADDRESS.equals(path)){
            return chain.filter(exchange);
        }else{
            HttpHeaders headers = request.getHeaders();
            String accessKey = headers.getFirst("accessKey");
            String nonce = headers.getFirst("nonce");
            String timestamp = headers.getFirst("timestamp");
            String sign = headers.getFirst("sign");
            // todo 调数据库来判断AK/SK合法
            if (!"huoyouri".equals(accessKey)){
                return handleNoAuth(response);
            }
            if (Long.parseLong(nonce) > 10000L) {
                return handleNoAuth(response);
            }
            // 时间和当前时间不能超过 5 分钟
            Long currentTime = System.currentTimeMillis() / 1000;
            final Long FIVE_MINUTES = 60 * 5L;
            if ((currentTime - Long.parseLong(timestamp)) >= FIVE_MINUTES) {
                return handleNoAuth(response);
            }
            // todo 实际情况中是从数据库中查出 secretKey
            // String secretKey = invokeUser.getSecretKey();
            // String serverSign = SignUtils.genSign(body, secretKey);
            String serverSign = "huoyouri";
            if (sign == null || !sign.equals(serverSign)) {
                return handleNoAuth(response);
            }
            return chain.filter(exchange);
        }
    }

    @Override
    public int getOrder() {
        return -100;
    }

    public Mono<Void> handleNoAuth(ServerHttpResponse response) {
        response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
        DataBuffer buffer = response.bufferFactory().
                wrap(JSON.toJSONString(ResultUtils.error(ErrorCode.NO_AUTH_ERROR.getCode(), ErrorCode.NO_AUTH_ERROR.getMessage())).
                        getBytes(StandardCharsets.UTF_8));
        //指定编码，否则在浏览器中会中文乱码
        response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        return response.writeWith(Mono.just(buffer));
    }
}
