package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzccy extends zzams {
    static final zzccy zzb = new zzccy();

    zzccy() {
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final zzamw zza(String str, byte[] bArr, String str2) {
        if ("moov".equals(str)) {
            return new zzamy();
        }
        if ("mvhd".equals(str)) {
            return new zzamz();
        }
        return new zzana(str);
    }
}
