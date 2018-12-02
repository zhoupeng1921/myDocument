package com.xhx.springboot.config;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;


/**
 * 改变表名大小写
 */
//@Component
public class MySQLUpperCaseStrategy extends PhysicalNamingStrategyStandardImpl {

	private static final long serialVersionUID = 1383021413247872469L;

	
	@Override
	public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
		// 将表名全部转换成大写
		String tableName = name.getText().toUpperCase();
		
		return name.toIdentifier(tableName);
	}

}