package com.example.Practice.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class UrlConfigurations {

    @Value("${reqres.api.call}")
    private String reqresUrl;
}
