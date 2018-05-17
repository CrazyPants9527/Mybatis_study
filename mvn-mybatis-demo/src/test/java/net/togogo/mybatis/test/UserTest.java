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

import net.togogo.mybatis.entity.User;
import net.togogo.mybatis.mapper.UserMapper;
import net.togogo.mybatis.page.Page;

public class UserTest {
	
	private SqlSessionFactory factory;
	private Logger logger = Logger.getLogger(UserTest.class);
	
	@Before
	public void init(){		
		try {
			InputStream in = Resources.getResourceAsStream("Mybatis-config.xml");
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
	/**
	 * 用接口名找到映射文件，增加用户
	 */
	@Test
	public void insert(){
		
			
			SqlSession seesion = factory.openSession();

			User user = new User();
			user.setUsername("第二十者");
			user.setPassword("101010");
			user.setRole("admin");
			user.setCreatetime(new Date());
			UserMapper usermapper= seesion.getMapper(UserMapper.class);
			usermapper.insert(user);
			seesion.commit();
			seesion.close();
			
	}
	/**
	 * 直接用详细类名定位映射文件，增加用户
	 */
	@Test
	public void insertUser(){
		
			SqlSession session = factory.openSession();
			
			
			User user=new User();
			user.setUsername("张三");
			user.setPassword("123456");
			user.setRole("admin");
			user.setCreatetime(new Date());
			session.insert("net.togogo.mybatis.mapper.UserMapper.insert", user);
			session.commit();
			session.close();
			
		
	}
	/**
	 * 用接口名找到映射文件，查询ID为2的用户
	 */
	@Test
	public void testgetById(){
		SqlSession session =factory.openSession();
		UserMapper usermapper= session.getMapper(UserMapper.class);
		User user = usermapper.get(1);
		System.out.println(user);
		session.commit();
		session.close();
	}


	/**
	 * 查詢表的所有用戶所有信息
	 */
	@Test
	public void testgetAll(){
		SqlSession session = factory.openSession();
		UserMapper usermapper =session.getMapper(UserMapper.class);
		List<User> users=usermapper.getAll();
		for (User user : users) {
			System.out.println(user);
		}
		session.close();
	}
	/**
	 * 根據Id刪除用戶
	 */
	@Test
	public void testdelete(){
	SqlSession session = factory.openSession();
	UserMapper user= session.getMapper(UserMapper.class);
	user.deleteById(44);
	session.commit();
	session.close();
	}
	/**
	 * 输入用戶ID，批量删除用户
	 */
	@Test
	public void testdeletes(){
	SqlSession session = factory.openSession();
	UserMapper usermapper= session.getMapper(UserMapper.class);
	usermapper.deleteByIds(new int[]{10,11});
	session.commit();
	session.close();
	}
	/**
	 * 批量删除List用户
	 */
	@Test
	public void testdeleteByListIds(){
	SqlSession session = factory.openSession();
	UserMapper usermapper= session.getMapper(UserMapper.class);
	List<Integer> ids = new ArrayList<Integer>();
	ids.add(8);
	ids.add(9);
	usermapper.deleteByListIds(ids);
	session.commit();
	session.close();
	}
	
	/**
	 * 更改用户信息
	 */
	@Test
	public void testupdate(){
	SqlSession session = factory.openSession();
	UserMapper usermapper= session.getMapper(UserMapper.class);
	User user=usermapper.get(1);
	System.out.println(user);
	user.setUsername("李大爺");
	user.setPassword("togogo");
	user.setRole("USER");
	usermapper.update(user);
	System.out.println(user);
	session.commit();
	session.close();
}
	/**
	 * 更改用户信息
	 */
	@Test
	public void testSessionOne(){
	SqlSession session = factory.openSession();
	User user= session.selectOne("net.togogo.mybatis.mapper.UserMapper.get", 1);
	user.setUsername("李大爷");
	user.setPassword("togogo");
	user.setRole("root");
	session.update("net.togogo.mybatis.mapper.UserMapper.update", user);
	session.commit();
	session.close();
}
	
	/**
	 * 根据条件查询
	 */
	@Test
	public void testgetuser(){
		SqlSession session = factory.openSession();
		UserMapper usermapper = session.getMapper(UserMapper.class);
		Properties pro = new Properties();
		pro.put("username", "李四");
		pro.put("role", "admin");
		List<User> users = usermapper.getUser(pro);
		for (User user : users) {
			System.out.println(user);
		}
		session.close();
	}
	
	/**
	 * 分页查询
	 */
	@Test
	public void testgetByPage(){
		SqlSession session = factory.openSession();
		UserMapper usermapper = session.getMapper(UserMapper.class);
		//从1开始  3个  
		List<User> users = usermapper.getByPage(new Page(1,3,8));
		for (User user : users) {
			System.out.println(user);
		}
		session.close();
	}
	
	/**
	 * 投影查询
	 */
	@Test
	public void testgetBycols(){
		SqlSession session = factory.openSession();
		UserMapper usermapper = session.getMapper(UserMapper.class);
		List<Map<String,Object>> users= usermapper.getByCols();
		for (Map<String, Object> user : users) {
			System.out.println(user);
		}
		session.close();
	}
	
	/**
	 * ********************SQL动态查询********************************
	 */
	
	/**
	 * if语句Test1 
	 */
	
	
}
