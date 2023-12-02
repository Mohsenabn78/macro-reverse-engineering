package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.compose.animation.core.AnimationKt;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzaga implements zzafz {
    private final long[] zza;
    private final long[] zzb;
    private final long zzc;
    private final long zzd;

    private zzaga(long[] jArr, long[] jArr2, long j4, long j5) {
        this.zza = jArr;
        this.zzb = jArr2;
        this.zzc = j4;
        this.zzd = j5;
    }

    @Nullable
    public static zzaga zza(long j4, long j5, zzabp zzabpVar, zzfa zzfaVar) {
        int i4;
        int zzk;
        zzfaVar.zzG(10);
        int zze = zzfaVar.zze();
        if (zze <= 0) {
            return null;
        }
        int i5 = zzabpVar.zzd;
        if (i5 >= 32000) {
            i4 = 1152;
        } else {
            i4 = 576;
        }
        long zzp = zzfj.zzp(zze, i4 * AnimationKt.MillisToNanos, i5);
        int zzo = zzfaVar.zzo();
        int zzo2 = zzfaVar.zzo();
        int zzo3 = zzfaVar.zzo();
        zzfaVar.zzG(2);
        long j6 = j5 + zzabpVar.zzc;
        long[] jArr = new long[zzo];
        long[] jArr2 = new long[zzo];
        int i6 = 0;
        long j7 = j5;
        while (i6 < zzo) {
            int i7 = zzo2;
            long j8 = j6;
            jArr[i6] = (i6 * zzp) / zzo;
            jArr2[i6] = Math.max(j7, j8);
            if (zzo3 != 1) {
                if (zzo3 != 2) {
                    if (zzo3 != 3) {
                        if (zzo3 != 4) {
                            return null;
                        }
                        zzk = zzfaVar.zzn();
                    } else {
                        zzk = zzfaVar.zzm();
                    }
                } else {
                    zzk = zzfaVar.zzo();
                }
            } else {
                zzk = zzfaVar.zzk();
            }
            j7 += zzk * i7;
            i6++;
            j6 = j8;
            zzo2 = i7;
            zzo = zzo;
        }
        if (j4 != -1 && j4 != j7) {
            zzer.zzf("VbriSeeker", "VBRI data size mismatch: " + j4 + ", " + j7);
        }
        return new zzaga(jArr, jArr2, zzp, j7);
    }

    @Override // com.google.android.gms.internal.ads.zzafz
    public final long zzb() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzafz
    public final long zzc(long j4) {
        return this.zza[zzfj.zzc(this.zzb, j4, true, true)];
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final long zze() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final zzabt zzg(long j4) {
        int zzc = zzfj.zzc(this.zza, j4, true, true);
        zzabw zzabwVar = new zzabw(this.zza[zzc], this.zzb[zzc]);
        if (zzabwVar.zzb < j4) {
            long[] jArr = this.zza;
            if (zzc != jArr.length - 1) {
                int i4 = zzc + 1;
                return new zzabt(zzabwVar, new zzabw(jArr[i4], this.zzb[i4]));
            }
        }
        return new zzabt(zzabwVar, zzabwVar);
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final boolean zzh() {
        return true;
    }
}
