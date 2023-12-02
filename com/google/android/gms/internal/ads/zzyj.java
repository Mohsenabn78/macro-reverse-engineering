package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzyj {
    private boolean zzc;
    private int zze;
    private zzyi zza = new zzyi();
    private zzyi zzb = new zzyi();
    private long zzd = -9223372036854775807L;

    public final float zza() {
        if (this.zza.zzf()) {
            return (float) (1.0E9d / this.zza.zza());
        }
        return -1.0f;
    }

    public final int zzb() {
        return this.zze;
    }

    public final long zzc() {
        if (this.zza.zzf()) {
            return this.zza.zza();
        }
        return -9223372036854775807L;
    }

    public final long zzd() {
        if (this.zza.zzf()) {
            return this.zza.zzb();
        }
        return -9223372036854775807L;
    }

    public final void zze(long j4) {
        this.zza.zzc(j4);
        int i4 = 0;
        if (this.zza.zzf()) {
            this.zzc = false;
        } else if (this.zzd != -9223372036854775807L) {
            if (!this.zzc || this.zzb.zze()) {
                this.zzb.zzd();
                this.zzb.zzc(this.zzd);
            }
            this.zzc = true;
            this.zzb.zzc(j4);
        }
        if (this.zzc && this.zzb.zzf()) {
            zzyi zzyiVar = this.zza;
            this.zza = this.zzb;
            this.zzb = zzyiVar;
            this.zzc = false;
        }
        this.zzd = j4;
        if (!this.zza.zzf()) {
            i4 = this.zze + 1;
        }
        this.zze = i4;
    }

    public final void zzf() {
        this.zza.zzd();
        this.zzb.zzd();
        this.zzc = false;
        this.zzd = -9223372036854775807L;
        this.zze = 0;
    }

    public final boolean zzg() {
        return this.zza.zzf();
    }
}
