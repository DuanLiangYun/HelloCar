package com.zx.hellocar.entity;

public class User {
	/**
	 * id 用户编号
	 * name 用户名
	 * password 密码
	 * sex 性别
	 * in_number 身份证号码
	 * tel 电话
	 * address 地址
	 * type 账户类型（是否管理员）
	 */
	private int id;
	private String username;
	private String password;
	private String sex;
	private String id_number;
	private String tel;
	private String address;
	private int type;
	public User(int id, String username, String password, String sex, String id_number, String tel, String address,
                int type) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.id_number = id_number;
		this.tel = tel;
		this.address = address;
		this.type = type;
	}
	public User() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return username;
	}
	public void setName(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getId_number() {
		return id_number;
	}
	public void setId_number(String id_number) {
		this.id_number = id_number;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", sex=" + sex + ", id_number="
				+ id_number + ", tel=" + tel + ", address=" + address + ", type=" + type + "]";
	}
	
	
}// end of class User
