package me.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import me.conf.MyInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="me.test")
//@PropertySource(value={"classpath:myprop.properties"})
@PropertySource(value={"classpath:/me/test/myprop.properties"})
public class ApplicationConfiguration extends WebMvcConfigurerAdapter {

	@Value("${name:Kumar}")
	private String names;
	
	@Bean
	public String getMyName() {
		return names;
	}
	
	@Bean
	public CommonsRequestLoggingFilter requestLoggingFilter() {
		//Need to enable String logger.
	    CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
	    loggingFilter.setIncludeClientInfo(true);
	    loggingFilter.setIncludeQueryString(true);
	    loggingFilter.setIncludePayload(true);
	    return loggingFilter;
	}
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//super.addInterceptors(registry);
		registry.addInterceptor(new MyInterceptor());
	}

//	@Bean
//	public static PropertyPlaceholderConfigurer placeHolderConfigurer() {
//		return new PropertyPlaceholderConfigurer();
//	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer  place2HolderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

}
