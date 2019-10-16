package user.conf;

import java.io.IOException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class SpringConfiguration {

	@Autowired
	private ApplicationContext context;

	@Bean(name = "dataSource")
	public BasicDataSource getBasicDataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		basicDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		basicDataSource.setUsername("java");
		basicDataSource.setPassword("tkdtn");
		basicDataSource.setMaxTotal(20);
		basicDataSource.setMaxIdle(3);

		return basicDataSource;
	}

	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactory getSqlSessionFactoryBean() {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(getBasicDataSource());
		try {
			Resource[] re = context.getResources("classpath:*/*/userMapper.xml");
			/* System.out.println(re.length); */
			/*
			 * for (Resource resource : re) { System.out.println(resource.toString()); }
			 */
			sqlSessionFactory.setConfigLocation(context.getResource("classpath:spring/mybatis-config.xml"));
			sqlSessionFactory.setMapperLocations(re);

		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			return (SqlSessionFactory) sqlSessionFactory.getObject();
		} catch (Exception e) {
			return null;
		}
	}

	@Bean(name = "sqlSession")
	public SqlSessionTemplate getqlSessionTemplate() {
		SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(getSqlSessionFactoryBean());
		return sqlSessionTemplate;
	}

	@Bean(name = "transactionManager")
	public DataSourceTransactionManager getDataSourceTransactionManager() {
		DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
		dataSourceTransactionManager.setDataSource(getBasicDataSource());
		return dataSourceTransactionManager;
	}
}
