package com.davidcorrado.kotlinrest.data

import com.zaxxer.hikari.HikariDataSource
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary


@Configuration
class DatabaseConfig {
    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource")
    fun dataSourceProperties(): DataSourceProperties? {
        return DataSourceProperties()
    }

    @Bean
    @ConfigurationProperties("spring.datasource")
    fun dataSource(properties: DataSourceProperties): HikariDataSource? {
        return properties.initializeDataSourceBuilder().type(HikariDataSource::class.java)
            .build()
    }
}