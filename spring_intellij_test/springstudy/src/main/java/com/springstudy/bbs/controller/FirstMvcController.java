package com.springstudy.bbs.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springstudy.bbs.service.FirstMvcService;

@Controller
@RequestMapping("/first")
public class FirstMvcController {

	@Autowired
	private FirstMvcService service;

	public void setFirstMvcService(FirstMvcService service) {
		this.service = service;
	}

	@RequestMapping(value={"/", "/intro", "/index"}, method=RequestMethod.GET)
	public String index() {
		return "/main";
	}

	@RequestMapping("/detail")	// get, post 둘 다 받는다	
	public String detail(@RequestParam(value="num", defaultValue="1") int no,  String id, Model model) {
		String msg = service.getMessage(no, id);
		model.addAttribute("msg", msg);
		// model의 addAttribute() 메서드 안에서 request.setAttribute("msg", msg);

		model.addAttribute("title","명준이의 디테일 당부");
		model.addAttribute("comment","정말루 스프링 공부 열심히 해야해염");

		return "detail";
	}

}
