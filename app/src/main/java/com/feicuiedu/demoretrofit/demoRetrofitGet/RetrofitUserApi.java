package com.feicuiedu.demoretrofit.demoRetrofitGet;

import com.feicuiedu.demoretrofit.demoOkHttpPost.User;
import com.feicuiedu.demoretrofit.demoRetrofitPost.UserResult;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by 123 on 2016/9/28.
 */
public interface RetrofitUserApi {
    /**
     * Retrofit基于OkHttp进行封装的
     *
     Request request = new Request.Builder()
     .url("https://api.github.com/users/gqq")
     .get()
     .build();
     */
    @GET("https://api.github.com/users/gqq")
    Call<ResponseBody> getData();

    /**
     * // 请求的构建
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
     * @return
     *
     * GSON 转换器，实体类转换成字符串，字符串转换成实体类（集合）
     * json字符串--->集合实体类
     * xml字符串--->
     *
     */
    @POST("/Handler/UserHandler.ashx?action=register")
    Call<UserResult> userRegister(@Body User user);



}
