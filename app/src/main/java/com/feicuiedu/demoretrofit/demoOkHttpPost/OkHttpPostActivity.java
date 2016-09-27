package com.feicuiedu.demoretrofit.demoOkHttpPost;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;

import com.feicuiedu.demoretrofit.R;
import com.google.gson.Gson;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkHttpPostActivity extends AppCompatActivity {

    @BindView(R.id.et_Username)
    EditText etUsername;
    @BindView(R.id.et_Passrword)
    EditText etPassrword;

    private String BASE_URL = "http://admin.syfeicuiedu.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http_post);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_Register)
    public void onClick() {

        // 进行请求
        // 拦截
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        Gson gson = new Gson();
        User user = new User(etUsername.getText().toString(),etPassrword.getText().toString());
        String content = gson.toJson(user);

        // 3，设置请求体
        RequestBody requestBody = RequestBody.create(null,content);

        // 2, 构建一个请求
        Request request = new Request.Builder()
                .post(requestBody)
                .url(BASE_URL+"/Handler/UserHandler.ashx?action=register")
                .build();

        // 1, 执行一个请求
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.w("gqq","响应失败");
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.w("gqq","响应成功");
            }
        });
    }
}
