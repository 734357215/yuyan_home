package com.yuyan.service.impl;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yuyan.model.People;

public class Demo {
	@Autowired
	private static PeopleServiceImpl peopleServiceImpl;
	public static PeopleServiceImpl getPeopleServiceImpl() {
		return peopleServiceImpl;
	}
	public static void setPeopleServiceImpl(PeopleServiceImpl peopleServiceImpl) {
		Demo.peopleServiceImpl = peopleServiceImpl;
	}
	public static void main(String[] args) throws IOException {	
/*		database aDataba = new database();
		SqlSession session = aDataba.openSession();
		int num = session.selectOne("com.yuyan.dao.PeopleMapper.getPeopleCount");
		System.out.println(num);*/
		
		
/*		PeopleServiceImpl peopleServiceImpl = new PeopleServiceImpl();
		int num = peopleServiceImpl.getCount();
		System.out.println(num);*/
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-Context.xml");
		People people =   (People) applicationContext.getBean("people");
		int num = peopleServiceImpl.findCount();
		System.out.println(num);
		System.out.println(people.getId());

	}
}
