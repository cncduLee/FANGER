package cn.cdu.fang.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.cdu.fang.constant.ApplicationConstant;

@Controller
public class SignOutController {
	
	@RequestMapping(value="/signOut",method=RequestMethod.GET)
	public String signOut(Model model, HttpSession session){
		session.removeAttribute(ApplicationConstant.APPLICATION_SIGNIN_USER);
		return "redirect:/signIn";
	}
}
