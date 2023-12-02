package com.google.android.gms.ads.h5;

import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.gms.internal.ads.zzbjc;
import com.google.android.gms.internal.ads.zzbjp;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
@RequiresApi(api = 21)
/* loaded from: classes4.dex */
public final class H5AdsWebViewClient extends zzbjc {

    /* renamed from: a  reason: collision with root package name */
    private final zzbjp f19026a;

    public H5AdsWebViewClient(@NonNull Context context, @NonNull WebView webView) {
        this.f19026a = new zzbjp(context, webView);
    }

    public void clearAdObjects() {
        this.f19026a.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzbjc
    @NonNull
    protected WebViewClient getDelegate() {
        return this.f19026a;
    }

    @Nullable
    public WebViewClient getDelegateWebViewClient() {
        return this.f19026a.getDelegate();
    }

    public void setDelegateWebViewClient(@Nullable WebViewClient webViewClient) {
        this.f19026a.zzb(webViewClient);
    }
}
