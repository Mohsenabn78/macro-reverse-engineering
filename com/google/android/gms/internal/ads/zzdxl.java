package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdxl extends zzdxr {
    private zzbtm zzh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdxl(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.zze = context;
        this.zzf = com.google.android.gms.ads.internal.zzt.zzt().zzb();
        this.zzg = scheduledExecutorService;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final synchronized void onConnected(@Nullable Bundle bundle) {
        if (!this.zzc) {
            this.zzc = true;
            try {
                this.zzd.zzp().zze(this.zzh, new zzdxq(this));
            } catch (RemoteException unused) {
                this.zza.zze(new zzdwa(1));
            }
        }
    }

    public final synchronized zzfwm zza(zzbtm zzbtmVar, long j4) {
        if (this.zzb) {
            return zzfwc.zzn(this.zza, j4, TimeUnit.MILLISECONDS, this.zzg);
        }
        this.zzb = true;
        this.zzh = zzbtmVar;
        zzb();
        zzfwm zzn = zzfwc.zzn(this.zza, j4, TimeUnit.MILLISECONDS, this.zzg);
        zzn.zzc(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdxk
            @Override // java.lang.Runnable
            public final void run() {
                zzdxl.this.zzc();
            }
        }, zzcae.zzf);
        return zzn;
    }
}
