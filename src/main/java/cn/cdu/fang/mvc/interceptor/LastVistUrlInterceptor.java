package cn.cdu.fang.mvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.cdu.fang.constant.ApplicationConstant;
import cn.cdu.fang.web.utill.AjaxUtil;
import cn.cdu.fang.web.utill.SessionUtil;

public class LastVistUrlInterceptor extends HandlerInterceptorAdapter{

	@Autowired
	SessionUtil sessionUtil;
	@Autowired
	AjaxUtil ajaxUtil;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		if(!ajaxUtil.isAjaxRequest(request) && 
				RequestMethod.GET.name().equals(request.getMethod())){
			HttpSession session = request.getSession();
			String referUrl = StringUtils.trimAllWhitespace(request.getHeader("referer"));
			if(StringUtils.hasText(referUrl) &&
					!referUrl.endsWith(".js") &&
					!referUrl.endsWith(".csss")){
				session.setAttribute(ApplicationConstant.SESSION_LAST_VISITED_URL,request.getHeader("referer"));
			}
		}
		return super.preHandle(request, response, handler);
	}
}
