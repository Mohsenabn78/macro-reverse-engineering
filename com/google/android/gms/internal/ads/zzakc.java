package com.google.android.gms.internal.ads;

import androidx.compose.animation.core.AnimationKt;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzakc implements zzakb {
    private final zzaaz zza;
    private final zzabz zzb;
    private final zzake zzc;
    private final zzam zzd;
    private final int zze;
    private long zzf;
    private int zzg;
    private long zzh;

    public zzakc(zzaaz zzaazVar, zzabz zzabzVar, zzake zzakeVar, String str, int i4) throws zzcd {
        this.zza = zzaazVar;
        this.zzb = zzabzVar;
        this.zzc = zzakeVar;
        int i5 = zzakeVar.zzb * zzakeVar.zze;
        int i6 = zzakeVar.zzd;
        int i7 = i5 / 8;
        if (i6 == i7) {
            int i8 = zzakeVar.zzc * i7;
            int i9 = i8 * 8;
            int max = Math.max(i7, i8 / 10);
            this.zze = max;
            zzak zzakVar = new zzak();
            zzakVar.zzS(str);
            zzakVar.zzv(i9);
            zzakVar.zzO(i9);
            zzakVar.zzL(max);
            zzakVar.zzw(zzakeVar.zzb);
            zzakVar.zzT(zzakeVar.zzc);
            zzakVar.zzN(i4);
            this.zzd = zzakVar.zzY();
            return;
        }
        throw zzcd.zza("Expected block size: " + i7 + "; got: " + i6, null);
    }

    @Override // com.google.android.gms.internal.ads.zzakb
    public final void zza(int i4, long j4) {
        this.zza.zzN(new zzakh(this.zzc, 1, i4, j4));
        this.zzb.zzk(this.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzakb
    public final void zzb(long j4) {
        this.zzf = j4;
        this.zzg = 0;
        this.zzh = 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzakb
    public final boolean zzc(zzaax zzaaxVar, long j4) throws IOException {
        int i4;
        zzake zzakeVar;
        int i5;
        int i6;
        long j5 = j4;
        while (true) {
            i4 = (j5 > 0L ? 1 : (j5 == 0L ? 0 : -1));
            if (i4 <= 0 || (i5 = this.zzg) >= (i6 = this.zze)) {
                break;
            }
            int zza = zzabx.zza(this.zzb, zzaaxVar, (int) Math.min(i6 - i5, j5), true);
            if (zza == -1) {
                j5 = 0;
            } else {
                this.zzg += zza;
                j5 -= zza;
            }
        }
        int i7 = this.zzc.zzd;
        int i8 = this.zzg / i7;
        if (i8 > 0) {
            int i9 = i8 * i7;
            int i10 = this.zzg - i9;
            this.zzb.zzs(this.zzf + zzfj.zzp(this.zzh, AnimationKt.MillisToNanos, zzakeVar.zzc), 1, i9, i10, null);
            this.zzh += i8;
            this.zzg = i10;
        }
        if (i4 <= 0) {
            return true;
        }
        return false;
    }
}
