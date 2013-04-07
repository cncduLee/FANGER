package cn.cdu.fang.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.cdu.fang.entity.EntityTemplate;
import cn.cdu.fang.entity.Spot;
import cn.cdu.fang.service.SpotService;
import cn.cdu.fang.service.TemplateService;

@Controller
public class HomeController {
	
	private static Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	TemplateService templateService;
	@Autowired
	SpotService spotService;
	
	
	@RequestMapping(value = "/",method=RequestMethod.GET)
	public String Home(Model uiModel,HttpSession session){
		List<Spot> all = spotService.getEntities();
		uiModel.addAttribute("fangs", handleList(all));
		logger.info("got home page");
		return "home";
	}
	
	/**
	 * 处理summay 过长的问题
	 * 
	 * @param spots
	 * @return
	 */
	private List<Spot> handleList(List<Spot> spots){
		List<Spot> list = new ArrayList<Spot>();
		for(Spot spot :spots){
			spot.setSummary(spot.getSummary().length() > 20 ? spot.getSummary().subSequence(0, 19) + "<a href='#'>...MORE...</a>" : spot.getSummary());
			list.add(spot);
		}
		return list;
	}
}
