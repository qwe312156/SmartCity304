package net.starmu.smartcity;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.google.gson.Gson;

import net.starmu.smartcity.bean.UserInfoBean;

public class MyApplication extends Application {

    static private Context context;
    static private String Token="";
    static private String MyUrl="";
    static private Gson gson;
    static private SharedPreferences sharedPreferences;
    static private SharedPreferences.Editor editor;
    static private UserInfoBean userInfo;

    public static UserInfoBean getUserInfo() {
        return userInfo;
    }

    public static void setUserInfo(UserInfoBean userInfo) {
        MyApplication.userInfo = userInfo;
    }

    public static Gson getGson(){
        return gson;
    }

    public static Context getContext() {
        return context;
    }

    public static String getToken() {
        return Token;
    }

    public static void setToken(String token) {
        Token = token;
    }

    public static String getMyUrl() {

        return sharedPreferences.getString("MyUrl","");

    }

    public static void setMyUrl(String myUrl) {
        MyUrl = myUrl;
        editor.putString("MyUrl",myUrl).commit();
    }


    @Override
    public void onCreate() {
        context = this;
        gson = new Gson();
        sharedPreferences=context.getSharedPreferences("MyUrl",MODE_PRIVATE);
        editor=sharedPreferences.edit();
        super.onCreate();
    }

    public static void showToast(String text) {
        Toast.makeText(context,text,Toast.LENGTH_SHORT).show();
    }

}
