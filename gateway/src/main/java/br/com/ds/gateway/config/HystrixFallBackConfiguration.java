package br.com.ds.gateway.config;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

@Configuration
@Slf4j
public class HystrixFallBackConfiguration implements FallbackProvider {

    @Override
    public String getRoute() {
        return "*";
    }

    @Override
    @HystrixCommand
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        log.info("Fallback response method called");
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() {
                return HttpStatus.SERVICE_UNAVAILABLE;
            }

            @Override
            public int getRawStatusCode() {
                return 503;
            }

            @Override
            public String getStatusText() {
                return "The service is unavailable";
            }

            @Override
            public void close() {}

            @Override
            public InputStream getBody() {
                return new ByteArrayInputStream(("{" +
                        addQuotesAndColon("errors") + "[{" +
                        addQuotesAndColon("message") + addQuotes("Sorry, this service is down") + "," +
                        addQuotesAndColon("error") + addQuotes(getStatusText()) + "," +
                        addQuotesAndColon("code") + addQuotes(getStatusCode().toString()) + "}]" +
                        "}")
                        .getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
                return headers;
            }
        };
    }

    private StringBuilder addQuotes(String message) {
        return new StringBuilder().append("\"").append(message).append("\"");
    }

    private StringBuilder addQuotesAndColon(String message) {
        return new StringBuilder().append("\"").append(message).append("\" : ");
    }

}