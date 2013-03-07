package cn.cdu.fang.service;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.cdu.fang.entity.Place;
import cn.cdu.fang.entity.User;

public class PlaceServiceTest {
	private PlaceService placeService;
	private UserService userService;
	
	@Before
	public void setUp() throws Exception {
		placeService = (PlaceService) new ClassPathXmlApplicationContext("META-INF/spring/applicationContext.xml").getBean("palceService");
		userService = (UserService) new ClassPathXmlApplicationContext("META-INF/spring/applicationContext.xml").getBean("userService");
	}

	@Test
	public void testSave() {
		Place p = new Place();
		User u = userService.getEntity(1);
		
		p.setUpdateBy(u);
		
		p.setCity("成都");
		p.setContry("中国");
		p.setCreateAt(new Date());
		p.setDistrict("31241");
		p.setFullAddr("23131");
		p.setLngLat(new Double[]{231.31,31.1});
		p.setName("小吃街");
		p.setZipCode("610106");
		p.setStreet("十陵");
		p.setProvince("四川");
		placeService.save(p);
	}
	
	@Test
	public void testQuery(){
		System.out.println(placeService.getEntity(1).getProvince());
	}

}
