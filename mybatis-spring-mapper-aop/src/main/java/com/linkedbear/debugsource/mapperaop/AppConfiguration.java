package com.linkedbear.debugsource.mapperaop;

import com.linkedbear.debugsource.mapperaop.aop.OperationLog;
import com.linkedbear.debugsource.mapperaop.aop.OperationLogInterceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Role;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableTransactionManagement
public class AppConfiguration {
    
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://10.126.126.5:3306/debugsource?characterEncoding=utf8");
        dataSource.setUsername("debuger");
        dataSource.setPassword("123456");
        return dataSource;
    }
    
    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
    
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage("com.linkedbear.debugsource.mapperaop.entity");
        sqlSessionFactoryBean.setMapperLocations(new Resource[] {new ClassPathResource("mapper/UserMapper.xml")});
        return sqlSessionFactoryBean;
    }
    
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
    
    /*
    @Bean
    public MapperFactoryBean<UserMapper> userMapper(SqlSessionFactory sqlSessionFactory) {
        MapperFactoryBean<UserMapper> userMapperFactoryBean = new MapperFactoryBean<>();
        userMapperFactoryBean.setMapperInterface(UserMapper.class);
        userMapperFactoryBean.setSqlSessionFactory(sqlSessionFactory);
        return userMapperFactoryBean;
    }
     */
    
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.linkedbear.debugsource.mapperaop.mapper");
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        return mapperScannerConfigurer;
    }
    
    /*
     * 以下为注册AOP组件的相关代码
    @Bean
    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
    public DefaultPointcutAdvisor operationLogAnnotationAdvisor() {
        AnnotationMatchingPointcut pointcut = new AnnotationMatchingPointcut(null, OperationLog.class);
        return new DefaultPointcutAdvisor(pointcut, operationLogInterceptor());
    }
    
    @Bean
    public OperationLogInterceptor operationLogInterceptor() {
        return new OperationLogInterceptor();
    }
     */
}
