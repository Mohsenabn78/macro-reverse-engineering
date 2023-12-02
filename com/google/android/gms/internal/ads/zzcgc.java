package com.google.android.gms.internal.ads;

import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import java.io.File;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public class zzcgc extends zzcfg {
    public zzcgc(zzcez zzcezVar, zzawz zzawzVar, boolean z3, @Nullable zzebl zzeblVar) {
        super(zzcezVar, zzawzVar, z3, new zzbqv(zzcezVar, zzcezVar.zzE(), new zzbaw(zzcezVar.getContext())), null, zzeblVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final WebResourceResponse zzN(WebView webView, String str, @Nullable Map map) {
        String str2;
        if (!(webView instanceof zzcez)) {
            zzbzr.zzj("Tried to intercept request from a WebView that wasn't an AdWebView.");
            return null;
        }
        zzcez zzcezVar = (zzcez) webView;
        zzbws zzbwsVar = this.zza;
        if (zzbwsVar != null) {
            zzbwsVar.zzd(str, map, 1);
        }
        if (!"mraid.js".equalsIgnoreCase(new File(str).getName())) {
            if (map == null) {
                map = Collections.emptyMap();
            }
            return super.zzc(str, map);
        }
        if (zzcezVar.zzN() != null) {
            zzcezVar.zzN().zzE();
        }
        if (zzcezVar.zzO().zzi()) {
            str2 = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzP);
        } else if (zzcezVar.zzaA()) {
            str2 = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzO);
        } else {
            str2 = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzN);
        }
        com.google.android.gms.ads.internal.zzt.zzp();
        return com.google.android.gms.ads.internal.util.zzs.zzt(zzcezVar.getContext(), zzcezVar.zzn().zza, str2);
    }
}
