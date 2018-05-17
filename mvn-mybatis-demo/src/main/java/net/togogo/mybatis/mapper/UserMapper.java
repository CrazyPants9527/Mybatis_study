package net.togogo.mybatis.mapper;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import net.togogo.mybatis.entity.User;
import net.togogo.mybatis.page.Page;
public interface UserMapper {
	/**
	 * 
	 * 插入对象
	 * param user
	 */
	public void insert (User user);
	
	/**
	 * 查询对象
	 * @param user
	 * @return 
	 */
	public User get(int id);
	
	/**
	 * 
	 * @param user
	 */
	public void update(User user);
	
	/**
	 * 删除对象
	 * @param id
	 */
	public void deleteById(int id);
	
	/**
	 * 批量删除对象
	 * @param id
	 */
	public void deleteByIds(int[] ids);
	
	/**
	 * 批量删除List对象
	 * @param ids
	 */
	public void deleteByListIds(List<Integer> ids);
	
	/**
	 * 查询所有对象
	 * @return
	 */
	public List<User> getAll();
	
	/**
	 * 根据条件查询
	 */
	public List<User> getUser(Properties pro);
	
	/**
	 * 分页查询
	 */
	public List<User> getByPage(Page page);

	/**
	 * 投影查询
	 */
	public List<Map<String,Object>> getByCols();
	
	
}
