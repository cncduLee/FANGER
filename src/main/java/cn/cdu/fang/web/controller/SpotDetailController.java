package cn.cdu.fang.web.controller;

import javax.servlet.http.HttpSession;

import junit.framework.Assert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.cdu.fang.entity.Spot;
import cn.cdu.fang.service.SpotService;

@Controller
public class SpotDetailController {
	
	@Autowired
	SpotService spotService;
	
	@RequestMapping(value="/spotDetail",method=RequestMethod.GET)
	public String detail(
			@RequestParam(value = "spotId", required = true) Integer spotId,
			Model model,HttpSession session){
		
		Assert.assertNotNull(spotId);
		Spot spot = spotService.getEntity(spotId);
		if(spot == null) return "";
		model.addAttribute("spotDetail",spot);
		
		return "spot/detail";
	}
	
}
