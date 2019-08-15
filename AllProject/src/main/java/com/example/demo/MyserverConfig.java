package com.example.demo;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyserverConfig {
   //注册servlet
	@Bean
	public ServletRegistrationBean myservlet()
	{
		ServletRegistrationBean SRB=new ServletRegistrationBean(new servlet_servercontroller(),"/wx");
		return SRB;
	}
}
