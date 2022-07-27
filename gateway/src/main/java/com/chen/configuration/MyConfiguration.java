package com.chen.configuration;

import org.springframework.context.annotation.Configuration;

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
