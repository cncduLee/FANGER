package cn.cdu.fang.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import cn.cdu.fang.constant.ApplicationConstant;


public class ContextPathListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContext sc = sce.getServletContext();
        sc.removeAttribute("base");
        ApplicationConstant.base = null;
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext sc = sce.getServletContext();
        sc.setAttribute("base", getContextPath(sc)); 
        ApplicationConstant.base = getContextPath(sc);
	}

	private String getContextPath(ServletContext sc) {
        return sc.getContextPath();
    }
}
