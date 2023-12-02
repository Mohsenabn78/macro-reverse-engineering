package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzfmn extends zzfmz {
    private String zza;
    private String zzb;

    @Override // com.google.android.gms.internal.ads.zzfmz
    public final zzfmz zza(String str) {
        this.zzb = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfmz
    public final zzfmz zzb(String str) {
        this.zza = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfmz
    public final zzfna zzc() {
        return new zzfmp(this.zza, this.zzb, null);
    }
}
