package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbyq implements Runnable {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzcaj zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbyq(zzbyr zzbyrVar, Context context, zzcaj zzcajVar) {
        this.zza = context;
        this.zzb = zzcajVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzb.zzd(AdvertisingIdClient.getAdvertisingIdInfo(this.zza));
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e4) {
            this.zzb.zze(e4);
            zzbzr.zzh("Exception while getting advertising Id info", e4);
        }
    }
}
