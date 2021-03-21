package net.starmu.smartcity;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class MyApplication extends Application {

    static private Context context;
    static private String Token="";
    static private String MyUrl="";
    static private Gson gson;
    static private SharedPreferences sharedPreferences;
    static private SharedPreferences.Editor editor;
    static HashMap<String,Object> Clickmap;
    public static HashMap<String, Object> getClickmap() {
        return Clickmap;
    }

    public static void setClickmap(HashMap<String, Object> clickmap) {
        Clickmap = clickmap;
      for(String key:clickmap.keySet()){
          //这里面的话，key就是String的Key，Value就是clickmap.get(key);
         Clickmap.put(key,clickmap.get(key));

      }

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
