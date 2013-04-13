package cn.cdu.fang.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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


@Controller
@Scope("prototype")
public class SpotsController implements ApplicationContextAware {

	private ApplicationContext ac;
	
	@Autowired
	SessionUtil sessionUtil;

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
				//网络地址，需要爬去此图片到本地
				res.setResId(spotVo.getImageUrl());
			}else if(spotVo.getImageUrl().startsWith(ApplicationConstant.base)){
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
		Place place = null;
		System.out.println("placeId from vo --->"+spotVo.getPlaceId());
		if(StringUtils.hasText(spotVo.getPlaceId())){
			//设置关联
			place = placeService.getEntity(Integer.parseInt(spotVo.getPlaceId()));
		}else{
			place = new Place();
			place.setFullAddr(spotVo.getFullAddr());
			place.setNation(ApplicationConstant.NATION);
			place.setProvince(ApplicationConstant.PROVINCE);
			place.setCity(ApplicationConstant.CITY);
			place.setDistrict(ApplicationConstant.DISTRICT);
			place.setStreet(ApplicationConstant.STREET);
			place.setZipCode(ApplicationConstant.ZIP_CODE);
			place.setLngLat(new Double[]{ApplicationConstant.FULL_CHINA_LAT,ApplicationConstant.FULL_CHINA_LNT});
			placeService.save(place);
			
			place = null;
			place =  placeService.getEntityByFullAdd(spotVo.getFullAddr());
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
	public @ResponseBody String upload(
			@RequestParam MultipartFile imageFile,
			@ModelAttribute("tempRepositories") String tempRepositories,
			Model model) throws IOException{
		
		String orgName = imageFile.getOriginalFilename();
		String newName = new StringBuilder().append(System.currentTimeMillis())
				.append(orgName.substring(orgName.lastIndexOf('.'))).toString();
		
		Resource res = ac.getResource(tempRepositories);
		File file = res.getFile();
		
		String storagePath = file.getPath() + File.separator + newName;
		
		if (file.isDirectory()) {
			file = new File(storagePath);
		}
		
		//this.copyFile(imageFile.getInputStream(), storagePath);
		
		imageFile.transferTo(file);
		return  ApplicationConstant.base+ApplicationConstant.SPOT_IMAGE_REPOSITORY + "/"
				+ newName;
	}

	@Override
	public void setApplicationContext(ApplicationContext ac)
			throws BeansException {
		this.ac = ac;
	}
	
	
	
	 /** 
     * 写文件到本地 
     * @param in 
     * @param fileName 
     * @throws IOException 
     */  
    private void copyFile(InputStream in,String path) throws IOException{  
        FileOutputStream fs = new FileOutputStream(path);  
          byte[] buffer = new byte[1024 * 1024];  
          int bytesum = 0;  
          int byteread = 0;  
          while ((byteread = in.read(buffer)) != -1) {  
              bytesum += byteread;  
              fs.write(buffer, 0, byteread);  
              fs.flush();  
          }  
          fs.close();  
          in.close();  
    }  
	
}
