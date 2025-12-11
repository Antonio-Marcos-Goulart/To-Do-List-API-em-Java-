package com.todo_list.demo.config;

import io.github.cdimascio.dotenv.Dotenv;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class CustomDataSourceConfig {

    @Autowired
    private Dotenv dotenv;

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .url(dotenv.get("DB_URL"))
                .username(dotenv.get("DB_USERNAME"))
                .password(dotenv.get("DB_PASSWORD"))
                .driverClassName("org.postgresql.Driver")
                .build();
    }
}

