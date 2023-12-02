package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdpz {
    final /* synthetic */ zzdqa zza;
    private final Map zzb = new ConcurrentHashMap();

    @VisibleForTesting
    public zzdpz(zzdqa zzdqaVar) {
        this.zza = zzdqaVar;
    }

    public static /* bridge */ /* synthetic */ zzdpz zza(zzdpz zzdpzVar) {
        Map map;
        Map map2 = zzdpzVar.zzb;
        map = zzdpzVar.zza.zzc;
        map2.putAll(map);
        return zzdpzVar;
    }

    public final zzdpz zzb(String str, String str2) {
        this.zzb.put(str, str2);
        return this;
    }

    public final zzdpz zzc(String str, @Nullable String str2) {
        if (!TextUtils.isEmpty(str2)) {
            this.zzb.put(str, str2);
        }
        return this;
    }

    public final zzdpz zzd(zzezn zzeznVar) {
        this.zzb.put("aai", zzeznVar.zzx);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzgN)).booleanValue()) {
            zzc("rid", zzeznVar.zzao);
        }
        return this;
    }

    public final zzdpz zze(zzezq zzezqVar) {
        this.zzb.put("gqi", zzezqVar.zzb);
        return this;
    }

    public final String zzf() {
        zzdqf zzdqfVar;
        zzdqfVar = this.zza.zza;
        return zzdqfVar.zzb(this.zzb);
    }

    public final void zzg() {
        Executor executor;
        executor = this.zza.zzb;
        executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdpy
            @Override // java.lang.Runnable
            public final void run() {
                zzdpz.this.zzi();
            }
        });
    }

    public final void zzh() {
        Executor executor;
        executor = this.zza.zzb;
        executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdpx
            @Override // java.lang.Runnable
            public final void run() {
                zzdpz.this.zzj();
            }
        });
    }

    public final /* synthetic */ void zzi() {
        zzdqf zzdqfVar;
        zzdqfVar = this.zza.zza;
        zzdqfVar.zze(this.zzb);
    }

    public final /* synthetic */ void zzj() {
        zzdqf zzdqfVar;
        zzdqfVar = this.zza.zza;
        zzdqfVar.zzd(this.zzb);
    }
}
