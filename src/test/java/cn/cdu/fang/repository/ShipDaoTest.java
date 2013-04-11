package cn.cdu.fang.repository;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import cn.cdu.fang.entity.FlowShip;
import cn.cdu.fang.entity.User;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:META-INF/spring/applicationContext.xml")
@Transactional
public class ShipDaoTest {
	
	@Autowired
	ShipDao shipDao;
	@Autowired
	UserDao userDao;

	@Before
	public void setUp() throws Exception {
		User t = userDao.findOne(1);
		User f = userDao.findOne(3);
		FlowShip ship = new FlowShip(t, f, 0, new Date(), new Date());
		
		shipDao.save(ship);
	}

	@Test
	public void testFindByFollowed() {
		List<FlowShip> ships = shipDao.findByFollowed(userDao.findOne(2));
		for(FlowShip s : ships){
			System.out.println(s.getFollowed().getName()+"----flowed---"+s.getTarget().getName());
		}
	}

	@Test
	public void testFindByTarget() {
//		System.out.println("http://localhost:8080/FANGER/signIn".contains("/signIn"));
		List<FlowShip> ships = shipDao.findByTarget(userDao.findOne(1));
		for(FlowShip s : ships){
			System.out.println(s.getTarget().getName()+"----target---"+s.getFollowed().getName());
		}
	}

}
