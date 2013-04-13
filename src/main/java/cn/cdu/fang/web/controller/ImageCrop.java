package cn.cdu.fang.web.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.cdu.fang.constant.ApplicationConstant;
import cn.cdu.fang.service.ResourceService;
import cn.cdu.fang.vo.AjaxResult;
import cn.cdu.fang.vo.AjaxResultCode;
import cn.cdu.fang.vo.ImageVo;
import cn.cdu.fang.web.utill.ImageUtils;

@Controller
@Scope("prototype")
public class ImageCrop implements ApplicationContextAware {

	private ApplicationContext ac;
	
	@Autowired
	ResourceService resourceService;
	
	@ModelAttribute("avatarRepositories")
	public String getRepositorLocaltion(){
		return ApplicationConstant.AVATAR_IMAGE_REPOSITORY;
	}
	
	@RequestMapping(value={"/avatar/image"},method=RequestMethod.POST)
	public @ResponseBody String imageCrops(
			@RequestParam MultipartFile imageFile,
			@ModelAttribute("avatarRepositories") String avatarRepositories,
			Model model) throws Exception{
		
		//上传源文件名称
		String orgName = imageFile.getOriginalFilename();
		//系统源图像名称
		String newName = new StringBuilder().append(System.currentTimeMillis()).append(ImageUtils.getExtension(orgName)).toString();
		
		File destRes = ac.getResource(avatarRepositories).getFile();
		
		String orgFilePath = destRes.getPath() + File.separator + newName;//源文件存放路径
		
		File orgFile = null;
		
		if(destRes.isDirectory()){
			orgFile = new File(orgFilePath);
		}
		//保存源文件到磁盘
		imageFile.transferTo(orgFile);
		
		return ApplicationConstant.base+ApplicationConstant.AVATAR_IMAGE_REPOSITORY + "/" + newName;
		//return new AjaxResult(AjaxResultCode.SUCCESS,);
	}
	
	/**
	 * 用于处理上传图片，然后根据裁剪的大小
	 * 存入两种规格的图片
	 * 
	 * @param imageFile
	 * @param imageVo
	 * @param model
	 * @param request
	 * @param session
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	@Deprecated
	@RequestMapping(value={"/avatar/image/crop"},method=RequestMethod.POST)
	public String imageCrop(
			@RequestParam MultipartFile imageFile,
			@ModelAttribute("avatarRepositories") String avatarRepositories,
			@ModelAttribute("imageVo") @Valid ImageVo imageVo,
			Model model,HttpServletRequest request,HttpSession session) throws ServletException, IOException {
		
		//上传源文件名称
		String orgName = imageFile.getOriginalFilename();
		//系统源图像名称
		String newName = new StringBuilder().append(System.currentTimeMillis()).append(ImageUtils.getExtension(orgName)).toString();
		//修改大小后的图像名称
		String  cutName = "cut"+newName;
		
		File destRes = ac.getResource("avatarRepositories").getFile();
		
		String orgFilePath = destRes.getPath() + File.separator + newName;//源文件存放路径
		String cutFilePath = destRes.getPath() + File.separator + cutName;//剪切文件存放路径
		
		File orgFile = null;
		
		if(destRes.isDirectory()){
			orgFile = new File(orgFilePath);
		}
		//保存源文件到磁盘
		imageFile.transferTo(orgFile);
		//保存剪切图片到磁盘
		ImageUtils.saveImage(orgFile, cutFilePath, imageVo.getX(), imageVo.getY(), imageVo.getWidth(), imageVo.getHight());
		
		return "cutFilePath";
	}


	@SuppressWarnings("unused")
	private void checkImageDir(String userWebAppPath) {
		File file = new File(userWebAppPath);
		if (!file.exists()) {
			file.mkdir();
		}
	}


	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.ac = applicationContext;
	}
	
	
//	class AvatarResult implements Serializable{
//		String 
//	}
}
