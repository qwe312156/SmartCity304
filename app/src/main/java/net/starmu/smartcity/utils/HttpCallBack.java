package net.starmu.smartcity.utils;

public interface HttpCallBack {
    void onSuccess(String json);
    void onError(String error);
}
