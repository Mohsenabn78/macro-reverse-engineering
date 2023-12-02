package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzakg {
    public static Pair zza(zzaax zzaaxVar) throws IOException {
        zzaaxVar.zzj();
        zzakf zzd = zzd(1684108385, zzaaxVar, new zzfa(8));
        ((zzaam) zzaaxVar).zzo(8, false);
        return Pair.create(Long.valueOf(zzaaxVar.zzf()), Long.valueOf(zzd.zzb));
    }

    public static zzake zzb(zzaax zzaaxVar) throws IOException {
        boolean z3;
        byte[] bArr;
        zzfa zzfaVar = new zzfa(16);
        zzakf zzd = zzd(1718449184, zzaaxVar, zzfaVar);
        if (zzd.zzb >= 16) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzdy.zzf(z3);
        zzaam zzaamVar = (zzaam) zzaaxVar;
        zzaamVar.zzm(zzfaVar.zzH(), 0, 16, false);
        zzfaVar.zzF(0);
        int zzi = zzfaVar.zzi();
        int zzi2 = zzfaVar.zzi();
        int zzh = zzfaVar.zzh();
        int zzh2 = zzfaVar.zzh();
        int zzi3 = zzfaVar.zzi();
        int zzi4 = zzfaVar.zzi();
        int i4 = ((int) zzd.zzb) - 16;
        if (i4 > 0) {
            bArr = new byte[i4];
            zzaamVar.zzm(bArr, 0, i4, false);
        } else {
            bArr = zzfj.zzf;
        }
        byte[] bArr2 = bArr;
        ((zzaam) zzaaxVar).zzo((int) (zzaaxVar.zze() - zzaaxVar.zzf()), false);
        return new zzake(zzi, zzi2, zzh, zzh2, zzi3, zzi4, bArr2);
    }

    public static boolean zzc(zzaax zzaaxVar) throws IOException {
        zzfa zzfaVar = new zzfa(8);
        int i4 = zzakf.zza(zzaaxVar, zzfaVar).zza;
        if (i4 != 1380533830 && i4 != 1380333108) {
            return false;
        }
        ((zzaam) zzaaxVar).zzm(zzfaVar.zzH(), 0, 4, false);
        zzfaVar.zzF(0);
        int zze = zzfaVar.zze();
        if (zze != 1463899717) {
            zzer.zzc("WavHeaderReader", "Unsupported form type: " + zze);
            return false;
        }
        return true;
    }

    private static zzakf zzd(int i4, zzaax zzaaxVar, zzfa zzfaVar) throws IOException {
        zzakf zza = zzakf.zza(zzaaxVar, zzfaVar);
        while (true) {
            int i5 = zza.zza;
            if (i5 != i4) {
                zzer.zzf("WavHeaderReader", "Ignoring unknown WAV chunk: " + i5);
                long j4 = zza.zzb + 8;
                if (j4 <= 2147483647L) {
                    ((zzaam) zzaaxVar).zzo((int) j4, false);
                    zza = zzakf.zza(zzaaxVar, zzfaVar);
                } else {
                    int i6 = zza.zza;
                    throw zzcd.zzc("Chunk is too large (~2GB+) to skip; id: " + i6);
                }
            } else {
                return zza;
            }
        }
    }
}
