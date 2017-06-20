package com.inhatc.juha.andorid_webview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView objwebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        objwebView = (WebView) findViewById(R.id.webView1);
        objwebView.setWebViewClient(new Android_WebViewClient());
        objwebView.getSettings().setJavaScriptEnabled(true);
        objwebView.loadUrl("http://www.google.com");
    }

    private class Android_WebViewClient extends WebViewClient {
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        public boolean shouldOverrideKeyEvent (WebView view, KeyEvent event) {
            int keyCode = event.getKeyCode();
            if ((keyCode == KeyEvent.KEYCODE_DPAD_LEFT) && objwebView.canGoBack()) {
                objwebView.goBack();
                return true;
            }
            else if ((keyCode == KeyEvent.KEYCODE_DPAD_RIGHT) && objwebView.canGoForward()) {
                objwebView.goForward();
                return true;
            }
            return false;
        }
    }
}
