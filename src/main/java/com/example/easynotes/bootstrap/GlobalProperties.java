package com.example.easynotes.bootstrap;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:global.properties")
@Getter
public class GlobalProperties {

    @Value("${thread-pool}")
    public int threadPool;

    @Value("${email}")
    public String email;

    @Value("${header}")
    public String globalHeader;



}
