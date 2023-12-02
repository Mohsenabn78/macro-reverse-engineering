package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzuo implements zzvf {
    final /* synthetic */ zzur zza;
    private final int zzb;

    public zzuo(zzur zzurVar, int i4) {
        this.zza = zzurVar;
        this.zzb = i4;
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final int zza(zzkj zzkjVar, zzhp zzhpVar, int i4) {
        return this.zza.zzg(this.zzb, zzkjVar, zzhpVar, i4);
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final int zzb(long j4) {
        return this.zza.zzi(this.zzb, j4);
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final void zzd() throws IOException {
        this.zza.zzH(this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final boolean zze() {
        return this.zza.zzO(this.zzb);
    }
}
