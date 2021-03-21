package net.starmu.smartcity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import net.starmu.smartcity.utils.HttpCallBack;
import net.starmu.smartcity.utils.HttpUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Luncher extends AppCompatActivity {
    private ViewPager luncherViewpager;
    private RadioGroup radiogroup;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;
    private RadioButton radioButton5;
    private TextView ipsetting;
    private Button login;
    ViewAdapter adapter;
    List<Integer> imgs;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    private String isfirst;
    Dialog dialog;
    private TextView textView;
    private TextView textView2;
    private TextView textView3;
    private EditText ipdress;
    private EditText portress;
    private Button button;
    private Map<String, Object> testaccount;
    private View inflate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luncher);
        isfistlogin();//用作第一次判定
        bindview();
        initview();
        group();

    }

    private void isfistlogin() {
        sharedPreferences=this.getSharedPreferences("isfirst",MODE_PRIVATE);
        editor=sharedPreferences.edit();
        isfirst = sharedPreferences.getString("isfirst","true");
        if(isfirst.equals("true")){

        }else {
            startActivity(new Intent(Luncher.this,MainActivity.class));
            Luncher.this.finish();
        }

    }

    private void group() {
        for (int i = 0; i < 5; i++) {

            final int finalI = i;
            ((RadioButton)radiogroup.getChildAt(i)).setOnClickListener(new View.OnClickListener() {     //这里要记住
                @Override
                public void onClick(View v) {
                    luncherViewpager.setCurrentItem(finalI);
                }
            });

        }
    }

    private void initview() {
        testaccount = new HashMap<>();
        adapter=new ViewAdapter();
        imgs=new ArrayList<>();
        imgs.add(R.drawable.lancher1);
        imgs.add(R.drawable.lancher2);
        imgs.add(R.drawable.lancher3);
        imgs.add(R.drawable.lancher4);
        imgs.add(R.drawable.lancher5);
        luncherViewpager.setAdapter(adapter);
        ((RadioButton)radiogroup.getChildAt(0)).setChecked(true);
        luncherViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                ((RadioButton)radiogroup.getChildAt(position)).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //写dialog
                editor.putString("isfirst","false").commit();
                dialog=new Dialog(Luncher.this);
                dialog.setContentView(inflate);//这里要写inflate，不能直接写R.layout
                dialog.setCancelable(false);
                dialog.show();

            }
        });

        button.setOnClickListener(new View.OnClickListener() {      //dialog的确认按钮
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(ipdress.getText())){
                    MyApplication.showToast("IP设置不能为空");
                }else if(TextUtils.isEmpty(portress.getText())) {
                    MyApplication.showToast("端口不能为空");
                }else {
                    testaccount.put("username","cghk004");
                    testaccount.put("password","123456");
                    HttpUtils.doPost(testaccount, "http://"+ipdress.getText()+":"+portress.getText()+"/login", new HttpCallBack() {
                        @Override
                        public void onSuccess(String json) {
                            Log.i("1", "onSuccess: ");
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Log.i("1", "run: ");
                                    MyApplication.showToast("登录成功");
                                    MyApplication.setMyUrl("http://"+ipdress.getText().toString().trim()+":"+portress.getText().toString().trim());
                                    startActivity(new Intent(Luncher.this,MainActivity.class));
                                    Luncher.this.finish();
                                }
                            });

                        }

                        @Override
                        public void onError(final String error) {

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Log.i("1", "run: "+error);
                                    MyApplication.showToast("登录失败，请检查端口设置");
                                }
                            });
                        }
                    });


                }
            }
        });
    }

    private void bindview() {
        inflate = LayoutInflater.from(this).inflate(R.layout.item_luncher,null,false);

        textView = inflate.findViewById(R.id.textView);
        textView2 = inflate.findViewById(R.id.textView2);
        textView3 = inflate.findViewById(R.id.textView3);
        ipdress = inflate.findViewById(R.id.ipdress);
        portress = inflate.findViewById(R.id.portress);
        button = inflate.findViewById(R.id.button);

        luncherViewpager = (ViewPager) findViewById(R.id.luncher_viewpager);
        radiogroup = (RadioGroup) findViewById(R.id.radiogroup);
        radioButton1 = (RadioButton) findViewById(R.id.radioButton1);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
        radioButton4 = (RadioButton) findViewById(R.id.radioButton4);
        radioButton5 = (RadioButton) findViewById(R.id.radioButton5);
        ipsetting = (TextView) findViewById(R.id.ipsetting);
        login = (Button) findViewById(R.id.login);
    }
    class ViewAdapter extends PagerAdapter {
        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position)
        {
            ImageView imageView=new ImageView(getApplicationContext());
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageResource(imgs.get(position));
            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }

        @Override
        public int getCount() {
            return imgs.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view==object;
        }
    }
}