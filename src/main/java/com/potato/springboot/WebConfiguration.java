package com.potato.springboot;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 在项目中会使用filters用于录调用日志、排除有XSS威胁的字符、执行权限验证等等。Spring
 * Boot自动添加了OrderedCharacterEncodingFilter和HiddenHttpMethodFilter，
 * 并且我们可以自定义Filter。 两个步骤： 实现Filter接口，实现Filter方法 添加@Configurationz
 * 注解，将自定义Filter加入过滤链
 * 
 * @author Tim
 *
 */
@Configuration
public class WebConfiguration {

	@Bean
	public RemoteIpFilter remoteIpFilter() {
		return new RemoteIpFilter();
	}

	@Bean
	public FilterRegistrationBean testFilterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new MyFilter());
		registration.addUrlPatterns("/*");
		registration.addInitParameter("paramName", "paramValue");
		registration.setName("MyFilter");
		registration.setOrder(1);
		return registration;
	}

}

class MyFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest _request = (HttpServletRequest) request;
		System.out.println("this is MyFilter,url :" + _request.getRequestURI());
		chain.doFilter(_request, response);
	}

	@Override
	public void destroy() {

	}

}
