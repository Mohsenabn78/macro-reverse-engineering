package com.arlosoft.macrodroid;

import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;
import androidx.webkit.WebSettingsCompat;
import androidx.webkit.WebViewFeature;
import com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity;
import com.arlosoft.macrodroid.settings.Settings;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* loaded from: classes2.dex */
public class HelpActivity extends MacroDroidBaseActivity {
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.help_view);
        setTitle(R.string.macrodroid_help);
        WebView webView = (WebView) findViewById(R.id.help_web_view);
        webView.setScrollBarStyle(33554432);
        if (WebViewFeature.isFeatureSupported("FORCE_DARK")) {
            String darkMode = Settings.getDarkMode(this);
            if (darkMode.equals(2)) {
                WebSettingsCompat.setForceDark(webView.getSettings(), 2);
            } else if (darkMode.equals(String.valueOf(-1))) {
                if (getResources().getBoolean(R.bool.is_night_mode)) {
                    WebSettingsCompat.setForceDark(webView.getSettings(), 2);
                } else {
                    WebSettingsCompat.setForceDark(webView.getSettings(), 0);
                }
            }
        }
        try {
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.helpfile), "UTF-8"));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    bufferedReader.close();
                    webView.loadDataWithBaseURL(null, sb.toString(), "text/html", "UTF-8", null);
                    return;
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }
}
