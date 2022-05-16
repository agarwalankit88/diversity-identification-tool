package com.wellsfargo.hackett.diversificationidentitytool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource() {

        return new EmbeddedDatabaseBuilder().addScript("data.sql")
                .setType(EmbeddedDatabaseType.H2).build();
    }
}