package ua.skidchenko.Configs;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Log4j2
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("ua.skidchenko.DAOLayer.SpringDataRepository")
@PropertySource("classpath:other.properties")
public class SpringConfig {

//    final
//    Environment environment;
//
//    public SpringConfig(Environment environment) {
//        log.info("Initializing Environment");
//        this.environment = environment;
//        log.info("Environment initializing successful.");
//    }
//


}
