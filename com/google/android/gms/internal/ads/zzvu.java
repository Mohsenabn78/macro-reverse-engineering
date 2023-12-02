package com.google.android.gms.internal.ads;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzvu extends zzvw {
    private final zzxo zzd;
    private final zzfsc zze;
    private final zzdz zzf;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzvu(zzcy zzcyVar, int[] iArr, int i4, zzxo zzxoVar, long j4, long j5, long j6, int i5, int i6, float f4, float f5, List list, zzdz zzdzVar) {
        super(zzcyVar, iArr, 0);
        this.zzd = zzxoVar;
        this.zze = zzfsc.zzj(list);
        this.zzf = zzdzVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ zzfsc zzf(zzwz[] zzwzVarArr) {
        int i4;
        int i5;
        zzfsc zzi;
        double d4;
        long j4;
        ArrayList arrayList = new ArrayList();
        char c4 = 0;
        int i6 = 0;
        while (true) {
            i4 = 2;
            i5 = 1;
            if (i6 >= 2) {
                break;
            }
            zzwz zzwzVar = zzwzVarArr[i6];
            if (zzwzVar != null && zzwzVar.zzb.length > 1) {
                zzfrz zzfrzVar = new zzfrz();
                zzfrzVar.zzf(new zzvs(0L, 0L));
                arrayList.add(zzfrzVar);
            } else {
                arrayList.add(null);
            }
            i6++;
        }
        long[][] jArr = new long[2];
        for (int i7 = 0; i7 < 2; i7++) {
            zzwz zzwzVar2 = zzwzVarArr[i7];
            if (zzwzVar2 == null) {
                jArr[i7] = new long[0];
            } else {
                jArr[i7] = new long[zzwzVar2.zzb.length];
                int i8 = 0;
                while (true) {
                    int[] iArr = zzwzVar2.zzb;
                    if (i8 >= iArr.length) {
                        break;
                    }
                    long j5 = zzwzVar2.zza.zzb(iArr[i8]).zzi;
                    long[] jArr2 = jArr[i7];
                    if (j5 == -1) {
                        j5 = 0;
                    }
                    jArr2[i8] = j5;
                    i8++;
                }
                Arrays.sort(jArr[i7]);
            }
        }
        int[] iArr2 = new int[2];
        long[] jArr3 = new long[2];
        for (int i9 = 0; i9 < 2; i9++) {
            long[] jArr4 = jArr[i9];
            if (jArr4.length == 0) {
                j4 = 0;
            } else {
                j4 = jArr4[0];
            }
            jArr3[i9] = j4;
        }
        zzg(arrayList, jArr3);
        zzfsn zza = zzftg.zzc(zzftl.zzc()).zzb(2).zza();
        int i10 = 0;
        while (i10 < i4) {
            int length = jArr[i10].length;
            if (length > i5) {
                double[] dArr = new double[length];
                int i11 = 0;
                while (true) {
                    long[] jArr5 = jArr[i10];
                    int length2 = jArr5.length;
                    double d5 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                    if (i11 >= length2) {
                        break;
                    }
                    long j6 = jArr5[i11];
                    if (j6 != -1) {
                        d5 = Math.log(j6);
                    }
                    dArr[i11] = d5;
                    i11++;
                }
                int i12 = length - 1;
                double d6 = dArr[i12] - dArr[c4];
                int i13 = 0;
                while (i13 < i12) {
                    double d7 = dArr[i13];
                    i13++;
                    double d8 = d7 + dArr[i13];
                    if (d6 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                        d4 = 1.0d;
                    } else {
                        d4 = ((d8 * 0.5d) - dArr[c4]) / d6;
                    }
                    zza.zzq(Double.valueOf(d4), Integer.valueOf(i10));
                    c4 = 0;
                }
            }
            i10++;
            c4 = 0;
            i4 = 2;
            i5 = 1;
        }
        zzfsc zzj = zzfsc.zzj(zza.zzr());
        for (int i14 = 0; i14 < zzj.size(); i14++) {
            int intValue = ((Integer) zzj.get(i14)).intValue();
            int i15 = iArr2[intValue] + 1;
            iArr2[intValue] = i15;
            jArr3[intValue] = jArr[intValue][i15];
            zzg(arrayList, jArr3);
        }
        for (int i16 = 0; i16 < 2; i16++) {
            if (arrayList.get(i16) != null) {
                long j7 = jArr3[i16];
                jArr3[i16] = j7 + j7;
            }
        }
        zzg(arrayList, jArr3);
        zzfrz zzfrzVar2 = new zzfrz();
        for (int i17 = 0; i17 < arrayList.size(); i17++) {
            zzfrz zzfrzVar3 = (zzfrz) arrayList.get(i17);
            if (zzfrzVar3 == null) {
                zzi = zzfsc.zzl();
            } else {
                zzi = zzfrzVar3.zzi();
            }
            zzfrzVar2.zzf(zzi);
        }
        return zzfrzVar2.zzi();
    }

    private static void zzg(List list, long[] jArr) {
        long j4 = 0;
        for (int i4 = 0; i4 < 2; i4++) {
            j4 += jArr[i4];
        }
        for (int i5 = 0; i5 < list.size(); i5++) {
            zzfrz zzfrzVar = (zzfrz) list.get(i5);
            if (zzfrzVar != null) {
                zzfrzVar.zzf(new zzvs(j4, jArr[i5]));
            }
        }
    }
}
