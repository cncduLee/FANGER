package cn.cdu.fang.service;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import cn.cdu.fang.constant.Gender;
import cn.cdu.fang.constant.Role;
import cn.cdu.fang.constant.ShipWithSpot;
import cn.cdu.fang.constant.UserStatus;
import cn.cdu.fang.entity.Comment;
import cn.cdu.fang.entity.Resource;
import cn.cdu.fang.entity.Spot;
import cn.cdu.fang.entity.User;
import cn.cdu.fang.entity.WithSpot;
import cn.cdu.fang.vo.SpotVo;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:META-INF/spring/applicationContext.xml")
@Transactional
public class SpotServiceTest {
	
	@Autowired
	private SpotService service;
	@Autowired
	private UserService userService;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSave() {
//		User user = userService.getEntity(1);
//		user.setEmail("xuxcsacx@g.com");
//		user.setGender(Gender.UNKNOWN);
//		user.setName("ncsames:aaaaaaaaaaa");
//		user.setPassword("2aa131");
//		user.setRole(Role.USER);
//		user.setCreateAt(new Date());
//		user.setStatus(UserStatus.VALID);
//		
//		Resource img = new Resource("231casca 4141", new Integer[]{1,2});
//		user.setAvatar(img);
//		
//		Spot spot = new Spot();
//	
//		spot.setCategory("news");
//		//spot.setCreatedBy(user);
//		spot.setCreatedAt(new Date());
//		spot.setName("eeeeeeeee测试数csa据");
//		spot.setSummary("hcsacasc长撒ello,hello,hello");
//		spot.setCreatedBy(user);
//		
//		Resource images = new Resource("231casca 4141", new Integer[]{1,2});
//		spot.setImages(images);
//					
//		Comment comment = new Comment();
//		comment.setCreatedAt(new Date());
//		comment.setCreatedBy(user);
//		comment.setContent("------ce擦擦撒shi ---");
////		spot.addComments(comment);
//		
//		/***/	
//
//		service.save(spot);
//		//userService.save(user);
		
		Spot spot = new Spot();
		spot.setCategory("news");
		spot.setCreatedAt(new Date());
		spot.setCreatedBy(userService.getEntity(1));
		spot.setName("测速****");
		spot.setSummary("hh");
		service.save(spot);
	}

	@Test
	public void testUpdate() {
		Spot sp = service.getEntity(1);
		sp.setName("update test");
		service.update(sp);
	}

	@Test
	public void testDelete() {
		//fail("Not yet implemented");
	}
	
	@Test
	public void testUpdateEntity() {
		Spot spot = service.getEntity(1);
		User tracked = userService.getEntity(1);
		
		WithSpot ws = new WithSpot();
		ws.setCreatedAt(new Date());
		ws.setType(ShipWithSpot.SHARE);
		ws.setStatus(0);
		ws.setTracked(tracked);
		ws.setTarget(spot);
		
		service.update(spot);
	}

	@Test
	public void testGetEntity() {
//		Set<Comment> all = service.getEntity(2).getComments();
//		for(Comment c : all){
//			System.out.println(c.getCreatedBy().getName());
//		}
		
		Spot spot = service.getEntity(1);
		System.out.println(spot.getPlace().getLngLat()[0]);
	}

	@Test
	public void testGetEntities() {
		for(Spot spot : service.findByCategory("news", new PageRequest(0, 10,Direction.DESC,"createdAt"))){
			System.out.println(spot.getPlace().getLngLat()==null?"y":spot.getPlace().getLngLat()[0] + "--------->"+spot.getName());
		}
	}
	
	@Test
	public void testQuery(){
		for(Spot spot : service.findByName("%a%", new PageRequest(0, 10,Direction.DESC,"createdAt")).getContent()){
			System.out.println("--------->"+spot.getName());
		}
	}
	

}
