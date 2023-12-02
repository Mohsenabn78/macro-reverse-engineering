package com.google.android.gms.internal.ads;

import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzblz implements Runnable {
    final /* synthetic */ zzbmk zza;
    final /* synthetic */ zzblg zzb;
    final /* synthetic */ ArrayList zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ zzbml zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzblz(zzbml zzbmlVar, zzbmk zzbmkVar, zzblg zzblgVar, ArrayList arrayList, long j4) {
        this.zze = zzbmlVar;
        this.zza = zzbmkVar;
        this.zzb = zzblgVar;
        this.zzc = arrayList;
        this.zzd = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        int i4;
        String str;
        obj = this.zze.zza;
        synchronized (obj) {
            if (this.zza.zze() != -1 && this.zza.zze() != 1) {
                this.zza.zzg();
                zzfwn zzfwnVar = zzcae.zze;
                final zzblg zzblgVar = this.zzb;
                zzfwnVar.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbly
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzblg.this.zzc();
                    }
                });
                String valueOf = String.valueOf(com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzd));
                int zze = this.zza.zze();
                i4 = this.zze.zzi;
                if (this.zzc.isEmpty()) {
                    str = ". Still waiting for the engine to be loaded";
                } else {
                    str = ". While waiting for the /jsLoaded gmsg, observed the loadNewJavascriptEngine latency is " + String.valueOf(this.zzc.get(0));
                }
                com.google.android.gms.ads.internal.util.zze.zza("Could not finish the full JS engine loading in " + valueOf + " ms. JS engine session reference status(fullLoadTimeout) is " + zze + ". Update status(fullLoadTimeout) is " + i4 + str + " ms. Total latency(fullLoadTimeout) is " + (com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis() - this.zzd) + " ms at timeout. Rejecting.");
            }
        }
    }
}
