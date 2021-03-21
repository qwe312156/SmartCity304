package net.starmu.smartcity.ui.mainFragments.personCenter;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import net.starmu.smartcity.MyApplication;
import net.starmu.smartcity.R;
import net.starmu.smartcity.base.BaseFragment;
import net.starmu.smartcity.bean.UserInfoBean;
import net.starmu.smartcity.ui.mainFragments.personCenter.activities.userInfo.UserInfoActivity;
import net.starmu.smartcity.ui.mainFragments.personCenter.activities.userLogin.UserLoginActivity;
import net.starmu.smartcity.utils.HttpCallBack;
import net.starmu.smartcity.utils.HttpUtils;


public class PersonCenterFragment extends BaseFragment {

    private ImageView personImageUserIco;
    private Button btnUserInfo;
    private Button btnOrderList;
    private Button btnChangePass;
    private Button btnOpinion;
    private TextView tvUsername;

    @Override
    protected int getLayout() {
        return R.layout.fragment_person_center;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initToolbar("个人中心", false);
        initView(view);
        initData();
        initEvent();
        super.onViewCreated(view, savedInstanceState);
    }

    private void initData() {
        if (!MyApplication.getToken().equals("")) {
            HttpUtils.doGet("/getInfo", new HttpCallBack() {
                @Override
                public void onSuccess(String json) {
                    Log.d("TAG", "onSuccess: ----> JSON\n" + json);
                    UserInfoBean userInfoBean = MyApplication.getGson().fromJson(json, UserInfoBean.class);
                    MyApplication.setUserInfo(userInfoBean);
                    String userIcoUrl = MyApplication.getMyUrl() + userInfoBean.getUser().getAvatar();
                    String username = userInfoBean.getUser().getNickName();
                    Log.d("TAG", "onSuccess: " + userIcoUrl + "  " + username);

                    getActivity().runOnUiThread(()->{
                        Glide.with(getContext()).load(userIcoUrl).into(personImageUserIco);
                        tvUsername.setText(username);
                    });

                }

                @Override
                public void onError(String error) {
                    Log.d("TAG", "onError: " + error);
                }
            });
        }
    }

    private void initView(View view) {
        personImageUserIco = (ImageView) view.findViewById(R.id.person_image_userIco);
        btnUserInfo = (Button) view.findViewById(R.id.btn_userInfo);
        btnOrderList = (Button) view.findViewById(R.id.btn_orderList);
        btnChangePass = (Button) view.findViewById(R.id.btn_changePass);
        btnOpinion = (Button) view.findViewById(R.id.btn_opinion);
        tvUsername = (TextView) view.findViewById(R.id.tv_username);
    }

    private void initEvent() {
        personImageUserIco.setOnClickListener(new PersonCenterClick());
        btnUserInfo.setOnClickListener(new PersonCenterClick());
        btnOrderList.setOnClickListener(new PersonCenterClick());
        btnChangePass.setOnClickListener(new PersonCenterClick());
        btnOpinion.setOnClickListener(new PersonCenterClick());
    }

    public class PersonCenterClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.person_image_userIco:
                    startActivityForResult(new Intent(getContext(), UserLoginActivity.class), 0);
                    break;
                case R.id.btn_userInfo:
                    if (!TextUtils.isEmpty(MyApplication.getToken())){
                        startActivity(new Intent(getContext(), UserInfoActivity.class));
                    }else {
                        MyApplication.showToast("用户未登录！");
                    }
                    break;
                case R.id.btn_orderList:
                    break;
                case R.id.btn_changePass:
                    break;
                case R.id.btn_opinion:
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode) {
            case 0:
                initData();
                Log.d("TAG", "onActivityResult: 回来了");
                break;
        }
    }
}