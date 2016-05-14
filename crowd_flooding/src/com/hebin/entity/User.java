package com.hebin.entity;

/**
 * @author created by hebin
 * @date 2016年5月13日---上午10:00:16
 * @problem
 * @answer
 * @action User实体类
 */
public class User {

	private int uid;/// 用户id
	private String username;/// 用户名
	private String password;/// 用户密码
	private String email;/// 邮箱
	private String sex;//// 性别
	private int age;/// 年龄
	private int type;//// 区分普通用户和特权用户

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public User(int uid, String username, String password, String email, String sex, int age,
			int type) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.email = email;
		this.sex = sex;
		this.age = age;
		this.type = type;
	}

	public User(String username, String password, String email, String sex, int age, int type) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.sex = sex;
		this.age = age;
		this.type = type;
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

}
