package cn.cdu.fang.service;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.cdu.fang.constant.ActivityType;
import cn.cdu.fang.constant.Gender;
import cn.cdu.fang.constant.Platform;
import cn.cdu.fang.constant.Role;
import cn.cdu.fang.constant.UserStatus;
import cn.cdu.fang.entity.Activity;
import cn.cdu.fang.entity.User;

public class ActivityServiceTest {
	private ActivityService as;
	private UserService userService;
	@Before
	public void setUp() throws Exception {
		as = (ActivityService)new ClassPathXmlApplicationContext("META-INF/spring/applicationContext.xml").getBean("activityService");
		userService = (UserService) new ClassPathXmlApplicationContext("META-INF/spring/applicationContext.xml").getBean("userService");
	}

	@Test
	public void test() {
		Activity activity = new Activity();
		activity.setOwner("aaaaaaaa");
		activity.setCreateAt(new Date());
		activity.setType(ActivityType.SPOT);
		activity.setPlatform(Platform.WEB);
		
		as.save(activity);
	}

}
