package com.yuyan.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.yuyan.model.People;
import com.yuyan.service.PeopleService;
import com.yuyan.service.impl.PeopleServiceImpl;


@Controller
public class IndexController extends HttpServlet {
	@Autowired
	private PeopleService peopleServiceImpl;
	@RequestMapping("/index")
	private ModelAndView index(String id) {
		int count = peopleServiceImpl.findCount();
		String aString = String.valueOf(count);
		People people = peopleServiceImpl.findPeopleById(id);
		Integer name = 111;
		name = people.getId();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("name", name);
		modelAndView.setViewName("testUpload");
		return modelAndView;
	}
	
	/**
	 *{id} 此种传递参数方式为rest风格，需要用@PathVariable修饰  且变量名一致 
	 * */
	@RequestMapping(value="/json/{id}")
	@ResponseBody
	private Object json(@PathVariable String id) {
		int count = peopleServiceImpl.findCount();
		String aString = String.valueOf(count);
		People people = peopleServiceImpl.findPeopleById(id);
		//Object object = JSONArray.toJSONString(people);
		return people;
	}
	
	@RequestMapping(value="/text/{id}",produces= {"application/text;charset=utf-8"})
	@ResponseBody
	private Object text(String id) {
		int count = peopleServiceImpl.findCount();
		String aString = String.valueOf(count);
		People people = peopleServiceImpl.findPeopleById(id);
		Object object = JSONArray.toJSONString(people);
		return "张三";
	}
	
	

}
