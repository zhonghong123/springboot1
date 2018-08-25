package com.gnete.springboot.demo.mapper;

import java.util.List;

import com.gnete.springboot.demo.entity.TestEntity;

public interface TestMapper {

	List<TestEntity> getAll();
	
	TestEntity getOne(Long id);

	void insert(TestEntity user);

	void update(TestEntity user);

	void delete(Long id);
	
	void update2(TestEntity user);
}
