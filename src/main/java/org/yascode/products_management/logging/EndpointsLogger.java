package org.yascode.products_management.logging;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Component
@Slf4j
public class EndpointsLogger implements ApplicationListener<ApplicationReadyEvent> {
    private final RequestMappingHandlerMapping handlerMapping;

    public EndpointsLogger(RequestMappingHandlerMapping handlerMapping) {
        this.handlerMapping = handlerMapping;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        handlerMapping.getHandlerMethods().forEach((requestMappingInfo, handlerMethod) ->
                log.info("API Endpoint: {} - Handler: {}", requestMappingInfo, handlerMethod.getBean()));
    }
}
