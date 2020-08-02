package com.home.jblog.config;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableTransactionManagement
@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer{
	
	@Autowired
	@Qualifier(value = "webInterceptor")
	private WebInterceptor webInterceptor;
	
	private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
				 "classpath:/META-INF/resources/"
				,"classpath:/static/"
				,"classpath:/static/css/"
				,"classpath:/static/js/"
				,"classpath:/static/html/"
	};
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// URI 루트로 접근 시, 접근 페이지 세팅
		registry.addRedirectViewController("/", "/index.html");
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
		registry.addResourceHandler("/webjars/**")
				.addResourceLocations("classpath:/static/webjars/", "classpath:/META-INF/resources/webjars/");
		registry.addResourceHandler("/**")
				.addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
	}
	
	@Bean
	public InternalResourceViewResolver resolver() {
		// JSP View resolver 설정
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// Cors 정책을 모두 허용으로 설정
		registry.addMapping("/**");
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(webInterceptor);
//			.addPathPatterns("/**");
		
//		registry.addInterceptor(webInterceptor)
//				.addPathPatterns("/**")
//				.excludePathPatterns("/user/**");
	}
	
	@Bean
	public LocaleResolver localeResolver() {
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver(); // 언어&국가정보가 없는 경우 미국으로 인식하도록 설정
		localeResolver.setDefaultLocale(Locale.KOREAN);
		return localeResolver;
	}
	
	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:/i18n/message_ko");
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setCacheSeconds(180);
		
		// 제공하지 않는 언어로 요청이 들어왔을 때 MessageSource에서 사용할 기본 언어정보.
		Locale.setDefault(Locale.KOREAN);
		return messageSource;
	}
	
//	@Override
//	public void configureMessageConverters(List<HttpMessageConverter> converters) {
//		converters.add(new MyHttpMessageConverter());
//	}
	
}
