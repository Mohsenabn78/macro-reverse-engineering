package com.arlosoft.macrodroid.privacy;

import android.net.Uri;
import android.os.Bundle;
import android.view.InflateException;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ViewFlipper;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.privacy.PrivacyActivity;
import com.arlosoft.macrodroid.remoteconfig.RemoteConfig;
import javax.inject.Inject;

/* loaded from: classes3.dex */
public class PrivacyActivity extends MacroDroidDaggerBaseActivity {

    /* renamed from: f  reason: collision with root package name */
    private WebView f13254f;

    /* renamed from: g  reason: collision with root package name */
    private ViewFlipper f13255g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f13256h = false;
    @Inject

    /* renamed from: i  reason: collision with root package name */
    RemoteConfig f13257i;

    /* loaded from: classes3.dex */
    class a extends WebViewClient {
        a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            if (!PrivacyActivity.this.f13256h) {
                PrivacyActivity.this.f13255g.setDisplayedChild(3);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i4, String str, String str2) {
            PrivacyActivity.this.f13256h = true;
            PrivacyActivity.this.f13255g.setDisplayedChild(2);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(String str, View view) {
        r(str);
    }

    private void r(String str) {
        this.f13256h = false;
        this.f13255g.setDisplayedChild(1);
        if (!str.contains("://")) {
            str = "http://" + str;
        }
        this.f13254f.resumeTimers();
        this.f13254f.loadUrl(str);
    }

    public void destroyWebView() {
        this.f13255g.removeAllViews();
        WebSettings settings = this.f13254f.getSettings();
        settings.setJavaScriptEnabled(false);
        settings.setBuiltInZoomControls(false);
        settings.setSupportZoom(false);
        this.f13254f.clearHistory();
        this.f13254f.clearCache(true);
        this.f13254f.loadUrl("about:blank");
        this.f13254f.onPause();
        this.f13254f.removeAllViews();
        this.f13254f.destroyDrawingCache();
        this.f13254f.pauseTimers();
        this.f13254f.destroy();
        this.f13254f = null;
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity, com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        try {
            setContentView(R.layout.remote_web_activity);
            setTitle(R.string.privacy_policy);
            Uri data = getIntent().getData();
            WebView webView = (WebView) findViewById(R.id.remote_web_view);
            this.f13254f = webView;
            webView.getSettings().setJavaScriptEnabled(false);
            this.f13255g = (ViewFlipper) findViewById(R.id.view_flipper);
            Button button = (Button) findViewById(R.id.retry_button);
            this.f13254f.setWebViewClient(new a());
            WebSettings settings = this.f13254f.getSettings();
            settings.setJavaScriptEnabled(false);
            settings.setBuiltInZoomControls(false);
            settings.setSupportZoom(true);
            this.f13254f.setWebChromeClient(new WebChromeClient());
            final String privacyPolicyLink = this.f13257i.getPrivacyPolicyLink();
            if (data != null) {
                str = data.toString();
            } else {
                str = privacyPolicyLink;
            }
            r(str);
            button.setOnClickListener(new View.OnClickListener() { // from class: h0.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PrivacyActivity.this.q(privacyPolicyLink, view);
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
}
