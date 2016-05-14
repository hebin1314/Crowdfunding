package com.hebin.crowd_flooding.atys;

import com.hebin.biz.impl.UserBizImpl;
import com.hebin.crowd_flooding.MainActivity;
import com.hebin.crowd_flooding.R;
import com.hebin.entity.User;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

/**
 * @author created by hebin
 * @date 2016年5月13日---下午12:34:32
 * @problem
 * @answer
 * @action
 */
public class AtyRegister extends Activity {

	private EditText et_username;
	private EditText et_password;
	private EditText et_email;
	private EditText et_age;
	private RadioGroup group;
	private Button btn_submit;
	private String et_sex;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.aty_register);
		et_username = (EditText) findViewById(R.id.et_register_username);
		et_password = (EditText) findViewById(R.id.et_register_password);
		et_email = (EditText) findViewById(R.id.et_register_email);
		et_age = (EditText) findViewById(R.id.et_register_age);
		group = (RadioGroup) findViewById(R.id.radiogroup);
		group.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				int radioButtonId = group.getCheckedRadioButtonId();
				RadioButton radiobutton = (RadioButton) AtyRegister.this
						.findViewById(radioButtonId);
				String et_sex = (String) radiobutton.getText();
			}
		});
		btn_submit = (Button) findViewById(R.id.btn_submit);
		btn_submit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				/// 获取用户注册的信息
				String username = et_username.getText().toString();
				String password = et_password.getText().toString();
				String email = et_email.getText().toString();
				String age1 = et_age.getText().toString();
				int age = Integer.parseInt(age1);
				String sex = et_sex;
				int type = 1;/// 区分特权，暂时不用
				User user = new User(username, password, email, sex, age, type);
				UserBizImpl userBizImpl = new UserBizImpl();
				int a = userBizImpl.registerUser(user);
				if (a == 1) {
					Toast.makeText(AtyRegister.this, "用户名已经存在", Toast.LENGTH_SHORT).show();
					return;
				}
				if (a == 2) {
					Toast.makeText(AtyRegister.this, "注册成功", Toast.LENGTH_SHORT).show();
					Intent i = new Intent(AtyRegister.this, MainActivity.class);
					startActivity(i);
				}
				if (a == 3) {
					Toast.makeText(AtyRegister.this, "注册失败，请重试", Toast.LENGTH_SHORT).show();
					return;
				}
			}
		});
	}

}
