package cn.cdu.fang.service;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import cn.cdu.fang.entity.Spot;
import cn.cdu.fang.repository.SpotDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:META-INF/spring/applicationContext.xml")
@Transactional
public class SpotDaoTest {
	
	@Autowired
	SpotDao spotDao;
	
	@Before
	public void setUp() throws Exception {
//		Spot spot = new Spot();
//		spot.setCategory("news");
//		spot.setCreatedAt(new Date());
//		spot.setCreatedBy(userService.getEntity(1));
//		spot.setName("测速");
//		spot.setSummary("hh");
//		spotDao.save(spot);
	}

	@Test
	public void testPaging() {
//		System.out.println("-->"+spotDao.findAll(new PageRequest(1, 3)));
	}
	
	@Test
	public void testCategoryPaging(){
		for(Spot spot : spotDao.findByCategory("foods", new PageRequest(0, 10)).getContent()){
			System.out.println(spot.getCategory()+"--->"+spot.getName());
		}
	}
	@Test
	public void testFindAll() {
		for(Spot spot : spotDao.findAll(new PageRequest(0, 10,new Sort(new Order(Direction.ASC, "createdAt")))).getContent()){
			System.out.println(spot.getCategory()+"--->"+spot.getName());
		}
	}
	@Test 
	public void testUpdate(){
		spotDao.setFixedCommentsCountFor(21, 1);	
	}
	
	@Test
	public void testLikeQuery(){
		for(Spot spot : spotDao.findByName("%a%",new PageRequest(0, 10,new Sort(new Order(Direction.ASC, "createdAt")))).getContent()){
			System.out.println(spot.getCategory()+"--->"+spot.getName());
		}
	}
	

}