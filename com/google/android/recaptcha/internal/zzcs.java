package com.google.android.recaptcha.internal;

import android.content.Context;
import android.net.Uri;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.io.ByteArrayInputStream;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzcs extends WebViewClient {
    final /* synthetic */ zzda zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcs(zzda zzdaVar) {
        this.zza = zzdaVar;
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(@NotNull WebView webView, @NotNull String str) {
        System.currentTimeMillis();
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(@NotNull WebView webView, @NotNull String str) {
        String str2;
        String str3;
        String str4;
        Context context;
        zzr zzrVar;
        zzdk zzdkVar;
        zzai zzaiVar = zzai.zza;
        zzkw zzkwVar = zzkw.INIT_NETWORK;
        str2 = this.zza.zzg;
        str3 = this.zza.zzh;
        str4 = this.zza.zzh;
        zzaf zzafVar = new zzaf(zzkwVar, str2, str3, str4, null);
        context = this.zza.zze;
        zzrVar = this.zza.zzf;
        zzai.zzc(zzafVar, context, zzrVar);
        zzdkVar = this.zza.zzn;
        long zza = zzdkVar.zza(TimeUnit.MICROSECONDS);
        zzj zzjVar = zzj.zza;
        zzj.zza(zzl.zzl.zza(), zza);
    }

    @Override // android.webkit.WebViewClient
    @Deprecated(message = "Use onReceivedError(WebView,request,error) instead")
    public final void onReceivedError(@NotNull WebView webView, int i4, @NotNull String str, @NotNull String str2) {
        Map map;
        super.onReceivedError(webView, i4, str, str2);
        zzf zzfVar = zzf.zze;
        map = this.zza.zzj;
        zzd zzdVar = (zzd) map.get(Integer.valueOf(i4));
        if (zzdVar == null) {
            zzdVar = zzd.zzb;
        }
        zzh zzhVar = new zzh(zzfVar, zzdVar);
        this.zza.zzm().hashCode();
        zzhVar.getMessage();
        this.zza.zzm().completeExceptionally(zzhVar);
    }

    @Override // android.webkit.WebViewClient
    @Deprecated(message = "Use shouldInterceptRequest(WebView,WebResourceRequest) instead")
    @Nullable
    public final WebResourceResponse shouldInterceptRequest(@NotNull WebView webView, @NotNull String str) {
        zzdb zzdbVar = zzdb.zza;
        if (!zzdb.zza(Uri.parse(str))) {
            Uri parse = Uri.parse(str);
            zzh zzhVar = new zzh(zzf.zzc, zzd.zzu);
            this.zza.zzm().hashCode();
            parse.toString();
            this.zza.zzm().completeExceptionally(zzhVar);
            return new WebResourceResponse("text/plain", "UTF-8", new ByteArrayInputStream(new byte[0]));
        }
        return super.shouldInterceptRequest(webView, str);
    }
}
