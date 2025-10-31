package br.com.nulog.bros.shared.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("bros")
public record BrosConfiguration(String secret_key, String jwt_issuer, String front_url) {
}
