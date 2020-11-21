package ua.skidchenko.DAOLayer.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories("ua.skidchenko.DAOLayer.SpringDataRepository")
public class HibernateConfig {


//    final
//    Environment environment;
//    private final DataSource dataSource;
//
//    public HibernateConfig(DataSource dataSource, Environment environment) {
//        this.dataSource = dataSource;
//        this.environment = environment;
//    }
//
//    @Bean("entityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(Environment env) {
//        LocalContainerEntityManagerFactoryBean emf =
//                new LocalContainerEntityManagerFactoryBean();
//
//        emf.setDataSource(dataSource);
//        emf.setPackagesToScan("com.skidchenko.Model");
//
//        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
//        adapter.setDatabase(Database.POSTGRESQL);
//
//        emf.setJpaVendorAdapter(adapter);
//        emf.setJpaProperties(jpaProperties(env));
//        return emf;
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
//
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(entityManagerFactory);
//
//        return transactionManager;
//    }
//
//    public Properties jpaProperties(Environment env) {
//
//        Properties properties = new Properties();
//        properties.setProperty("hibernate.dialect",
//                "org.hibernate.dialect.PostgreSQL95Dialect");
//        properties.setProperty("hibernate.show_sql",
//                env.getProperty("hibernate.show_sql"));
//        properties.setProperty("hibernate.hbm2ddl.auto", "update");
//        return properties;
//    }
}