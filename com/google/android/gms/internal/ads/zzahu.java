package com.google.android.gms.internal.ads;

import androidx.compose.animation.core.AnimationKt;
import java.io.IOException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public abstract class zzahu {
    private zzabz zzb;
    private zzaaz zzc;
    private zzahp zzd;
    private long zze;
    private long zzf;
    private long zzg;
    private int zzh;
    private int zzi;
    private long zzk;
    private boolean zzl;
    private boolean zzm;
    private final zzahn zza = new zzahn();
    private zzahr zzj = new zzahr();

    protected abstract long zza(zzfa zzfaVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzb(boolean z3) {
        int i4;
        if (z3) {
            this.zzj = new zzahr();
            this.zzf = 0L;
            i4 = 0;
        } else {
            i4 = 1;
        }
        this.zzh = i4;
        this.zze = -1L;
        this.zzg = 0L;
    }

    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    protected abstract boolean zzc(zzfa zzfaVar, long j4, zzahr zzahrVar) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zze(zzaax zzaaxVar, zzabs zzabsVar) throws IOException {
        boolean z3;
        zzdy.zzb(this.zzb);
        int i4 = zzfj.zza;
        int i5 = this.zzh;
        if (i5 != 0) {
            if (i5 != 1) {
                if (i5 != 2) {
                    return -1;
                }
                long zzd = this.zzd.zzd(zzaaxVar);
                if (zzd >= 0) {
                    zzabsVar.zza = zzd;
                    return 1;
                }
                if (zzd < -1) {
                    zzi(-(zzd + 2));
                }
                if (!this.zzl) {
                    zzabv zze = this.zzd.zze();
                    zzdy.zzb(zze);
                    this.zzc.zzN(zze);
                    this.zzl = true;
                }
                if (this.zzk <= 0 && !this.zza.zze(zzaaxVar)) {
                    this.zzh = 3;
                    return -1;
                }
                this.zzk = 0L;
                zzfa zza = this.zza.zza();
                long zza2 = zza(zza);
                if (zza2 >= 0) {
                    long j4 = this.zzg;
                    if (j4 + zza2 >= this.zze) {
                        long zzf = zzf(j4);
                        zzabx.zzb(this.zzb, zza, zza.zzd());
                        this.zzb.zzs(zzf, 1, zza.zzd(), 0, null);
                        this.zze = -1L;
                    }
                }
                this.zzg += zza2;
                return 0;
            }
            ((zzaam) zzaaxVar).zzo((int) this.zzf, false);
            this.zzh = 2;
            return 0;
        }
        while (this.zza.zze(zzaaxVar)) {
            long zzf2 = zzaaxVar.zzf();
            long j5 = this.zzf;
            this.zzk = zzf2 - j5;
            if (zzc(this.zza.zza(), j5, this.zzj)) {
                this.zzf = zzaaxVar.zzf();
            } else {
                zzam zzamVar = this.zzj.zza;
                this.zzi = zzamVar.zzA;
                if (!this.zzm) {
                    this.zzb.zzk(zzamVar);
                    this.zzm = true;
                }
                zzahp zzahpVar = this.zzj.zzb;
                if (zzahpVar != null) {
                    this.zzd = zzahpVar;
                } else if (zzaaxVar.zzd() == -1) {
                    this.zzd = new zzaht(null);
                } else {
                    zzaho zzb = this.zza.zzb();
                    if ((zzb.zza & 4) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    this.zzd = new zzahi(this, this.zzf, zzaaxVar.zzd(), zzb.zzd + zzb.zze, zzb.zzb, z3);
                }
                this.zzh = 2;
                this.zza.zzd();
                return 0;
            }
        }
        this.zzh = 3;
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long zzf(long j4) {
        return (j4 * AnimationKt.MillisToNanos) / this.zzi;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long zzg(long j4) {
        return (this.zzi * j4) / AnimationKt.MillisToNanos;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzh(zzaaz zzaazVar, zzabz zzabzVar) {
        this.zzc = zzaazVar;
        this.zzb = zzabzVar;
        zzb(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzi(long j4) {
        this.zzg = j4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzj(long j4, long j5) {
        this.zza.zzc();
        if (j4 == 0) {
            zzb(!this.zzl);
        } else if (this.zzh != 0) {
            long zzg = zzg(j5);
            this.zze = zzg;
            zzahp zzahpVar = this.zzd;
            int i4 = zzfj.zza;
            zzahpVar.zzg(zzg);
            this.zzh = 2;
        }
    }
}
