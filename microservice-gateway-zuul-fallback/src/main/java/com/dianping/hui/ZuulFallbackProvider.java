package com.dianping.hui;

import com.netflix.hystrix.exception.HystrixTimeoutException;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * @author: lanxinyu@meituan.com  2018-12-03 1:23 PM
 * @Description: zuul的回退类
 */
@Component
public class ZuulFallbackProvider implements FallbackProvider {
    public ClientHttpResponse fallbackResponse(Throwable cause) {
        if(cause instanceof HystrixTimeoutException) {
            return response(HttpStatus.GATEWAY_TIMEOUT);
        }
        return this.fallbackResponse();
    }

    public String getRoute() {
        //为哪个微服务提供回退，*为所有微服务提供回退
        return "*";
    }

    public ClientHttpResponse fallbackResponse() {
        return this.response(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ClientHttpResponse response(final HttpStatus httpStatus) {
        return new ClientHttpResponse() {
            public HttpStatus getStatusCode() throws IOException {
                return httpStatus;
            }

            public int getRawStatusCode() throws IOException {
                return httpStatus.value();
            }

            public String getStatusText() throws IOException {
                return httpStatus.getReasonPhrase();
            }

            public void close() {

            }

            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream("Lansing说服务不可用，请稍后重试".getBytes());
            }

            public HttpHeaders getHeaders() {
                //headers设定
                HttpHeaders httpHeaders = new HttpHeaders();
                MediaType mediaType = new MediaType("application","json", Charset.forName("UTF-8"));
                httpHeaders.setContentType(mediaType);
                return httpHeaders;
            }
        };
    }
}
