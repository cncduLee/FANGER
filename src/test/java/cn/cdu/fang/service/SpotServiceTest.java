package cn.cdu.fang.service;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.cdu.fang.constant.Gender;
import cn.cdu.fang.constant.Role;
import cn.cdu.fang.constant.UserStatus;
import cn.cdu.fang.entity.Comment;
import cn.cdu.fang.entity.Resource;
import cn.cdu.fang.entity.Spot;
import cn.cdu.fang.entity.User;
import cn.cdu.fang.vo.SpotVo;

public class SpotServiceTest {
	private SpotService service;
	private UserService userService;
	@Before
	public void setUp() throws Exception {
		service = (SpotService) new ClassPathXmlApplicationContext("META-INF/spring/applicationContext.xml").getBean("spotService");
		userService = (UserService) new ClassPathXmlApplicationContext("META-INF/spring/applicationContext.xml").getBean("userService");
	}

	@Test
	public void testSave() {
		User user = userService.getEntity(1);
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
		
		Spot spot = new Spot();
	
		spot.setCategory("news");
		//spot.setCreatedBy(user);
		spot.setCreatedAt(new Date());
		spot.setName("eeeeeeeee测试数csa据");
		spot.setSummary("hcsacasc长撒ello,hello,hello");
		spot.setCreatedBy(user);
		
		Resource images = new Resource("231casca 4141", new Integer[]{1,2});
		spot.setImages(images);
					
		Comment comment = new Comment();
		comment.setCreatedAt(new Date());
		comment.setCreatedBy(user);
		comment.setContent("------ce擦擦撒shi ---");
		spot.addComments(comment);
		
		/***/	

		//service.save(spot);
		//userService.save(user);
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
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
		for(Spot spot : service.getEntities()){
			System.out.println(spot.getPlace().getLngLat()==null?"y":spot.getPlace().getLngLat()[0]);
		}
	}

}
