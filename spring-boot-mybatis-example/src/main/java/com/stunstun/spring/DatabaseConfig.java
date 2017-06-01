package com.stunstun.spring;

import com.stunstun.spring.properties.MasterDatabaseProperties;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author stunstun
 *
 */
@EnableConfigurationProperties(value = MasterDatabaseProperties.class)
public abstract class DatabaseConfig {

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private MasterDatabaseProperties masterDatabaseProperties;

    @Bean
    public abstract DataSource dataSource();

	protected void initialize(org.apache.tomcat.jdbc.pool.DataSource dataSource) {
		Resource schema = applicationContext.getResource("classpath:scripts/schema.sql");
		Resource data = applicationContext.getResource("classpath:scripts/data.sql");
		DatabasePopulator databasePopulator = new ResourceDatabasePopulator(schema, data);
		DatabasePopulatorUtils.execute(databasePopulator, dataSource);
	}

    protected void configureDataSource(org.apache.tomcat.jdbc.pool.DataSource dataSource) {
    	dataSource.setDriverClassName(masterDatabaseProperties.getDriverClassName());
    	dataSource.setUrl(masterDatabaseProperties.getUrl());
    	dataSource.setUsername(masterDatabaseProperties.getUserName());
    	dataSource.setPassword(masterDatabaseProperties.getPassword());
		dataSource.setInitialSize(masterDatabaseProperties.getInitialSize());
        dataSource.setMaxActive(masterDatabaseProperties.getMaxActive());
        dataSource.setMaxIdle(masterDatabaseProperties.getMaxIdle());
        dataSource.setMinIdle(masterDatabaseProperties.getMinIdle());
        dataSource.setMaxWait(masterDatabaseProperties.getMaxWait());
        dataSource.setTestOnBorrow(false);
        dataSource.setTestOnReturn(false);

		if(masterDatabaseProperties.isInitialize())
			initialize(dataSource);
    }
}

@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = {"com.stunstun.spring.repository"}, sqlSessionFactoryRef = "masterSqlSessionFactory")
class DefaultDatabaseConfig extends DatabaseConfig {
	
	@Autowired
	private ApplicationContext applicationContext;

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();
		configureDataSource(dataSource);
		return dataSource;
	}
	
	@Bean
    public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource());
		transactionManager.setGlobalRollbackOnParticipationFailure(false);
		return transactionManager;
    }
	
	@Bean(name = "masterSqlSessionFactory")
	public SqlSessionFactory masterSqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setTypeAliasesPackage("com.stunstun.spring.repository.entity");
		sessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:mybatis/mybatis-config.xml"));
		sessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mybatis/mapper/**/*.xml"));
		return sessionFactoryBean.getObject();
	}
}