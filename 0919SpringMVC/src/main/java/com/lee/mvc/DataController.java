package com.lee.mvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lee.mvc.service.LoginService;

@RestController
public class DataController {
	
	@Autowired
	private LoginService loginService;
	
	//아이디 중복 체크를 처리해주는 메소드 
	@RequestMapping(value="idcheck",method=RequestMethod.GET)
	public Map<String, Object> idcheck(@RequestParam("id") String id){
		String result= loginService.idcheck(id);
		Map<String, Object> map = new HashMap<String, Object>();
		if(result == null) {
			map.put("result", "true");
		}else {
			map.put("result", "false");
		}
		return map ;
		
	}
	
	

	@RequestMapping(value = "data.csv", method = RequestMethod.GET)
	public String dataCsv() {
		return "csv,xml,json";
	}

	// json을 만들어서 리턴하는 메소드
	@RequestMapping(value = "data.json", method = RequestMethod.GET)
	public List<Map<String, Object>> datajson() {
		List<Map<String, Object>> list = new ArrayList<>();

		Map<String, Object> map = new HashMap<>();
		map.put("name", "아이린");
		map.put("group", "레드벨벳");
		list.add(map);

		map = new HashMap<>();
		map.put("name", "아이유");
		map.put("group", "솔로");
		list.add(map);

		map = new HashMap<>();
		map.put("name", "수지");
		map.put("group", "솔로");
		list.add(map);
		return list;
	}


	
	
	
}
