package com.simple.springmvc.config;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.simple.springmvc.service.UserService;
import com.simple.springmvc.service.UserServiceImpl;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Properties;

@EnableWebMvc
@PropertySource("classpath:application.properties")
@ComponentScan("com.simple.springmvc")
@EnableJpaRepositories("com.simple.springmvc.dao")
@EnableTransactionManagement
@Import(SecurityConfig.class)
public class WebConfig implements WebMvcConfigurer {

    private static final String DB_DRIVER = "db.driver";
    private static final String DB_URL = "db.url";
    private static final String DB_LOGIN = "db.login";
    private static final String DB_PASSWORD= "db.password";

    private static final String PROP_HIBERNATE_DIALECT = "db.hibernate.dialect";
    private static final String PROP_HIBERNATE_SHOW_SQL = "db.hibernate.show_sql";
    private static final String PROP_HIBERNATE_HBM2DLL = "db.hibernate.hbm2dll.auto";

    @Resource
    private Environment environment;

    @Bean
    public UrlBasedViewResolver setupViewResolver(){
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }

    @Bean
    public UserService getUserService(){
        return new UserServiceImpl();
    }

    @Bean
    public DataSource getDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DB_DRIVER);
        dataSource.setUrl(DB_URL);
        dataSource.setUsername(DB_LOGIN);
        dataSource.setPassword(DB_PASSWORD);
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(){
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(getDataSource());
        factoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        factoryBean.setPackagesToScan(environment.getRequiredProperty("db.entitymanager.packages.to.scan"));
        factoryBean.setJpaProperties(getProperties());
        return factoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager(){
        JpaTransactionManager jpaTransactionManager =new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
        return jpaTransactionManager;
    }

    private Properties getProperties(){
        Properties properties = new Properties();
        properties.setProperty(PROP_HIBERNATE_DIALECT, environment.getProperty(PROP_HIBERNATE_DIALECT));
        properties.setProperty(PROP_HIBERNATE_HBM2DLL, environment.getProperty(PROP_HIBERNATE_HBM2DLL));
        properties.setProperty(PROP_HIBERNATE_SHOW_SQL, environment.getProperty(PROP_HIBERNATE_SHOW_SQL));
        return properties;
    }
}
