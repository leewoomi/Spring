package com.lee.mvc0919;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lee.mvc0919.vo.Login;

@Controller
public class HomeController {
	// 시작 요청이 왔을 때 처리하는 메소드
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		return "home";
	}

	// login 요청이 왔을 때 처리하는 메소드
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(Model model) {
		// 여기서 리턴한 뷰 이름을 가지고 servlet-context.xml
		// 파일의 ViewResolver와 결합해서 실제 출력할 파일이 결정
		return "login";

	}

	/*
	 * @RequestMapping(value="login",method=RequestMethod.POST) //java web 프로그래밍에서
	 * 제공하는 request 객체를 이용해서 파라미터 읽기 public String login(HttpServletRequest request,
	 * Model model) { String id = request.getParameter("id"); String pw =
	 * request.getParameter("pw"); System.out.println("id : " + id );
	 * System.out.println("pw: " + pw ); return ""; }
	 */

	// RequestParam을 이용한 파라미터 처리
	/*@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@RequestParam("id") String id, @RequestParam("pw") String pw, Model model) {


		System.out.println("id : " + id);
		System.out.println("pw: " + pw);

		return "출력할 뷰 이름";
	}*/

	
	//Command 객체를 이용한 파라미터 처리 
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(Login login, Model model, HttpSession session, RedirectAttributes attr){
		//request에 저장
		model.addAttribute("client","web browse");
		session.setAttribute("server", "Java- Spring");
		//세션에 저장된는데 한 번 사용하면 삭제됨
		//리다이렉트 할 때만 전달 됨.
		attr.addFlashAttribute("db","Oracle");
		//result로 리다이렉트 - model의 데이터는 전송되지 않습니다. 
		return "redirect:result";
		
	}
	
	//result 요청이 왔을 때 처리하는 메소드
	@RequestMapping(value="result",method=RequestMethod.GET)
	public String result (Model model) {
		return "result";
		
	}
}
