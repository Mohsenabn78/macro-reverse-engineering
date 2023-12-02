package com.arlosoft.macrodroid;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.InflateException;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ViewFlipper;
import com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity;
import com.arlosoft.macrodroid.homescreen.tiles.ForumTile;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;

/* loaded from: classes2.dex */
public class ForumActivity extends MacroDroidBaseActivity {

    /* renamed from: f  reason: collision with root package name */
    private WebView f1998f;

    /* renamed from: g  reason: collision with root package name */
    private ViewFlipper f1999g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f2000h = false;

    /* loaded from: classes2.dex */
    class a extends WebViewClient {
        a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            if (!ForumActivity.this.f2000h) {
                ForumActivity.this.f1999g.setDisplayedChild(3);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i4, String str, String str2) {
            ForumActivity.this.f2000h = true;
            ForumActivity.this.f1999g.setDisplayedChild(2);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str.startsWith("http://www.macrodroidlink.com/macrostore?")) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                ForumActivity.this.startActivity(intent);
                return true;
            }
            if (str.endsWith(".pdf")) {
                Intent intent2 = new Intent("android.intent.action.VIEW");
                intent2.setData(Uri.parse(str));
                try {
                    webView.getContext().startActivity(intent2);
                    return true;
                } catch (ActivityNotFoundException unused) {
                }
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(View view) {
        r(ForumTile.NEW_FORUM_URL);
    }

    private void r(String str) {
        this.f2000h = false;
        this.f1999g.setDisplayedChild(1);
        if (!str.contains("://")) {
            str = "http://" + str;
        }
        this.f1998f.resumeTimers();
        this.f1998f.loadUrl(str);
    }

    public void destroyWebView() {
        this.f1999g.removeAllViews();
        WebSettings settings = this.f1998f.getSettings();
        settings.setJavaScriptEnabled(false);
        settings.setBuiltInZoomControls(false);
        settings.setSupportZoom(false);
        this.f1998f.clearHistory();
        this.f1998f.clearCache(true);
        this.f1998f.loadUrl("about:blank");
        this.f1998f.onPause();
        this.f1998f.removeAllViews();
        this.f1998f.destroyDrawingCache();
        this.f1998f.pauseTimers();
        this.f1998f.destroy();
        this.f1998f = null;
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f1998f.canGoBack()) {
            this.f1998f.goBack();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        try {
            setContentView(R.layout.remote_web_activity);
            setTitle(R.string.macrodroid_forum);
            Uri data = getIntent().getData();
            WebView webView = (WebView) findViewById(R.id.remote_web_view);
            this.f1998f = webView;
            webView.getSettings().setJavaScriptEnabled(false);
            this.f1999g = (ViewFlipper) findViewById(R.id.view_flipper);
            Button button = (Button) findViewById(R.id.retry_button);
            this.f1998f.setWebViewClient(new a());
            WebSettings settings = this.f1998f.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setBuiltInZoomControls(true);
            settings.setSupportZoom(true);
            settings.setDomStorageEnabled(true);
            settings.setLoadWithOverviewMode(true);
            settings.setAllowContentAccess(true);
            settings.setDatabaseEnabled(true);
            settings.setUserAgentString(settings.getUserAgentString().replace("; wv", ""));
            this.f1998f.setWebChromeClient(new WebChromeClient());
            if (data != null) {
                str = data.toString();
            } else {
                str = ForumTile.NEW_FORUM_URL;
            }
            r(str);
            button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.c0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ForumActivity.this.q(view);
                }
            });
        } catch (InflateException e4) {
            SystemLog.logError("Failed to initialse web view, maybe Google Play is currently updating your web view? : " + e4.toString());
            finish();
        }
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        try {
            destroyWebView();
        } catch (Exception unused) {
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        super.onBackPressed();
        return true;
    }
}
