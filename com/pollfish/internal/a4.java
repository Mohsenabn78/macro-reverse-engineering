package com.pollfish.internal;

import android.net.Uri;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.pollfish.internal.f4;
import com.pollfish.internal.l4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public final class a4 extends WebViewClient {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final u3 f36690a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public String f36691b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f36692c;

    public a4(@NotNull u3 u3Var) {
        this.f36690a = u3Var;
    }

    public final void a(@Nullable String str) {
        this.f36691b = str;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(@Nullable WebView webView, @Nullable String str) {
        z3 z3Var;
        super.onPageFinished(webView, str);
        if (webView != null) {
            c4 c4Var = null;
            if (webView instanceof z3) {
                z3Var = (z3) webView;
            } else {
                z3Var = null;
            }
            if (z3Var != null) {
                if (this.f36692c) {
                    z3Var.b();
                    return;
                } else {
                    z3Var.d();
                    return;
                }
            }
            if (webView instanceof c4) {
                c4Var = (c4) webView;
            }
            if (c4Var != null) {
                if (this.f36692c) {
                    c4Var.f36744a.n();
                } else {
                    c4Var.f36744a.o();
                }
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(@Nullable WebView webView, @Nullable WebResourceRequest webResourceRequest, @Nullable WebResourceError webResourceError) {
        z3 z3Var;
        boolean contains$default;
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        if (webView != null) {
            c4 c4Var = null;
            if (webView instanceof z3) {
                z3Var = (z3) webView;
            } else {
                z3Var = null;
            }
            if (z3Var != null) {
                if (webResourceRequest != null) {
                    String uri = webResourceRequest.getUrl().toString();
                    String str = this.f36691b;
                    if (str == null) {
                        str = "should_go_false";
                    }
                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) uri, (CharSequence) str, false, 2, (Object) null);
                    if (contains$default) {
                        z3Var.e();
                        return;
                    }
                    return;
                }
                return;
            }
            if (webView instanceof c4) {
                c4Var = (c4) webView;
            }
            if (c4Var != null && webResourceRequest != null && !Intrinsics.areEqual(webResourceRequest.getUrl().toString(), this.f36691b)) {
                this.f36692c = true;
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpError(@Nullable WebView webView, @Nullable WebResourceRequest webResourceRequest, @Nullable WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        if (webView != null && (webView instanceof z3) && webResourceRequest != null && Intrinsics.areEqual(webResourceRequest.getUrl().toString(), this.f36691b)) {
            this.f36690a.a(f4.a.ERROR, new l4.a.g0(webResourceRequest, webResourceResponse));
            ((z3) webView).e();
        }
    }

    @Override // android.webkit.WebViewClient
    @Nullable
    public final WebResourceResponse shouldInterceptRequest(@Nullable WebView webView, @Nullable WebResourceRequest webResourceRequest) {
        Uri url;
        String uri;
        if (webResourceRequest != null && (url = webResourceRequest.getUrl()) != null && (uri = url.toString()) != null) {
            this.f36690a.a(f4.a.DEBUG, new l4.a.f0(uri));
        }
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }
}
