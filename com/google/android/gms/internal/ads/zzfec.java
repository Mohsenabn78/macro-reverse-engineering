package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfec {
    final /* synthetic */ zzfed zza;
    private final Object zzb;
    @Nullable
    private final String zzc;
    private final zzfwm zzd;
    private final List zze;
    private final zzfwm zzf;

    private zzfec(zzfed zzfedVar, Object obj, String str, zzfwm zzfwmVar, List list, zzfwm zzfwmVar2) {
        this.zza = zzfedVar;
        this.zzb = obj;
        this.zzc = str;
        this.zzd = zzfwmVar;
        this.zze = list;
        this.zzf = zzfwmVar2;
    }

    public final zzfdq zza() {
        zzfee zzfeeVar;
        Object obj = this.zzb;
        String str = this.zzc;
        if (str == null) {
            str = this.zza.zzf(obj);
        }
        final zzfdq zzfdqVar = new zzfdq(obj, str, this.zzf);
        zzfeeVar = this.zza.zzd;
        zzfeeVar.zza(zzfdqVar);
        zzfwm zzfwmVar = this.zzd;
        Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzfdw
            @Override // java.lang.Runnable
            public final void run() {
                zzfee zzfeeVar2;
                zzfec zzfecVar = zzfec.this;
                zzfdq zzfdqVar2 = zzfdqVar;
                zzfeeVar2 = zzfecVar.zza.zzd;
                zzfeeVar2.zzc(zzfdqVar2);
            }
        };
        zzfwn zzfwnVar = zzcae.zzf;
        zzfwmVar.zzc(runnable, zzfwnVar);
        zzfwc.zzq(zzfdqVar, new zzfea(this, zzfdqVar), zzfwnVar);
        return zzfdqVar;
    }

    public final zzfec zzb(Object obj) {
        return this.zza.zzb(obj, zza());
    }

    public final zzfec zzc(Class cls, zzfvj zzfvjVar) {
        zzfwn zzfwnVar;
        zzfed zzfedVar = this.zza;
        Object obj = this.zzb;
        String str = this.zzc;
        zzfwm zzfwmVar = this.zzd;
        List list = this.zze;
        zzfwm zzfwmVar2 = this.zzf;
        zzfwnVar = zzfedVar.zzb;
        return new zzfec(zzfedVar, obj, str, zzfwmVar, list, zzfwc.zzf(zzfwmVar2, cls, zzfvjVar, zzfwnVar));
    }

    public final zzfec zzd(final zzfwm zzfwmVar) {
        return zzg(new zzfvj() { // from class: com.google.android.gms.internal.ads.zzfdx
            @Override // com.google.android.gms.internal.ads.zzfvj
            public final zzfwm zza(Object obj) {
                return zzfwm.this;
            }
        }, zzcae.zzf);
    }

    public final zzfec zze(final zzfdo zzfdoVar) {
        return zzf(new zzfvj() { // from class: com.google.android.gms.internal.ads.zzfdz
            @Override // com.google.android.gms.internal.ads.zzfvj
            public final zzfwm zza(Object obj) {
                return zzfwc.zzh(zzfdo.this.zza(obj));
            }
        });
    }

    public final zzfec zzf(zzfvj zzfvjVar) {
        zzfwn zzfwnVar;
        zzfwnVar = this.zza.zzb;
        return zzg(zzfvjVar, zzfwnVar);
    }

    public final zzfec zzg(zzfvj zzfvjVar, Executor executor) {
        return new zzfec(this.zza, this.zzb, this.zzc, this.zzd, this.zze, zzfwc.zzm(this.zzf, zzfvjVar, executor));
    }

    public final zzfec zzh(String str) {
        return new zzfec(this.zza, this.zzb, str, this.zzd, this.zze, this.zzf);
    }

    public final zzfec zzi(long j4, TimeUnit timeUnit) {
        ScheduledExecutorService scheduledExecutorService;
        zzfed zzfedVar = this.zza;
        Object obj = this.zzb;
        String str = this.zzc;
        zzfwm zzfwmVar = this.zzd;
        List list = this.zze;
        zzfwm zzfwmVar2 = this.zzf;
        scheduledExecutorService = zzfedVar.zzc;
        return new zzfec(zzfedVar, obj, str, zzfwmVar, list, zzfwc.zzn(zzfwmVar2, j4, timeUnit, scheduledExecutorService));
    }
}
