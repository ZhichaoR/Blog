package rjgc.ten.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import rjgc.ten.blog.web.interceptor.BaseInterceptor;
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Autowired
    private BaseInterceptor baseInterceptor;

    @Override
    // 重写addInterceptors()方法，注册自定义拦截器
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(baseInterceptor);
    }
}
