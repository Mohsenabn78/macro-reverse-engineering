package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzabm {
    public final List zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final float zzf;
    @Nullable
    public final String zzg;

    private zzabm(List list, int i4, int i5, int i6, int i7, int i8, int i9, float f4, @Nullable String str) {
        this.zza = list;
        this.zzb = i4;
        this.zzc = i7;
        this.zzd = i8;
        this.zze = i9;
        this.zzf = f4;
        this.zzg = str;
    }

    public static zzabm zza(zzfa zzfaVar) throws zzcd {
        List singletonList;
        int i4;
        int i5;
        try {
            zzfaVar.zzG(21);
            int zzk = zzfaVar.zzk() & 3;
            int zzk2 = zzfaVar.zzk();
            int zzc = zzfaVar.zzc();
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < zzk2; i8++) {
                zzfaVar.zzG(1);
                int zzo = zzfaVar.zzo();
                for (int i9 = 0; i9 < zzo; i9++) {
                    int zzo2 = zzfaVar.zzo();
                    i7 += zzo2 + 4;
                    zzfaVar.zzG(zzo2);
                }
            }
            zzfaVar.zzF(zzc);
            byte[] bArr = new byte[i7];
            String str = null;
            int i10 = 0;
            int i11 = 0;
            int i12 = -1;
            int i13 = -1;
            int i14 = -1;
            int i15 = -1;
            int i16 = -1;
            float f4 = 1.0f;
            while (i10 < zzk2) {
                int zzk3 = zzfaVar.zzk() & 63;
                int zzo3 = zzfaVar.zzo();
                int i17 = 0;
                while (i17 < zzo3) {
                    int zzo4 = zzfaVar.zzo();
                    int i18 = zzk2;
                    System.arraycopy(zzfu.zza, i6, bArr, i11, 4);
                    int i19 = i11 + 4;
                    System.arraycopy(zzfaVar.zzH(), zzfaVar.zzc(), bArr, i19, zzo4);
                    if (zzk3 == 33 && i17 == 0) {
                        zzfr zzc2 = zzfu.zzc(bArr, i19 + 2, i19 + zzo4);
                        i12 = zzc2.zzg;
                        i13 = zzc2.zzh;
                        i14 = zzc2.zzj;
                        int i20 = zzc2.zzk;
                        int i21 = zzc2.zzl;
                        float f5 = zzc2.zzi;
                        i4 = zzk3;
                        i5 = zzo3;
                        str = zzea.zzb(zzc2.zza, zzc2.zzb, zzc2.zzc, zzc2.zzd, zzc2.zze, zzc2.zzf);
                        i17 = 0;
                        f4 = f5;
                        i15 = i20;
                        i16 = i21;
                    } else {
                        i4 = zzk3;
                        i5 = zzo3;
                    }
                    i11 = i19 + zzo4;
                    zzfaVar.zzG(zzo4);
                    i17++;
                    zzk2 = i18;
                    zzk3 = i4;
                    zzo3 = i5;
                    i6 = 0;
                }
                i10++;
                i6 = 0;
            }
            if (i7 == 0) {
                singletonList = Collections.emptyList();
            } else {
                singletonList = Collections.singletonList(bArr);
            }
            return new zzabm(singletonList, zzk + 1, i12, i13, i14, i15, i16, f4, str);
        } catch (ArrayIndexOutOfBoundsException e4) {
            throw zzcd.zza("Error parsing HEVC config", e4);
        }
    }
}
