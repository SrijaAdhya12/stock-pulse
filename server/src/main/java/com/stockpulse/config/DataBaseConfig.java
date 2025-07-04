package com.stockpulse.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableJpaRepositories(basePackages = "com.stockpulse.repository")
@EnableJpaAuditing
@EnableTransactionManagement
@Slf4j
public class DataBaseConfig {


    @Bean
    public FlywayMigrationStrategy flywayMigrationStrategy() {
        return flyway -> {
            try {
                flyway.migrate();
            } catch (Exception e) {
                log.warn("Flyway migration failed, attempting repair and retry: {}", e.getMessage());
                flyway.repair();
                flyway.migrate();
            }

        };
    }

}
