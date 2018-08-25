package com.gnete.springboot.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gnete.springboot.demo.entity.TestEntity;
import com.gnete.springboot.demo.mapper.TestMapper;
import com.gnete.springboot.demo.service.DemoService;

@Service(value = "demoService")
public class DemoServiceImpl implements DemoService {

	@Autowired
	private TestMapper testMapper;

	@Override
	public TestEntity getTestEntityById(long id) {
		TestEntity entity = testMapper.getOne(id);
		return entity;
	}

	@Override
	public List<TestEntity> getTestEntity() {
		List<TestEntity> entities = testMapper.getAll();
		return entities;
	}

	/* (non-Javadoc)
	 * @see com.gnete.springboot.demo.service.DemoService#addTestEntity(com.gnete.springboot.demo.entity.TestEntity)
	 * 
	 * propagation:传播行为。
	 * 		Propagation.REQUIRED=表示当前方法必须运行在事务中。如果当前事务存在，方法将会在该事务中运行。否则，会启动一个新的事务
	 * 		PROPAGATION_SUPPORTS=表示当前方法不需要事务上下文，但是如果存在当前事务的话，那么该方法会在这个事务中运行
	 * 		PROPAGATION_MANDATORY=表示该方法必须在事务中运行，如果当前事务不存在，则会抛出一个异常
	 * 		还有其他类型，参考文档查看
	 * isolation：隔离级别。隔离级别定义了一个事务可能受其他并发事务影响的程度
	 * 		ISOLATION_DEFAULT=使用后端数据库默认的隔离级别
	 * 		ISOLATION_READ_UNCOMMITTED=最低的隔离级别，允许读取尚未提交的数据变更，可能会导致脏读、幻读或不可重复读
	 * 		ISOLATION_READ_COMMITTED=允许读取并发事务已经提交的数据，可以阻止脏读，但是幻读或不可重复读仍有可能发生
	 * 		ISOLATION_REPEATABLE_READ=对同一字段的多次读取结果都是一致的，除非数据是被本身事务自己所修改，可以阻止脏读和不可重复读，但幻读仍有可能发生
	 * 		ISOLATION_SERIALIZABLE=最高的隔离级别，完全服从ACID的隔离级别，确保阻止脏读、不可重复读以及幻读，也是最慢的事务隔离级别，因为它通常是通过完全锁定事务相关的数据库表来实现的
	 * timeout：超时回滚：如果用这个注解描述一个方法的话，线程已经跑到方法里面，
	 * 			如果已经过去60秒了还没跑完这个方法并且线程在这个方法中的后面还有涉及到对数据库的增删改查操作时会报事务超时错误（会回滚）。
	 * 			如果已经过去60秒了还没跑完但是后面已经没有涉及到对数据库的增删改查操作，那么这时不会报事务超时错误（不会回滚）。
	 * rollbackFor：回滚条件，如果不加rollbackFor = Exception.class，抛出new Exception是不会回滚
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
	public void addTestEntity(TestEntity entity) throws Exception {
		testMapper.insert(entity);
		throw new Exception("测试事物回滚");
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public void updatTestEntity(int age, int id, int sleep) {
		TestEntity entity = new TestEntity();
		entity.setAge(age);
		entity.setId(id);
		testMapper.update2(entity);
		try {
			Thread.sleep(sleep);
		} catch (InterruptedException e) {
		}
	}

}
