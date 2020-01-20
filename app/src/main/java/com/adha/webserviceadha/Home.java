package com.adha.webserviceadha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class Home extends AppCompatActivity {
    //WebView webView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        button = findViewById(R.id.btn_keluar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

//        webView = findViewById(R.id.web_view);
//        webView.setWebViewClient(new WebViewClient());
//        webView.loadUrl("https://adha-belajar.000webhostapp.com/");
//
//        WebSettings webSetting = webView.getSettings();
//        webSetting.setJavaScriptEnabled(true);
    }
}
