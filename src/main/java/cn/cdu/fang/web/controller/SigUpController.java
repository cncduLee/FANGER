package cn.cdu.fang.web.controller;

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

import cn.cdu.fang.constant.ApplicationConstant;
import cn.cdu.fang.entity.User;
import cn.cdu.fang.service.UserService;
import cn.cdu.fang.vo.SignUpVO;
import cn.cdu.fang.web.utill.SessionUtil;

@Controller
public class SigUpController {
	
	@Autowired
	UserService userService;
	@Autowired
	SessionUtil sessionUtil;
	
	@ModelAttribute("signUpUserVo")
	public SignUpVO createSignUpUserVo() {
		SignUpVO vo = new SignUpVO();
		return vo;
	}
	
	/**
	 * 请求signup页面
	 * 
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/signUp",method=RequestMethod.GET)
	public String signUp(Model model, HttpSession session){
		if(session.getAttribute(ApplicationConstant.APPLICATION_SIGNIN_USER) != null)
			return "redirect:/";
		
		model.addAttribute(ApplicationConstant.SESSION_LAST_VISITED_URL, sessionUtil.getLastVisitedUrl(session));
		
		return "signUp";
	}
	
	/**
	 * 提交表单
	 * 
	 * @param signUpUserVo
	 * @param result
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/signUp", method=RequestMethod.POST)
	public String signUp(@Valid SignUpVO signUpUserVo,
			BindingResult result,
			Model model, HttpSession session){
		
		if(!result.hasFieldErrors("email")){
			//邮箱正确，需验证其唯一
			if(userService.getUserByEmail(signUpUserVo.getEmail()).size() != 0){
				result.addError(new FieldError("signUpUserVo", "email", "该邮箱已经被注册，请换一个邮箱吧！"));
			}
			//用户名唯一
			if(userService.getUserByName(signUpUserVo.getName()).size() != 0){
				result.addError(new FieldError("signUpUserVo", "name", "该邮箱已经被注册，请换一个邮箱吧！"));
			}
			
			if(result.hasErrors()){
				return "signUp";
			}
			
			//注册成功
			userService.save(User.builtByVo(signUpUserVo));
			session.setAttribute(ApplicationConstant.APPLICATION_SIGNIN_USER, User.builtByVo(signUpUserVo));
			
			return "redrict:"+sessionUtil.getLastVisitedUrl(session);
		}
		
		return "redirect:/";
	}
}
