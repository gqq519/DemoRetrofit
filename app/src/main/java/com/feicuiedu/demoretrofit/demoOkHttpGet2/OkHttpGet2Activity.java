package com.feicuiedu.demoretrofit.demoOkHttpGet2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.feicuiedu.demoretrofit.R;
import com.feicuiedu.demoretrofit.demoOkHttpPost2.NetPostClient;

import java.io.IOException;

import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class OkHttpGet2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http_get);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    public void onClick() {

        // 去进行Get请求
        NetPostClient.getInstance().getData().enqueue(new UICallBack() {

            // UI 线程执行，可以进行UI视图的变化，比如Toast,对话框等
            @Override
            public void onFailureInUI(Call call, IOException e) {
                Toast.makeText(OkHttpGet2Activity.this, "响应失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponseInUi(Call call, Response response) {
                Toast.makeText(OkHttpGet2Activity.this, "响应成功", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
