package cn.cdu.fang.repository;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.cdu.fang.constant.Role;
import cn.cdu.fang.constant.UserStatus;
import cn.cdu.fang.entity.User;
import cn.cdu.fang.service.UserService;

/**
 * 1、初始化最高权限用户
 * 2、代补充...
 * 
 * @author Lee
 */
//@Component
public class Loader implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	UserService userService;
	
	@Override
	@Transactional
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		User user = new User();
		
		user.setCreateAt(new Date());
		user.setEmail("admin@gmail.com");
		user.setPassword("aaaaaa");
		user.setName("admin");
		user.setRole(Role.ADMIN);
		user.setStatus(UserStatus.VALID);
		user.setSummary("我是超级用户");
		
		userService.save(user);
		
	}


}
