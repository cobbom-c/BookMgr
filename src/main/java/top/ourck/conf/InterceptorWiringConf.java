package top.ourck.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import top.ourck.interceptor.TeacherAuthInterceptor;
import top.ourck.interceptor.AdminAuthInterceptor;
import top.ourck.interceptor.RememberedUserInterceptor;
import top.ourck.interceptor.StudentAuthInterceptor;

@Configuration
public class InterceptorWiringConf implements WebMvcConfigurer {

	@Autowired
	private RememberedUserInterceptor uaInterceptor;
	
	@Autowired
	private TeacherAuthInterceptor taInterceptor;
	
	@Autowired
	private StudentAuthInterceptor saInterceptor;
	
	@Autowired
	private AdminAuthInterceptor adminInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(uaInterceptor);
		registry.addInterceptor(taInterceptor).addPathPatterns("/tch", "/tch/**");
		registry.addInterceptor(saInterceptor).addPathPatterns("/stu", "/stu/**");
		registry.addInterceptor(adminInterceptor).addPathPatterns("/admin", "/admin/**");
		WebMvcConfigurer.super.addInterceptors(registry);
	}

	
}
