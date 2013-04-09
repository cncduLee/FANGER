package cn.cdu.fang.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.cdu.fang.entity.EntityTemplate;
import cn.cdu.fang.entity.Spot;
import cn.cdu.fang.service.SpotService;
import cn.cdu.fang.service.TemplateService;
import cn.cdu.fang.web.utill.Paging;

@Controller
public class HomeController {
	
	private static Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	TemplateService templateService;
	@Autowired
	SpotService spotService;
	
	
	@RequestMapping(value = {"/","list","home"},method=RequestMethod.GET)
	public String Home(
			@RequestParam(value = "currentPage", required = false) Integer currentPage, 
			@RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestParam(value = "type", required = false) String type,
			Model uiModel,HttpSession session){
		logger.info("got home page");

		int ps = pageSize == null ? 10 : pageSize.intValue();//设置页大小
		
		int cp = currentPage == null ? 0 : currentPage.intValue();//当前页
		
		String tp = type == null ? "createdAt":type.trim();  
		
		//当前页数据
		List<Spot> all = spotService.findAll(new PageRequest(cp, ps, Direction.DESC,tp)).getContent();
		uiModel.addAttribute("fangs", handleList(all));
		
		//总页数
		final long  count = spotService.count();
		final long nrOfPages = count % ps == 0 ?  count / ps : (count / ps + 1);
		
		uiModel.addAttribute("type",tp);
		uiModel.addAttribute("pagingScript",Paging.pagingScript(cp, ps, (int)nrOfPages));
		
		return "home";
	}
	
	@RequestMapping(value={"/search/home","/search"} ,method=RequestMethod.POST)
	public String HomeSearch (
			@RequestParam(value = "keyWord", required = false) String keyWord,
			@RequestParam(value = "currentPage", required = false) Integer currentPage, 
			@RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestParam(value = "type", required = false) String type,
			Model uiModel,HttpSession session){
		
		logger.info(" search... with keyWord" + keyWord);
		
		int ps = pageSize == null ? 10 : pageSize.intValue();//设置页大小
		
		int cp = currentPage == null ? 0 : currentPage.intValue();//当前页
		
		String tp = type == null ? "createdAt":type.trim();  
		
		//当前页数据
		List<Spot> all = spotService.findByName("%"+keyWord+"%",new PageRequest(cp, ps, Direction.DESC,tp)).getContent();
		
		System.out.println(all.size()+"--------##");
		
		uiModel.addAttribute("fangs", handleList(all));
		
		//总页数
		final long  count = spotService.count();
		final long nrOfPages = count % ps == 0 ?  count / ps : (count / ps + 1);
		
		uiModel.addAttribute("type",tp);
		uiModel.addAttribute("pagingScript",Paging.pagingScript(cp, ps, (int)nrOfPages));
		
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
