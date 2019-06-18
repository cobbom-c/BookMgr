package top.ourck.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import top.ourck.interceptor.LoginCheckInterceptor;
import top.ourck.interceptor.UserAuthInterceptor;

@Configuration
public class InterceptorWiringConf implements WebMvcConfigurer {

	@Autowired
	private UserAuthInterceptor uaInterceptor;
	
	@Autowired
	private LoginCheckInterceptor lcInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(uaInterceptor);
		registry.addInterceptor(lcInterceptor).addPathPatterns("/tch/*", "/tch/*/");
		WebMvcConfigurer.super.addInterceptors(registry);
	}

	
}
