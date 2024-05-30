package com.example.phoneShopping.config;

import org.slf4j.LoggerFactory; // Log남기기 위한 설정 1
import org.slf4j.Logger;		// Log남기기 위한 설정 2

import org.springframework.boot.context.properties.ConfigurationProperties; // 외부 파일 가져와서 사용하는 것 허용
import org.springframework.context.annotation.Bean; // Bean(SW component)사용
import org.springframework.context.annotation.Configuration; // 설정 파일임을 명시
import org.springframework.context.annotation.PropertySource; // 스프링 환경설정파일 위치 명시

import com.zaxxer.hikari.HikariConfig; // DB연결 도와주는 라이브러리 1
import com.zaxxer.hikari.HikariDataSource; // DB연결 도와주는 라이브러리 2
import java.util.Date;
import javax.sql.DataSource; // DB연결 도와주는 라이브러리 3

import org.apache.ibatis.session.SqlSessionFactory; // MyBatis 사용하기 위한 설정 1
import org.mybatis.spring.SqlSessionFactoryBean;	// MyBatis 사용하기 위한 설정 2
import org.mybatis.spring.SqlSessionTemplate;		// MyBatis 사용하기 위한 설정 3

import org.springframework.core.io.Resource;		// 사용 자원에 대한 설명 명시
import org.springframework.core.io.support.PathMatchingResourcePatternResolver; // 사용한 자원의 위치 명시

@Configuration
@PropertySource("classpath:application.properties")
public class DatabaseConfig 
{
    private final Logger logger = LoggerFactory.getLogger(
            DatabaseConfig.class);					// DatabaseConfig.class에 대한 로그 파일을 남기기 위해 선언

        @Bean
        @ConfigurationProperties(prefix = "spring.datasource.hikari")
        public HikariConfig hikariConfig() // DB와 연동하여 사용하기 위해 Hikari Config 구성
        {
            logger.info("DatabaseConfig dataSource(): {}", new Date());
            return new HikariConfig();
        }

        @Bean
        public DataSource dataSource() // DB와 연동하여 사용하기 위해 Data Source 구성
        {
            logger.info("DatabaseConfig dataSource(): {}", new Date());
            DataSource dataSource = new HikariDataSource(hikariConfig());
            logger.info("DatabaseConfig dataSource(): dataSource={}", dataSource);
            return dataSource;
        }

        @Bean
        public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception // 위에서 구성한 환경들을 기반으로 MyBatis에서 SQL처리 설정 1
        {
            logger.info("DatabaseConfig sqlSessionFactory(): {}", new Date());
            SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
            sqlSessionFactoryBean.setDataSource(dataSource);
            Resource[] resources = new PathMatchingResourcePatternResolver()
                                    .getResources("classpath:sqls/*.xml");
            sqlSessionFactoryBean.setMapperLocations(resources);
            sqlSessionFactoryBean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);

            return (SqlSessionFactory) sqlSessionFactoryBean.getObject();
        }

        @Bean
        public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory)  // MyBatis에서 SQL처리 설정 2
        {
            return new SqlSessionTemplate(sqlSessionFactory);
        }
}
