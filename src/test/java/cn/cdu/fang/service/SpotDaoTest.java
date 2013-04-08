package cn.cdu.fang.service;


import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.cdu.fang.entity.Spot;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:META-INF/spring/applicationContext.xml")
public class SpotDaoTest {
	
	@Autowired
	SpotDao spotDao;
	@Autowired
	UserService userService;
	
	@Before
	public void setUp() throws Exception {
		Spot spot = new Spot();
		spot.setCategory("news");
		spot.setCreatedAt(new Date());
		spot.setCreatedBy(userService.getEntity(1));
		spot.setName("测速");
		spot.setSummary("hh");
		spotDao.save(spot);
	}

	@Test
	public void testPaging() {
		//System.out.println("-->"+spotDao.paging(new PageRequest(1, 3)));
	}

	@Test
	public void testFindAll() {
		System.out.println("====>"+spotDao.findAll());
	}

}
