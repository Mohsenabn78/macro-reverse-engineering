package com.pollfish.internal;

import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes6.dex */
public final class c4 extends WebView {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final u3 f36744a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public a4 f36745b;

    public c4(@NotNull Context context, @NotNull u3 u3Var) {
        super(context);
        this.f36744a = u3Var;
        this.f36745b = new a4(u3Var);
        setLayerType(2, null);
        setBackgroundColor(0);
        WebView.setWebContentsDebuggingEnabled(false);
        a();
        b();
        addJavascriptInterface(this, "Native");
        c();
    }

    public final void a() {
        if (!CookieManager.getInstance().acceptCookie()) {
            CookieManager.getInstance().setAcceptCookie(true);
        }
        CookieManager.getInstance().setAcceptThirdPartyCookies(this, true);
    }

    public final void b() {
        WebSettings settings = getSettings();
        settings.setSupportZoom(false);
        settings.setBuiltInZoomControls(false);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setDefaultTextEncodingName("utf-8");
        settings.setAllowFileAccess(true);
        settings.setAllowContentAccess(true);
        settings.setAllowUniversalAccessFromFileURLs(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setAllowFileAccessFromFileURLs(true);
        setOverScrollMode(2);
        setWebViewClient(this.f36745b);
    }

    public final void c() {
        Unit unit;
        onResume();
        resumeTimers();
        if (this.f36744a.d() != null) {
            StringBuilder a4 = u4.a("file://");
            a4.append(getContext().getCacheDir().getPath());
            a4.append("/pollfish/index.html");
            loadUrl(a4.toString());
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.f36744a.n();
        }
    }

    @JavascriptInterface
    @NotNull
    public final String getDeviceInfo() {
        String a4;
        i0 deviceInfo = this.f36744a.getDeviceInfo();
        if (deviceInfo == null || (a4 = deviceInfo.a()) == null) {
            this.f36744a.n();
            return "";
        }
        return a4;
    }

    @JavascriptInterface
    @NotNull
    public final String getFromServer() {
        String str;
        g2 d4 = this.f36744a.d();
        if (d4 == null || (str = d4.f36856g) == null) {
            this.f36744a.n();
            return "";
        }
        return str;
    }

    @JavascriptInterface
    public final void noSurveyFound() {
        this.f36744a.r();
    }

    @JavascriptInterface
    public final void sendToServer(@NotNull String str, @NotNull String str2, boolean z3) {
        boolean endsWith$default;
        boolean endsWith$default2;
        endsWith$default = kotlin.text.m.endsWith$default(str, "/device/set/survey/received", false, 2, null);
        if (!endsWith$default) {
            endsWith$default2 = kotlin.text.m.endsWith$default(str, "/device/set/session/received", false, 2, null);
            if (!endsWith$default2) {
                return;
            }
        }
        this.f36744a.a(str, str2);
    }

    @JavascriptInterface
    public final void webViewLoaded() {
        this.f36744a.h();
    }
}
