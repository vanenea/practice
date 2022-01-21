package com.chen.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.*;

@Configuration
public class MyConfiguration {

	/*@Bean
	public HttpMessageConverters customConverters() {
		HttpMessageConverter<?> additional = null;
		HttpMessageConverter<?> another = null;
		return new HttpMessageConverters(additional, another);
	}*/
	
	/* @Bean(name = "dataSource")
	 @Qualifier(value = "dataSource")
	 @Primary
	 @ConfigurationProperties(prefix = "spring.datasource.dbcp2")
	 public DataSource dataSource(){
		 return DataSourceBuilder.create().type(org.apache.commons.dbcp2.BasicDataSource.class).build();
	 }
	 */

//    @Configuration
//    @Profile("prod")
//    @PropertySource({
//            "classpath:/config.properties"
//    })
//    public static class ProdConfiguration {
//    }
}
