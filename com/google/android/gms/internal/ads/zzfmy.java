package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzfmy extends zzfnq {
    private final String zza;
    private final String zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzfmy(String str, String str2, zzfmx zzfmxVar) {
        this.zza = str;
        this.zzb = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfnq) {
            zzfnq zzfnqVar = (zzfnq) obj;
            String str = this.zza;
            if (str != null ? str.equals(zzfnqVar.zzb()) : zzfnqVar.zzb() == null) {
                String str2 = this.zzb;
                if (str2 != null ? str2.equals(zzfnqVar.zza()) : zzfnqVar.zza() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        String str = this.zza;
        int i4 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        String str2 = this.zzb;
        if (str2 != null) {
            i4 = str2.hashCode();
        }
        return ((hashCode ^ 1000003) * 1000003) ^ i4;
    }

    public final String toString() {
        String str = this.zza;
        String str2 = this.zzb;
        return "OverlayDisplayUpdateRequest{sessionToken=" + str + ", appId=" + str2 + "}";
    }

    @Override // com.google.android.gms.internal.ads.zzfnq
    @Nullable
    public final String zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfnq
    @Nullable
    public final String zzb() {
        return this.zza;
    }
}
