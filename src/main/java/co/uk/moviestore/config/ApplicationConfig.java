package co.uk.moviestore.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Application Configuration Setup
 *
 * @author Benjamin O'Flaherty
 * @date Created on: 23/01/2015
 * @project MovieStore
 */
@Configuration
@ComponentScan("co.uk.moviestore.*")
@EnableTransactionManagement
public class ApplicationConfig {

    @Bean(name="dataSource")
    public DataSource getDataSource() {

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc.mysql://localhost:3306/moviestore");
        dataSource.setUsername("admin");
        dataSource.setPassword("admin");

        return dataSource;
    }


}
