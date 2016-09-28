package com.feicuiedu.demoretrofit.demoRetrofitGet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.feicuiedu.demoretrofit.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitGetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_get);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_retrofit)
    public void onClick() {

        // 进行请求
        NetRetrofitClient.getInsatnce().getData().enqueue(new Callback<ResponseBody>() {
            // 封装好的，可以进行UI操作
            // 响应成功
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Toast.makeText(RetrofitGetActivity.this, "响应成功", Toast.LENGTH_SHORT).show();
            }

            // 响应失败
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(RetrofitGetActivity.this, "响应失败", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
