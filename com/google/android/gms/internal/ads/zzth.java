package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzth extends zztc {
    public static final Object zzd = new Object();
    @Nullable
    private final Object zze;
    @Nullable
    private final Object zzf;

    private zzth(zzcw zzcwVar, @Nullable Object obj, @Nullable Object obj2) {
        super(zzcwVar);
        this.zze = obj;
        this.zzf = obj2;
    }

    public static zzth zzq(zzbp zzbpVar) {
        return new zzth(new zzti(zzbpVar), zzcv.zza, zzd);
    }

    public static zzth zzr(zzcw zzcwVar, @Nullable Object obj, @Nullable Object obj2) {
        return new zzth(zzcwVar, obj, obj2);
    }

    @Override // com.google.android.gms.internal.ads.zztc, com.google.android.gms.internal.ads.zzcw
    public final int zza(Object obj) {
        Object obj2;
        zzcw zzcwVar = this.zzc;
        if (zzd.equals(obj) && (obj2 = this.zzf) != null) {
            obj = obj2;
        }
        return zzcwVar.zza(obj);
    }

    @Override // com.google.android.gms.internal.ads.zztc, com.google.android.gms.internal.ads.zzcw
    public final zzct zzd(int i4, zzct zzctVar, boolean z3) {
        this.zzc.zzd(i4, zzctVar, z3);
        if (zzfj.zzC(zzctVar.zzc, this.zzf) && z3) {
            zzctVar.zzc = zzd;
        }
        return zzctVar;
    }

    @Override // com.google.android.gms.internal.ads.zztc, com.google.android.gms.internal.ads.zzcw
    public final zzcv zze(int i4, zzcv zzcvVar, long j4) {
        this.zzc.zze(i4, zzcvVar, j4);
        if (zzfj.zzC(zzcvVar.zzc, this.zze)) {
            zzcvVar.zzc = zzcv.zza;
        }
        return zzcvVar;
    }

    @Override // com.google.android.gms.internal.ads.zztc, com.google.android.gms.internal.ads.zzcw
    public final Object zzf(int i4) {
        Object zzf = this.zzc.zzf(i4);
        if (zzfj.zzC(zzf, this.zzf)) {
            return zzd;
        }
        return zzf;
    }

    public final zzth zzp(zzcw zzcwVar) {
        return new zzth(zzcwVar, this.zze, this.zzf);
    }
}
