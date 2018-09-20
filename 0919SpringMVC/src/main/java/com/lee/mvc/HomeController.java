package com.lee.mvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lee.mvc.domain.Item;
import com.lee.mvc.service.ItemService;

@Controller
public class HomeController {

	@Autowired
	private ItemService itemService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		List<Item> list = itemService.listItem();
		model.addAttribute("list", list);

		return "home";
	}

	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String getItem(@RequestParam("itemid") int itemid, Model model) {
		Item item = itemService.getItem(itemid);
		model.addAttribute("item", item);
		return "detail";
	}

	// excel.xml 요청을 처리하는 메소드
	@RequestMapping(value = "excel.xls", method = RequestMethod.GET)
	public String excel(Model model) {
		// 1.7 이상에서만 아래 형태로 사용 가능
		// 그 이하 버전에는 반드시 <>안에 자료형 기재
		List<String> list = new ArrayList<>();
		list.add("Java");
		list.add("C");
		list.add("C++");
		list.add("JavaScript");

		model.addAttribute("list", list);
		return "programming";
	}

	// data.pdf 요청을 처리하는 메소드
	@RequestMapping(value = "data.pdf", method = RequestMethod.GET)
	public String data(Model model) {
		List<String> list = new ArrayList<>();
		list.add("Oracle-RDBMS");
		list.add("MySQL(MariaDB)-RDBMS");
		list.add("MS-SQL-RDBMS");
		list.add("MongoDB-NoSQL");

		// db라는 이름으로 list를 저장
		model.addAttribute("db", list);

		// 출력하는 뷰 이름을 db로 설정

		return "db";
	}

	// jsonview.json 요청을 처리하는 메소드
	@RequestMapping(value = "jsonview.json", method = RequestMethod.GET)
	public String jsonview(Model model) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> map = new HashMap<String, String>();

		map.put("name", "아이린");
		map.put("age", "30");
		list.add(map);

		map = new HashMap<String, String>();
		map.put("name", "웬디");
		map.put("age", "26");
		list.add(map);

		map = new HashMap<String, String>();
		map.put("name", "조이");
		map.put("age", "24");
		list.add(map);

		map = new HashMap<String, String>();
		map.put("name", "슬기");
		map.put("age", "22");
		list.add(map);

		map = new HashMap<String, String>();
		map.put("name", "예리");
		map.put("age", "20");
		list.add(map);

		model.addAttribute("list", list);
		
	
		return "jsonview";

	}

}
