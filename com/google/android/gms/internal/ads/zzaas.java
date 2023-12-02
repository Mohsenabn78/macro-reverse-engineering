package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaas {
    public final String zza;

    private zzaas(int i4, int i5, String str) {
        this.zza = str;
    }

    @Nullable
    public static zzaas zza(zzfa zzfaVar) {
        String str;
        zzfaVar.zzG(2);
        int zzk = zzfaVar.zzk();
        int i4 = zzk >> 1;
        int i5 = zzk & 1;
        int zzk2 = zzfaVar.zzk() >> 3;
        if (i4 != 4 && i4 != 5 && i4 != 7) {
            if (i4 == 8) {
                str = "hev1";
            } else if (i4 == 9) {
                str = "avc3";
            } else {
                return null;
            }
        } else {
            str = "dvhe";
        }
        int i6 = zzk2 | (i5 << 5);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        String str2 = ".0";
        sb.append(".0");
        sb.append(i4);
        if (i6 >= 10) {
            str2 = ".";
        }
        sb.append(str2);
        sb.append(i6);
        return new zzaas(i4, i6, sb.toString());
    }
}
