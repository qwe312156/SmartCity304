package net.starmu.smartcity.ui.mainFragments.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
<<<<<<< HEAD:app/src/main/java/net/starmu/smartcity/ui/home/HomeFragment.java
import androidx.recyclerview.widget.GridLayoutManager;
=======
>>>>>>> 136e4a9d6b40e38fa80146d8fabafa83b10b0383:app/src/main/java/net/starmu/smartcity/ui/mainFragments/home/HomeFragment.java
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;

import net.starmu.smartcity.MyApplication;
import net.starmu.smartcity.R;
<<<<<<< HEAD:app/src/main/java/net/starmu/smartcity/ui/home/HomeFragment.java
import net.starmu.smartcity.ui.home.Activity.ParkCarActivity.ParkCarActivity;
=======
import net.starmu.smartcity.bean.BannerBean;
>>>>>>> 136e4a9d6b40e38fa80146d8fabafa83b10b0383:app/src/main/java/net/starmu/smartcity/ui/mainFragments/home/HomeFragment.java
import net.starmu.smartcity.utils.HttpCallBack;
import net.starmu.smartcity.utils.HttpUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomeFragment extends Fragment {
    private Toolbar toolbar;
    private TextView title;

    private RecyclerView recservice;
    Banner banner;
    private List<String> imgs;
    private List<String> itemimgs;
    private List<String> itemtxt;
    private BannerBean looperBean;
    RecyAdapter adapter;
    private GridLayoutManager layoutManager;
    private RecyBean recyBean;
    private HashMap<String, Object> clickMap;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        bindview(root);
        initview(root);

        return root;
    }

    private void initview(View root) {
               imgs = new ArrayList<>();
//Banner
        HttpUtils.doGet("/userinfo/rotation/list?type=45", new HttpCallBack() {
            @Override
            public void onSuccess(String json) {
<<<<<<< HEAD:app/src/main/java/net/starmu/smartcity/ui/home/HomeFragment.java
                looperBean = MyApplication.getGson().fromJson(json,BannerBean.class);
                for (int i = 0; i <looperBean.getTotal() ; i++) {
                    imgs.add(MyApplication.getMyUrl()+looperBean.getRows().get(i).getImgUrl());
=======
                for (int i = 0; i <MyApplication.getGson().fromJson(json, BannerBean.class).getTotal() ; i++) {
                   imgs.add(MyApplication.getGson().fromJson(json,BannerBean.class).getRows().get(i).getImgUrl());
>>>>>>> 136e4a9d6b40e38fa80146d8fabafa83b10b0383:app/src/main/java/net/starmu/smartcity/ui/mainFragments/home/HomeFragment.java
                }
                root.post(new Runnable() {
                    @Override
                    public void run() {
                        banner.setAdapter(new BannerImageAdapter<String>(imgs) {
                            @Override
                            public void onBindView(BannerImageHolder bannerImageHolder, String s, int i, int i1) {
                                Glide.with(getContext()).load(imgs.get(i)).into(bannerImageHolder.imageView);//这里的img.get（i） 一定要写get（i）
                            }
                        });
                        banner.setBannerRound(30);
                        banner.setIndicator(new CircleIndicator(getActivity()));
                        banner.setBannerGalleryEffect(0,20);
                    }
                });
            }
            @Override
            public void onError(String error) {
            }
        });
//Recyview
        itemimgs=new ArrayList<>();
        itemtxt=new ArrayList<>();
        clickMap = new HashMap<>();
        HttpUtils.doGet("/service/service/list?pageNum=1&pageSize=10", new HttpCallBack() {
            @Override
            public void onSuccess(String json) {
                recyBean = MyApplication.getGson().fromJson(json,RecyBean.class);
                for (int i = 0; i <    recyBean.getTotal(); i++) {
                    itemimgs.add(MyApplication.getMyUrl()+recyBean.getRows().get(i).getImgUrl());       //每次我都忘记加前面的MyUrl了
                    itemtxt.add(recyBean.getRows().get(i).getServiceName());
                    clickMap.put("城市地铁",ParkCarActivity.class);    // TODO: 2021/3/20 这边是以后要加的跳转
                    MyApplication.setClickmap(clickMap);
                }
                root.post(new Runnable() {                  //setadapter之类的必须写到doGet里，用post才能读到img等数组数据
                    @Override
                    public void run() {
                        adapter=new RecyAdapter(itemimgs,itemtxt);
                        recservice.setAdapter(adapter);
                        layoutManager = new GridLayoutManager(getContext(),2);
                        recservice.setLayoutManager(layoutManager);
                        adapter.setItemClick(new RecyAdapter.ItemClick() {
                            @Override
                            public void setvoid(int pos,String title) {
                                Log.i("1", "setvoid: "+pos);

                                for (String key:MyApplication.getClickmap().keySet()) {
                                if(title.equals(key)){
                                    startActivity(new Intent(MyApplication.getContext(), (Class<?>) MyApplication.getClickmap().get(title)));
                                }else {
                                    MyApplication.showToast("错误");
                                }
                                }

                            }
                        });
                    }
                });
            }

            @Override
            public void onError(String error) {

            }
        });




    }

    private void bindview(View root) {
        toolbar =root. findViewById(R.id.toolbar);
        title = root.findViewById(R.id.title);
        banner = root.findViewById(R.id.banner);
        recservice =root. findViewById(R.id.recservice);

    }
    static class RecyAdapter extends RecyclerView.Adapter<RecyAdapter.MyHolder>{
        private View inflat;
        private List<String> itemimgs;
        private List<String> itemtxt;

        public RecyAdapter(List<String> itemimgs, List<String> itemtxt) {
            this.itemimgs=itemimgs;
            this.itemtxt=itemtxt;
        }

        @NonNull
        @Override
        public RecyAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            inflat= LayoutInflater.from(MyApplication.getContext()).inflate(R.layout.item_recy,parent,false);
            return new MyHolder(inflat);
        }
        interface ItemClick{
            void setvoid(int pos,String title);
        }
        ItemClick itemClick;
        void setItemClick(ItemClick itemClick){
            this.itemClick=itemClick;
        }
        @Override
        public void onBindViewHolder(@NonNull MyHolder holder, int position) {

            Glide.with(MyApplication.getContext()).load(itemimgs.get(position)).into(holder.itemImg);
            holder.itemTxt.setText(itemtxt.get(position));
            holder.itemImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
            itemClick.setvoid(position,itemtxt.get(position));
                }
            });
        }

        @Override
        public int getItemCount() {
            return itemimgs.size();
        }

        class MyHolder extends RecyclerView.ViewHolder {
            private ImageView itemImg;
            private TextView itemTxt;


            public MyHolder(@NonNull View itemView) {
                super(itemView);
                itemImg = itemView.findViewById(R.id.item_img);
                itemTxt = itemView.findViewById(R.id.item_txt);

            }
        }
    }

}