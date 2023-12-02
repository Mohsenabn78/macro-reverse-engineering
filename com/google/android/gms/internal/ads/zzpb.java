package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzpb {
    @Nullable
    private final zzpa zza;
    private int zzb;
    private long zzc;
    private long zzd;
    private long zze;
    private long zzf;

    public zzpb(AudioTrack audioTrack) {
        int i4 = zzfj.zza;
        this.zza = new zzpa(audioTrack);
        zzh(0);
    }

    private final void zzh(int i4) {
        this.zzb = i4;
        long j4 = 10000;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2 && i4 != 3) {
                    j4 = 500000;
                } else {
                    j4 = 10000000;
                }
            } else {
                this.zzd = 10000L;
                return;
            }
        } else {
            this.zze = 0L;
            this.zzf = -1L;
            this.zzc = System.nanoTime() / 1000;
        }
        this.zzd = j4;
    }

    @TargetApi(19)
    public final long zza() {
        return this.zza.zza();
    }

    @TargetApi(19)
    public final long zzb() {
        return this.zza.zzb();
    }

    public final void zzc() {
        if (this.zzb == 4) {
            zzh(0);
        }
    }

    public final void zzd() {
        zzh(4);
    }

    public final void zze() {
        zzh(0);
    }

    public final boolean zzf() {
        if (this.zzb == 2) {
            return true;
        }
        return false;
    }

    @TargetApi(19)
    public final boolean zzg(long j4) {
        zzpa zzpaVar = this.zza;
        if (j4 - this.zze < this.zzd) {
            return false;
        }
        this.zze = j4;
        boolean zzc = zzpaVar.zzc();
        int i4 = this.zzb;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 == 3) {
                        if (!zzc) {
                            return false;
                        }
                        zzh(0);
                        return true;
                    }
                } else if (zzc) {
                    return true;
                } else {
                    zzh(0);
                    return false;
                }
            } else if (zzc) {
                if (this.zza.zza() > this.zzf) {
                    zzh(2);
                    return true;
                }
            } else {
                zzh(0);
            }
        } else if (zzc) {
            if (this.zza.zzb() < this.zzc) {
                return false;
            }
            this.zzf = this.zza.zza();
            zzh(1);
            return true;
        } else if (j4 - this.zzc > 500000) {
            zzh(3);
            return false;
        }
        return zzc;
    }
}
