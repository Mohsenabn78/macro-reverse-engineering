package com.pollfish.internal;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.pollfish.internal.b4;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public final class b4 extends WebView implements z3, z {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final u3 f36698a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final r3 f36699b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public y3 f36700c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public t1 f36701d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f36702e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    public a4 f36703f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f36704g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    public String f36705h;

    /* loaded from: classes6.dex */
    public static final class a extends Lambda implements Function0<Unit> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f36707b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str) {
            super(0);
            this.f36707b = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            b4 b4Var = b4.this;
            if (!b4Var.f36704g) {
                String str = this.f36707b;
                b4Var.f36705h = str;
                b4Var.loadUrl(str);
            }
            return Unit.INSTANCE;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends Lambda implements Function0<Unit> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            y3 y3Var = b4.this.f36700c;
            if (y3Var != null) {
                y3Var.onHideCustomView();
            }
            return Unit.INSTANCE;
        }
    }

    public b4(@NotNull Context context, @NotNull u3 u3Var, @NotNull s3 s3Var) {
        super(context);
        this.f36698a = u3Var;
        this.f36699b = s3Var;
        this.f36703f = new a4(u3Var);
        this.f36705h = "";
        setLayerType(2, null);
        setBackgroundColor(0);
        WebView.setWebContentsDebuggingEnabled(false);
        f();
        g();
        h();
        i();
        addJavascriptInterface(this, "Native");
        j();
        setOnKeyListener(new View.OnKeyListener() { // from class: k1.d
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i4, KeyEvent keyEvent) {
                return b4.a(b4.this, view, i4, keyEvent);
            }
        });
    }

    public static final boolean a(b4 b4Var, View view, int i4, KeyEvent keyEvent) {
        if (i4 == 66 && keyEvent.getAction() == 0) {
            b4Var.a("javascript:Pollfish.mobile.interface.loseFocus(true);");
            return true;
        } else if (keyEvent.getAction() == 6 || keyEvent.getAction() == 3) {
            b4Var.a("javascript:Pollfish.mobile.interface.loseFocus(true);");
            return true;
        } else {
            return false;
        }
    }

    public final void b(@NotNull final String str) {
        post(new Runnable() { // from class: k1.c
            @Override // java.lang.Runnable
            public final void run() {
                b4.a(b4.this, str);
            }
        });
    }

    @Override // com.pollfish.internal.z
    public final void c() {
        a("javascript:Pollfish.mobile.interface.loseFocus(true);");
    }

    @Override // com.pollfish.internal.z3, com.pollfish.internal.s2
    @JavascriptInterface
    public void close() {
        this.f36698a.l();
    }

    @Override // com.pollfish.internal.z3, com.pollfish.internal.s2
    @JavascriptInterface
    public void closeAndNoShow() {
        this.f36698a.v();
    }

    @Override // com.pollfish.internal.z3
    public final void d() {
        this.f36698a.o();
    }

    @Override // android.webkit.WebView
    public final void destroy() {
        this.f36704g = true;
        super.destroy();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEventPreIme(@Nullable KeyEvent keyEvent) {
        if (keyEvent != null && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && this.f36702e) {
            a("javascript:Pollfish.mobile.interface.loseFocus(true);");
            this.f36702e = false;
            return true;
        }
        return super.dispatchKeyEventPreIme(keyEvent);
    }

    @Override // com.pollfish.internal.z3
    public final void e() {
        String str;
        g2 d4 = this.f36698a.d();
        if (d4 != null && (str = d4.D) != null) {
            loadDataWithBaseURL(null, str, "text/html", "utf-8", null);
        }
    }

    public final void f() {
        if (!CookieManager.getInstance().acceptCookie()) {
            CookieManager.getInstance().setAcceptCookie(true);
        }
        CookieManager.getInstance().setAcceptThirdPartyCookies(this, true);
    }

    public final void g() {
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
    }

    @NotNull
    public final String getCurrentUrl() {
        return this.f36705h;
    }

    @Override // com.pollfish.internal.z3, com.pollfish.internal.s2
    @JavascriptInterface
    @NotNull
    public String getDeviceInfo() {
        String a4;
        i0 deviceInfo = this.f36698a.getDeviceInfo();
        if (deviceInfo == null || (a4 = deviceInfo.a()) == null) {
            this.f36698a.n();
            return "";
        }
        return a4;
    }

    @Override // com.pollfish.internal.z3, com.pollfish.internal.s2
    @JavascriptInterface
    @NotNull
    public String getFromServer() {
        String str;
        g2 d4 = this.f36698a.d();
        if (d4 == null || (str = d4.f36856g) == null) {
            this.f36698a.n();
            return "";
        }
        return str;
    }

    @Nullable
    public final t1 getMediationWebChromeClient() {
        return this.f36701d;
    }

    public final void h() {
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
        setWebViewClient(this.f36703f);
    }

    @Override // com.pollfish.internal.z3, com.pollfish.internal.s2
    @JavascriptInterface
    public void hideMediationViews() {
        this.f36698a.hideMediationViews();
    }

    public final void i() {
        setHapticFeedbackEnabled(false);
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    public final void j() {
        Unit unit;
        onResume();
        resumeTimers();
        if (this.f36698a.d() != null) {
            StringBuilder a4 = u4.a("file://");
            a4.append(getContext().getCacheDir().getPath());
            a4.append("/pollfish/index.html");
            loadUrl(a4.toString());
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.f36698a.n();
        } else {
            setBackgroundColor(0);
        }
    }

    public final void k() {
        a("javascript:Pollfish.mobile.interface.panelClosed();");
    }

    @Override // com.pollfish.internal.z3, com.pollfish.internal.s2
    @JavascriptInterface
    public void notifyVideoEnd() {
        s5.a(this, new b());
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onCheckIsTextEditor() {
        return false;
    }

    @Override // android.webkit.WebView, android.view.View
    @NotNull
    public final InputConnection onCreateInputConnection(@Nullable EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (onCreateInputConnection != null) {
            return new r2(onCreateInputConnection, this);
        }
        return new BaseInputConnection(this, true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a("javascript:Pollfish.mobile.interface.webViewFocus(false)");
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onWindowFocusChanged(boolean z3) {
        a("javascript:Pollfish.mobile.interface.webViewFocus(" + z3 + ')');
        super.onWindowFocusChanged(z3);
    }

    @Override // com.pollfish.internal.z3, com.pollfish.internal.s2
    @JavascriptInterface
    public void openWebsite(@NotNull String str) {
        s5.a(this, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0024, code lost:
        if (r0 == null) goto L8;
     */
    @Override // com.pollfish.internal.z3, com.pollfish.internal.s2
    @android.webkit.JavascriptInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void openWebsiteInWebview(@org.jetbrains.annotations.NotNull java.lang.String r6) {
        /*
            r5 = this;
            kotlin.Pair r6 = com.pollfish.internal.j3.a.a(r6)
            java.lang.Object r0 = r6.getSecond()
            java.lang.Exception r0 = (java.lang.Exception) r0
            if (r0 == 0) goto L26
            com.pollfish.internal.u3 r1 = r5.f36698a
            com.pollfish.internal.f4$a r2 = com.pollfish.internal.f4.a.WARNING
            com.pollfish.internal.l4$a$q r3 = new com.pollfish.internal.l4$a$q
            java.lang.Object r4 = r6.getFirst()
            com.pollfish.internal.j3 r4 = (com.pollfish.internal.j3) r4
            r3.<init>(r4, r0)
            r1.a(r2, r3)
            java.lang.Object r0 = r6.getFirst()
            com.pollfish.internal.j3 r0 = (com.pollfish.internal.j3) r0
            if (r0 != 0) goto L2d
        L26:
            java.lang.Object r6 = r6.getFirst()
            r0 = r6
            com.pollfish.internal.j3 r0 = (com.pollfish.internal.j3) r0
        L2d:
            com.pollfish.internal.u3 r6 = r5.f36698a
            r6.a(r0)
            java.lang.String r6 = r0.c()
            r5.b(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pollfish.internal.b4.openWebsiteInWebview(java.lang.String):void");
    }

    @Override // com.pollfish.internal.z3, com.pollfish.internal.s2
    @JavascriptInterface
    public void sendToServer(@NotNull String str, @NotNull String str2, boolean z3) {
        boolean endsWith$default;
        boolean endsWith$default2;
        endsWith$default = kotlin.text.m.endsWith$default(str, "/device/set/survey/received", false, 2, null);
        if (!endsWith$default) {
            endsWith$default2 = kotlin.text.m.endsWith$default(str, "/device/set/session/received", false, 2, null);
            if (!endsWith$default2) {
                this.f36698a.a(str, str2);
            }
        }
    }

    @Override // com.pollfish.internal.z3, com.pollfish.internal.s2
    @JavascriptInterface
    public void sentDataOfUserConsentToServer(@NotNull String str, @NotNull String str2) {
    }

    public final void setPollfishWebChromeClient(@NotNull y3 y3Var) {
        this.f36700c = y3Var;
        setWebChromeClient(y3Var);
    }

    @Override // com.pollfish.internal.z3, com.pollfish.internal.s2
    @JavascriptInterface
    public void setSurveyCompleted(@Nullable String str) {
        Unit unit;
        if (str != null) {
            this.f36698a.onPollfishSurveyCompleted(z1.a(str));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            setSurveyCompleted();
        }
    }

    @Override // com.pollfish.internal.z3, com.pollfish.internal.s2
    @JavascriptInterface
    public void showToastMsg(@NotNull String str) {
        this.f36699b.a(str);
    }

    @Override // com.pollfish.internal.z3, com.pollfish.internal.s2
    @JavascriptInterface
    public void textFieldFocus() {
        this.f36702e = true;
    }

    @Override // com.pollfish.internal.z3, com.pollfish.internal.s2
    @JavascriptInterface
    public void textFieldUnFocus() {
        this.f36702e = false;
        ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
    }

    @Override // com.pollfish.internal.z3, com.pollfish.internal.s2
    @JavascriptInterface
    public void userNotEligible() {
        this.f36698a.p();
    }

    @Override // com.pollfish.internal.z3, com.pollfish.internal.s2
    @JavascriptInterface
    public void userRejectedSurvey() {
        this.f36698a.g();
    }

    @Override // com.pollfish.internal.z3, com.pollfish.internal.s2
    @JavascriptInterface
    public void webViewLoaded() {
        this.f36698a.h();
    }

    public static final void b(b4 b4Var, String str) {
        b4Var.loadUrl(str);
    }

    @Override // com.pollfish.internal.z3, com.pollfish.internal.s2
    @JavascriptInterface
    public void sentDataOfUserConsentToServer(@NotNull String str, @NotNull String str2, @NotNull String str3) {
    }

    @Override // com.pollfish.internal.z3
    public final void b() {
        this.f36698a.n();
    }

    public final void setPollfishWebChromeClient(@NotNull t1 t1Var) {
        this.f36701d = t1Var;
        setWebChromeClient(t1Var);
    }

    @Override // com.pollfish.internal.z3, com.pollfish.internal.s2
    @JavascriptInterface
    public void setSurveyCompleted() {
        this.f36698a.onPollfishSurveyCompleted(null);
    }

    public final void a(@NotNull String str) {
        s5.a(this, new a(str));
    }

    public static final void a(final b4 b4Var, final String str) {
        b4Var.setBackgroundColor(-1);
        b4Var.clearHistory();
        b4Var.clearCache(true);
        b4Var.f36705h = str;
        b4Var.f36703f.a(str);
        b4Var.loadUrl("about:blank");
        b4Var.postDelayed(new Runnable() { // from class: k1.b
            @Override // java.lang.Runnable
            public final void run() {
                b4.b(b4.this, str);
            }
        }, 300L);
    }

    @Override // com.pollfish.internal.z
    public final void a() {
        a("javascript:Pollfish.mobile.interface.loseFocus(true);");
    }

    @Override // com.pollfish.internal.z3, com.pollfish.internal.s2
    @JavascriptInterface
    public void noSurveyFound() {
    }

    @Override // com.pollfish.internal.z3, com.pollfish.internal.s2
    @JavascriptInterface
    public void openWeb() {
    }
}
