package net.starmu.smartcity.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerAdapter;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;

import net.starmu.smartcity.MyApplication;
import net.starmu.smartcity.R;
import net.starmu.smartcity.utils.HttpCallBack;
import net.starmu.smartcity.utils.HttpUtils;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private Toolbar toolbar;
    private TextView title;
    List<String> imgs;
    private RecyclerView recservice;
    Banner banner;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        bindview(root);
        initview(root);

        return root;
    }

    private void initview(View root) {
        imgs=new ArrayList<>();
        HttpUtils.doGet("/userinfo/rotation/list?type=45", new HttpCallBack() {
            @Override
            public void onSuccess(String json) {
                for (int i = 0; i <MyApplication.getGson().fromJson(json,BannerBean.class).getTotal() ; i++) {
                   imgs.add(MyApplication.getGson().fromJson(json,BannerBean.class).getRows().get(i).getImgUrl());
                }

            }

            @Override
            public void onError(String error) {

            }
        });

        banner.setAdapter(new BannerImageAdapter<String>(imgs) {
            @Override
            public void onBindView(BannerImageHolder bannerImageHolder, String s, int i, int i1) {
             Glide.with(getContext()).load(imgs).into(bannerImageHolder.imageView);
            }


        });
        banner.setBannerRound(20);
        banner.setIndicator(new CircleIndicator(getActivity()));
        banner.setBannerGalleryEffect(0,20);
    }

    private void bindview(View root) {


        toolbar =root. findViewById(R.id.toolbar);
        title = root.findViewById(R.id.title);
        banner = root.findViewById(R.id.banner);
        recservice =root. findViewById(R.id.recservice);

    }

}