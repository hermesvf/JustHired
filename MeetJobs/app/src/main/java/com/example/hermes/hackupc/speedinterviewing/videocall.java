package com.example.hermes.hackupc.speedinterviewing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class videocall extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videocall);

        WebView htmlWebView = (WebView) findViewById(R.id.webview);
        htmlWebView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = htmlWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDisplayZoomControls(true);
        htmlWebView.loadUrl("https://appr.tc/r/204057864");
    }
}
