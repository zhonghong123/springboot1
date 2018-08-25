package com.gnete.springboot.demo.service;

import javax.annotation.Resource;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gnete.springboot.demo.entity.TestEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoServiceTest {
	
	@Resource(name = "demoService")
	private DemoService demoService;

	@Test
	public void getTestEntityByIdTest(){
		//System.out.println(demoService.getTestEntityById(1));
		TestEntity entity = demoService.getTestEntityById(1);
		//System.out.println("age = "+ entity.getAge());
		//System.out.println("name = "+ entity.getName());
		
		assertEquals(entity.getName(), "张三");
		assertEquals(entity.getAge().intValue(), 15);
	}
	
	@Test
	public void addTestEntityTest(){
		TestEntity entity = new TestEntity();
		entity.setAge(45);
		entity.setName("liuliu3");
		try {
			demoService.addTestEntity(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void updatTestEntityTest(){
		demoService.updatTestEntity(1, 1, 1000);
	}
	
	@Test
	public void updatTestEntityTest2(){
		demoService.updatTestEntity(1, 1, 10000);
	}
}
