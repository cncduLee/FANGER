package cn.cdu.fang.android.restful;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.cdu.fang.android.vo.AndrSpot;
import cn.cdu.fang.entity.Spot;
import cn.cdu.fang.service.SpotService;
import cn.cdu.fang.vo.AjaxResult;
import cn.cdu.fang.vo.AjaxResultCode;


@Controller
@RequestMapping("/rest/spot")
public class AnrSpotController {
	
	private static final Logger logger = LoggerFactory.getLogger(AnrSpotController.class);
	
	@Autowired
	SpotService spotService;
	
	@RequestMapping(value={"/list","/all","/page"},method=RequestMethod.GET)
	public @ResponseBody List<AndrSpot> getSpot(
			@RequestParam(value = "currentPage", required = false) Integer currentPage, 
			@RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "name", required = false) String name,
			HttpServletRequest request){
		
		logger.info("get list for the restful");
		
		int ps = pageSize == null ? 10 : pageSize.intValue();//设置页大小
		
		int cp = currentPage == null ? 0 : currentPage.intValue();//当前页
		
		String tp = type == null ? "createdAt":type.trim();   
		
		String spName = ( name!=null&&!name.trim().equals("") )? name:null;
		
		List<Spot> all = null; 
		//当前页数据
		if(spName == null)
			all=spotService.findAll(new PageRequest(cp, ps, Direction.DESC,tp)).getContent();
		else
			all=spotService.findByName("%"+spName+"%",new PageRequest(cp, ps, Direction.DESC,tp)).getContent();
		
		return convertTo(all);//new AjaxResult(AjaxResultCode.SUCCESS,convertTo(spotService.getEntitiesByPage(startPosition, maxResult))); 
	}
	
	
	private List<AndrSpot> convertTo(List<Spot> spots){
		List<AndrSpot> results = new ArrayList<AndrSpot>();
		for(Spot spot : spots){
			results.add(AndrSpot.convertTo(spot));
		}
		return results;
	}
}
