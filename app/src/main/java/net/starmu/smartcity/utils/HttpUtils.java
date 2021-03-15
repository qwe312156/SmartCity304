package net.starmu.smartcity.utils;

import net.starmu.smartcity.MyApplication;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpUtils {
    private static OkHttpClient client;

    static {
        client = new OkHttpClient.Builder()
                .readTimeout(1000, TimeUnit.SECONDS)
                .connectTimeout(1000,TimeUnit.SECONDS)
                .writeTimeout(1000,TimeUnit.SECONDS)
                .build();
    }

    public static void doGet(String url,HttpCallBack callBack){
        Request request = new Request.Builder()
                .addHeader("Authorization", MyApplication.getToken())
                .url(MyApplication.getMyUrl()+url)
                .get()
                .build();
        doRequest(request,callBack);
    }

    private static void doRequest(Request request, final HttpCallBack callBack) {
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callBack.onError(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string().trim();
                try {
                    JSONObject jsonObject = new JSONObject(json);
                    if (jsonObject.getInt("code")==200){
                        callBack.onSuccess(json);
                    }else {
                        callBack.onError(json);
                    }
                } catch (JSONException e) {
                    callBack.onError(e.getMessage());
                    e.printStackTrace();
                }
            }
        });
    }
}
