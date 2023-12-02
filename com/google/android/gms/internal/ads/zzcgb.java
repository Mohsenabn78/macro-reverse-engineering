package com.google.android.gms.internal.ads;

import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcgb extends zzcgc {
    public zzcgb(zzcez zzcezVar, zzawz zzawzVar, boolean z3, @Nullable zzebl zzeblVar) {
        super(zzcezVar, zzawzVar, z3, zzeblVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcfg, android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return zzN(webView, str, null);
    }
}
