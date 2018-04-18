package com.chen.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Configuration
@ConfigurationProperties(prefix = "conf",ignoreUnknownFields=false)
@PropertySource("classpath:config.properties")
public class PropertiesConfig {
	private String salt;

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}
	
}
