package com.feicuiedu.demoretrofit.demoOkHttpGet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.feicuiedu.demoretrofit.R;

import java.io.IOException;

import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpGetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http_get);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    public void onClick() {

        // 使用OkHttp来进行
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .get()// 请求方式
                .url("https://api.github.com/users/gqq")
                .build();

        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                // 后台线程，不能做UI的变化
                Log.w("zzz","失败了");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                // 后台线程
                Log.w("zzz","响应成功了");
            }
        });
    }
}
