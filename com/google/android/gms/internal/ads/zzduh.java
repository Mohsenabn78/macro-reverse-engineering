package com.google.android.gms.internal.ads;

import android.content.Context;
import android.webkit.CookieManager;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzduh implements zzgwe {
    private final zzgwr zza;
    private final zzgwr zzb;

    public zzduh(zzgwr zzgwrVar, zzgwr zzgwrVar2) {
        this.zza = zzgwrVar;
        this.zzb = zzgwrVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzgwr
    public final /* bridge */ /* synthetic */ Object zzb() {
        final CookieManager zzb = com.google.android.gms.ads.internal.zzt.zzq().zzb((Context) this.zzb.zzb());
        zzfef zzfefVar = zzfef.WEBVIEW_COOKIE;
        zzfec zzi = zzfdv.zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzdue
            @Override // java.util.concurrent.Callable
            public final Object call() {
                CookieManager cookieManager = zzb;
                if (cookieManager == null) {
                    return "";
                }
                return cookieManager.getCookie((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzaK));
            }
        }, zzfefVar, (zzfel) this.zza.zzb()).zzi(1L, TimeUnit.SECONDS);
        final zzduf zzdufVar = new zzfdo() { // from class: com.google.android.gms.internal.ads.zzduf
            @Override // com.google.android.gms.internal.ads.zzfdo
            public final Object zza(Object obj) {
                Exception exc = (Exception) obj;
                return "";
            }
        };
        return zzi.zzc(Exception.class, new zzfvj() { // from class: com.google.android.gms.internal.ads.zzfdy
            @Override // com.google.android.gms.internal.ads.zzfvj
            public final zzfwm zza(Object obj) {
                Exception exc = (Exception) ((Throwable) obj);
                return zzfwc.zzh("");
            }
        }).zza();
    }
}
