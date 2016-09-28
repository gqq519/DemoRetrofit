package com.feicuiedu.demoretrofit.demoRetrofitGet;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Created by 123 on 2016/9/28.
 */
public class NetRetrofitClient implements RetrofitUserApi{

    private static NetRetrofitClient netRetrofitClient;
    private final RetrofitUserApi userApi;

    private String BASE_URL = "http://admin.syfeicuiedu.com";

    private NetRetrofitClient(){
        // 完成Retrofit的初始化
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .build();
        userApi = retrofit.create(RetrofitUserApi.class);
    }

    public static NetRetrofitClient getInsatnce(){
        if (netRetrofitClient==null){
            netRetrofitClient = new NetRetrofitClient();
        }
        return netRetrofitClient;
    }

    @Override
    public Call<ResponseBody> getData() {
        return userApi.getData();
    }
}
