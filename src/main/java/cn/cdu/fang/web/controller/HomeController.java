package cn.cdu.fang.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.cdu.fang.entity.EntityTemplate;
import cn.cdu.fang.service.SpotService;
import cn.cdu.fang.service.TemplateService;

@Controller
public class HomeController {
	
	private static Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	TemplateService templateService;
	@Autowired
	SpotService spotService;
	
	
	@RequestMapping(value = "/")
	public String Home(Model uiModel){
		List<EntityTemplate> all = templateService.getEntityTemplates();
		uiModel.addAttribute("fangs", all);
		return "home";
	}
	
}
