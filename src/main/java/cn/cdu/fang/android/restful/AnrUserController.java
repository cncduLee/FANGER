package cn.cdu.fang.android.restful;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.cdu.fang.android.vo.AndrUser;
import cn.cdu.fang.entity.User;
import cn.cdu.fang.service.UserService;
import cn.cdu.fang.vo.AjaxResult;
import cn.cdu.fang.vo.AjaxResultCode;


@Controller
@RequestMapping("/rest/AnrUser")
public class AnrUserController {
	
	private static final Logger logger = LoggerFactory.getLogger(AnrUserController.class);
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET,produces = "application/json")
	public @ResponseBody List<AndrUser> getUserForTest(HttpServletRequest request){
		logger.info("get info from the android plaform");
		return convertTo(userService.getEntities());//new AjaxResult(AjaxResultCode.SUCCESS, convertTo(userService.getEntities()));
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public @ResponseBody String login(
			@RequestBody LinkedMultiValueMap<String, String> map){
		
//		System.out.println(map.getFirst("name")+ "-----" + map.getFirst("pwd"));
		
		logger.info("login from the rest");
		
		List<User> userByName = userService.getUserByName(map.getFirst("name"));
		
		if(userByName.size()==1 && userByName.get(0).getPassword().equals(map.getFirst("name"))){
			return "SUCCESS";
		}
		return "FAILURE";
	}
	
	
	/**
	 * 辅助类型转换
	 * @param list
	 * @return
	 */
	private List<AndrUser> convertTo(List<User> list){
		List<AndrUser> result = new ArrayList<AndrUser>();
		for(User user : list){
			result.add(AndrUser.convertTo(user));
		}
		return result;
	}
	
}
