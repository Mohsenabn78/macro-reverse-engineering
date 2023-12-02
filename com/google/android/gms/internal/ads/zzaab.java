package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaab {
    public final List zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final float zzh;
    @Nullable
    public final String zzi;

    private zzaab(List list, int i4, int i5, int i6, int i7, int i8, int i9, float f4, @Nullable String str) {
        this.zza = list;
        this.zzb = i4;
        this.zzc = i5;
        this.zzd = i6;
        this.zze = i7;
        this.zzf = i8;
        this.zzg = i9;
        this.zzh = f4;
        this.zzi = str;
    }

    public static zzaab zza(zzfa zzfaVar) throws zzcd {
        String str;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        float f4;
        try {
            zzfaVar.zzG(4);
            int zzk = (zzfaVar.zzk() & 3) + 1;
            if (zzk != 3) {
                ArrayList arrayList = new ArrayList();
                int zzk2 = zzfaVar.zzk() & 31;
                for (int i9 = 0; i9 < zzk2; i9++) {
                    arrayList.add(zzb(zzfaVar));
                }
                int zzk3 = zzfaVar.zzk();
                for (int i10 = 0; i10 < zzk3; i10++) {
                    arrayList.add(zzb(zzfaVar));
                }
                if (zzk2 > 0) {
                    zzft zze = zzfu.zze((byte[]) arrayList.get(0), zzk + 1, ((byte[]) arrayList.get(0)).length);
                    int i11 = zze.zze;
                    int i12 = zze.zzf;
                    int i13 = zze.zzh;
                    int i14 = zze.zzi;
                    int i15 = zze.zzj;
                    float f5 = zze.zzg;
                    str = zzea.zza(zze.zza, zze.zzb, zze.zzc);
                    i7 = i14;
                    i8 = i15;
                    f4 = f5;
                    i4 = i11;
                    i5 = i12;
                    i6 = i13;
                } else {
                    str = null;
                    i4 = -1;
                    i5 = -1;
                    i6 = -1;
                    i7 = -1;
                    i8 = -1;
                    f4 = 1.0f;
                }
                return new zzaab(arrayList, zzk, i4, i5, i6, i7, i8, f4, str);
            }
            throw new IllegalStateException();
        } catch (ArrayIndexOutOfBoundsException e4) {
            throw zzcd.zza("Error parsing AVC config", e4);
        }
    }

    private static byte[] zzb(zzfa zzfaVar) {
        int zzo = zzfaVar.zzo();
        int zzc = zzfaVar.zzc();
        zzfaVar.zzG(zzo);
        return zzea.zzc(zzfaVar.zzH(), zzc, zzo);
    }
}
