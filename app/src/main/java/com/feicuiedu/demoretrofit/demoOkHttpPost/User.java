package com.feicuiedu.demoretrofit.demoOkHttpPost;

import com.google.gson.annotations.SerializedName;

/**
 * 作者：yuanchao on 2016/8/15 0015 14:22
 * 邮箱：yuanchao@feicuiedu.com
 */
public class User {
    /**
     * Password : 654321
     * UserName : qjd
     */

    private String username;// 用户名

    private String password;// 密码

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }


}
