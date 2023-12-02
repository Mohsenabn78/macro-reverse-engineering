package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzlc {
    private static final zzto zzt = new zzto(new Object());
    public final zzcw zza;
    public final zzto zzb;
    public final long zzc;
    public final long zzd;
    public final int zze;
    @Nullable
    public final zzih zzf;
    public final boolean zzg;
    public final zzvn zzh;
    public final zzxh zzi;
    public final List zzj;
    public final zzto zzk;
    public final boolean zzl;
    public final int zzm;
    public final zzch zzn;
    public final boolean zzo;
    public volatile long zzp;
    public volatile long zzq;
    public volatile long zzr;
    public volatile long zzs;

    public zzlc(zzcw zzcwVar, zzto zztoVar, long j4, long j5, int i4, @Nullable zzih zzihVar, boolean z3, zzvn zzvnVar, zzxh zzxhVar, List list, zzto zztoVar2, boolean z4, int i5, zzch zzchVar, long j6, long j7, long j8, long j9, boolean z5) {
        this.zza = zzcwVar;
        this.zzb = zztoVar;
        this.zzc = j4;
        this.zzd = j5;
        this.zze = i4;
        this.zzf = zzihVar;
        this.zzg = z3;
        this.zzh = zzvnVar;
        this.zzi = zzxhVar;
        this.zzj = list;
        this.zzk = zztoVar2;
        this.zzl = z4;
        this.zzm = i5;
        this.zzn = zzchVar;
        this.zzp = j6;
        this.zzq = j7;
        this.zzr = j8;
        this.zzs = j9;
        this.zzo = z5;
    }

    public static zzlc zzi(zzxh zzxhVar) {
        zzcw zzcwVar = zzcw.zza;
        zzto zztoVar = zzt;
        return new zzlc(zzcwVar, zztoVar, -9223372036854775807L, 0L, 1, null, false, zzvn.zza, zzxhVar, zzfsc.zzl(), zztoVar, false, 0, zzch.zza, 0L, 0L, 0L, 0L, false);
    }

    public static zzto zzj() {
        return zzt;
    }

    public final long zza() {
        long j4;
        long j5;
        if (zzk()) {
            do {
                j4 = this.zzs;
                j5 = this.zzr;
            } while (j4 != this.zzs);
            return zzfj.zzo(zzfj.zzq(j5) + (((float) (SystemClock.elapsedRealtime() - j4)) * this.zzn.zzc));
        }
        return this.zzr;
    }

    @CheckResult
    public final zzlc zzb() {
        return new zzlc(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzp, this.zzq, zza(), SystemClock.elapsedRealtime(), this.zzo);
    }

    @CheckResult
    public final zzlc zzc(zzto zztoVar) {
        return new zzlc(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, zztoVar, this.zzl, this.zzm, this.zzn, this.zzp, this.zzq, this.zzr, this.zzs, this.zzo);
    }

    @CheckResult
    public final zzlc zzd(zzto zztoVar, long j4, long j5, long j6, long j7, zzvn zzvnVar, zzxh zzxhVar, List list) {
        return new zzlc(this.zza, zztoVar, j5, j6, this.zze, this.zzf, this.zzg, zzvnVar, zzxhVar, list, this.zzk, this.zzl, this.zzm, this.zzn, this.zzp, j7, j4, SystemClock.elapsedRealtime(), this.zzo);
    }

    @CheckResult
    public final zzlc zze(boolean z3, int i4) {
        return new zzlc(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, z3, i4, this.zzn, this.zzp, this.zzq, this.zzr, this.zzs, this.zzo);
    }

    @CheckResult
    public final zzlc zzf(@Nullable zzih zzihVar) {
        return new zzlc(this.zza, this.zzb, this.zzc, this.zzd, this.zze, zzihVar, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzp, this.zzq, this.zzr, this.zzs, this.zzo);
    }

    @CheckResult
    public final zzlc zzg(int i4) {
        return new zzlc(this.zza, this.zzb, this.zzc, this.zzd, i4, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzp, this.zzq, this.zzr, this.zzs, this.zzo);
    }

    @CheckResult
    public final zzlc zzh(zzcw zzcwVar) {
        return new zzlc(zzcwVar, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzp, this.zzq, this.zzr, this.zzs, this.zzo);
    }

    public final boolean zzk() {
        if (this.zze == 3 && this.zzl && this.zzm == 0) {
            return true;
        }
        return false;
    }
}
