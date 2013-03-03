package cn.cdu.fang.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.cdu.fang.entity.EntityItem;
import cn.cdu.fang.entity.EntityTemplate;


public class TemplateServiceTest {

	@SuppressWarnings("unused")
	private TemplateService service;
	
	@Before
	public void setUp() throws Exception {
		service = (TemplateService) new ClassPathXmlApplicationContext("META-INF/spring/applicationContext.xml").getBean("templateService");
	}

	@Test
	public void testSave() {
		
		for(int a=0;a<50;a++){
			EntityTemplate tem = new EntityTemplate("不管是",new Date());
			service.save(tem);
		}
		
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
			System.out.println(tem.getId());
		}
	}

}
