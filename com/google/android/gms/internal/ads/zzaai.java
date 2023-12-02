package com.google.android.gms.internal.ads;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public class zzaai {
    protected final zzaac zza;
    protected final zzaah zzb;
    @Nullable
    protected zzaae zzc;
    private final int zzd;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzaai(zzaaf zzaafVar, zzaah zzaahVar, long j4, long j5, long j6, long j7, long j8, long j9, int i4) {
        this.zzb = zzaahVar;
        this.zzd = i4;
        this.zza = new zzaac(zzaafVar, j4, 0L, j6, j7, j8, j9);
    }

    protected static final int zzf(zzaax zzaaxVar, long j4, zzabs zzabsVar) {
        if (j4 == zzaaxVar.zzf()) {
            return 0;
        }
        zzabsVar.zza = j4;
        return 1;
    }

    protected static final boolean zzg(zzaax zzaaxVar, long j4) throws IOException {
        long zzf = j4 - zzaaxVar.zzf();
        if (zzf < 0 || zzf > PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            return false;
        }
        ((zzaam) zzaaxVar).zzo((int) zzf, false);
        return true;
    }

    public final int zza(zzaax zzaaxVar, zzabs zzabsVar) throws IOException {
        long j4;
        long j5;
        long j6;
        long j7;
        int i4;
        long j8;
        long j9;
        long j10;
        long j11;
        long j12;
        long j13;
        long j14;
        while (true) {
            zzaae zzaaeVar = this.zzc;
            zzdy.zzb(zzaaeVar);
            j4 = zzaaeVar.zzf;
            j5 = zzaaeVar.zzg;
            j6 = zzaaeVar.zzh;
            if (j5 - j4 <= this.zzd) {
                zzc(false, j4);
                return zzf(zzaaxVar, j4, zzabsVar);
            } else if (!zzg(zzaaxVar, j6)) {
                return zzf(zzaaxVar, j6, zzabsVar);
            } else {
                zzaaxVar.zzj();
                zzaah zzaahVar = this.zzb;
                j7 = zzaaeVar.zzb;
                zzaag zza = zzaahVar.zza(zzaaxVar, j7);
                i4 = zza.zzb;
                if (i4 != -3) {
                    if (i4 == -2) {
                        j13 = zza.zzc;
                        j14 = zza.zzd;
                        zzaae.zzh(zzaaeVar, j13, j14);
                    } else if (i4 != -1) {
                        j8 = zza.zzd;
                        zzg(zzaaxVar, j8);
                        j9 = zza.zzd;
                        zzc(true, j9);
                        j10 = zza.zzd;
                        return zzf(zzaaxVar, j10, zzabsVar);
                    } else {
                        j11 = zza.zzc;
                        j12 = zza.zzd;
                        zzaae.zzg(zzaaeVar, j11, j12);
                    }
                } else {
                    zzc(false, j6);
                    return zzf(zzaaxVar, j6, zzabsVar);
                }
            }
        }
    }

    public final zzabv zzb() {
        return this.zza;
    }

    protected final void zzc(boolean z3, long j4) {
        this.zzc = null;
        this.zzb.zzb();
    }

    public final void zzd(long j4) {
        long j5;
        long j6;
        long j7;
        long j8;
        long j9;
        zzaae zzaaeVar = this.zzc;
        if (zzaaeVar != null) {
            j9 = zzaaeVar.zza;
            if (j9 == j4) {
                return;
            }
        }
        long zzf = this.zza.zzf(j4);
        zzaac zzaacVar = this.zza;
        j5 = zzaacVar.zzc;
        j6 = zzaacVar.zzd;
        j7 = zzaacVar.zze;
        j8 = zzaacVar.zzf;
        this.zzc = new zzaae(j4, zzf, 0L, j5, j6, j7, j8);
    }

    public final boolean zze() {
        if (this.zzc != null) {
            return true;
        }
        return false;
    }
}
