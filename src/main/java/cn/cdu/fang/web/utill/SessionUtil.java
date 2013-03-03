package cn.cdu.fang.web.utill;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import cn.cdu.fang.constant.ApplicationConstant;
import cn.cdu.fang.constant.Platform;
import cn.cdu.fang.entity.User;

@Component
public class SessionUtil {
	
	/**
	 * 获取最后一次访问URL
	 * 
	 * @param session
	 * @return
	 */
	public String getLastVisitedUrl(HttpSession session){
		String lastVisitedUrl = (String) session.getAttribute(ApplicationConstant.SESSION_LAST_VISITED_URL);
		return lastVisitedUrl != null ? lastVisitedUrl : "/";
	}
	
	/**
	 * 获取登陆用户信息
	 * 
	 * @param session
	 * @return
	 */
	public User getSignInUser(HttpSession session){
		return (User)session.getAttribute(ApplicationConstant.APPLICATION_SIGNIN_USER);
	}
	
	/**
	 * 获取操作平台
	 * 
	 * @param session
	 * @return
	 */
	public Platform getBy(HttpSession session){
		return (Platform) session.getAttribute(ApplicationConstant.SESSION_PLATFORM);
	}
	
}
