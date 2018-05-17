package net.togogo.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.mysql.jdbc.log.LogFactory;

import net.togogo.mybatis.entity.Admin;
import net.togogo.mybatis.mapper.AdminMapper;

import net.togogo.mybatis.page.Page;

public class AdminTest {
	
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
	public void list(){
		SqlSession session= factory.openSession();
		AdminMapper mapper= session.getMapper(AdminMapper.class);
		Admin user= new Admin();
//		user.setAdminname("张三");
		List<Admin> admins=mapper.list(user);
		for (Admin admin : admins) {
			System.out.println(admin);
		}
		session.close();
	}
	@Test
	public void list2(){
		SqlSession session= factory.openSession();
		AdminMapper mapper= session.getMapper(AdminMapper.class);
		Admin user= new Admin();
		user.setAdminname("王五");
		List<Admin> admins=mapper.list(user);
		for (Admin admin : admins) {
			System.out.println(admin);
		}
		session.close();
	}
	
}
