package org.zerock.config;

import javax.servlet.Filter;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// web.xml을 대신하는 config 파일
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] { RootConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {ServleConfig.class};
	}
	

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] { "/" } ;
	}

	//404 Error 예외처리 
	@Override
	protected void customizeRegistration(Dynamic registration) {
		// TODO Auto-generated method stub
		//super.customizeRegistration(registration);
		registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");
	}
	
	// Filter 설정
	@Override
	protected Filter[] getServletFilters() {
		
		// TODO Auto-generated method stub
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		return new Filter[] { characterEncodingFilter };
	}
	
	
}
