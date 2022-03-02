package com.alpha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAutoConfiguration
@SpringBootApplication
@EnableAsync
@EnableJpaAuditing
@ComponentScan(basePackages = { "com.alpha" })
public class AlphaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlphaApplication.class, args);
	}

//	@Bean
//	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
//		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter(mapper);
//		return converter;
//	}

}