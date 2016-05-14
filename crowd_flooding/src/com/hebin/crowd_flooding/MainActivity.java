package com.hebin.crowd_flooding;

import com.hebin.biz.impl.UserBizImpl;
import com.hebin.crowd_flooding.atys.AtyRegister;
import com.hebin.crowd_flooding.atys.AtyTimeline;
import com.hebin.entity.User;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText et_username;
	private EditText et_password;
	private Button btn_login;
	private Button btn_register;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		et_username = (EditText) findViewById(R.id.et_username);
		et_password = (EditText) findViewById(R.id.et_password);
		btn_login = (Button) findViewById(R.id.btn_login);
		btn_register = (Button) findViewById(R.id.btn_register);

		btn_login.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (TextUtils.isEmpty(et_username.getText())||TextUtils.isEmpty(et_password.getText())) {
					Toast.makeText(MainActivity.this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
					return;
				}else {
					String username = et_username.getText().toString();
					String password = et_password.getText().toString();
					User user = new User(username, password);
					user = new UserBizImpl().login(username,password);
					if (user != null){
						Intent i = new Intent(MainActivity.this,AtyTimeline.class);
						startActivity(i);
					}else{
						Toast.makeText(MainActivity.this, "用户不存在，请注册后登陆", Toast.LENGTH_SHORT).show();
						return;
					}
				}
			}
		});
		
		btn_register.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MainActivity.this,AtyRegister.class);
				startActivity(i);
				
			}
		});
	}

}
