package com.rbac.exception;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * Created by hahah on 2017/5/4.
 */
@Configuration
public class AppErrorPagesConfiguration {

    public EmbeddedServletContainerCustomizer containerCustomizer(){
        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,"/error/404"));
                container.addErrorPages(new ErrorPage(HttpStatus.BAD_REQUEST,"/error/400"));
                container.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/error/500"));
                container.addErrorPages(new ErrorPage(Throwable.class,"/error/500"));
            }
        };
    }
}
