package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import java.util.Locale;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdxo extends zzdxr {
    private zzbti zzh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdxo(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.zze = context;
        this.zzf = com.google.android.gms.ads.internal.zzt.zzt().zzb();
        this.zzg = scheduledExecutorService;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final synchronized void onConnected(@Nullable Bundle bundle) {
        if (!this.zzc) {
            this.zzc = true;
            try {
                this.zzd.zzp().zzf(this.zzh, new zzdxq(this));
            } catch (RemoteException unused) {
                this.zza.zze(new zzdwa(1));
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdxr, com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i4) {
        String format = String.format(Locale.US, "Remote ad service connection suspended, cause: %d.", Integer.valueOf(i4));
        zzbzr.zze(format);
        this.zza.zze(new zzdwa(1, format));
    }

    public final synchronized zzfwm zza(zzbti zzbtiVar, long j4) {
        if (this.zzb) {
            return zzfwc.zzn(this.zza, j4, TimeUnit.MILLISECONDS, this.zzg);
        }
        this.zzb = true;
        this.zzh = zzbtiVar;
        zzb();
        zzfwm zzn = zzfwc.zzn(this.zza, j4, TimeUnit.MILLISECONDS, this.zzg);
        zzn.zzc(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdxn
            @Override // java.lang.Runnable
            public final void run() {
                zzdxo.this.zzc();
            }
        }, zzcae.zzf);
        return zzn;
    }
}
