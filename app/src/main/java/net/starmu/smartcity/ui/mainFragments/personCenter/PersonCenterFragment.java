package net.starmu.smartcity.ui.mainFragments.personCenter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import net.starmu.smartcity.R;
import net.starmu.smartcity.base.BaseFragment;
import net.starmu.smartcity.ui.mainFragments.personCenter.activities.userLogin.UserLoginActivity;


public class PersonCenterFragment extends BaseFragment {

    private ImageView personImageUserIco;
    private Button btnUserInfo;
    private Button btnOrderList;
    private Button btnChangePass;
    private Button btnOpinion;

    @Override
    protected int getLayout() {
        return R.layout.fragment_person_center;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initToolbar("个人中心", false);
        initView(view);
        initEvent();
        super.onViewCreated(view, savedInstanceState);
    }

    private void initView(View view) {
        personImageUserIco = (ImageView) view.findViewById(R.id.person_image_userIco);
        btnUserInfo = (Button) view.findViewById(R.id.btn_userInfo);
        btnOrderList = (Button) view.findViewById(R.id.btn_orderList);
        btnChangePass = (Button) view.findViewById(R.id.btn_changePass);
        btnOpinion = (Button) view.findViewById(R.id.btn_opinion);
    }

    private void initEvent() {
        personImageUserIco.setOnClickListener(new PersonCenterClick());
        btnUserInfo.setOnClickListener(new PersonCenterClick());
        btnOrderList.setOnClickListener(new PersonCenterClick());
        btnChangePass.setOnClickListener(new PersonCenterClick());
        btnOpinion.setOnClickListener(new PersonCenterClick());
    }

    public class PersonCenterClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.person_image_userIco:
                    startActivity(new Intent(getContext(), UserLoginActivity.class));
                    break;
                case R.id.btn_userInfo:
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
}