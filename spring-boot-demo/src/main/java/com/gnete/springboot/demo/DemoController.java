package com.gnete.springboot.demo;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gnete.springboot.demo.entity.TestEntity;
import com.gnete.springboot.demo.service.DemoService;

@Controller
@RequestMapping(value = "/demo")
public class DemoController {
	
	@Resource(name = "demoService")
	private DemoService demoService;

	@RequestMapping(value = "/test1")
	@ResponseBody
	public String test1(){
		String msg = "this is test1!";
		System.out.println(msg);
		return msg;
	}
	
	@RequestMapping("/test2")
	public String test2(){
		return "hello";
	}
	
	@RequestMapping("/test3")
	@ResponseBody
	public TestEntity test3(){
		return demoService.getTestEntityById(1);
	}
	
	@RequestMapping("/test4")
	public String test4(Model model){
		List<TestEntity> entities = demoService.getTestEntity();
		model.addAttribute("entitys", entities);
		return "user";
	}
}
