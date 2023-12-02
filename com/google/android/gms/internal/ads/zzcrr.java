package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcrr {
    private final Executor zza;
    private final ScheduledExecutorService zzb;
    private final zzfwm zzc;
    private volatile boolean zzd = true;

    public zzcrr(Executor executor, ScheduledExecutorService scheduledExecutorService, zzfwm zzfwmVar) {
        this.zza = executor;
        this.zzb = scheduledExecutorService;
        this.zzc = zzfwmVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzb(final zzcrr zzcrrVar, List list, final zzfvy zzfvyVar) {
        if (list != null && !list.isEmpty()) {
            zzfwm zzh = zzfwc.zzh(null);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                final zzfwm zzfwmVar = (zzfwm) it.next();
                zzh = zzfwc.zzm(zzfwc.zzf(zzh, Throwable.class, new zzfvj() { // from class: com.google.android.gms.internal.ads.zzcrm
                    @Override // com.google.android.gms.internal.ads.zzfvj
                    public final zzfwm zza(Object obj) {
                        zzfvy.this.zza((Throwable) obj);
                        return zzfwc.zzh(null);
                    }
                }, zzcrrVar.zza), new zzfvj() { // from class: com.google.android.gms.internal.ads.zzcrn
                    @Override // com.google.android.gms.internal.ads.zzfvj
                    public final zzfwm zza(Object obj) {
                        return zzcrr.this.zza(zzfvyVar, zzfwmVar, (zzcrd) obj);
                    }
                }, zzcrrVar.zza);
            }
            zzfwc.zzq(zzh, new zzcrq(zzcrrVar, zzfvyVar), zzcrrVar.zza);
            return;
        }
        zzcrrVar.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcrl
            @Override // java.lang.Runnable
            public final void run() {
                zzfvy.this.zza(new zzdtx(3));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zza(zzfvy zzfvyVar, zzfwm zzfwmVar, zzcrd zzcrdVar) throws Exception {
        if (zzcrdVar != null) {
            zzfvyVar.zzb(zzcrdVar);
        }
        return zzfwc.zzn(zzfwmVar, ((Long) zzbdr.zzb.zze()).longValue(), TimeUnit.MILLISECONDS, this.zzb);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzd() {
        this.zzd = false;
    }

    public final void zze(zzfvy zzfvyVar) {
        zzfwc.zzq(this.zzc, new zzcrp(this, zzfvyVar), this.zza);
    }

    public final boolean zzf() {
        return this.zzd;
    }
}
