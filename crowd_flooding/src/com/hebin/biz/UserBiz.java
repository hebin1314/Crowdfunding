package com.hebin.biz;

import com.hebin.entity.User;

/**
*@author   created by hebin 
*@date     2016年5月13日---上午11:19:06
*@problem     
*@answer 
*@action   
*/
public interface UserBiz {

	public User login(String username, String password);///用户登录
	
	public int registerUser(User user);///注册用户
	
}
