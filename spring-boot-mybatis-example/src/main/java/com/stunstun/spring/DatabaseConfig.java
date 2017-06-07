package com.stunstun.spring;

import com.stunstun.spring.properties.DatabaseProperties;
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
abstract class DatabaseConfig {

    abstract DataSource dataSource();

	abstract void initialize(org.apache.tomcat.jdbc.pool.DataSource dataSource);

    void configureDataSource(org.apache.tomcat.jdbc.pool.DataSource dataSource, DatabaseProperties databaseProperties) {
    	dataSource.setDriverClassName(databaseProperties.getDriverClassName());
    	dataSource.setUrl(databaseProperties.getUrl());
    	dataSource.setUsername(databaseProperties.getUserName());
    	dataSource.setPassword(databaseProperties.getPassword());
		dataSource.setInitialSize(databaseProperties.getInitialSize());
        dataSource.setMaxActive(databaseProperties.getMaxActive());
        dataSource.setMaxIdle(databaseProperties.getMaxIdle());
        dataSource.setMinIdle(databaseProperties.getMinIdle());
        dataSource.setMaxWait(databaseProperties.getMaxWait());
        dataSource.setTestOnBorrow(false);
        dataSource.setTestOnReturn(false);

		if(databaseProperties.isInitialize())
			initialize(dataSource);
    }
}

@Configuration
@EnableConfigurationProperties(value = MasterDatabaseProperties.class)
@EnableTransactionManagement
@MapperScan(basePackages = {DefaultDatabaseConfig.BASE_PACKAGE_PREFIX}, sqlSessionFactoryRef = "masterSqlSessionFactory")
class DefaultDatabaseConfig extends DatabaseConfig {

	public static final String BASE_PACKAGE_PREFIX = "com.stunstun.spring.repository";

	public static final String ENTITY_PACKAGE_PREFIX = "com.stunstun.spring.repository.entity";

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private MasterDatabaseProperties masterDatabaseProperties;

	@Bean(destroyMethod = "close")
	@Override
	public DataSource dataSource() {
		org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();
		configureDataSource(dataSource, masterDatabaseProperties);
		return dataSource;
	}

	@Override
	protected void initialize(org.apache.tomcat.jdbc.pool.DataSource dataSource) {
		Resource schema = applicationContext.getResource("classpath:scripts/schema.sql");
		Resource data = applicationContext.getResource("classpath:scripts/data.sql");
		DatabasePopulator databasePopulator = new ResourceDatabasePopulator(schema, data);
		DatabasePopulatorUtils.execute(databasePopulator, dataSource);
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
		sessionFactoryBean.setTypeAliasesPackage(DefaultDatabaseConfig.ENTITY_PACKAGE_PREFIX);
		sessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:mybatis/mybatis-config.xml"));
		sessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mybatis/mapper/**/*.xml"));
		return sessionFactoryBean.getObject();
	}
}