package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioFormat;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzph {
    private Boolean zza;

    public zzph() {
    }

    public zzph(@Nullable Context context) {
    }

    public final zzoh zza(zzam zzamVar, zzk zzkVar) {
        zzamVar.getClass();
        zzkVar.getClass();
        int i4 = zzfj.zza;
        if (i4 >= 29 && zzamVar.zzA != -1) {
            Boolean bool = this.zza;
            if (bool != null) {
                bool.booleanValue();
            } else {
                Boolean bool2 = Boolean.FALSE;
                this.zza = bool2;
                bool2.booleanValue();
            }
            String str = zzamVar.zzm;
            str.getClass();
            int zza = zzcc.zza(str, zzamVar.zzj);
            if (zza == 0) {
                return zzoh.zza;
            }
            if (i4 < 34 && zza == 30) {
                return zzoh.zza;
            }
            int zzf = zzfj.zzf(zzamVar.zzz);
            if (zzf == 0) {
                return zzoh.zza;
            }
            AudioFormat zzs = zzfj.zzs(zzamVar.zzA, zzf, zza);
            if (i4 >= 31) {
                return zzpg.zza(zzs, zzkVar.zza().zza, false);
            }
            return zzpf.zza(zzs, zzkVar.zza().zza, false);
        }
        return zzoh.zza;
    }
}
