package com.stunstun.spring;

import com.stunstun.spring.repository.support.PaymentSchema;
import com.stunstun.spring.repository.support.UserSchema;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @author stunstun
 *
 */
public abstract class MyBatisConfig {
	
	public static final String BASE_PACKAGE_PREFIX = "com.stunstun.spring.repository";

	public static final String ENTITY_PACKAGE_PREFIX = "com.stunstun.spring.repository.entity";

	public static final String CONFIG_LOCATION_PATH = "classpath:mybatis/mybatis-config.xml";

	public static final String MAPPER_LOCATIONS_PATH = "classpath:mybatis/mapper/**/*.xml";
	
	protected void configureSqlSessionFactory(SqlSessionFactoryBean sessionFactoryBean, DataSource dataSource) throws IOException {
		PathMatchingResourcePatternResolver pathResolver = new PathMatchingResourcePatternResolver();
		sessionFactoryBean.setDataSource(dataSource);
		sessionFactoryBean.setTypeAliasesPackage(ENTITY_PACKAGE_PREFIX);
		sessionFactoryBean.setConfigLocation(pathResolver.getResource(CONFIG_LOCATION_PATH));
		sessionFactoryBean.setMapperLocations(pathResolver.getResources(MAPPER_LOCATIONS_PATH));
	}
}

@Configuration
@MapperScan(basePackages = MyBatisConfig.BASE_PACKAGE_PREFIX, annotationClass = UserSchema.class, sqlSessionFactoryRef = "userSqlSessionFactory")
class UserMybatisConfig extends MyBatisConfig {

	@Bean(name = "userSqlSessionFactory")
	@Primary
	public SqlSessionFactory userSqlSessionFactory(@Qualifier("userDataSource") DataSource userDataSource) throws Exception {
		SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
		configureSqlSessionFactory(sessionFactoryBean, userDataSource);
		return sessionFactoryBean.getObject();
	}
}

@Configuration
@MapperScan(basePackages = MyBatisConfig.BASE_PACKAGE_PREFIX, annotationClass = PaymentSchema.class, sqlSessionFactoryRef = "paymentSqlSessionFactory")
class PaymentMybatisConfig extends MyBatisConfig {
	
	@Bean(name = "paymentSqlSessionFactory")
	public SqlSessionFactory paymentSqlSessionFactory(@Qualifier("paymentDataSource") DataSource paymentDataSource) throws Exception {
		SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
		configureSqlSessionFactory(sessionFactoryBean, paymentDataSource);
		return sessionFactoryBean.getObject();
	}
}