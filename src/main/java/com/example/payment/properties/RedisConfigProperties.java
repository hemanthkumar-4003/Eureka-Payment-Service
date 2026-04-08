package com.example.payment.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Validated
@ConfigurationProperties(prefix = "spring.data.redis")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RedisConfigProperties {
    private String host;
    private int port;
}
