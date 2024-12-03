package com.example.migration.gradual.config;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.example.migration.gradual.domain.recentad",
        entityManagerFactoryRef = "recentAdEntityManagerFactory",
        transactionManagerRef = "recentAdTransactionManager"
)
public class RecentAdJpaConfig {


    @Primary
    @Bean("recentAdDataSource")
    @ConfigurationProperties(prefix = "spring.jpa.recent-ad.hikari")
    public DataSource dataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }


    @Bean("recentAdJpaProperties")
    @ConfigurationProperties(prefix = "spring.jpa.recent-ad.properties")
    public Properties recentAdJpaProperties() {
        return new Properties();
    }


    @Primary
    @Bean("recentAdEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean recentAdEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("recentAdDataSource")  DataSource dataSource,
            @Qualifier("recentAdJpaProperties") Properties properties
    ) {
        LocalContainerEntityManagerFactoryBean factoryBean = builder
                .dataSource(dataSource)
                .packages("com.example.migration.gradual.domain.recentad")
                .build();
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factoryBean.setJpaProperties(properties);
        return factoryBean;
    }

    @Primary
    @Bean("recentAdTransactionManager")
    public PlatformTransactionManager recentAdTransactionManager(
            @Qualifier("recentAdEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}