package org.zerock.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/*
 *	spring5.0 이전에는 WebMvcConfigurer가 아닌  WebMvcConfigurerAdapter 추상클래스를 이용했음.
*/

@EnableWebMvc
@ComponentScan(basePackages = { "org.zerock.controller" , "org.zerock.exception" })
public class ServleConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setViewClass(JstlView.class);
		bean.setPrefix("/WEB-INF/views/");
		bean.setSuffix(".jsp");
		registry.viewResolver(bean);
	}

	/*
	 *   CommonsMultipartResolver - 클래스
	 *   MultipartResolver - Interface 
	 */
	@Bean(name="multipartResolver")
	public CommonsMultipartResolver getResolver() throws IOException {
		
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setDefaultEncoding("UTF-8");
		resolver.setMaxUploadSize(104857560);
		resolver.setMaxUploadSizePerFile(2097152);
		resolver.setUploadTempDir(new FileSystemResource("c:\\upload\\tmp"));
		resolver.setMaxInMemorySize(10485756);
		
		return resolver;
	}
}
