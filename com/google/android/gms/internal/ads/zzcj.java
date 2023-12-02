package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcj {
    private final zzaf zza = new zzaf();

    public final zzcj zza(int i4) {
        this.zza.zza(i4);
        return this;
    }

    public final zzcj zzb(zzcl zzclVar) {
        zzah zzahVar;
        zzaf zzafVar = this.zza;
        zzahVar = zzclVar.zzd;
        for (int i4 = 0; i4 < zzahVar.zzb(); i4++) {
            zzafVar.zza(zzahVar.zza(i4));
        }
        return this;
    }

    public final zzcj zzc(int... iArr) {
        zzaf zzafVar = this.zza;
        for (int i4 = 0; i4 < 19; i4++) {
            zzafVar.zza(iArr[i4]);
        }
        return this;
    }

    public final zzcj zzd(int i4, boolean z3) {
        zzaf zzafVar = this.zza;
        if (z3) {
            zzafVar.zza(i4);
        }
        return this;
    }

    public final zzcl zze() {
        return new zzcl(this.zza.zzb(), null);
    }
}
