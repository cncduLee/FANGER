package cn.cdu.fang.web.utill;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;


@Component
public class AjaxUtil {
	public boolean isAjaxRequest(HttpServletRequest request) {
		String requestedWith = request.getHeader("X-Requested-With");
		return requestedWith != null ? "XMLHttpRequest".equals(requestedWith)
				: false;
	}
}
