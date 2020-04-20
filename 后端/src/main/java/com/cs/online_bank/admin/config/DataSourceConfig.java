package com.cs.online_bank.admin.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.jolbox.bonecp.BoneCPDataSource;
@Configuration
public class DataSourceConfig {
	@Bean
	@Primary//若有多个数据源对象，以本次创建的数据源为主
	@ConfigurationProperties(prefix="boneCP")//获取application.properties配置文件中的配置项给dataSource对应的属性
	public DataSource getDataSource() {
		return DataSourceBuilder.create().type(BoneCPDataSource.class).build();
	}

}
