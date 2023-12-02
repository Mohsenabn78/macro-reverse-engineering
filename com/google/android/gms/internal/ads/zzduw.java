package com.google.android.gms.internal.ads;

import android.os.Binder;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzduw {
    private final ScheduledExecutorService zza;
    private final zzfwn zzb;
    private final zzfwn zzc;
    private final zzdvn zzd;
    private final zzgvy zze;

    public zzduw(ScheduledExecutorService scheduledExecutorService, zzfwn zzfwnVar, zzfwn zzfwnVar2, zzdvn zzdvnVar, zzgvy zzgvyVar) {
        this.zza = scheduledExecutorService;
        this.zzb = zzfwnVar;
        this.zzc = zzfwnVar2;
        this.zzd = zzdvnVar;
        this.zze = zzgvyVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zza(zzbue zzbueVar, int i4, Throwable th) throws Exception {
        return ((zzdyh) this.zze.zzb()).zzd(zzbueVar, i4);
    }

    public final zzfwm zzb(final zzbue zzbueVar) {
        zzfwm zzb;
        String str = zzbueVar.zzd;
        com.google.android.gms.ads.internal.zzt.zzp();
        if (com.google.android.gms.ads.internal.util.zzs.zzy(str)) {
            zzb = zzfwc.zzg(new zzdwa(1));
        } else {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzhn)).booleanValue()) {
                zzb = this.zzc.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzduu
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return zzduw.this.zzc(zzbueVar);
                    }
                });
            } else {
                zzb = this.zzd.zzb(zzbueVar);
            }
        }
        final int callingUid = Binder.getCallingUid();
        return zzfwc.zzf((zzfvt) zzfwc.zzn(zzfvt.zzv(zzb), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzfm)).intValue(), TimeUnit.SECONDS, this.zza), Throwable.class, new zzfvj() { // from class: com.google.android.gms.internal.ads.zzduv
            @Override // com.google.android.gms.internal.ads.zzfvj
            public final zzfwm zza(Object obj) {
                return zzduw.this.zza(zzbueVar, callingUid, (Throwable) obj);
            }
        }, this.zzb);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ InputStream zzc(zzbue zzbueVar) throws Exception {
        return (InputStream) this.zzd.zzb(zzbueVar).get(((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzfm)).intValue(), TimeUnit.SECONDS);
    }
}
