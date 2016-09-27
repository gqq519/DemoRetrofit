package com.feicuiedu.demoretrofit.demoOkHttpPost2;

import com.feicuiedu.demoretrofit.demoOkHttpPost.User;

import okhttp3.Call;

/**
 * 目前仅仅只是为了将所有的网络连接接口放在一起
 * Created by 123 on 2016/9/27.
 */
public interface UserApi {

    // 注册
    Call register(User user);

    // 通过Get请求来进行
    Call getData();

}
