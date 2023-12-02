package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzub implements zzxa {
    private final zzxa zza;
    private final zzcy zzb;

    public zzub(zzxa zzxaVar, zzcy zzcyVar) {
        this.zza = zzxaVar;
        this.zzb = zzcyVar;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzub)) {
            return false;
        }
        zzub zzubVar = (zzub) obj;
        if (this.zza.equals(zzubVar.zza) && this.zzb.equals(zzubVar.zzb)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((this.zzb.hashCode() + 527) * 31) + this.zza.hashCode();
    }

    @Override // com.google.android.gms.internal.ads.zzxe
    public final int zza(int i4) {
        return this.zza.zza(0);
    }

    @Override // com.google.android.gms.internal.ads.zzxe
    public final int zzb(int i4) {
        return this.zza.zzb(i4);
    }

    @Override // com.google.android.gms.internal.ads.zzxe
    public final int zzc() {
        return this.zza.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzxe
    public final zzam zzd(int i4) {
        return this.zza.zzd(i4);
    }

    @Override // com.google.android.gms.internal.ads.zzxe
    public final zzcy zze() {
        return this.zzb;
    }
}
