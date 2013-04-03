package cn.cdu.fang.android.restful;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(value="/list/{startPosition},{maxResult}",
			method=RequestMethod.GET)
	public @ResponseBody List<AndrSpot> getSpot(
			@PathVariable("startPosition") Integer startPosition,
			@PathVariable("maxResult") Integer maxResult,
			HttpServletRequest request){

		logger.info("get list for the restful");
		return convertTo(spotService.getEntitiesByPage(startPosition, maxResult));//new AjaxResult(AjaxResultCode.SUCCESS,convertTo(spotService.getEntitiesByPage(startPosition, maxResult))); 
	}
	
	
	private List<AndrSpot> convertTo(List<Spot> spots){
		List<AndrSpot> results = new ArrayList<AndrSpot>();
		for(Spot spot : spots){
			results.add(AndrSpot.convertTo(spot));
		}
		return results;
	}
}
