package com.google.android.gms.internal.ads;

import androidx.annotation.CallSuper;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzve implements zzabz {
    private boolean zzA;
    private boolean zzB;
    @Nullable
    private zzqv zzC;
    private final zzuy zza;
    @Nullable
    private final zzqu zzd;
    @Nullable
    private final zzqo zze;
    @Nullable
    private zzvd zzf;
    @Nullable
    private zzam zzg;
    private int zzo;
    private int zzp;
    private int zzq;
    private int zzr;
    private boolean zzv;
    @Nullable
    private zzam zzy;
    @Nullable
    private zzam zzz;
    private final zzva zzb = new zzva();
    private int zzh = 1000;
    private long[] zzi = new long[1000];
    private long[] zzj = new long[1000];
    private long[] zzm = new long[1000];
    private int[] zzl = new int[1000];
    private int[] zzk = new int[1000];
    private zzaby[] zzn = new zzaby[1000];
    private final zzvl zzc = new zzvl(new zzec() { // from class: com.google.android.gms.internal.ads.zzuz
    });
    private long zzs = Long.MIN_VALUE;
    private long zzt = Long.MIN_VALUE;
    private long zzu = Long.MIN_VALUE;
    private boolean zzx = true;
    private boolean zzw = true;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzve(zzxp zzxpVar, @Nullable zzqu zzquVar, @Nullable zzqo zzqoVar) {
        this.zzd = zzquVar;
        this.zze = zzqoVar;
        this.zza = new zzuy(zzxpVar);
    }

    private final int zzA(int i4) {
        int i5 = this.zzq + i4;
        int i6 = this.zzh;
        if (i5 < i6) {
            return i5;
        }
        return i5 - i6;
    }

    private final synchronized int zzB(zzkj zzkjVar, zzhp zzhpVar, boolean z3, boolean z4, zzva zzvaVar) {
        zzhpVar.zzc = false;
        if (!zzJ()) {
            if (!z4 && !this.zzv) {
                zzam zzamVar = this.zzz;
                if (zzamVar == null || (!z3 && zzamVar == this.zzg)) {
                    return -3;
                }
                zzG(zzamVar, zzkjVar);
                return -5;
            }
            zzhpVar.zzc(4);
            return -4;
        }
        zzam zzamVar2 = ((zzvc) this.zzc.zza(this.zzp + this.zzr)).zza;
        if (!z3 && zzamVar2 == this.zzg) {
            int zzA = zzA(this.zzr);
            if (!zzK(zzA)) {
                zzhpVar.zzc = true;
                return -3;
            }
            zzhpVar.zzc(this.zzl[zzA]);
            if (this.zzr == this.zzo - 1 && (z4 || this.zzv)) {
                zzhpVar.zza(536870912);
            }
            long j4 = this.zzm[zzA];
            zzhpVar.zzd = j4;
            if (j4 < this.zzs) {
                zzhpVar.zza(Integer.MIN_VALUE);
            }
            zzvaVar.zza = this.zzk[zzA];
            zzvaVar.zzb = this.zzj[zzA];
            zzvaVar.zzc = this.zzn[zzA];
            return -4;
        }
        zzG(zzamVar2, zzkjVar);
        return -5;
    }

    private final synchronized long zzC(long j4, boolean z3, boolean z4) {
        int i4;
        int i5 = this.zzo;
        if (i5 != 0) {
            long[] jArr = this.zzm;
            int i6 = this.zzq;
            if (j4 >= jArr[i6]) {
                if (z4 && (i4 = this.zzr) != i5) {
                    i5 = i4 + 1;
                }
                int zzz = zzz(i6, i5, j4, false);
                if (zzz == -1) {
                    return -1L;
                }
                return zzE(zzz);
            }
        }
        return -1L;
    }

    private final synchronized long zzD() {
        int i4 = this.zzo;
        if (i4 == 0) {
            return -1L;
        }
        return zzE(i4);
    }

    @GuardedBy("this")
    private final long zzE(int i4) {
        int i5;
        long j4 = this.zzt;
        long j5 = Long.MIN_VALUE;
        if (i4 != 0) {
            int zzA = zzA(i4 - 1);
            for (int i6 = 0; i6 < i4; i6++) {
                j5 = Math.max(j5, this.zzm[zzA]);
                if ((this.zzl[zzA] & 1) != 0) {
                    break;
                }
                zzA--;
                if (zzA == -1) {
                    zzA = this.zzh - 1;
                }
            }
        }
        this.zzt = Math.max(j4, j5);
        this.zzo -= i4;
        int i7 = this.zzp + i4;
        this.zzp = i7;
        int i8 = this.zzq + i4;
        this.zzq = i8;
        int i9 = this.zzh;
        if (i8 >= i9) {
            this.zzq = i8 - i9;
        }
        int i10 = this.zzr - i4;
        this.zzr = i10;
        if (i10 < 0) {
            this.zzr = 0;
        }
        this.zzc.zze(i7);
        if (this.zzo == 0) {
            int i11 = this.zzq;
            if (i11 == 0) {
                i11 = this.zzh;
            }
            return this.zzj[i11 - 1] + this.zzk[i5];
        }
        return this.zzj[this.zzq];
    }

    private final synchronized void zzF(long j4, int i4, long j5, int i5, @Nullable zzaby zzabyVar) {
        boolean z3;
        boolean z4;
        int i6 = this.zzo;
        if (i6 > 0) {
            int zzA = zzA(i6 - 1);
            if (this.zzj[zzA] + this.zzk[zzA] <= j5) {
                z4 = true;
            } else {
                z4 = false;
            }
            zzdy.zzd(z4);
        }
        if ((536870912 & i4) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.zzv = z3;
        this.zzu = Math.max(this.zzu, j4);
        int zzA2 = zzA(this.zzo);
        this.zzm[zzA2] = j4;
        this.zzj[zzA2] = j5;
        this.zzk[zzA2] = i5;
        this.zzl[zzA2] = i4;
        this.zzn[zzA2] = zzabyVar;
        this.zzi[zzA2] = 0;
        if (this.zzc.zzf() || !((zzvc) this.zzc.zzb()).zza.equals(this.zzz)) {
            zzqt zzqtVar = zzqt.zzb;
            zzvl zzvlVar = this.zzc;
            int i7 = this.zzp + this.zzo;
            zzam zzamVar = this.zzz;
            zzamVar.getClass();
            zzvlVar.zzc(i7, new zzvc(zzamVar, zzqtVar, null));
        }
        int i8 = this.zzo + 1;
        this.zzo = i8;
        int i9 = this.zzh;
        if (i8 == i9) {
            int i10 = i9 + 1000;
            long[] jArr = new long[i10];
            long[] jArr2 = new long[i10];
            long[] jArr3 = new long[i10];
            int[] iArr = new int[i10];
            int[] iArr2 = new int[i10];
            zzaby[] zzabyVarArr = new zzaby[i10];
            int i11 = this.zzq;
            int i12 = i9 - i11;
            System.arraycopy(this.zzj, i11, jArr2, 0, i12);
            System.arraycopy(this.zzm, this.zzq, jArr3, 0, i12);
            System.arraycopy(this.zzl, this.zzq, iArr, 0, i12);
            System.arraycopy(this.zzk, this.zzq, iArr2, 0, i12);
            System.arraycopy(this.zzn, this.zzq, zzabyVarArr, 0, i12);
            System.arraycopy(this.zzi, this.zzq, jArr, 0, i12);
            int i13 = this.zzq;
            System.arraycopy(this.zzj, 0, jArr2, i12, i13);
            System.arraycopy(this.zzm, 0, jArr3, i12, i13);
            System.arraycopy(this.zzl, 0, iArr, i12, i13);
            System.arraycopy(this.zzk, 0, iArr2, i12, i13);
            System.arraycopy(this.zzn, 0, zzabyVarArr, i12, i13);
            System.arraycopy(this.zzi, 0, jArr, i12, i13);
            this.zzj = jArr2;
            this.zzm = jArr3;
            this.zzl = iArr;
            this.zzk = iArr2;
            this.zzn = zzabyVarArr;
            this.zzi = jArr;
            this.zzq = 0;
            this.zzh = i10;
        }
    }

    private final void zzG(zzam zzamVar, zzkj zzkjVar) {
        boolean z3;
        zzad zzadVar;
        zzam zzamVar2 = this.zzg;
        if (zzamVar2 == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzqv zzqvVar = null;
        if (z3) {
            zzadVar = null;
        } else {
            zzadVar = zzamVar2.zzp;
        }
        this.zzg = zzamVar;
        zzad zzadVar2 = zzamVar.zzp;
        zzkjVar.zza = zzamVar.zzc(this.zzd.zza(zzamVar));
        zzkjVar.zzb = this.zzC;
        if (!z3 && zzfj.zzC(zzadVar, zzadVar2)) {
            return;
        }
        if (zzamVar.zzp != null) {
            zzqvVar = new zzqv(new zzqm(new zzqx(1), 6001));
        }
        this.zzC = zzqvVar;
        zzkjVar.zzb = zzqvVar;
    }

    private final void zzH() {
        if (this.zzC != null) {
            this.zzC = null;
            this.zzg = null;
        }
    }

    private final synchronized void zzI() {
        this.zzr = 0;
        this.zza.zzg();
    }

    private final boolean zzJ() {
        if (this.zzr != this.zzo) {
            return true;
        }
        return false;
    }

    private final boolean zzK(int i4) {
        if (this.zzC != null) {
            return (this.zzl[i4] & 1073741824) != 0 ? false : false;
        }
        return true;
    }

    private final synchronized boolean zzL(zzam zzamVar) {
        this.zzx = false;
        if (zzfj.zzC(zzamVar, this.zzz)) {
            return false;
        }
        if (!this.zzc.zzf() && ((zzvc) this.zzc.zzb()).zza.equals(zzamVar)) {
            this.zzz = ((zzvc) this.zzc.zzb()).zza;
        } else {
            this.zzz = zzamVar;
        }
        zzam zzamVar2 = this.zzz;
        this.zzA = zzcc.zze(zzamVar2.zzm, zzamVar2.zzj);
        this.zzB = false;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzl(zzvc zzvcVar) {
        zzqt zzqtVar = zzvcVar.zzb;
        int i4 = zzqs.zza;
    }

    private final int zzz(int i4, int i5, long j4, boolean z3) {
        int i6 = -1;
        for (int i7 = 0; i7 < i5; i7++) {
            int i8 = (this.zzm[i4] > j4 ? 1 : (this.zzm[i4] == j4 ? 0 : -1));
            if (i8 > 0) {
                break;
            }
            if (!z3 || (this.zzl[i4] & 1) != 0) {
                i6 = i7;
                if (i8 == 0) {
                    break;
                }
            }
            i4++;
            if (i4 == this.zzh) {
                i4 = 0;
            }
        }
        return i6;
    }

    public final int zza() {
        return this.zzp + this.zzr;
    }

    public final synchronized int zzb(long j4, boolean z3) {
        int i4 = this.zzr;
        int zzA = zzA(i4);
        if (zzJ() && j4 >= this.zzm[zzA]) {
            if (j4 > this.zzu && z3) {
                return this.zzo - i4;
            }
            int zzz = zzz(zzA, this.zzo - i4, j4, true);
            if (zzz == -1) {
                return 0;
            }
            return zzz;
        }
        return 0;
    }

    public final int zzc() {
        return this.zzp + this.zzo;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0034, code lost:
        if (r9 != 0) goto L17;
     */
    @androidx.annotation.CallSuper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zzd(com.google.android.gms.internal.ads.zzkj r9, com.google.android.gms.internal.ads.zzhp r10, int r11, boolean r12) {
        /*
            r8 = this;
            r0 = r11 & 2
            r1 = 1
            if (r0 == 0) goto L7
            r5 = 1
            goto L9
        L7:
            r0 = 0
            r5 = 0
        L9:
            com.google.android.gms.internal.ads.zzva r7 = r8.zzb
            r2 = r8
            r3 = r9
            r4 = r10
            r6 = r12
            int r9 = r2.zzB(r3, r4, r5, r6, r7)
            r12 = -4
            if (r9 != r12) goto L3e
            boolean r9 = r10.zzg()
            if (r9 != 0) goto L3d
            r9 = r11 & 1
            r11 = r11 & 4
            if (r11 != 0) goto L34
            if (r9 == 0) goto L2c
            com.google.android.gms.internal.ads.zzuy r9 = r8.zza
            com.google.android.gms.internal.ads.zzva r11 = r8.zzb
            r9.zzd(r10, r11)
            goto L3d
        L2c:
            com.google.android.gms.internal.ads.zzuy r9 = r8.zza
            com.google.android.gms.internal.ads.zzva r11 = r8.zzb
            r9.zze(r10, r11)
            goto L37
        L34:
            if (r9 == 0) goto L37
            goto L3d
        L37:
            int r9 = r8.zzr
            int r9 = r9 + r1
            r8.zzr = r9
            return r12
        L3d:
            r9 = -4
        L3e:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzve.zzd(com.google.android.gms.internal.ads.zzkj, com.google.android.gms.internal.ads.zzhp, int, boolean):int");
    }

    @Override // com.google.android.gms.internal.ads.zzabz
    public final /* synthetic */ int zze(zzt zztVar, int i4, boolean z3) {
        return zzabx.zza(this, zztVar, i4, z3);
    }

    @Override // com.google.android.gms.internal.ads.zzabz
    public final int zzf(zzt zztVar, int i4, boolean z3, int i5) throws IOException {
        return this.zza.zza(zztVar, i4, z3);
    }

    public final synchronized long zzg() {
        return this.zzu;
    }

    @Nullable
    public final synchronized zzam zzh() {
        if (this.zzx) {
            return null;
        }
        return this.zzz;
    }

    public final void zzi(long j4, boolean z3, boolean z4) {
        this.zza.zzc(zzC(j4, false, z4));
    }

    public final void zzj() {
        this.zza.zzc(zzD());
    }

    @Override // com.google.android.gms.internal.ads.zzabz
    public final void zzk(zzam zzamVar) {
        this.zzy = zzamVar;
        boolean zzL = zzL(zzamVar);
        zzvd zzvdVar = this.zzf;
        if (zzvdVar != null && zzL) {
            zzvdVar.zzL(zzamVar);
        }
    }

    @CallSuper
    public final void zzm() throws IOException {
        zzqv zzqvVar = this.zzC;
        if (zzqvVar == null) {
            return;
        }
        throw zzqvVar.zza();
    }

    @CallSuper
    public final void zzn() {
        zzj();
        zzH();
    }

    @CallSuper
    public final void zzo() {
        zzp(true);
        zzH();
    }

    @CallSuper
    public final void zzp(boolean z3) {
        this.zza.zzf();
        this.zzo = 0;
        this.zzp = 0;
        this.zzq = 0;
        this.zzr = 0;
        this.zzw = true;
        this.zzs = Long.MIN_VALUE;
        this.zzt = Long.MIN_VALUE;
        this.zzu = Long.MIN_VALUE;
        this.zzv = false;
        this.zzc.zzd();
        if (z3) {
            this.zzy = null;
            this.zzz = null;
            this.zzx = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzabz
    public final /* synthetic */ void zzq(zzfa zzfaVar, int i4) {
        zzabx.zzb(this, zzfaVar, i4);
    }

    @Override // com.google.android.gms.internal.ads.zzabz
    public final void zzr(zzfa zzfaVar, int i4, int i5) {
        this.zza.zzh(zzfaVar, i4);
    }

    @Override // com.google.android.gms.internal.ads.zzabz
    public final void zzs(long j4, int i4, int i5, int i6, @Nullable zzaby zzabyVar) {
        if (this.zzw) {
            if ((i4 & 1) == 0) {
                return;
            }
            this.zzw = false;
        }
        if (this.zzA) {
            if (j4 < this.zzs) {
                return;
            }
            if ((i4 & 1) == 0) {
                if (!this.zzB) {
                    zzer.zzf("SampleQueue", "Overriding unexpected non-sync sample for format: ".concat(String.valueOf(this.zzz)));
                    this.zzB = true;
                }
                i4 |= 1;
            }
        }
        zzF(j4, i4, (this.zza.zzb() - i5) - i6, i5, zzabyVar);
    }

    public final void zzt(long j4) {
        this.zzs = j4;
    }

    public final void zzu(@Nullable zzvd zzvdVar) {
        this.zzf = zzvdVar;
    }

    public final synchronized void zzv(int i4) {
        boolean z3 = false;
        if (i4 >= 0) {
            try {
                if (this.zzr + i4 <= this.zzo) {
                    z3 = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        zzdy.zzd(z3);
        this.zzr += i4;
    }

    public final synchronized boolean zzw() {
        return this.zzv;
    }

    @CallSuper
    public final synchronized boolean zzx(boolean z3) {
        boolean z4 = true;
        if (!zzJ()) {
            if (!z3 && !this.zzv) {
                zzam zzamVar = this.zzz;
                if (zzamVar != null) {
                    if (zzamVar == this.zzg) {
                        return false;
                    }
                } else {
                    z4 = false;
                }
            }
            return z4;
        } else if (((zzvc) this.zzc.zza(this.zzp + this.zzr)).zza != this.zzg) {
            return true;
        } else {
            return zzK(zzA(this.zzr));
        }
    }

    public final synchronized boolean zzy(long j4, boolean z3) {
        zzI();
        int i4 = this.zzr;
        int zzA = zzA(i4);
        if (!zzJ() || j4 < this.zzm[zzA] || (j4 > this.zzu && !z3)) {
            return false;
        }
        int zzz = zzz(zzA, this.zzo - i4, j4, true);
        if (zzz == -1) {
            return false;
        }
        this.zzs = j4;
        this.zzr += zzz;
        return true;
    }
}
