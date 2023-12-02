package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzfmw extends zzfnp {
    private String zza;
    private String zzb;

    @Override // com.google.android.gms.internal.ads.zzfnp
    public final zzfnp zza(String str) {
        this.zzb = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfnp
    public final zzfnp zzb(String str) {
        this.zza = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfnp
    public final zzfnq zzc() {
        return new zzfmy(this.zza, this.zzb, null);
    }
}
