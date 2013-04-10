package cn.cdu.fang.web.controller;

import java.util.List;

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
import cn.cdu.fang.constant.Role;
import cn.cdu.fang.constant.UserStatus;
import cn.cdu.fang.entity.User;
import cn.cdu.fang.service.UserService;
import cn.cdu.fang.vo.SignInVO;
import cn.cdu.fang.web.utill.SessionUtil;

@Controller
public class SignInController {
	
	@Autowired
	UserService userService;
	@Autowired
	SessionUtil sessionUtil;
	
	@RequestMapping(value = "/signIn",method=RequestMethod.GET)
	public String signIn(Model model,HttpSession session){
		if(sessionUtil.getSignInUser(session) != null) 
			return "redirect:"+sessionUtil.getLastVisitedUrl(session); 
		return "signIn";
	}
	
	@RequestMapping(value = "/signIn",method = RequestMethod.POST)
	public String signIn(@ModelAttribute("signInVo") @Valid SignInVO signInVo,
			BindingResult result,
			Model model, HttpSession session){
		
		User exited = null;
		if(!result.hasFieldErrors("sname")){
			
			List<User> list = userService.getUserByEmail(signInVo.getSname());
			
			if(list.size() == 1){
				exited = list.get(0);
			}
			
			if(exited == null){
				result.addError(new FieldError("signInVo", "sname", "注册邮箱不存在！"));
			}else{
				if(!exited.getPassword().equals(signInVo.getSpassword())){
					result.addError(new FieldError("signInVo", "spassword", "密码输入有误，请检查！"));
				}
				if(exited.getStatus() != UserStatus.VALID){
					result.addError(new FieldError("signInVo", "sname", "账户被冻结，不可用！"));
				}
			}
			
		}
		if(result.hasErrors()){
			return "redirect:/signIn";
		}
		
		if(exited != null){
			session.setAttribute(ApplicationConstant.APPLICATION_SIGNIN_USER, exited);
			if(exited.getRole()!=null && exited.getRole().equals(Role.ADMIN)){
				return "redirect:admin/index";
			}
		}
		
		return "redirect:/";
	}
	
}
