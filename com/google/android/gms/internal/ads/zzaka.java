package com.google.android.gms.internal.ads;

import androidx.compose.animation.core.AnimationKt;
import com.android.dx.io.Opcodes;
import net.bytebuddy.asm.Advice;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzaka implements zzakb {
    private static final int[] zza = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};
    private static final int[] zzb = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, 130, 143, 157, 173, 190, Opcodes.RSUB_INT, 230, 253, 279, 307, 337, 371, 408, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, Advice.MethodSizeHandler.UNDEFINED_SIZE};
    private final zzaaz zzc;
    private final zzabz zzd;
    private final zzake zze;
    private final int zzf;
    private final byte[] zzg;
    private final zzfa zzh;
    private final int zzi;
    private final zzam zzj;
    private int zzk;
    private long zzl;
    private int zzm;
    private long zzn;

    public zzaka(zzaaz zzaazVar, zzabz zzabzVar, zzake zzakeVar) throws zzcd {
        this.zzc = zzaazVar;
        this.zzd = zzabzVar;
        this.zze = zzakeVar;
        int max = Math.max(1, zzakeVar.zzc / 10);
        this.zzi = max;
        zzfa zzfaVar = new zzfa(zzakeVar.zzf);
        zzfaVar.zzi();
        int zzi = zzfaVar.zzi();
        this.zzf = zzi;
        int i4 = zzakeVar.zzb;
        int i5 = zzakeVar.zzd;
        int i6 = (((i5 - (i4 * 4)) * 8) / (zzakeVar.zze * i4)) + 1;
        if (zzi == i6) {
            int i7 = zzfj.zza;
            int i8 = ((max + zzi) - 1) / zzi;
            this.zzg = new byte[i5 * i8];
            this.zzh = new zzfa(i8 * (zzi + zzi) * i4);
            int i9 = ((zzakeVar.zzc * zzakeVar.zzd) * 8) / zzi;
            zzak zzakVar = new zzak();
            zzakVar.zzS("audio/raw");
            zzakVar.zzv(i9);
            zzakVar.zzO(i9);
            zzakVar.zzL((max + max) * i4);
            zzakVar.zzw(zzakeVar.zzb);
            zzakVar.zzT(zzakeVar.zzc);
            zzakVar.zzN(2);
            this.zzj = zzakVar.zzY();
            return;
        }
        throw zzcd.zza("Expected frames per block: " + i6 + "; got: " + zzi, null);
    }

    private final int zzd(int i4) {
        int i5 = this.zze.zzb;
        return i4 / (i5 + i5);
    }

    private final int zze(int i4) {
        return (i4 + i4) * this.zze.zzb;
    }

    private final void zzf(int i4) {
        long zzp = this.zzl + zzfj.zzp(this.zzn, AnimationKt.MillisToNanos, this.zze.zzc);
        int zze = zze(i4);
        this.zzd.zzs(zzp, 1, zze, this.zzm - zze, null);
        this.zzn += i4;
        this.zzm -= zze;
    }

    @Override // com.google.android.gms.internal.ads.zzakb
    public final void zza(int i4, long j4) {
        this.zzc.zzN(new zzakh(this.zze, this.zzf, i4, j4));
        this.zzd.zzk(this.zzj);
    }

    @Override // com.google.android.gms.internal.ads.zzakb
    public final void zzb(long j4) {
        this.zzk = 0;
        this.zzl = j4;
        this.zzm = 0;
        this.zzn = 0L;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x003c -> B:4:0x0021). Please submit an issue!!! */
    @Override // com.google.android.gms.internal.ads.zzakb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzc(com.google.android.gms.internal.ads.zzaax r21, long r22) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 350
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaka.zzc(com.google.android.gms.internal.ads.zzaax, long):boolean");
    }
}
