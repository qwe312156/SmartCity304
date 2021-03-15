package net.starmu.smartcity;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

public class MyApplication extends Application {

    static private Context context;

    @Override
    public void onCreate() {
        context = this;
        super.onCreate();
    }

    public static void showToast(String text) {
        Toast.makeText(context,text,Toast.LENGTH_SHORT).show();
    }

}
