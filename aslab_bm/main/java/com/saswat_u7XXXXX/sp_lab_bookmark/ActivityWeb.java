package com.saswat_u7156387.sp_lab_bookmark;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Toast;

public class ActivityWeb extends AppCompatActivity {

    WebView webView;
    String url="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        webView = (WebView) findViewById(R.id.webview);
        Intent geturl=getIntent();
        url=geturl.getStringExtra("url");
        if(!(url==""||url==null||url.length()==0)) {
            webView.getSettings().setLoadsImagesAutomatically(true);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
            webView.loadUrl(url);
        }
        else
            Toast.makeText(getApplicationContext(), "Sorry the url is Invalid",Toast.LENGTH_SHORT).show();


    }
}