package com.masitbd.spring.soap.api.config;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
@EnableWs
public class SoapWSConfig {
	
	public ServletRegistrationBean<MessageDispatcherServlet>messageDispatcherServerlet(ApplicationContext context){
		    MessageDispatcherServlet serverlet = new MessageDispatcherServlet();
		    serverlet.setApplicationContext((org.springframework.context.ApplicationContext) context);
     	    serverlet.setTransformWsdlLocations(true);
		    return new ServletRegistrationBean<MessageDispatcherServlet>(serverlet,"/ws/*");
		
		    
	}
	@Bean(name="LoanEligibility")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema schema) {
		   DefaultWsdl11Definition defaultWsdl11Definition = new DefaultWsdl11Definition();
		   defaultWsdl11Definition.setPortTypeName("LoanEligibility");
		   defaultWsdl11Definition.setLocationUri("/ws");
		   defaultWsdl11Definition.setTargetNamespace("http://www.masitbd.com/spring/soap/api/loanEligibility");
		   defaultWsdl11Definition.setSchema(schema);
		return defaultWsdl11Definition;
	}
	@Bean
	public XsdSchema schema() {
		return new SimpleXsdSchema(new ClassPathResource("loaneligibility.xsd"));
	}
 
}
