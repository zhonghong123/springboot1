package com.gnete.springboot.demo.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gnete.springboot.demo.entity.TestEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.gnete.springboot.demo.mapper")
public class TestMapperTest {
	
	@Autowired
	private TestMapper testMapper;

	@Test
	public void getAllTest(){
		System.out.println(testMapper.getAll());
	}
	
	@Test
	public void getOneTest(){
		System.out.println(testMapper.getOne(1L));
	}
	
	@Test
	public void insertTest(){
		TestEntity entity = new TestEntity();
		entity.setAge(15);
		entity.setName("wahaha");
		testMapper.insert(entity);
	}
	
	@Test
	public void updateTest(){
		TestEntity entity = new TestEntity();
		entity.setId(3);
		entity.setName("alibaba3");
		entity.setAge(14);
		testMapper.update(entity);
	}
	
	@Test
	public void deleteTest(){
		testMapper.delete(5L);
	}
}
