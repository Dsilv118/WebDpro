package com.lec.ch08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
//	http://localhost:8090/ch08/ 의 요청 처리 로직
	@RequestMapping("/")
	public String home() {
		return "main"; // view : "/WEB-INF/view/" + "main" + ".jsp" -> 뷰가 만들어짐
	}
}
