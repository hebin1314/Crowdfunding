package test;

import com.hebin.biz.impl.UserBizImpl;
import com.hebin.dao.UserDao;
import com.hebin.dao.impl.BaseDao;
import com.hebin.dao.impl.UserDaoImpl;
import com.hebin.entity.User;

import android.test.AndroidTestCase;

/**
*@author   created by hebin 
*@date     2016年5月13日---上午11:13:26
*@problem     
*@answer 
*@action   
*/
public class MyTest extends AndroidTestCase{
	public MyTest() {
		new BaseDao();
	}

	public void insert(){
		UserDaoImpl daoImpl = new UserDaoImpl();
		UserBizImpl bizImpl = new UserBizImpl();
		User user = new User("123", "123");
		bizImpl.login("123", "123");
	}
	
	
	
}
