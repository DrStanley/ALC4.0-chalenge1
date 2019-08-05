package com.stanleyj.android.alc40_challenge;

import android.net.http.SslError;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

public class ActivityB extends AppCompatActivity {
    Button b1;

    WebView wv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_b);

//        find the webview from the xml
        wv1 = (WebView) findViewById(R.id.webView);

        Toast.makeText(ActivityB.this, "Loading Page Please wait...", Toast.LENGTH_LONG).show();
//        finding the toolbar from the xml and setting it as the support actionbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarB);
        setSupportActionBar(toolbar);
//        adding title to the bar
        getSupportActionBar().setTitle("About ALC");
//        enabling the back arrow in the actionbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        making the action back arrow go back to previous unfinished activity
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

//        making wv1 respond to javascript webpages
        wv1.getSettings().setJavaScriptEnabled(true);
        wv1.loadUrl("https://andela.com/alc/");
//      to prevent url to open in the browser
//        wv1.setWebViewClient(new WebViewClient());
        wv1.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedSslError(WebView v, SslErrorHandler handler, SslError er) {
                handler.proceed();
            }
        });

    }

    @Override
    public void onBackPressed() {
//        make your back press navigate  to the previous page in webview
        if (wv1.canGoBack()) {
            wv1.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
