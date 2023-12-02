package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzadj extends zzabk {
    private final long zza;

    public zzadj(zzaax zzaaxVar, long j4) {
        super(zzaaxVar);
        boolean z3;
        if (zzaaxVar.zzf() >= j4) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzdy.zzd(z3);
        this.zza = j4;
    }

    @Override // com.google.android.gms.internal.ads.zzabk, com.google.android.gms.internal.ads.zzaax
    public final long zzd() {
        return super.zzd() - this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzabk, com.google.android.gms.internal.ads.zzaax
    public final long zze() {
        return super.zze() - this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzabk, com.google.android.gms.internal.ads.zzaax
    public final long zzf() {
        return super.zzf() - this.zza;
    }
}
