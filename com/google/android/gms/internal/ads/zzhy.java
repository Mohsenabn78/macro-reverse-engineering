package com.google.android.gms.internal.ads;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public abstract class zzhy implements zzli, zzlk {
    private final int zzb;
    @Nullable
    private zzll zzd;
    private int zze;
    private zzoc zzf;
    private int zzg;
    @Nullable
    private zzvf zzh;
    @Nullable
    private zzam[] zzi;
    private long zzj;
    private boolean zzl;
    private boolean zzm;
    @Nullable
    @GuardedBy("lock")
    private zzlj zzn;
    private final Object zza = new Object();
    private final zzkj zzc = new zzkj();
    private long zzk = Long.MIN_VALUE;

    public zzhy(int i4) {
        this.zzb = i4;
    }

    private final void zzS(long j4, boolean z3) throws zzih {
        this.zzl = false;
        this.zzk = j4;
        zzv(j4, z3);
    }

    @Override // com.google.android.gms.internal.ads.zzli
    public final void zzA() {
        boolean z3;
        if (this.zzg == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzdy.zzf(z3);
    }

    @Override // com.google.android.gms.internal.ads.zzli
    public final void zzB(zzam[] zzamVarArr, zzvf zzvfVar, long j4, long j5) throws zzih {
        zzdy.zzf(!this.zzl);
        this.zzh = zzvfVar;
        if (this.zzk == Long.MIN_VALUE) {
            this.zzk = j4;
        }
        this.zzi = zzamVarArr;
        this.zzj = j5;
        zzz(zzamVarArr, j4, j5);
    }

    @Override // com.google.android.gms.internal.ads.zzli
    public final void zzC() {
        boolean z3;
        if (this.zzg == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzdy.zzf(z3);
        zzkj zzkjVar = this.zzc;
        zzkjVar.zzb = null;
        zzkjVar.zza = null;
        zzw();
    }

    @Override // com.google.android.gms.internal.ads.zzli
    public final void zzD(long j4) throws zzih {
        zzS(j4, false);
    }

    @Override // com.google.android.gms.internal.ads.zzli
    public final void zzE() {
        this.zzl = true;
    }

    @Override // com.google.android.gms.internal.ads.zzlk
    public final void zzF(zzlj zzljVar) {
        synchronized (this.zza) {
            this.zzn = zzljVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzli
    public final void zzH() throws zzih {
        boolean z3 = true;
        if (this.zzg != 1) {
            z3 = false;
        }
        zzdy.zzf(z3);
        this.zzg = 2;
        zzx();
    }

    @Override // com.google.android.gms.internal.ads.zzli
    public final void zzI() {
        boolean z3;
        if (this.zzg == 2) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzdy.zzf(z3);
        this.zzg = 1;
        zzy();
    }

    @Override // com.google.android.gms.internal.ads.zzli
    public final boolean zzJ() {
        if (this.zzk == Long.MIN_VALUE) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzli
    public final boolean zzK() {
        return this.zzl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean zzL() {
        if (zzJ()) {
            return this.zzl;
        }
        zzvf zzvfVar = this.zzh;
        zzvfVar.getClass();
        return zzvfVar.zze();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzam[] zzM() {
        zzam[] zzamVarArr = this.zzi;
        zzamVarArr.getClass();
        return zzamVarArr;
    }

    @Override // com.google.android.gms.internal.ads.zzli, com.google.android.gms.internal.ads.zzlk
    public final int zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzli
    public final int zzbc() {
        return this.zzg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int zzbd(zzkj zzkjVar, zzhp zzhpVar, int i4) {
        zzvf zzvfVar = this.zzh;
        zzvfVar.getClass();
        int zza = zzvfVar.zza(zzkjVar, zzhpVar, i4);
        if (zza == -4) {
            if (zzhpVar.zzg()) {
                this.zzk = Long.MIN_VALUE;
                if (this.zzl) {
                    return -4;
                }
                return -3;
            }
            long j4 = zzhpVar.zzd + this.zzj;
            zzhpVar.zzd = j4;
            this.zzk = Math.max(this.zzk, j4);
        } else if (zza == -5) {
            zzam zzamVar = zzkjVar.zza;
            zzamVar.getClass();
            long j5 = zzamVar.zzq;
            if (j5 != Long.MAX_VALUE) {
                zzak zzb = zzamVar.zzb();
                zzb.zzW(j5 + this.zzj);
                zzkjVar.zza = zzb.zzY();
                return -5;
            }
        }
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzih zzbe(Throwable th, @Nullable zzam zzamVar, boolean z3, int i4) {
        int i5;
        if (zzamVar != null && !this.zzm) {
            this.zzm = true;
            try {
                int zzR = zzR(zzamVar) & 7;
                this.zzm = false;
                i5 = zzR;
            } catch (zzih unused) {
                this.zzm = false;
            } catch (Throwable th2) {
                this.zzm = false;
                throw th2;
            }
            return zzih.zzb(th, zzN(), this.zze, zzamVar, i5, z3, i4);
        }
        i5 = 4;
        return zzih.zzb(th, zzN(), this.zze, zzamVar, i5, z3, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int zzd(long j4) {
        zzvf zzvfVar = this.zzh;
        zzvfVar.getClass();
        return zzvfVar.zzb(j4 - this.zzj);
    }

    @Override // com.google.android.gms.internal.ads.zzlk
    public int zze() throws zzih {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzli
    public final long zzf() {
        return this.zzk;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzkj zzh() {
        zzkj zzkjVar = this.zzc;
        zzkjVar.zzb = null;
        zzkjVar.zza = null;
        return zzkjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzli
    @Nullable
    public zzkl zzi() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzll zzk() {
        zzll zzllVar = this.zzd;
        zzllVar.getClass();
        return zzllVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzoc zzl() {
        zzoc zzocVar = this.zzf;
        zzocVar.getClass();
        return zzocVar;
    }

    @Override // com.google.android.gms.internal.ads.zzli
    @Nullable
    public final zzvf zzm() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzlk
    public final void zzn() {
        synchronized (this.zza) {
            this.zzn = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzli
    public final void zzo() {
        boolean z3 = true;
        if (this.zzg != 1) {
            z3 = false;
        }
        zzdy.zzf(z3);
        zzkj zzkjVar = this.zzc;
        zzkjVar.zzb = null;
        zzkjVar.zza = null;
        this.zzg = 0;
        this.zzh = null;
        this.zzi = null;
        this.zzl = false;
        zzt();
    }

    @Override // com.google.android.gms.internal.ads.zzli
    public final void zzp(zzll zzllVar, zzam[] zzamVarArr, zzvf zzvfVar, long j4, boolean z3, boolean z4, long j5, long j6) throws zzih {
        boolean z5;
        if (this.zzg == 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        zzdy.zzf(z5);
        this.zzd = zzllVar;
        this.zzg = 1;
        zzu(z3, z4);
        zzB(zzamVarArr, zzvfVar, j5, j6);
        zzS(j4, z3);
    }

    @Override // com.google.android.gms.internal.ads.zzli
    public final void zzr(int i4, zzoc zzocVar) {
        this.zze = i4;
        this.zzf = zzocVar;
    }

    @Override // com.google.android.gms.internal.ads.zzli
    public final void zzs() throws IOException {
        zzvf zzvfVar = this.zzh;
        zzvfVar.getClass();
        zzvfVar.zzd();
    }

    protected void zzt() {
        throw null;
    }

    protected void zzv(long j4, boolean z3) throws zzih {
        throw null;
    }

    protected void zzz(zzam[] zzamVarArr, long j4, long j5) throws zzih {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzli
    public final zzlk zzj() {
        return this;
    }

    protected void zzw() {
    }

    protected void zzx() throws zzih {
    }

    protected void zzy() {
    }

    @Override // com.google.android.gms.internal.ads.zzli
    public /* synthetic */ void zzG(float f4, float f5) {
    }

    @Override // com.google.android.gms.internal.ads.zzle
    public void zzq(int i4, @Nullable Object obj) throws zzih {
    }

    protected void zzu(boolean z3, boolean z4) throws zzih {
    }
}
