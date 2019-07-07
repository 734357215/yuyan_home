package com.yuyan.service;

import org.apache.ibatis.annotations.Param;

import com.yuyan.model.People;

public interface PeopleService {
	int findCount();
	People findPeopleById(String id);
	boolean addPeople(People people);
	boolean updatePeople(People people);
}
