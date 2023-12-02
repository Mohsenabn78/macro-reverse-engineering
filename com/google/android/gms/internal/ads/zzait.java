package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzait {
    private final zzabz zza;
    private long zzb;
    private boolean zzc;
    private int zzd;
    private long zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;
    private long zzk;
    private long zzl;
    private boolean zzm;

    public zzait(zzabz zzabzVar) {
        this.zza = zzabzVar;
    }

    private final void zze(int i4) {
        long j4 = this.zzl;
        if (j4 == -9223372036854775807L) {
            return;
        }
        this.zza.zzs(j4, this.zzm ? 1 : 0, (int) (this.zzb - this.zzk), i4, null);
    }

    public final void zza(long j4, int i4, boolean z3) {
        if (this.zzj && this.zzg) {
            this.zzm = this.zzc;
            this.zzj = false;
        } else if (!this.zzh && !this.zzg) {
        } else {
            if (z3 && this.zzi) {
                zze(i4 + ((int) (j4 - this.zzb)));
            }
            this.zzk = this.zzb;
            this.zzl = this.zze;
            this.zzm = this.zzc;
            this.zzi = true;
        }
    }

    public final void zzb(byte[] bArr, int i4, int i5) {
        boolean z3;
        if (this.zzf) {
            int i6 = this.zzd;
            int i7 = (i4 + 2) - i6;
            if (i7 < i5) {
                if ((bArr[i7] & 128) != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                this.zzg = z3;
                this.zzf = false;
                return;
            }
            this.zzd = i6 + (i5 - i4);
        }
    }

    public final void zzc() {
        this.zzf = false;
        this.zzg = false;
        this.zzh = false;
        this.zzi = false;
        this.zzj = false;
    }

    public final void zzd(long j4, int i4, int i5, long j5, boolean z3) {
        boolean z4;
        boolean z5 = false;
        this.zzg = false;
        this.zzh = false;
        this.zze = j5;
        this.zzd = 0;
        this.zzb = j4;
        if (i5 >= 32 && i5 != 40) {
            if (this.zzi && !this.zzj) {
                if (z3) {
                    zze(i4);
                }
                this.zzi = false;
            }
            if (i5 <= 35 || i5 == 39) {
                this.zzh = !this.zzj;
                this.zzj = true;
            }
        }
        if (i5 >= 16 && i5 <= 21) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.zzc = z4;
        this.zzf = (z4 || i5 <= 9) ? true : true;
    }
}
