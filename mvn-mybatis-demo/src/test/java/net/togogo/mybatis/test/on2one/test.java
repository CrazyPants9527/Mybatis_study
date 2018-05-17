package net.togogo.mybatis.test.on2one;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import net.togogo.mybatis.entity.Admin;
import net.togogo.mybatis.entity.one2one.Card;
import net.togogo.mybatis.mapper.AdminMapper;
import net.togogo.mybatis.mapper.one2one.PersonCardMapper;
import net.togogo.mybatis.test.UserTest;

public class test {
	private SqlSessionFactory factory;
	private Logger logger = Logger.getLogger(UserTest.class);
	
	@Before
	public void init(){		
		try {
			//加载数据源文件
			InputStream in = Resources.getResourceAsStream("Mybatis-config.xml");
			//
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			
			factory= builder.build(in);
			org.apache.ibatis.logging.LogFactory.useLog4JLogging();
			logger.info("mybatis加载成功......");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("mybatis加载失败....."+e.getMessage());
			e.printStackTrace();
		}
		
	}
	@Test
	public void testGetById(){
		SqlSession session= factory.openSession();
		PersonCardMapper mapper= session.getMapper(PersonCardMapper.class);
		Card card= mapper.getById(10);
		System.out.println(card);
		session.close();
	}
}
