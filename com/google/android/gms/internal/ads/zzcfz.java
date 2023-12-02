package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.JavascriptInterface;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcfz {
    private final zzcga zza;
    private final zzcfy zzb;

    public zzcfz(zzcga zzcgaVar, zzcfy zzcfyVar) {
        this.zzb = zzcfyVar;
        this.zza = zzcgaVar;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.gms.internal.ads.zzcgh, com.google.android.gms.internal.ads.zzcga] */
    @JavascriptInterface
    public String getClickSignals(String str) {
        if (TextUtils.isEmpty(str)) {
            com.google.android.gms.ads.internal.util.zze.zza("Click string is empty, not proceeding.");
            return "";
        }
        ?? r02 = this.zza;
        zzaqs zzI = r02.zzI();
        if (zzI == null) {
            com.google.android.gms.ads.internal.util.zze.zza("Signal utils is empty, ignoring.");
            return "";
        }
        zzaqo zzc = zzI.zzc();
        if (r02.getContext() == null) {
            com.google.android.gms.ads.internal.util.zze.zza("Context is null, ignoring.");
            return "";
        }
        Context context = this.zza.getContext();
        zzcga zzcgaVar = this.zza;
        return zzc.zzf(context, str, (View) zzcgaVar, zzcgaVar.zzi());
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.ads.zzcgh, com.google.android.gms.internal.ads.zzcga] */
    @JavascriptInterface
    public String getViewSignals() {
        ?? r02 = this.zza;
        zzaqs zzI = r02.zzI();
        if (zzI == null) {
            com.google.android.gms.ads.internal.util.zze.zza("Signal utils is empty, ignoring.");
            return "";
        }
        zzaqo zzc = zzI.zzc();
        if (r02.getContext() == null) {
            com.google.android.gms.ads.internal.util.zze.zza("Context is null, ignoring.");
            return "";
        }
        Context context = this.zza.getContext();
        zzcga zzcgaVar = this.zza;
        return zzc.zzh(context, (View) zzcgaVar, zzcgaVar.zzi());
    }

    @JavascriptInterface
    public void notify(final String str) {
        if (TextUtils.isEmpty(str)) {
            zzbzr.zzj("URL is empty, ignoring message");
        } else {
            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfx
                @Override // java.lang.Runnable
                public final void run() {
                    zzcfz.this.zza(str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(String str) {
        zzcfy zzcfyVar = this.zzb;
        Uri parse = Uri.parse(str);
        zzcfg zzaJ = ((zzcfs) zzcfyVar.zza).zzaJ();
        if (zzaJ == null) {
            zzbzr.zzg("Unable to pass GMSG, no AdWebViewClient for AdWebView!");
        } else {
            zzaJ.zzj(parse);
        }
    }
}
