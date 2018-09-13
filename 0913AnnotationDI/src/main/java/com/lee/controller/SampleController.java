package com.lee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lee.dao.SampleDao;

@Controller
public class SampleController {

	@Autowired
	private SampleDao sampleDao;
	
public String test() {
	return sampleDao.test();
}

}
