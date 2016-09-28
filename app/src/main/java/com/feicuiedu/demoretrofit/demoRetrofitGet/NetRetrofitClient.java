package com.feicuiedu.demoretrofit.demoRetrofitGet;

import com.feicuiedu.demoretrofit.demoOkHttpPost.User;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;

/**
 * Created by 123 on 2016/9/28.
 */
public class NetRetrofitClient implements RetrofitUserApi{

    private static NetRetrofitClient netRetrofitClient;
    private final RetrofitUserApi userApi;

    private String BASE_URL = "http://admin.syfeicuiedu.com";

    private NetRetrofitClient(){

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        // 完成Retrofit的初始化
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
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

    @Override
    public Call<ResponseBody> userRegister(@Body User user) {
        return userApi.userRegister(user);
    }
}
