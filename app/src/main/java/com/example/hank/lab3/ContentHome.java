package com.example.hank.lab3;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.CheckBox;

import java.security.PrivateKey;

/**
 * Created by Hank on 13.12.2015.
 */
public class ContentHome extends Fragment {
    private WebView mWebView;
    Button buttonGLE;
    Button buttonG;
    Button buttonGTS;
    Button buttonC63;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.content_home, container, false);
        buttonC63 = (Button) v.findViewById(R.id.buttonC);
        buttonGLE = (Button) v.findViewById(R.id.buttonGLE);
        buttonG = (Button) v.findViewById(R.id.buttonG);
        buttonGTS = (Button) v.findViewById(R.id.buttonGTS);
        v.scrollTo(0,0);
        mWebView = (WebView) v.findViewById(R.id.webView);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new MyWebViewClient());
        loadURL(1);
        buttonGLE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadURL(1);
            }
        });
        buttonG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadURL(2);
            }
        });
        buttonGTS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadURL(3);
            }
        });
        buttonC63.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadURL(4);
            }
        });
        return v;
    }

    private class MyWebViewClient extends WebViewClient
    {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url)
        {
            view.loadUrl(url);
            return true;
        }
    }

    private void loadURL(int a){
        buttonGLE.setBackgroundColor(getResources().getColor(R.color.background_button_start));
        buttonG.setBackgroundColor(getResources().getColor(R.color.background_button_start));
        buttonGTS.setBackgroundColor(getResources().getColor(R.color.background_button_start));
        buttonC63.setBackgroundColor(getResources().getColor(R.color.background_button_start));
        switch (a){
            case 1:
                buttonGLE.setBackgroundColor(getResources().getColor(R.color.background_button_choose));
                mWebView.loadUrl("http://www.mercedes-amg.com/gle63c.php?lang=rus#vehicle_overview_section");
                break;
            case 2:
                buttonG.setBackgroundColor(getResources().getColor(R.color.background_button_choose));
                mWebView.loadUrl("http://www.mercedes-amg.com/g63.php?lang=rus");
                break;
            case 3:
                buttonGTS.setBackgroundColor(getResources().getColor(R.color.background_button_choose));
                mWebView.loadUrl("http://www.mercedes-amg.com/webspecial/amggt/index_rus.php#media/");
                break;
            case 4:
                buttonC63.setBackgroundColor(getResources().getColor(R.color.background_button_choose));
                mWebView.loadUrl("http://www.mercedes-amg.com/webspecial/c63/index_rus.php#home");
                break;
        }
    }

}
