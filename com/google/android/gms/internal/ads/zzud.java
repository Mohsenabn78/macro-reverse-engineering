package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzud implements zzvf {
    private final zzvf zza;
    private final long zzb;

    public zzud(zzvf zzvfVar, long j4) {
        this.zza = zzvfVar;
        this.zzb = j4;
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final int zza(zzkj zzkjVar, zzhp zzhpVar, int i4) {
        int zza = this.zza.zza(zzkjVar, zzhpVar, i4);
        if (zza == -4) {
            zzhpVar.zzd = Math.max(0L, zzhpVar.zzd + this.zzb);
            return -4;
        }
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final int zzb(long j4) {
        return this.zza.zzb(j4 - this.zzb);
    }

    public final zzvf zzc() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final void zzd() throws IOException {
        this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final boolean zze() {
        return this.zza.zze();
    }
}
