package com.hebin.dao;

import com.hebin.entity.User;

/**
 * @author created by hebin
 * @date 2016年5月13日---上午10:27:42
 * @problem
 * @answer
 * @action 数据访问层接口
 */
public interface UserDao {

	public boolean saveUser(User user);//// 添加用户

	public boolean updateUser(User user);/// 更新用户

	public User queryUser(User user);//// 查询用户信息
	
	public User checkUser(String username, String password);////判断用户是否存在

}
