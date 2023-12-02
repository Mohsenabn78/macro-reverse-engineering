package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdhj {
    zzbfs zza;
    zzbfp zzb;
    zzbgf zzc;
    zzbgc zzd;
    zzbla zze;
    final SimpleArrayMap zzf = new SimpleArrayMap();
    final SimpleArrayMap zzg = new SimpleArrayMap();

    public final zzdhj zza(zzbfp zzbfpVar) {
        this.zzb = zzbfpVar;
        return this;
    }

    public final zzdhj zzb(zzbfs zzbfsVar) {
        this.zza = zzbfsVar;
        return this;
    }

    public final zzdhj zzc(String str, zzbfy zzbfyVar, @Nullable zzbfv zzbfvVar) {
        this.zzf.put(str, zzbfyVar);
        if (zzbfvVar != null) {
            this.zzg.put(str, zzbfvVar);
        }
        return this;
    }

    public final zzdhj zzd(zzbla zzblaVar) {
        this.zze = zzblaVar;
        return this;
    }

    public final zzdhj zze(zzbgc zzbgcVar) {
        this.zzd = zzbgcVar;
        return this;
    }

    public final zzdhj zzf(zzbgf zzbgfVar) {
        this.zzc = zzbgfVar;
        return this;
    }

    public final zzdhl zzg() {
        return new zzdhl(this);
    }
}
