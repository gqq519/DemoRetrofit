package com.feicuiedu.demoretrofit.demoOkHttpPost2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;

import com.feicuiedu.demoretrofit.R;
import com.feicuiedu.demoretrofit.demoOkHttpPost.User;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class OkHttpPost2Activity extends AppCompatActivity {

    @BindView(R.id.et_Username)
    EditText etUsername;
    @BindView(R.id.et_Passrword)
    EditText etPassrword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http_post);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.btn_Register)
    public void onClick() {

        // 去执行请求
        User user = new User(etUsername.getText().toString(),etPassrword.getText().toString());
        NetPostClient.getInstance().register(user).enqueue(new Callback() {

            // 响应失败
            @Override
            public void onFailure(Call call, IOException e) {
                Log.w("gqq","响应失败");
            }

            // 响应成功
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.w("gqq","响应成功");
            }
        });
    }
}
