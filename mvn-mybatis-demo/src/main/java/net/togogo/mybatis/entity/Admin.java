package net.togogo.mybatis.entity;

import java.util.Date;

public class Admin {
	private int id;
	private String adminname;
	private String password;
	private String role;
	private Date createtime;
	public Admin(int id, String adminname, String password, String role, Date createtime) {
		super();
		this.id = id;
		this.adminname = adminname;
		this.password = password;
		this.role = role;
		this.createtime = createtime;
	}
	public Admin() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", adminname=" + adminname + ", password=" + password + ", role=" + role
				+ ", createtime=" + createtime + "]";
	}
	
	
}
