package com.yuyan.dao;

import org.apache.ibatis.annotations.Param;

import com.yuyan.model.People;

public interface PeopleMapper {
	int findCount(); //返回用户总数量
	People findPeopleById(@Param("id")String id);
	
	int addPeople(People people);
	int updatePeople(People people);
	
}
