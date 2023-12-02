package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzia {
    public final String zza;
    public final zzam zzb;
    public final zzam zzc;
    public final int zzd;
    public final int zze;

    public zzia(String str, zzam zzamVar, zzam zzamVar2, int i4, int i5) {
        boolean z3 = true;
        if (i4 != 0) {
            if (i5 == 0) {
                i5 = 0;
            } else {
                z3 = false;
            }
        }
        zzdy.zzd(z3);
        zzdy.zzc(str);
        this.zza = str;
        zzamVar.getClass();
        this.zzb = zzamVar;
        zzamVar2.getClass();
        this.zzc = zzamVar2;
        this.zzd = i4;
        this.zze = i5;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzia.class == obj.getClass()) {
            zzia zziaVar = (zzia) obj;
            if (this.zzd == zziaVar.zzd && this.zze == zziaVar.zze && this.zza.equals(zziaVar.zza) && this.zzb.equals(zziaVar.zzb) && this.zzc.equals(zziaVar.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((this.zzd + 527) * 31) + this.zze) * 31) + this.zza.hashCode()) * 31) + this.zzb.hashCode()) * 31) + this.zzc.hashCode();
    }
}
