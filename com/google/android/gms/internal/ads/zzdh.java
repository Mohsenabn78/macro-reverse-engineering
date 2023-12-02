package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdh {
    private final zzfsc zzd;
    public static final zzdh zza = new zzdh(zzfsc.zzl());
    private static final String zzc = Integer.toString(0, 36);
    public static final zzn zzb = new zzn() { // from class: com.google.android.gms.internal.ads.zzde
    };

    public zzdh(List list) {
        this.zzd = zzfsc.zzj(list);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzdh.class == obj.getClass()) {
            return this.zzd.equals(((zzdh) obj).zzd);
        }
        return false;
    }

    public final int hashCode() {
        return this.zzd.hashCode();
    }

    public final zzfsc zza() {
        return this.zzd;
    }

    public final boolean zzb(int i4) {
        for (int i5 = 0; i5 < this.zzd.size(); i5++) {
            zzdg zzdgVar = (zzdg) this.zzd.get(i5);
            if (zzdgVar.zzc() && zzdgVar.zza() == i4) {
                return true;
            }
        }
        return false;
    }
}
