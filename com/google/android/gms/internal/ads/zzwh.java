package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzwh implements Comparable {
    private final boolean zza;
    private final boolean zzb;

    public zzwh(zzam zzamVar, int i4) {
        this.zza = 1 == (zzamVar.zze & 1);
        this.zzb = zzwy.zzn(i4, false);
    }

    @Override // java.lang.Comparable
    /* renamed from: zza */
    public final int compareTo(zzwh zzwhVar) {
        return zzfrr.zzj().zzd(this.zzb, zzwhVar.zzb).zzd(this.zza, zzwhVar.zza).zza();
    }
}
