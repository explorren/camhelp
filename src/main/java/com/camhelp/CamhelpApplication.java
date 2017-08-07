package com.camhelp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.web.MultipartProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.MultipartConfigElement;
import javax.servlet.Servlet;

@SpringBootApplication
@RestController
public class CamhelpApplication {

	@RequestMapping("/")
	public String Hello(){

		return "hello";
	}

	public static void main(String[] args) {
		SpringApplication.run(CamhelpApplication.class, args);
	}
	/**
	 * 解除上传文件的限制
	 */
	@Configuration
	@ConditionalOnClass({Servlet.class, StandardServletMultipartResolver.class,
			MultipartConfigElement.class})
	@ConditionalOnProperty(prefix = "spring.http.multipart", name = "enabled", matchIfMissing = true)
	@EnableConfigurationProperties(MultipartProperties.class)
	public class MultipartAutoConfiguration {

		private final MultipartProperties multipartProperties;

		public MultipartAutoConfiguration(MultipartProperties multipartProperties) {
			this.multipartProperties = multipartProperties;
			multipartProperties.setMaxFileSize("-1");
		}

		@Bean
		@ConditionalOnMissingBean
		public MultipartConfigElement multipartConfigElement() {
			return this.multipartProperties.createMultipartConfig();
		}

		@Bean(name = DispatcherServlet.MULTIPART_RESOLVER_BEAN_NAME)
		@ConditionalOnMissingBean(MultipartResolver.class)
		public StandardServletMultipartResolver multipartResolver() {
			StandardServletMultipartResolver multipartResolver = new StandardServletMultipartResolver();
			multipartResolver.setResolveLazily(this.multipartProperties.isResolveLazily());
			return multipartResolver;
		}

	}

}
