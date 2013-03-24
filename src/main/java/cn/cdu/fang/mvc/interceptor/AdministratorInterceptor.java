package cn.cdu.fang.mvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.cdu.fang.constant.ApplicationConstant;
import cn.cdu.fang.constant.Role;
import cn.cdu.fang.entity.User;
import cn.cdu.fang.web.utill.SessionUtil;

public class AdministratorInterceptor extends HandlerInterceptorAdapter{

	@Autowired
	SessionUtil sessionUtil;
	
	@SuppressWarnings("null")
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		User user = sessionUtil.getSignInUser(session);
		//拦截admin下面的所有请求
		String url = request.getRequestURL().toString();

		if (user == null || !user.getRole().equals(Role.ADMIN)) {
			request.getRequestDispatcher("/signIn").forward(request, response);
			return false;
		}
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}
	
}
