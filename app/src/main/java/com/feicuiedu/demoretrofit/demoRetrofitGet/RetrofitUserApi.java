package com.feicuiedu.demoretrofit.demoRetrofitGet;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by 123 on 2016/9/28.
 */
public interface RetrofitUserApi {
    /**
     Request request = new Request.Builder()
     .url("https://api.github.com/users/gqq")
     .get()
     .build();
     */
    @GET("https://api.github.com/users/gqq")
    Call<ResponseBody> getData();

}
