package com.yuyan.service.impl;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.Null;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class database {
	private static InputStream inputStream = null;
	private static SqlSessionFactory sessionFactory = null;
	static {
		try {
			inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	public static SqlSession openSession() {
		return sessionFactory.openSession();
	}
	
	public static String closeSession(SqlSession session) {
		if (session!=null) {
			session.close();
			return "成功关闭连接";
		}
		return "连接对象为空，无需关闭！";
	}

}
