package com.feicuiedu.demoretrofit.demoOkHttpPost2;

import com.feicuiedu.demoretrofit.demoOkHttpPost.User;
import com.google.gson.Gson;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by 123 on 2016/9/27.
 */
public class NetPostClient implements UserApi{

    private String BASE_URL = "http://admin.syfeicuiedu.com";

    private static NetPostClient netPostClient;
    private final OkHttpClient okHttpClient;

    public static NetPostClient getInstance(){
        if (netPostClient==null){
            netPostClient = new NetPostClient();
        }
        return netPostClient;
    }

    private NetPostClient(){
        // OkHttpClient 的创建
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

    }

    // 完成注册网络连接接口的实现
    @Override
    public Call register(User user) {
        // 请求的构建
        Gson gson = new Gson();
        String content = gson.toJson(user);
        // 3，设置请求体
        RequestBody requestBody = RequestBody.create(null,content);
        // 2, 构建一个请求
        Request request = new Request.Builder()
                .post(requestBody)
                .url(BASE_URL+"/Handler/UserHandler.ashx?action=register")
                .build();
        return okHttpClient.newCall(request);
    }

    @Override
    public Call login() {
        return null;
    }
}
