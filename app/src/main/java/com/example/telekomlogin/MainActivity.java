package com.example.telekomlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.ValueCallback;
import android.webkit.CookieManager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity
{
    WebView telekomLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        telekomLogin = (WebView) findViewById(R.id.TelekomLogin);

        //Websettings WebView
        WebSettings Settings = telekomLogin.getSettings();
        Settings.setJavaScriptEnabled(true);

        //No Cache
        Settings.setCacheMode(Settings.LOAD_NO_CACHE);
        Settings.setAppCacheEnabled(false);
        clearCookies();
        telekomLogin.loadUrl("https://hotspot.t-mobile.net/TD/hotspot/de_DE/index.html#/start");
        Settings.getSafeBrowsingEnabled();
        telekomLogin.clearFormData();
        telekomLogin.clearHistory();
        telekomLogin.clearSslPreferences();

        //open Settings with button
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.Settings);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                openSettings();

            }
        });
    }

    public void openSettings()
    {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }

    //No cookies
    public static void clearCookies()
    {
        android.webkit.CookieManager cookieManager =
                CookieManager.getInstance();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            cookieManager.removeAllCookies(new ValueCallback<Boolean>()
            {
                @Override
                public void onReceiveValue(Boolean aBoolean)
                {
                    //
                }
            });
        }
        else cookieManager.removeAllCookie();
    }


    // App automatisch schließen nach Nutzung
    public void onBackPressed()
    {
        moveTaskToBack(true);

        // Optional
        System.exit(0);
    }


}
