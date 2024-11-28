package com.example.legacy.config;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.example.legacy.domain",
        entityManagerFactoryRef = "legacyAdEntityManagerFactory",
        transactionManagerRef = "legacyAdTransactionManager"
)
@EnableTransactionManagement
public class LegacyAdJpaConfig {


    @Bean("legacyAdDataSource")
    @ConfigurationProperties(prefix = "spring.jpa.legacy-ad.hikari")
    public DataSource dataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }


    @Bean("legacyAdJpaProperties")
    @ConfigurationProperties(prefix = "spring.jpa.legacy-ad.properties")
    public Properties jpaProperties() {
        return new Properties();
    }


    @Bean("legacyAdEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean legacyAdEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("legacyAdDataSource")  DataSource dataSource,
            @Qualifier("legacyAdJpaProperties") Properties properties
    ) {
        LocalContainerEntityManagerFactoryBean factoryBean = builder
                .dataSource(dataSource)
                .packages("com.example.legacy.domain")
                .build();
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factoryBean.setJpaProperties(properties);
        return factoryBean;
    }

    @Bean("legacyAdTransactionManager")
    public PlatformTransactionManager legacyAdTransactionManager(
            @Qualifier("legacyAdEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
