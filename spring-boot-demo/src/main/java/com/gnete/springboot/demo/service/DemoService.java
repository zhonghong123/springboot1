package com.gnete.springboot.demo.service;

import java.util.List;

import com.gnete.springboot.demo.entity.TestEntity;

public interface DemoService {

	public TestEntity getTestEntityById(long id);

	public List<TestEntity> getTestEntity();
	
	public void addTestEntity(TestEntity entity) throws Exception;
	
	public void updatTestEntity(int age, int id, int sleep);
}
