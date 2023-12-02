package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;
import android.webkit.WebView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaux implements Runnable {
    final ValueCallback zza;
    final /* synthetic */ zzaup zzb;
    final /* synthetic */ WebView zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ zzauz zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaux(zzauz zzauzVar, final zzaup zzaupVar, final WebView webView, final boolean z3) {
        this.zze = zzauzVar;
        this.zzb = zzaupVar;
        this.zzc = webView;
        this.zzd = z3;
        this.zza = new ValueCallback() { // from class: com.google.android.gms.internal.ads.zzauw
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                zzaux zzauxVar = zzaux.this;
                zzaup zzaupVar2 = zzaupVar;
                WebView webView2 = webView;
                boolean z4 = z3;
                zzauxVar.zze.zzd(zzaupVar2, webView2, (String) obj, z4);
            }
        };
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzc.getSettings().getJavaScriptEnabled()) {
            try {
                this.zzc.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.zza);
            } catch (Throwable unused) {
                this.zza.onReceiveValue("");
            }
        }
    }
}
