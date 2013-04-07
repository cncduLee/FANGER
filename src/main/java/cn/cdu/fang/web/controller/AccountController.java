package cn.cdu.fang.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.cdu.fang.constant.ApplicationConstant;
import cn.cdu.fang.entity.User;
import cn.cdu.fang.service.UserService;
import cn.cdu.fang.vo.AjaxResult;
import cn.cdu.fang.vo.AjaxResultCode;
import cn.cdu.fang.vo.SpotVo;
import cn.cdu.fang.vo.UpDatePwdVo;
import cn.cdu.fang.web.utill.SessionUtil;

@Controller
public class AccountController {

	@Autowired
	SessionUtil sessionUtil;

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/account/profiles", method = RequestMethod.GET)
	public String profilesInfo() {
		return "Account/profiles";
	}
	
	@RequestMapping(value = "/account/info", method = RequestMethod.GET)
	public String updateInfo(Model model, HttpSession session) {
		return "Account/accountInfo";
	}
	@RequestMapping(value = "/account/modifyPwd", method = RequestMethod.GET)
	public String modifyPwd(Model model, HttpSession session) {
		return "Account/modifyPwd";
	}

	
	@RequestMapping(value = "/account/info", method = RequestMethod.POST)
	public String updateInfo(@ModelAttribute("spotVo") @Valid SpotVo spotVo,
			BindingResult result, Model model, HttpSession session) {
		User signInUser = sessionUtil.getSignInUser(session);
		if (signInUser == null) {
			return "redirect:/signIn";
		} else {

		}
		return "Account/accountInfo";
	}


	@RequestMapping(value = "/account/modifyPwd", method = RequestMethod.POST)
	public String modifyPwd(@ModelAttribute("pwdvo") @Valid UpDatePwdVo pwdvo,
			BindingResult result, Model model, HttpSession session) {
		
		System.out.println(pwdvo.getOldpwd()+"-----"+pwdvo.getNewpwd()+"------"+pwdvo.getRenewpwd());
		
		//旧密码
		User user = sessionUtil.getSignInUser(session);
		if (user == null) return "redirect:/signIn";
		
		//就摸吗
		if (!result.hasFieldErrors("oldpwd") && !user.getPassword().equals(pwdvo.getOldpwd())){
			result.addError(new FieldError("pwdvo", "oldpwd","旧密码输入有误！"));
		}
		
		//新密码
		if(!result.hasFieldErrors("newpwd")){
			if (pwdvo.getNewpwd().equals(pwdvo.getOldpwd())) {
				 result.addError(new FieldError("pwdvo", "newpwd","新密码必须与旧密码不一致！"));
			}
		}
		
		//新密码
		if(!result.hasFieldErrors("renewpwd")){
			if (!pwdvo.getNewpwd().equals(pwdvo.getRenewpwd())) {
				 result.addError(new FieldError("pwdvo", "renewpwd","新密码输入不一致！"));
			}	
		}
		
		if(result.hasErrors()){
			return "Account/modifyPwd";
		}
		
		try {
			
			user.setPassword(pwdvo.getNewpwd());
			userService.update(user);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:"+sessionUtil.getLastVisitedUrl(session);
	}
}
