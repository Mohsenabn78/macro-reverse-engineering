package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaca {
    private final byte[] zza = new byte[10];
    private boolean zzb;
    private int zzc;
    private long zzd;
    private int zze;
    private int zzf;
    private int zzg;

    public final void zza(zzabz zzabzVar, @Nullable zzaby zzabyVar) {
        if (this.zzc > 0) {
            zzabzVar.zzs(this.zzd, this.zze, this.zzf, this.zzg, zzabyVar);
            this.zzc = 0;
        }
    }

    public final void zzb() {
        this.zzb = false;
        this.zzc = 0;
    }

    public final void zzc(zzabz zzabzVar, long j4, int i4, int i5, int i6, @Nullable zzaby zzabyVar) {
        if (this.zzg <= i5 + i6) {
            if (!this.zzb) {
                return;
            }
            int i7 = this.zzc;
            int i8 = i7 + 1;
            this.zzc = i8;
            if (i7 == 0) {
                this.zzd = j4;
                this.zze = i4;
                this.zzf = 0;
            }
            this.zzf += i5;
            this.zzg = i6;
            if (i8 >= 16) {
                zza(zzabzVar, zzabyVar);
                return;
            }
            return;
        }
        throw new IllegalStateException("TrueHD chunk samples must be contiguous in the sample queue.");
    }

    public final void zzd(zzaax zzaaxVar) throws IOException {
        if (this.zzb) {
            return;
        }
        zzaaxVar.zzh(this.zza, 0, 10);
        zzaaxVar.zzj();
        byte[] bArr = this.zza;
        int i4 = zzzx.zza;
        if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111 && (bArr[7] & 254) == 186) {
            this.zzb = true;
        }
    }
}
