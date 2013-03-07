package cn.cdu.fang.web.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.cdu.fang.constant.ApplicationConstant;
import cn.cdu.fang.entity.Comment;
import cn.cdu.fang.entity.Spot;
import cn.cdu.fang.entity.User;
import cn.cdu.fang.service.CommentService;
import cn.cdu.fang.service.SpotService;
import cn.cdu.fang.service.UserService;
import cn.cdu.fang.vo.AjaxResult;
import cn.cdu.fang.vo.AjaxResultCode;
import cn.cdu.fang.vo.CommentVo;


@Controller
public class CommentContrller {
	
	private static Logger logger = LoggerFactory.getLogger(CommentContrller.class);
	
	@Autowired
	CommentService commentService;
	@Autowired
	UserService userService;
	@Autowired
	SpotService spotService;
	
	@RequestMapping(value="/addComment",method=RequestMethod.POST)
	public @ResponseBody AjaxResult addComment(
			@ModelAttribute("commentVo") @Valid CommentVo commentVo,
			BindingResult result,
			Model model,HttpSession session ){
		User createUser = (User)session.getAttribute(ApplicationConstant.APPLICATION_SIGNIN_USER);
		if(!result.hasErrors()){
			new AjaxResult(AjaxResultCode.NO_AUTH);
		}
		Comment comment = new Comment();
		Spot targetSpot = spotService.getEntity(commentVo.getSpotId());
		if(createUser == null){
			comment.voToComment(commentVo, targetSpot);
		}else{
			comment.voToComment(commentVo, createUser, targetSpot);
		}
		try{
			commentService.save(comment);
			targetSpot.setCommentsCount(targetSpot.getCommentsCount()+1);
			spotService.update(targetSpot);
		}catch(Exception e){
			logger.error("评论失败"+new Date());
			return new AjaxResult(AjaxResultCode.EXCEPTION);
		}
		return new AjaxResult(AjaxResultCode.SUCCESS); 
	}
}
