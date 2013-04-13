package cn.cdu.fang.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.cdu.fang.constant.ApplicationConstant;
import cn.cdu.fang.constant.Role;
import cn.cdu.fang.constant.UserStatus;
import cn.cdu.fang.entity.FlowShip;
import cn.cdu.fang.entity.Resource;
import cn.cdu.fang.entity.User;
import cn.cdu.fang.service.FlowShipService;
import cn.cdu.fang.service.UserService;
import cn.cdu.fang.vo.AjaxResult;
import cn.cdu.fang.vo.AjaxResultCode;
import cn.cdu.fang.vo.UpDatePwdVo;
import cn.cdu.fang.vo.UserInfoVo;
import cn.cdu.fang.web.utill.Paging;
import cn.cdu.fang.web.utill.SessionUtil;

@Controller
public class AccountController {
	
	private static Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	SessionUtil sessionUtil;

	@Autowired
	UserService userService;
	@Autowired
	FlowShipService flowShipService; 
	
	
	@RequestMapping(value = "/account/profiles", method = RequestMethod.GET)
	public String profilesInfo(
			@RequestParam(value = "accountId" , required = true) Integer accountId,  
			Model model,HttpServletRequest request,HttpServletResponse response){
		
		User user = userService.getEntity(accountId);
		model.addAttribute("account", user);
		
		List<FlowShip> targets = flowShipService.findByTarget(user);
		List<FlowShip> followed = flowShipService.findByFollowed(user);
		
		
		model.addAttribute("targetUsers", this.findShipByType(followed, ShipType.TARGET));
		model.addAttribute("followedUsers", this.findShipByType(targets, ShipType.FOLLOW));
		
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
	
	@RequestMapping(value = "/account/follow", method = RequestMethod.POST)
	public @ResponseBody AjaxResult followSomeOne(
			@RequestParam(value="targetId",required=true) Integer targetId,
			Model model, HttpSession session) {

		User signInUser = sessionUtil.getSignInUser(session);
		
		if(signInUser == null){
		   return new AjaxResult(AjaxResultCode.NO_AUTH);
		}
		
		try{
			
			User target = userService.getEntity(targetId);
			
			if(flowShipService.findByFollowedAndTarget(signInUser, target) != null){
				return new AjaxResult(AjaxResultCode.FAILE);
			}
			
			FlowShip ship = new FlowShip(target,signInUser,0,new Date(),new Date());
			
			flowShipService.save(ship);
			
			return new AjaxResult(AjaxResultCode.SUCCESS);
			
		}catch(Exception e){
			e.printStackTrace();
			return new AjaxResult(AjaxResultCode.EXCEPTION);
		}
		
	}
	
	
	@RequestMapping(value = {"/accounts","/account/list"}, method = RequestMethod.GET)
	public String accountList(
			@RequestParam(value = "currentPage", required = false) Integer currentPage, 
			@RequestParam(value = "pageSize", required = false) Integer pageSize,
			Model uiModel,HttpSession session){
		
		int ps = pageSize == null ? 10 : pageSize.intValue();//设置页大小
		
		int cp = currentPage == null ? 0 : currentPage.intValue();//当前页
		
		//当前页数据
		List<User> all = userService.findAll(UserStatus.VALID,Role.USER,new PageRequest(cp, ps)).getContent();
		logger.info("length of this page "+all.size());
	
		uiModel.addAttribute("users", all);
		
		//总页数
		final long  count = userService.count(UserStatus.VALID,Role.USER);
		final long nrOfPages = count % ps == 0 ?  count / ps : (count / ps + 1);
		
		System.out.println("tottle pages-----"+nrOfPages);
		
		uiModel.addAttribute("pagingScript",Paging.pagingScriptAccount(cp, ps, (int)nrOfPages));
		
		return "accounts";
	}
	
	@RequestMapping(value = "/account/info", method = RequestMethod.POST)
	public String updateInfo(
			@ModelAttribute("userInfoVo") @Valid UserInfoVo userInfoVo,
			BindingResult result, Model model, HttpSession session) {
		
		User signInUser = sessionUtil.getSignInUser(session);
		
		if (signInUser == null) {
		
			return "redirect:/signIn";
			
		} else {
			//2、验证email是否可用
			if(userInfoVo.getEmail() != null && !"".equals(userInfoVo.getEmail().trim())){
				//不是他的邮件地址，但是已经被注册过
				if(!userInfoVo.getEmail().equals(signInUser.getEmail()) && userService.getUserByEmail(userInfoVo.getEmail()).size() > 0)
					result.addError(new FieldError("userInfoVo", "email", "这个email已经被注册，请更换!"));
			}
				
			//3、验证name是否可用
			if(userInfoVo.getName() != null && !"".equals(userInfoVo.getName().trim())){
				//不是他的昵称，但是已经被注册过
				if(!userInfoVo.getName().equals(signInUser.getName()) && userService.getUserByName(userInfoVo.getName()).size() > 0)
					result.addError(new FieldError("userInfoVo", "name", "这个昵称已经被注册，请更换!"));
			}
				
			
			//有错.....
			if(result.hasErrors())
			{
				return "redirect:/account/info";
			}
			
			
			if(userInfoVo.getBlog() != null && !"".equals(userInfoVo.getBlog().trim())) signInUser.setBlog(userInfoVo.getBlog());
			if(userInfoVo.getSummary() != null && !"".equals(userInfoVo.getSummary().trim())) signInUser.setSummary(userInfoVo.getSummary());
			if(userInfoVo.getEmail() != null && !"".equals(userInfoVo.getEmail().trim())) signInUser.setEmail(userInfoVo.getEmail());
			if(userInfoVo.getName() != null && !"".equals(userInfoVo.getName().trim())) signInUser.setName(userInfoVo.getName());
			
			if(userInfoVo.getAvatalrUr()!=null && !"".equals(userInfoVo.getAvatalrUr())){
				//1、设置设置avatar
				Resource resource = new Resource(userInfoVo.getAvatalrUr(), new Integer[]{});
				//设置新的属性
				signInUser.setAvatar(resource);
			}
			
			userService.update(signInUser);
			
			session.setAttribute(ApplicationConstant.APPLICATION_SIGNIN_USER, userService.getEntity(signInUser.getId()));
			
			return "redirect:/account/profiles?accountId="+signInUser.getId();
					
		}
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
	
	private List<User> findShipByType(List<FlowShip> ships , ShipType type){
		
		//Assert.notNull(type);
		
		List<User> result = new ArrayList<User>();
		
		for(FlowShip s : ships){
			if(type.equals(ShipType.FOLLOW)){
				
				result.add(s.getFollowed());
				
			}
			if(type.equals(ShipType.TARGET)){
				result.add(s.getTarget());
			}
		}
		
		return result;
	}
	
	enum ShipType {
		TARGET,FOLLOW
	}
}
