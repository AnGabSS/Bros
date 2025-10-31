package br.com.nulog.bros;

import br.com.nulog.bros.shared.config.BrosConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(BrosConfiguration.class)
public class BrosApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrosApplication.class, args);
	}

}
