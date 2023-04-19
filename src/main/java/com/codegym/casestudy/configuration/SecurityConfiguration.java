package com.codegym.casestudy.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableAutoConfiguration
@EnableWebSecurity
@ComponentScan("com.codegym.casestudy.model")
public class SecurityConfiguration {
}
