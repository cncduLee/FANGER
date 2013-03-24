package cn.cdu.fang.admin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class AdminIndex {
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String adminIndex(Model model,HttpSession session){
		return "/admin/adminIndex";
	}
	
}
