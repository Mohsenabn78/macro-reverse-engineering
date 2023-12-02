package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzfmv extends zzfnn {
    private final int zza;
    private final String zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzfmv(int i4, String str, zzfmu zzfmuVar) {
        this.zza = i4;
        this.zzb = str;
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfnn) {
            zzfnn zzfnnVar = (zzfnn) obj;
            if (this.zza == zzfnnVar.zza() && ((str = this.zzb) != null ? str.equals(zzfnnVar.zzb()) : zzfnnVar.zzb() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int i4 = this.zza ^ 1000003;
        String str = this.zzb;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return (i4 * 1000003) ^ hashCode;
    }

    public final String toString() {
        int i4 = this.zza;
        String str = this.zzb;
        return "OverlayDisplayState{statusCode=" + i4 + ", sessionToken=" + str + "}";
    }

    @Override // com.google.android.gms.internal.ads.zzfnn
    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzfnn
    @Nullable
    public final String zzb() {
        return this.zzb;
    }
}
