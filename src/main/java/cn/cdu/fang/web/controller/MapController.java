package cn.cdu.fang.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.cdu.fang.constant.ApplicationConstant;
import cn.cdu.fang.entity.Spot;
import cn.cdu.fang.service.SpotService;
import cn.cdu.fang.vo.AjaxResult;
import cn.cdu.fang.vo.AjaxResultCode;
import cn.cdu.fang.vo.SpotJson;
import cn.cdu.fang.web.utill.SessionUtil;

@Controller
public class MapController {
	
	@Autowired
	SessionUtil sessionUtil;
	@Autowired
	SpotService spotService;
	
	@RequestMapping(value="/map",method=RequestMethod.GET)
	public String mapPage(Model model,HttpSession session){
		session.setAttribute(ApplicationConstant.SESSION_LAST_VISITED_URL, "/map");
		return "mapView";
	}
	
	@RequestMapping(value="/spotsMap",method=RequestMethod.GET)
	public @ResponseBody AjaxResult mapData(HttpServletRequest request, 
			ModelAndView mav, HttpSession session){
		List<Spot> spots = spotService.getEntities();
		return new AjaxResult(AjaxResultCode.SUCCESS,getSpotJson(spots));
	} 
	
	
	
	private List<SpotJson> getSpotJson(List<Spot> spots){
		List<SpotJson> result = new ArrayList<SpotJson>();
		for(Spot item : spots){
			result.add(new SpotJson().builtJosn(item));
		}
		return result;
	}
}
