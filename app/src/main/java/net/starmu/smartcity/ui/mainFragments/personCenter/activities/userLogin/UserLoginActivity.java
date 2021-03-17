package net.starmu.smartcity.ui.mainFragments.personCenter.activities.userLogin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import net.starmu.smartcity.MyApplication;
import net.starmu.smartcity.R;
import net.starmu.smartcity.base.BaseActivity;
import net.starmu.smartcity.utils.HttpCallBack;
import net.starmu.smartcity.utils.HttpUtils;

import java.util.HashMap;
import java.util.Map;

public class UserLoginActivity extends BaseActivity {

    private EditText edtUsername;
    private EditText edtPassword;
    private Button btnLogin;

    @Override
    protected int getLayout() {
        return R.layout.activity_user_login;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initToolbar("请登录", true);
        initView();
        initEvent();
    }

    private void initEvent() {
        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Map<String,Object> date = new HashMap<>();
                date.put("username",edtUsername.getText().toString().trim());
                date.put("password",edtPassword.getText().toString().trim());
                HttpUtils.doPost(date, "/login", new HttpCallBack() {
                    @Override
                    public void onSuccess(String json) {
                        MyApplication.showToast("登录成功！");
                    }

                    @Override
                    public void onError(String error) {

                    }
                });
            }
        });
    }

    private void initView() {
        edtUsername = (EditText) findViewById(R.id.edt_username);
        edtPassword = (EditText) findViewById(R.id.edt_password);
        btnLogin = (Button) findViewById(R.id.btn_login);
    }
}