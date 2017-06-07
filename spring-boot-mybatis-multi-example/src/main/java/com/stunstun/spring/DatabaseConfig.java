package com.stunstun.spring;

import com.stunstun.spring.properties.DatabaseProperties;
import com.stunstun.spring.properties.PaymentDatabaseProperties;
import com.stunstun.spring.properties.UserDatabaseProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @author stunstun
 *
 */
public abstract class DatabaseConfig {

    public abstract DataSource dataSource();

	abstract void initialize(org.apache.tomcat.jdbc.pool.DataSource dataSource);

    protected void configureDataSource(org.apache.tomcat.jdbc.pool.DataSource dataSource, DatabaseProperties databaseProperties) {
    	dataSource.setDriverClassName(databaseProperties.getDriverClassName());
    	dataSource.setUrl(databaseProperties.getUrl());
    	dataSource.setUsername(databaseProperties.getUserName());
    	dataSource.setPassword(databaseProperties.getPassword());
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
@EnableConfigurationProperties(UserDatabaseProperties.class)
class UserDatabaseConfig extends DatabaseConfig {
	
	@Autowired
	private UserDatabaseProperties userDatabaseProperties;

	@Override
	protected void initialize(org.apache.tomcat.jdbc.pool.DataSource dataSource) {
		PathMatchingResourcePatternResolver pathResolver = new PathMatchingResourcePatternResolver();
		Resource schema = pathResolver.getResource("classpath:scripts/user-schema.sql");
		Resource data = pathResolver.getResource("classpath:scripts/user-data.sql");
		DatabasePopulator databasePopulator = new ResourceDatabasePopulator(schema, data);
		DatabasePopulatorUtils.execute(databasePopulator, dataSource);
	}

	@Bean(name = "userDataSource", destroyMethod = "close")
	@Primary
	public DataSource dataSource() {
		org.apache.tomcat.jdbc.pool.DataSource userDataSource = new org.apache.tomcat.jdbc.pool.DataSource();
		configureDataSource(userDataSource, userDatabaseProperties);
		return userDataSource;
	}

	@Bean(name = "userTransactionManager")
	@Primary
	public PlatformTransactionManager userTransactionManager(@Qualifier("userDataSource") DataSource userDataSource) {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(userDataSource);
		transactionManager.setGlobalRollbackOnParticipationFailure(false);
		return transactionManager;
	}
}

@Configuration
@EnableConfigurationProperties(PaymentDatabaseProperties.class)
class PaymentDatabaseConfig extends DatabaseConfig {
	
	@Autowired
	private PaymentDatabaseProperties paymentDatabaseProperties;

	@Override
	protected void initialize(org.apache.tomcat.jdbc.pool.DataSource dataSource) {
		PathMatchingResourcePatternResolver pathResolver = new PathMatchingResourcePatternResolver();
		Resource schema = pathResolver.getResource("classpath:scripts/payment-schema.sql");
		Resource data = pathResolver.getResource("classpath:scripts/payment-data.sql");
		DatabasePopulator databasePopulator = new ResourceDatabasePopulator(schema, data);
		DatabasePopulatorUtils.execute(databasePopulator, dataSource);
	}

	@Bean(name = "paymentDataSource", destroyMethod = "close")
	public DataSource dataSource() {
		org.apache.tomcat.jdbc.pool.DataSource paymentDataSource = new org.apache.tomcat.jdbc.pool.DataSource();
		configureDataSource(paymentDataSource, paymentDatabaseProperties);
		return paymentDataSource;
	}

	@Bean(name = "paymentTransactionManager")
	public PlatformTransactionManager paymentTransactionManager(@Qualifier("paymentDataSource") DataSource paymentDataSource) {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(paymentDataSource);
		transactionManager.setGlobalRollbackOnParticipationFailure(false);
		return transactionManager;
	}
}