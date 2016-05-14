package com.hebin.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.hebin.dao.UserDao;
import com.hebin.entity.User;

/**
 * @author created by hebin
 * @date 2016年5月13日---上午10:45:35
 * @problem
 * @answer
 * @action
 */
public class UserDaoImpl extends BaseDao implements UserDao {

	/**添加用户，注册
	 *  (non-Javadoc)
	 * @see com.hebin.dao.UserDao#saveUser(com.hebin.entity.User)
	 */
	@Override
	public boolean saveUser(User user) {
		String sql = "insert into user (username,password,email,sex,age,type) values (?,?,?,?,?,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(user.getUsername());
		params.add(user.getPassword());
		params.add(user.getEmail());
		params.add(user.getSex());
		params.add(user.getAge());
		params.add(user.getType());
		return this.operUpdate(sql, params);
	}

	/**用户修改个人信息
	 * 
	 *  (non-Javadoc)
	 * @see com.hebin.dao.UserDao#updateUser(com.hebin.entity.User)
	 */
	@Override
	public boolean updateUser(User user) {
		String sql = "update user set username = ?,password = ?,email = ?,sex = ?,age = ? where uid = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(user.getUsername());
		params.add(user.getPassword());
		params.add(user.getEmail());
		params.add(user.getSex());
		params.add(user.getAge());
		params.add(user.getUid());
		return this.operUpdate(sql, params);
	}

	/**
	 * 查询用户信息 (non-Javadoc)
	 * 
	 * @see com.hebin.dao.UserDao#queryUser(com.hebin.entity.User)
	 */
	@Override
	public User queryUser(User user) {
		List<User> uList = null;
		String sql = "select uid,username,password,email,sex,age,type from user where username = ? and password = ? and email = ? and sex = ? and age = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(user.getUid());
		params.add(user.getUsername());
		params.add(user.getPassword());
		params.add(user.getEmail());
		params.add(user.getSex());
		params.add(user.getAge());
		params.add(user.getType());
		try {
			uList = this.operQuery(sql, params, User.class);
		} catch (Exception e) {
			e.printStackTrace();
		}if (uList.size() > 0){
			return uList.get(0);
		}
		return null;
	}

	/**检查用户登录
	 *  (non-Javadoc)
	 * @see com.hebin.dao.UserDao#checkUser(java.lang.String, java.lang.String)
	 */
	@Override
	public User checkUser(String username, String password) {
		List<User> uList = null;
		String sql = "select username ,password from user where username = ? and password = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(username);
		params.add(password);
		try {
			uList = this.operQuery(sql, params, User.class);
		} catch (Exception e) {
			e.printStackTrace();
		}if (uList.size() > 0){
			return uList.get(0);
		}
		return null;
	}

	
}
