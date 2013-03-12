package cn.cdu.fang.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.cdu.fang.constant.ActivityType;
import cn.cdu.fang.constant.ApplicationConstant;
import cn.cdu.fang.constant.Platform;
import cn.cdu.fang.entity.Activity;
import cn.cdu.fang.entity.Place;
import cn.cdu.fang.entity.Spot;
import cn.cdu.fang.entity.User;
import cn.cdu.fang.service.PlaceService;
import cn.cdu.fang.service.ResourceService;
import cn.cdu.fang.service.SpotService;
import cn.cdu.fang.service.UserService;
import cn.cdu.fang.vo.AjaxResult;
import cn.cdu.fang.vo.AjaxResultCode;
import cn.cdu.fang.vo.SpotVo;
import cn.cdu.fang.web.utill.SessionUtil;
import cn.cdu.fang.web.utill.Validate;
import cn.cdu.fang.web.utill.WebImageUtil;


@Controller
@Scope("prototype")
public class SpotsController implements ApplicationContextAware {

	private ApplicationContext ac;
	
	@Autowired
	SessionUtil sessionUtil;
	@Autowired
	WebImageUtil webImageUtil;
	@Autowired
	ResourceService resourceService;
	@Autowired
	SpotService spotService;
	@Autowired
	UserService userService;
	@Autowired
	PlaceService placeService;
	
	@ModelAttribute("tempRepositories")
	public String getRepositorLocaltion(){
		return ApplicationConstant.SPOT_IMAGE_REPOSITORY;
	}
	
	@RequestMapping(value="/spot/create",method=RequestMethod.GET)
	public String create(Model model,HttpSession session){
		session.setAttribute(ApplicationConstant.SESSION_LAST_VISITED_URL, "spot/create");
		if(session.getAttribute(ApplicationConstant.APPLICATION_SIGNIN_USER)==null)
			return "redirect:/signIn";
		return "spot/create";
	}
	
	@RequestMapping(value="/spot/create",method=RequestMethod.POST)
	public @ResponseBody AjaxResult create(
			@ModelAttribute("spotVo") @Valid SpotVo spotVo,
			BindingResult result,
			Model model,HttpSession session){
		
		User signInUser = sessionUtil.getSignInUser(session);
		
		if(signInUser==null){
			return new AjaxResult(AjaxResultCode.NEED_SIGNIN);
		}
		if(result.hasErrors()){
			return new AjaxResult(AjaxResultCode.INVALID, 
					"验证没有通过");
		}
		//============故事的主题============//
		Spot spot = Spot.builSpotByVo(spotVo, signInUser);
		
		try {
			cn.cdu.fang.entity.Resource res = new cn.cdu.fang.entity.Resource();
			
			if(Validate.isUrl(spotVo.getImageUrl())){
				System.out.println("from url");
				//网络地址，需要爬去此图片到本地
				res.setResId(spotVo.getImageUrl());
			}else if(spotVo.getImageUrl().startsWith(ApplicationConstant.base)){
				System.out.println("from uolaod file");
				//上传的资源图片，只需要读取路径到数据库
				res.setResId(spotVo.getImageUrl().substring(ApplicationConstant.base.length()+1));
			}else{
				//错误的路径，存放缺省的图片资源
				res.setResId("");	
			}
			spot.setImages(res);
			
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		
		//===========故事地点==========//
		Place place = new Place();
		if(StringUtils.hasText(spotVo.getPlaceId())){
			//根据编号查询地点
			place.setZipCode(spotVo.getPlaceId());
		}else{
			place.setFullAddr(spotVo.getFullAddr());
		}
		spot.setPlace(place);
		
		//============故事存入============//
		spotService.save(spot);
		//==============记录增长=================//
		signInUser.setSpotCount(signInUser.getSpotCount() + 1);
		userService.update(signInUser);
		
		//==============活动记录=================//
		Activity activity = new Activity();
		activity.setOwner(signInUser.getName());
		activity.setCreateAt(new Date());
		activity.setType(ActivityType.SPOT);
		activity.setPlatform(Platform.WEB);
		activity.setTargetSpot(spot.getName());
		
		return new AjaxResult(AjaxResultCode.SUCCESS);
	}
	
	@RequestMapping(value="/spot/upload",method=RequestMethod.POST)
	public @ResponseBody String upload(@RequestParam MultipartFile imageFile,
			@ModelAttribute("tempRepositories") String tempRepositories,
			Model model) throws IOException{
		
		String orgName = imageFile.getOriginalFilename();
		String newName = new StringBuilder().append(System.currentTimeMillis())
				.append(orgName.substring(orgName.lastIndexOf('.'))).toString();
		
		Resource res = ac.getResource(tempRepositories);
		
		File file = res.getFile();
		if (file.isDirectory()) {
			file = new File(file.getPath() + File.separator + newName);
		}
		imageFile.transferTo(file);
		
		
		return  ApplicationConstant.base+ApplicationConstant.SPOT_IMAGE_REPOSITORY + "/"
				+ newName;
	}

	@Override
	public void setApplicationContext(ApplicationContext ac)
			throws BeansException {
		this.ac = ac;
	}
	
	
}
