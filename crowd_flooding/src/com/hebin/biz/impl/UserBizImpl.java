package com.hebin.biz.impl;

import com.hebin.biz.UserBiz;
import com.hebin.dao.UserDao;
import com.hebin.dao.impl.UserDaoImpl;
import com.hebin.entity.User;

/**
 * @author created by hebin
 * @date 2016年5月13日---上午11:20:55
 * @problem
 * @answer
 * @action
 */
public class UserBizImpl implements UserBiz {

	private UserDao userDao = null;

	public UserBizImpl() {
		userDao = new UserDaoImpl();
	}

	@Override
	public User login(String username, String password) {
		return userDao.checkUser(username,password);
	}

	@Override
	public int registerUser(User user) {
		if (userDao.queryUser(user) != null) {
			return 1;//// 此用户名已经存在
		} else {
			boolean res = userDao.saveUser(user);
			if (res) {
				return 2;/// 注册成功
			} else {
				return 3;//// 注册失败
			}
		}
	}
}
