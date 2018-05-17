package net.togogo.mybatis.mapper;

import java.util.List;

import net.togogo.mybatis.entity.Admin;

public interface AdminMapper {
	
	public List<Admin> list(Admin admin);
	public List<Admin> list2(Admin admin);
}
