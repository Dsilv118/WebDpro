package com.lec.uitest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.uitest.vo.Students;

@Controller
@RequestMapping("input.do")
public class StudentController {
	@ModelAttribute("cnt")
	public int cnt() {
		return 4;
	}
	@RequestMapping(method=RequestMethod.GET)
	public String inputDoGet() {
		return "student/input";
	}
	@RequestMapping(method=RequestMethod.POST)
	public String inputDoPost(Students students) {
		return "student/result";
	}
}
