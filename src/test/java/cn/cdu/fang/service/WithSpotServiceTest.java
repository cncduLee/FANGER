package cn.cdu.fang.service;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.cdu.fang.constant.ShipWithSpot;
import cn.cdu.fang.entity.Spot;
import cn.cdu.fang.entity.User;
import cn.cdu.fang.entity.WithSpot;

public class WithSpotServiceTest {
	
	WithSpotService service;
	private SpotService spotService;
	private UserService userService;

	
	@Before
	public void setUp() throws Exception {
		service = (WithSpotService) new ClassPathXmlApplicationContext("META-INF/spring/applicationContext.xml").getBean("withSpotService");
		spotService = (SpotService) new ClassPathXmlApplicationContext("META-INF/spring/applicationContext.xml").getBean("spotService");
		userService = (UserService) new ClassPathXmlApplicationContext("META-INF/spring/applicationContext.xml").getBean("userService");
	}

	@Test
	public void testSave() {
		Spot spot = spotService.getEntity(1);
		User tracked = userService.getEntity(1);
		
		WithSpot ws = new WithSpot();
		ws.setCreatedAt(new Date());
		ws.setType(ShipWithSpot.SHARE);
		ws.setStatus(0);
		ws.setTracked(tracked);
		ws.setTarget(spot);
		
		service.save(ws);
	}

}
