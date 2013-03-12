package cn.cdu.fang.web.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.cdu.fang.constant.ApplicationConstant;
import cn.cdu.fang.entity.User;
import cn.cdu.fang.vo.SpotVo;
import cn.cdu.fang.web.utill.SessionUtil;


@Controller
public class AccountController {
	
	@Autowired
	SessionUtil sessionUtil;
	
	@RequestMapping(value="/account/base" , method=RequestMethod.GET)
	public String accountInfo(Model model,HttpSession session){
		session.setAttribute(ApplicationConstant.SESSION_LAST_VISITED_URL, "Account/accountInfo");
		return "Account/accountInfo";
	}
	
	@RequestMapping(value="/account/base" , method=RequestMethod.POST)
	public String updateInfo(
			@ModelAttribute("spotVo") @Valid SpotVo spotVo,
			BindingResult result,
			Model model,HttpSession session){
		User signInUser = sessionUtil.getSignInUser(session);
		if(signInUser == null){
			session.setAttribute(ApplicationConstant.SESSION_LAST_VISITED_URL, "Account/accountInfo");
			return "redirect:/signIn";
		}else{
			
		}
		
		
		
		return "Account/accountInfo";
	}
	
	@RequestMapping(value="/account/profiles" , method=RequestMethod.GET)
	public String profilesInfo(){
		return "Account/profiles";
	}
	
}
