package cn.cdu.fang.service;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.cdu.fang.constant.Gender;
import cn.cdu.fang.entity.EntityItem;
import cn.cdu.fang.entity.EntityTemplate;


public class TemplateServiceTest {

	private TemplateService service;
	
	@Before
	public void setUp() throws Exception {
		service = (TemplateService) new ClassPathXmlApplicationContext("META-INF/spring/applicationContext.xml").getBean("templateService");
	}

	@Test
	public void testSave() {
		EntityTemplate tem = new EntityTemplate("不管是",new Date());
		Set<EntityItem> items = new HashSet<EntityItem>(); 
		for(int a=0;a<50;a++){
			EntityItem item = new EntityItem("小李"+a, 22, new Date(), 2, tem);
			tem.addItems(item);
			//items.add(item);
		}
		//tem.setEntityItems(items);
		service.save(tem);
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
		fail("Not yet implemented");
	}

	@Test
	public void testGetEntityTemplates() {
		for(EntityTemplate tem : service.getEntityTemplates()){
			for(EntityItem in : tem.getEntityItems()){
				System.out.println(in.getName());
			}
		}
	}

}