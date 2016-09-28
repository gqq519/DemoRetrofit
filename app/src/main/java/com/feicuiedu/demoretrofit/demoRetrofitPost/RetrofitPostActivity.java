package com.feicuiedu.demoretrofit.demoRetrofitPost;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import com.feicuiedu.demoretrofit.R;
import com.feicuiedu.demoretrofit.demoOkHttpPost.User;
import com.feicuiedu.demoretrofit.demoRetrofitGet.NetRetrofitClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitPostActivity extends AppCompatActivity {

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

        User user = new User(etUsername.getText().toString(),etPassrword.getText().toString());

        // 去进行请求
        NetRetrofitClient.getInsatnce().userRegister(user).enqueue(new Callback<UserResult>() {

            // 响应成功
            @Override
            public void onResponse(Call<UserResult> call, Response<UserResult> response) {
                UserResult result = response.body();
                Toast.makeText(RetrofitPostActivity.this, "响应成功:信息"+result.getMsg(), Toast.LENGTH_SHORT).show();

            }

            // 响应失败
            @Override
            public void onFailure(Call<UserResult> call, Throwable t) {
                Toast.makeText(RetrofitPostActivity.this, "响应失败", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
