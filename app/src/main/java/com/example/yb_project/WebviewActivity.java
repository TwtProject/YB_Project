package com.example.yb_project;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class WebviewActivity extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String newLink;
        setContentView(R.layout.web_view);

        newLink = getUrlImg();
        webView = (WebView) findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(newLink);
    }

    private String getUrlImg(){
        if (getIntent().hasExtra("link_url")){
            String link = getIntent().getStringExtra("link_url");
            return link;
        }
        return null;
    }
}
