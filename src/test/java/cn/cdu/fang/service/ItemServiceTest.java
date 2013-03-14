package cn.cdu.fang.service;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.cdu.fang.entity.EntityItem;
import cn.cdu.fang.entity.EntityOne;
import cn.cdu.fang.entity.EntityTemplate;

public class ItemServiceTest {
	private ItemService service;
	private TemplateService templateService;
	@Before
	public void setUp() throws Exception {
		service = (ItemService) new ClassPathXmlApplicationContext("META-INF/spring/applicationContext.xml").getBean("itemService");
		templateService = (TemplateService)new ClassPathXmlApplicationContext("META-INF/spring/applicationContext.xml").getBean("templateService");
	}

	@Test
	public void testSave() {
		EntityTemplate entityTemplate = templateService.getEntity(1);
		EntityItem item = new EntityItem("aa", 21, new Date(), 2, new Double[]{231.1,213.324},entityTemplate);
		
		item.setOne(new EntityOne("hahh"));
//		EntityTemplate entityTemplate = new EntityTemplate("aaaa", new Date());
		service.save(item);
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
		System.out.println(service.getEntity(2).getLan_lat()[0]);
	}

	@Test
	public void testGetEntityItems() {
		fail("Not yet implemented");
	}

}
