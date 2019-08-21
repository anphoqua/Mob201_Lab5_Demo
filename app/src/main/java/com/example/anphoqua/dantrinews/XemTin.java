package com.example.anphoqua.dantrinews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class XemTin extends AppCompatActivity {
    WebView webView;
    String link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xem_tin);
        webView = findViewById(R.id.webView);

        link = getIntent().getExtras().getString("link");
        Toast.makeText(XemTin.this, link, Toast.LENGTH_SHORT).show();

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                webView.loadUrl(link);
                return super.shouldOverrideUrlLoading(view, request);
            }
        });
        webView.loadUrl(link);
    }
}
