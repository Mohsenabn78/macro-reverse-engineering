package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzuc implements zztm, zztl {
    private final zztm zza;
    private final long zzb;
    private zztl zzc;

    public zzuc(zztm zztmVar, long j4) {
        this.zza = zztmVar;
        this.zzb = j4;
    }

    @Override // com.google.android.gms.internal.ads.zztm
    public final long zza(long j4, zzlm zzlmVar) {
        return this.zza.zza(j4 - this.zzb, zzlmVar) + this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zztm, com.google.android.gms.internal.ads.zzvh
    public final long zzb() {
        long zzb = this.zza.zzb();
        if (zzb == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return zzb + this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zztm, com.google.android.gms.internal.ads.zzvh
    public final long zzc() {
        long zzc = this.zza.zzc();
        if (zzc == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return zzc + this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zztm
    public final long zzd() {
        long zzd = this.zza.zzd();
        if (zzd == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return zzd + this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zztm
    public final long zze(long j4) {
        return this.zza.zze(j4 - this.zzb) + this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zztm
    public final long zzf(zzxa[] zzxaVarArr, boolean[] zArr, zzvf[] zzvfVarArr, boolean[] zArr2, long j4) {
        zzvf[] zzvfVarArr2 = new zzvf[zzvfVarArr.length];
        int i4 = 0;
        while (true) {
            zzvf zzvfVar = null;
            if (i4 >= zzvfVarArr.length) {
                break;
            }
            zzud zzudVar = (zzud) zzvfVarArr[i4];
            if (zzudVar != null) {
                zzvfVar = zzudVar.zzc();
            }
            zzvfVarArr2[i4] = zzvfVar;
            i4++;
        }
        long zzf = this.zza.zzf(zzxaVarArr, zArr, zzvfVarArr2, zArr2, j4 - this.zzb);
        for (int i5 = 0; i5 < zzvfVarArr.length; i5++) {
            zzvf zzvfVar2 = zzvfVarArr2[i5];
            if (zzvfVar2 == null) {
                zzvfVarArr[i5] = null;
            } else {
                zzvf zzvfVar3 = zzvfVarArr[i5];
                if (zzvfVar3 == null || ((zzud) zzvfVar3).zzc() != zzvfVar2) {
                    zzvfVarArr[i5] = new zzud(zzvfVar2, this.zzb);
                }
            }
        }
        return zzf + this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzvg
    public final /* bridge */ /* synthetic */ void zzg(zzvh zzvhVar) {
        zztm zztmVar = (zztm) zzvhVar;
        zztl zztlVar = this.zzc;
        zztlVar.getClass();
        zztlVar.zzg(this);
    }

    @Override // com.google.android.gms.internal.ads.zztm
    public final zzvn zzh() {
        return this.zza.zzh();
    }

    @Override // com.google.android.gms.internal.ads.zztl
    public final void zzi(zztm zztmVar) {
        zztl zztlVar = this.zzc;
        zztlVar.getClass();
        zztlVar.zzi(this);
    }

    @Override // com.google.android.gms.internal.ads.zztm
    public final void zzj(long j4, boolean z3) {
        this.zza.zzj(j4 - this.zzb, false);
    }

    @Override // com.google.android.gms.internal.ads.zztm
    public final void zzk() throws IOException {
        this.zza.zzk();
    }

    @Override // com.google.android.gms.internal.ads.zztm
    public final void zzl(zztl zztlVar, long j4) {
        this.zzc = zztlVar;
        this.zza.zzl(this, j4 - this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zztm, com.google.android.gms.internal.ads.zzvh
    public final void zzm(long j4) {
        this.zza.zzm(j4 - this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zztm, com.google.android.gms.internal.ads.zzvh
    public final boolean zzo(long j4) {
        return this.zza.zzo(j4 - this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zztm, com.google.android.gms.internal.ads.zzvh
    public final boolean zzp() {
        return this.zza.zzp();
    }
}
