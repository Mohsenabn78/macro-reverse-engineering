package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzabg {
    @Nullable
    public static zzbz zza(zzaax zzaaxVar, boolean z3) throws IOException {
        zzaek zzaekVar;
        if (z3) {
            zzaekVar = null;
        } else {
            zzaekVar = zzaem.zza;
        }
        zzbz zza = new zzabn().zza(zzaaxVar, zzaekVar);
        if (zza == null || zza.zza() == 0) {
            return null;
        }
        return zza;
    }

    public static zzabi zzb(zzfa zzfaVar) {
        zzfaVar.zzG(1);
        int zzm = zzfaVar.zzm();
        long zzc = zzfaVar.zzc();
        long j4 = zzm;
        int i4 = zzm / 18;
        long[] jArr = new long[i4];
        long[] jArr2 = new long[i4];
        int i5 = 0;
        while (true) {
            if (i5 >= i4) {
                break;
            }
            long zzr = zzfaVar.zzr();
            if (zzr == -1) {
                jArr = Arrays.copyOf(jArr, i5);
                jArr2 = Arrays.copyOf(jArr2, i5);
                break;
            }
            jArr[i5] = zzr;
            jArr2[i5] = zzfaVar.zzr();
            zzfaVar.zzG(2);
            i5++;
        }
        zzfaVar.zzG((int) ((zzc + j4) - zzfaVar.zzc()));
        return new zzabi(jArr, jArr2);
    }
}
