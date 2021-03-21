package net.starmu.smartcity.ui.mainFragments.personCenter.activities.userInfo;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import net.starmu.smartcity.MyApplication;
import net.starmu.smartcity.R;
import net.starmu.smartcity.base.BaseActivity;

public class UserInfoActivity extends BaseActivity {

    private ImageView imgUserIco;
    private EditText userNikeName;
    private EditText userId;
    private EditText userIdCard;
    private EditText userEmail;
    private EditText userPhone;
    private EditText userSex;

    @Override
    protected int getLayout() {
        return R.layout.activity_user_info;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initToolbar("个人信息", true);
        initView();
        initEvent();
    }

    private void initEvent() {
        userNikeName.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                MyApplication.showToast("获取焦点");
                return false;
            }
        });
    }

    private void initView() {
        imgUserIco = (ImageView) findViewById(R.id.img_userIco);
        userNikeName = (EditText) findViewById(R.id.user_nikeName);
        userId = (EditText) findViewById(R.id.user_id);
        userIdCard = (EditText) findViewById(R.id.user_idCard);
        userEmail = (EditText) findViewById(R.id.user_email);
        userPhone = (EditText) findViewById(R.id.user_phone);
        userSex = (EditText) findViewById(R.id.user_sex);
    }
}