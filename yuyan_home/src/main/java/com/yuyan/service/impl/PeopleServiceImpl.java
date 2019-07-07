package com.yuyan.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.yuyan.dao.PeopleMapper;
import com.yuyan.model.People;
import com.yuyan.service.PeopleService;

@Service
public class PeopleServiceImpl implements PeopleService{
	@Autowired
	@Qualifier("peopleMapper")
	private PeopleMapper peopleDao;
	@Override
	public int findCount() {
		int count = peopleDao.findCount();
		return count;
	}
	@Override
	public People findPeopleById(String id) {
		return peopleDao.findPeopleById(id);
	}
	@Override
	public boolean addPeople(People people) {
		return peopleDao.addPeople(people)>0;
	}
	@Override
	public boolean updatePeople(People people) {
		return peopleDao.updatePeople(people)>0;
	}
	
}
