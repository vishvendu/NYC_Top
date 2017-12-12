package com.example.vishvendu.nyctopnews.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.vishvendu.nyctopnews.R;

public class WebViewDetails extends AppCompatActivity {

    WebView webView ;
    String web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        initView();
    }

    private void initView() {

        webView = (WebView)findViewById(R.id.webview);



       Bundle bundle = getIntent().getExtras();
       web = bundle.getString("SelectedUrl");

        loadWebViewLoad(webView);


    }


    private void loadWebViewLoad(WebView webview) {
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webview.getSettings().setSupportMultipleWindows(true);
        webview.setWebViewClient(new WebViewClient());
        webview.setWebChromeClient(new WebChromeClient());
        webview.loadUrl(web);
    }
}
