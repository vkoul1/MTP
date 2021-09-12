package com.perficient.mtp.commons.metrics;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.micrometer.core.instrument.MeterRegistry;

@Configuration
public class MetricsConfig {
	
  	private static final String PROFILE_TAG_KEY = "profile";
  	private static final String APP_TAG_KEY = "app";
  
  	@Value("${spring.application.name}")
  	private String appName;

  	@Value("${spring.profile:dev}")
  	private String profile;
    
  	@Bean
  	public MeterRegistryCustomizer<MeterRegistry> customize() {
    
      return registry -> {
        registry.config()
        	.commonTags(APP_TAG_KEY, appName)
        	.commonTags(PROFILE_TAG_KEY, profile);
      };
    }
    
}
