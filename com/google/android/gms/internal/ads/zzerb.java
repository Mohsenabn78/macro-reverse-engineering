package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.GuardedBy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzerb {
    private final Context zza;
    private final Set zzb;
    private final Executor zzc;
    private final zzffy zzd;
    private final zzdqa zze;
    private long zzf = 0;
    @GuardedBy("this")
    private int zzg = 0;

    public zzerb(Context context, Executor executor, Set set, zzffy zzffyVar, zzdqa zzdqaVar) {
        this.zza = context;
        this.zzc = executor;
        this.zzb = set;
        this.zzd = zzffyVar;
        this.zze = zzdqaVar;
    }

    public final zzfwm zza(final Object obj) {
        zzffn zza = zzffm.zza(this.zza, 8);
        zza.zzh();
        final ArrayList arrayList = new ArrayList(this.zzb.size());
        List arrayList2 = new ArrayList();
        zzbbe zzbbeVar = zzbbm.zzkf;
        if (!((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbeVar)).isEmpty()) {
            arrayList2 = Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbeVar)).split(","));
        }
        this.zzf = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime();
        for (final zzeqy zzeqyVar : this.zzb) {
            if (!arrayList2.contains(String.valueOf(zzeqyVar.zza()))) {
                final long elapsedRealtime = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime();
                zzfwm zzb = zzeqyVar.zzb();
                zzb.zzc(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeqz
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzerb.this.zzb(elapsedRealtime, zzeqyVar);
                    }
                }, zzcae.zzf);
                arrayList.add(zzb);
            }
        }
        zzfwm zza2 = zzfwc.zzb(arrayList).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzera
            @Override // java.util.concurrent.Callable
            public final Object call() {
                List<zzfwm> list = arrayList;
                Object obj2 = obj;
                for (zzfwm zzfwmVar : list) {
                    zzeqx zzeqxVar = (zzeqx) zzfwmVar.get();
                    if (zzeqxVar != null) {
                        zzeqxVar.zzh(obj2);
                    }
                }
                return obj2;
            }
        }, this.zzc);
        if (zzfgb.zza()) {
            zzffx.zza(zza2, this.zzd, zza);
        }
        return zza2;
    }

    public final void zzb(long j4, zzeqy zzeqyVar) {
        long elapsedRealtime = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - j4;
        if (((Boolean) zzbdi.zza.zze()).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.zza("Signal runtime (ms) : " + zzfpw.zzc(zzeqyVar.getClass().getCanonicalName()) + " = " + elapsedRealtime);
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzbT)).booleanValue()) {
            return;
        }
        zzdpz zza = this.zze.zza();
        zza.zzb("action", "lat_ms");
        zza.zzb("lat_grp", "sig_lat_grp");
        zza.zzb("lat_id", String.valueOf(zzeqyVar.zza()));
        zza.zzb("clat_ms", String.valueOf(elapsedRealtime));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzbU)).booleanValue()) {
            synchronized (this) {
                this.zzg++;
            }
            zza.zzb("seq_num", com.google.android.gms.ads.internal.zzt.zzo().zzg().zzc());
            synchronized (this) {
                if (this.zzg == this.zzb.size() && this.zzf != 0) {
                    this.zzg = 0;
                    String valueOf = String.valueOf(com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - this.zzf);
                    if (zzeqyVar.zza() > 39 && zzeqyVar.zza() < 52) {
                        zza.zzb("lat_gmssg", valueOf);
                    } else {
                        zza.zzb("lat_clsg", valueOf);
                    }
                }
            }
        }
        zza.zzh();
    }
}
