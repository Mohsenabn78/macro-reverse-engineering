package com.arlosoft.macrodroid;

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
import androidx.activity.OnBackPressedCallback;
import com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;

/* loaded from: classes2.dex */
public class WikiActivity extends MacroDroidBaseActivity {

    /* renamed from: f  reason: collision with root package name */
    private WebView f2032f;

    /* renamed from: g  reason: collision with root package name */
    private ViewFlipper f2033g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f2034h = false;

    /* loaded from: classes2.dex */
    class a extends WebViewClient {
        a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            if (!WikiActivity.this.f2034h) {
                WikiActivity.this.f2033g.setDisplayedChild(3);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i4, String str, String str2) {
            WikiActivity.this.f2034h = true;
            WikiActivity.this.f2033g.setDisplayedChild(2);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    /* loaded from: classes2.dex */
    class b extends OnBackPressedCallback {
        b(boolean z3) {
            super(z3);
        }

        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackPressed() {
            if (WikiActivity.this.f2032f.canGoBack()) {
                WikiActivity.this.f2032f.goBack();
            } else {
                WikiActivity.this.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(View view) {
        s("https://www.macrodroidforum.com/wiki");
    }

    private void s(String str) {
        this.f2034h = false;
        this.f2033g.setDisplayedChild(1);
        if (!str.contains("://")) {
            str = "http://" + str;
        }
        this.f2032f.resumeTimers();
        this.f2032f.loadUrl(str);
    }

    public void destroyWebView() {
        this.f2033g.removeAllViews();
        WebSettings settings = this.f2032f.getSettings();
        settings.setJavaScriptEnabled(false);
        settings.setBuiltInZoomControls(false);
        settings.setSupportZoom(false);
        this.f2032f.clearHistory();
        this.f2032f.clearCache(true);
        this.f2032f.loadUrl("about:blank");
        this.f2032f.onPause();
        this.f2032f.removeAllViews();
        this.f2032f.destroyDrawingCache();
        this.f2032f.pauseTimers();
        this.f2032f.destroy();
        this.f2032f = null;
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        try {
            setContentView(R.layout.remote_web_activity);
            setTitle(R.string.wiki);
            Uri data = getIntent().getData();
            WebView webView = (WebView) findViewById(R.id.remote_web_view);
            this.f2032f = webView;
            webView.getSettings().setJavaScriptEnabled(false);
            this.f2033g = (ViewFlipper) findViewById(R.id.view_flipper);
            Button button = (Button) findViewById(R.id.retry_button);
            this.f2032f.setWebViewClient(new a());
            WebSettings settings = this.f2032f.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setBuiltInZoomControls(true);
            settings.setSupportZoom(true);
            settings.setDomStorageEnabled(true);
            settings.setLoadWithOverviewMode(true);
            settings.setAllowContentAccess(true);
            settings.setDatabaseEnabled(true);
            settings.setUserAgentString(settings.getUserAgentString().replace("; wv", ""));
            this.f2032f.setWebChromeClient(new WebChromeClient());
            if (data != null) {
                str = data.toString();
            } else {
                str = "https://www.macrodroidforum.com/wiki";
            }
            s(str);
            button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.s0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WikiActivity.this.r(view);
                }
            });
            getOnBackPressedDispatcher().addCallback(this, new b(true));
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
