package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzoh {
    public static final zzoh zza = new zzof().zzd();
    public final boolean zzb;
    public final boolean zzc;
    public final boolean zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzoh(zzof zzofVar, zzog zzogVar) {
        boolean z3;
        boolean z4;
        boolean z5;
        z3 = zzofVar.zza;
        this.zzb = z3;
        z4 = zzofVar.zzb;
        this.zzc = z4;
        z5 = zzofVar.zzc;
        this.zzd = z5;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzoh.class == obj.getClass()) {
            zzoh zzohVar = (zzoh) obj;
            if (this.zzb == zzohVar.zzb && this.zzc == zzohVar.zzc && this.zzd == zzohVar.zzd) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        boolean z3 = this.zzc;
        return ((this.zzb ? 1 : 0) << 2) + (z3 ? 1 : 0) + (z3 ? 1 : 0) + (this.zzd ? 1 : 0);
    }
}
