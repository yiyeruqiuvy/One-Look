package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageView;

import static android.webkit.WebSettings.LOAD_NO_CACHE;

public class MainActivity extends AppCompatActivity{

    private EditText wv_edit;
    private ImageView wv_search;
    private ImageView wv_back;
    private ImageView wv_home;
    private ImageView wv_forward;
    private ImageView wv_renovate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //加载初始网页
        final WebView webView = (WebView)findViewById(R.id.web_view);
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        final String wurl = "http://"+url;
        webView.loadUrl(wurl);

        //启用WebSettings
        WebSettings webSettings = webView.getSettings();
        //开启Javascript
        webSettings.setJavaScriptEnabled(true);
        //webSettings.setCacheMode(LOAD_NO_CACHE);

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                webView.loadUrl(url);
                return true;
            }
        });

        //本页面切换网页
        wv_search = (ImageView)findViewById(R.id.wv_search);
        wv_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wv_edit = (EditText)findViewById(R.id.wv_edit);
                final String wv_url = "http://"+wv_edit.getText().toString();
                webView.loadUrl(wv_url);
            }
        });

        //网页后退
        wv_back =  (ImageView)findViewById(R.id.wv_back);
        wv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.goBack();
            }
        });
        //网页前进
        wv_forward = (ImageView)findViewById(R.id.wv_forward);
        wv_forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.goForward();
            }
        });
        //回到主页
        wv_home = (ImageView)findViewById(R.id.wv_home);
        wv_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,HomePage.class);
                startActivity(intent);
            }
        });
        //刷新页面
        wv_renovate = (ImageView)findViewById(R.id.wv_renovate);
        wv_renovate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.reload();
            }
        });

    }
}
