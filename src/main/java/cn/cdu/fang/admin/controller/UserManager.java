package cn.cdu.fang.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.cdu.fang.constant.Role;
import cn.cdu.fang.constant.UserStatus;
import cn.cdu.fang.entity.User;
import cn.cdu.fang.service.UserService;
import cn.cdu.fang.vo.SignInVO;
import cn.cdu.fang.web.utill.Paging;
import cn.cdu.fang.web.utill.SessionUtil;


@Controller
@RequestMapping("/admin/user")
public class UserManager {
	
	@Autowired
	UserService userService;
	@Autowired
	SessionUtil sessionUtil;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String adminLogin(
		@RequestParam(value = "currentPage", required = false) Integer currentPage, 
		@RequestParam(value = "pageSize", required = false) Integer pageSize,
		Model uiModel,HttpSession session){
	
		int ps = pageSize == null ? 20 : pageSize.intValue();//设置页大小
		
		int cp = currentPage == null ? 0 : currentPage.intValue();//当前页
		
		//当前页数据
		List<User> all = userService.findAll(UserStatus.VALID,Role.USER,new PageRequest(cp, ps)).getContent();
		uiModel.addAttribute("users", all);
		
		//总页数
		final long  count = userService.count(UserStatus.VALID,Role.USER);
		final long nrOfPages = count % ps == 0 ?  count / ps : (count / ps + 1);
		
		uiModel.addAttribute("pagingScript",Paging.pagingScript(cp, ps, (int)nrOfPages));
			
		uiModel.addAttribute("userList", userService.getEntities());
		return "admin/userInfo";
	}
	

/**		
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String adminLogin(@ModelAttribute("signInVo") @Valid SignInVO signInVo,
			BindingResult result,
			Model model, HttpSession session){
		
		return "";
	}
	
	**/
}
