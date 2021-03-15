package net.starmu.smartcity;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

public class MyApplication extends Application {

    static private Context context;
    static private String Token;
    static private String MyUrl;

    public static String getToken() {
        return Token;
    }

    public static void setToken(String token) {
        Token = token;
    }

    public static String getMyUrl() {
        return MyUrl;
    }

    public static void setMyUrl(String myUrl) {
        MyUrl = myUrl;
    }

    @Override
    public void onCreate() {
        context = this;
        super.onCreate();
    }

    public static void showToast(String text) {
        Toast.makeText(context,text,Toast.LENGTH_SHORT).show();
    }

}
