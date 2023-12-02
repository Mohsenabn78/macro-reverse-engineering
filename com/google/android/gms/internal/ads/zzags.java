package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzags {
    public final zzabz zza;
    public zzahf zzd;
    public zzago zze;
    public int zzf;
    public int zzg;
    public int zzh;
    public int zzi;
    private boolean zzl;
    public final zzahe zzb = new zzahe();
    public final zzfa zzc = new zzfa();
    private final zzfa zzj = new zzfa(1);
    private final zzfa zzk = new zzfa();

    public zzags(zzabz zzabzVar, zzahf zzahfVar, zzago zzagoVar) {
        this.zza = zzabzVar;
        this.zzd = zzahfVar;
        this.zze = zzagoVar;
        zzh(zzahfVar, zzagoVar);
    }

    public final int zza() {
        int i4;
        if (!this.zzl) {
            i4 = this.zzd.zzg[this.zzf];
        } else if (this.zzb.zzj[this.zzf]) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        if (zzf() != null) {
            return i4 | 1073741824;
        }
        return i4;
    }

    public final int zzb() {
        if (!this.zzl) {
            return this.zzd.zzd[this.zzf];
        }
        return this.zzb.zzh[this.zzf];
    }

    public final int zzc(int i4, int i5) {
        zzfa zzfaVar;
        boolean z3;
        int i6;
        zzahd zzf = zzf();
        if (zzf == null) {
            return 0;
        }
        int i7 = zzf.zzd;
        if (i7 != 0) {
            zzfaVar = this.zzb.zzn;
        } else {
            byte[] bArr = zzf.zze;
            int i8 = zzfj.zza;
            zzfa zzfaVar2 = this.zzk;
            int length = bArr.length;
            zzfaVar2.zzD(bArr, length);
            zzfaVar = this.zzk;
            i7 = length;
        }
        boolean zzb = this.zzb.zzb(this.zzf);
        if (!zzb && i5 == 0) {
            z3 = false;
        } else {
            z3 = true;
        }
        zzfa zzfaVar3 = this.zzj;
        byte[] zzH = zzfaVar3.zzH();
        if (true != z3) {
            i6 = 0;
        } else {
            i6 = 128;
        }
        zzH[0] = (byte) (i6 | i7);
        zzfaVar3.zzF(0);
        this.zza.zzr(this.zzj, 1, 1);
        this.zza.zzr(zzfaVar, i7, 1);
        if (!z3) {
            return i7 + 1;
        }
        if (!zzb) {
            this.zzc.zzC(8);
            zzfa zzfaVar4 = this.zzc;
            byte[] zzH2 = zzfaVar4.zzH();
            zzH2[0] = 0;
            zzH2[1] = 1;
            zzH2[2] = 0;
            zzH2[3] = (byte) i5;
            zzH2[4] = (byte) ((i4 >> 24) & 255);
            zzH2[5] = (byte) ((i4 >> 16) & 255);
            zzH2[6] = (byte) ((i4 >> 8) & 255);
            zzH2[7] = (byte) (i4 & 255);
            this.zza.zzr(zzfaVar4, 8, 1);
            return i7 + 9;
        }
        zzfa zzfaVar5 = this.zzb.zzn;
        int zzo = zzfaVar5.zzo();
        zzfaVar5.zzG(-2);
        int i9 = (zzo * 6) + 2;
        if (i5 != 0) {
            this.zzc.zzC(i9);
            byte[] zzH3 = this.zzc.zzH();
            zzfaVar5.zzB(zzH3, 0, i9);
            int i10 = (((zzH3[2] & 255) << 8) | (zzH3[3] & 255)) + i5;
            zzH3[2] = (byte) ((i10 >> 8) & 255);
            zzH3[3] = (byte) (i10 & 255);
            zzfaVar5 = this.zzc;
        }
        this.zza.zzr(zzfaVar5, i9, 1);
        return i7 + 1 + i9;
    }

    public final long zzd() {
        if (!this.zzl) {
            return this.zzd.zzc[this.zzf];
        }
        return this.zzb.zzf[this.zzh];
    }

    public final long zze() {
        if (!this.zzl) {
            return this.zzd.zzf[this.zzf];
        }
        zzahe zzaheVar = this.zzb;
        return zzaheVar.zzi[this.zzf];
    }

    @Nullable
    public final zzahd zzf() {
        if (!this.zzl) {
            return null;
        }
        zzahe zzaheVar = this.zzb;
        zzago zzagoVar = zzaheVar.zza;
        int i4 = zzfj.zza;
        int i5 = zzagoVar.zza;
        zzahd zzahdVar = zzaheVar.zzm;
        if (zzahdVar == null) {
            zzahdVar = this.zzd.zza.zza(i5);
        }
        if (zzahdVar == null || !zzahdVar.zza) {
            return null;
        }
        return zzahdVar;
    }

    public final void zzh(zzahf zzahfVar, zzago zzagoVar) {
        this.zzd = zzahfVar;
        this.zze = zzagoVar;
        this.zza.zzk(zzahfVar.zza.zzf);
        zzi();
    }

    public final void zzi() {
        zzahe zzaheVar = this.zzb;
        zzaheVar.zzd = 0;
        zzaheVar.zzp = 0L;
        zzaheVar.zzq = false;
        zzaheVar.zzk = false;
        zzaheVar.zzo = false;
        zzaheVar.zzm = null;
        this.zzf = 0;
        this.zzh = 0;
        this.zzg = 0;
        this.zzi = 0;
        this.zzl = false;
    }

    public final boolean zzk() {
        this.zzf++;
        if (!this.zzl) {
            return false;
        }
        int i4 = this.zzg + 1;
        this.zzg = i4;
        int[] iArr = this.zzb.zzg;
        int i5 = this.zzh;
        if (i4 != iArr[i5]) {
            return true;
        }
        this.zzh = i5 + 1;
        this.zzg = 0;
        return false;
    }
}
