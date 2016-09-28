package com.feicuiedu.demoretrofit.demoRetrofitGet;

import com.feicuiedu.demoretrofit.demoOkHttpPost.User;
import com.feicuiedu.demoretrofit.demoRetrofitPost.UserResult;

import java.util.List;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

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

    @POST("/Handler/UserHandler.ashx?action=register")
    Call<UserResult> userRegister(@Body User user);

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
     */


    @Headers({"Accept-type:json","....","......"})
    @POST("/Handler/UserHandler.ashx?action=register")
    Call<UserResult> userRegister(@Body User user, @Header("Accept-type")String ac);

    /**
     * 注解
     * 1. 请求方式：@GET("url"),@POST("url")
     * 2. 请求头：@Headers("一条")，@Heasers({"","",""})，@Header("Accept-type")String ac动态修改头信息
     * 3. 请求体：@Body User user，设置请求体
     *
     */

    /**
     * URL 注解
     *
     * 1.url 可替换块 {user}    @Path
     *      https://api.github.com/users/gqq/name
     *      https://api.github.com/users/{user}/name
     *      https://api.github.com/repos/{owner}/{repo}
     * 2. https://api.github.com/search/issues?q=java&w=zxc&.....;
     *
     *      https://api.github.com/search/issues
     *      q=....,w=...--------->结果,
     *      q=....--------->结果
     *
     * 3. 综合使用  POST https://api.github.com/repos/{owner}/{repo}
     *
     * 4.FormUrlEncoded 以表单形式提交
     *
     * 5.多部分提交,Multipart
     *
     */

    // user zxc,
//    @GET("https://api.github.com/users/{user}/name")
    @GET("https://api.github.com/repos/{owner}/{repo}")
    Call<ResponseBody> getUser(@Path("owner")String user,@Path("repo")String repo);


    // 把请求地址写死：https://api.github.com/search/issues?q=abc&w=zzz;

    // daa--abc,w---a,请求https://api.github.com/search/issues?q=abc&w=a
    // daa----xcv,w---b,请求https://api.github.com/search/issues?q=xcv&w=b
    @GET("https://api.github.com/search/issues")
    Call<ResponseBody> getData2(@Query("q")String daa,@Query("w")String w);

    @POST("https://api.github.com/repos/{owner}")
    Call<ResponseBody> getAA(@Body User user,@Path("owner")String s,@Query("q")String q);

    @FormUrlEncoded
    @POST("https://api.github.com/repos/")
    // name,password;
    Call<ResponseBody> getUserA(@Field("name")String name,@Field("password")String password);

    @Multipart
    @POST("http://hjhkjlgk;")
    Call<ResponseBody> getMult(@Part("photo")String photo, @Part("user") RequestBody user,@Part("other")RequestBody other);
}
