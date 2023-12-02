package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzfjh extends zzfjd {
    private final String zza;
    private final boolean zzb;
    private final boolean zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzfjh(String str, boolean z3, boolean z4, zzfjg zzfjgVar) {
        this.zza = str;
        this.zzb = z3;
        this.zzc = z4;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfjd) {
            zzfjd zzfjdVar = (zzfjd) obj;
            if (this.zza.equals(zzfjdVar.zzb()) && this.zzb == zzfjdVar.zzd() && this.zzc == zzfjdVar.zzc()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i4;
        int hashCode = this.zza.hashCode() ^ 1000003;
        int i5 = 1237;
        if (true != this.zzb) {
            i4 = 1237;
        } else {
            i4 = 1231;
        }
        if (true == this.zzc) {
            i5 = 1231;
        }
        return (((hashCode * 1000003) ^ i4) * 1000003) ^ i5;
    }

    public final String toString() {
        String str = this.zza;
        boolean z3 = this.zzb;
        boolean z4 = this.zzc;
        return "AdShield2Options{clientVersion=" + str + ", shouldGetAdvertisingId=" + z3 + ", isGooglePlayServicesAvailable=" + z4 + "}";
    }

    @Override // com.google.android.gms.internal.ads.zzfjd
    public final String zzb() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzfjd
    public final boolean zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzfjd
    public final boolean zzd() {
        return this.zzb;
    }
}
