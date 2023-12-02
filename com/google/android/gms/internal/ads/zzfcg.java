package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfcg implements zzfce {
    private final String zza;

    public zzfcg(String str) {
        this.zza = str;
    }

    @Override // com.google.android.gms.internal.ads.zzfce
    public final boolean equals(Object obj) {
        if (!(obj instanceof zzfcg)) {
            return false;
        }
        return this.zza.equals(((zzfcg) obj).zza);
    }

    @Override // com.google.android.gms.internal.ads.zzfce
    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        return this.zza;
    }
}
