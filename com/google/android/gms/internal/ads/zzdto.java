package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.LoadAdError;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdto extends AdListener {
    final /* synthetic */ String zza;
    final /* synthetic */ zzdtr zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdto(zzdtr zzdtrVar, String str) {
        this.zzb = zzdtrVar;
        this.zza = str;
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        String zzl;
        zzdtr zzdtrVar = this.zzb;
        zzl = zzdtr.zzl(loadAdError);
        zzdtrVar.zzm(zzl, this.zza);
    }
}
