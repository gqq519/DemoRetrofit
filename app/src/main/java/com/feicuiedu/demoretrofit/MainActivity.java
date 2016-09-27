package com.feicuiedu.demoretrofit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.feicuiedu.demoretrofit.demoOkHttpGet.OkHttpGetActivity;
import com.feicuiedu.demoretrofit.demoOkHttpPost.OkHttpPostActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @BindView(R.id.listView)
    ListView listView;

    private Demo[] demos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        demos = createDemos();
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, demos));
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        startActivity(demos[position].intent);
    }

    private Demo[] createDemos() {
        return new Demo[]{
                new Demo("OkHttp的GET请求",new Intent(this,OkHttpGetActivity.class)),
                new Demo("OkHttp的POST请求",new Intent(this, OkHttpPostActivity.class))
        };
    }

    static class Demo {
        String name;
        Intent intent;

        private Demo(String name, Intent intent) {
            this.name = name;
            this.intent = intent;
        }

        public String toString() {
            return name;
        }
    }

       /* *//**
     * 请求  Request
     Header 头
     RequestBody 请求体

     响应  Response
     Header 头
     ResponseBody 响应体

     ##Client类
     *//*
        // 2.请求行
        HttpGet httpGet = new HttpGet("url");
        // 3.请求头
        httpGet.addHeader(new BasicHeader("",""));
        httpGet.addHeader(new BasicHeader("",""));

        // 4.请求体
        // Get 请求没有请求体，POst有请求体，用户信息

        // 1. 执行请求
        HttpClient httpClient = new DefaultHttpClient();
        HttpResponse response = httpClient.execute(httpGet);


        // 1.响应行，code 200-299
        if (response.getStatusLine().getStatusCode()==200){

            // 2. 响应头
            response.getHeaders("");
            response.getAllHeaders();

            // 3.响应体
            HttpEntity entity = response.getEntity();
            InputStream content = entity.getContent();
        }

*/
}
