package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zztg implements zztm, zztl {
    public final zzto zza;
    private final long zzb;
    private zztq zzc;
    private zztm zzd;
    @Nullable
    private zztl zze;
    private long zzf = -9223372036854775807L;
    private final zzxp zzg;

    public zztg(zzto zztoVar, zzxp zzxpVar, long j4) {
        this.zza = zztoVar;
        this.zzg = zzxpVar;
        this.zzb = j4;
    }

    private final long zzv(long j4) {
        long j5 = this.zzf;
        if (j5 != -9223372036854775807L) {
            return j5;
        }
        return j4;
    }

    @Override // com.google.android.gms.internal.ads.zztm
    public final long zza(long j4, zzlm zzlmVar) {
        zztm zztmVar = this.zzd;
        int i4 = zzfj.zza;
        return zztmVar.zza(j4, zzlmVar);
    }

    @Override // com.google.android.gms.internal.ads.zztm, com.google.android.gms.internal.ads.zzvh
    public final long zzb() {
        zztm zztmVar = this.zzd;
        int i4 = zzfj.zza;
        return zztmVar.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zztm, com.google.android.gms.internal.ads.zzvh
    public final long zzc() {
        zztm zztmVar = this.zzd;
        int i4 = zzfj.zza;
        return zztmVar.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zztm
    public final long zzd() {
        zztm zztmVar = this.zzd;
        int i4 = zzfj.zza;
        return zztmVar.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zztm
    public final long zze(long j4) {
        zztm zztmVar = this.zzd;
        int i4 = zzfj.zza;
        return zztmVar.zze(j4);
    }

    @Override // com.google.android.gms.internal.ads.zztm
    public final long zzf(zzxa[] zzxaVarArr, boolean[] zArr, zzvf[] zzvfVarArr, boolean[] zArr2, long j4) {
        long j5;
        long j6 = this.zzf;
        if (j6 != -9223372036854775807L && j4 == this.zzb) {
            this.zzf = -9223372036854775807L;
            j5 = j6;
        } else {
            j5 = j4;
        }
        zztm zztmVar = this.zzd;
        int i4 = zzfj.zza;
        return zztmVar.zzf(zzxaVarArr, zArr, zzvfVarArr, zArr2, j5);
    }

    @Override // com.google.android.gms.internal.ads.zzvg
    public final /* bridge */ /* synthetic */ void zzg(zzvh zzvhVar) {
        zztm zztmVar = (zztm) zzvhVar;
        zztl zztlVar = this.zze;
        int i4 = zzfj.zza;
        zztlVar.zzg(this);
    }

    @Override // com.google.android.gms.internal.ads.zztm
    public final zzvn zzh() {
        zztm zztmVar = this.zzd;
        int i4 = zzfj.zza;
        return zztmVar.zzh();
    }

    @Override // com.google.android.gms.internal.ads.zztl
    public final void zzi(zztm zztmVar) {
        zztl zztlVar = this.zze;
        int i4 = zzfj.zza;
        zztlVar.zzi(this);
    }

    @Override // com.google.android.gms.internal.ads.zztm
    public final void zzj(long j4, boolean z3) {
        zztm zztmVar = this.zzd;
        int i4 = zzfj.zza;
        zztmVar.zzj(j4, false);
    }

    @Override // com.google.android.gms.internal.ads.zztm
    public final void zzk() throws IOException {
        try {
            zztm zztmVar = this.zzd;
            if (zztmVar != null) {
                zztmVar.zzk();
                return;
            }
            zztq zztqVar = this.zzc;
            if (zztqVar != null) {
                zztqVar.zzy();
            }
        } catch (IOException e4) {
            throw e4;
        }
    }

    @Override // com.google.android.gms.internal.ads.zztm
    public final void zzl(zztl zztlVar, long j4) {
        this.zze = zztlVar;
        zztm zztmVar = this.zzd;
        if (zztmVar != null) {
            zztmVar.zzl(this, zzv(this.zzb));
        }
    }

    @Override // com.google.android.gms.internal.ads.zztm, com.google.android.gms.internal.ads.zzvh
    public final void zzm(long j4) {
        zztm zztmVar = this.zzd;
        int i4 = zzfj.zza;
        zztmVar.zzm(j4);
    }

    public final long zzn() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zztm, com.google.android.gms.internal.ads.zzvh
    public final boolean zzo(long j4) {
        zztm zztmVar = this.zzd;
        if (zztmVar != null && zztmVar.zzo(j4)) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zztm, com.google.android.gms.internal.ads.zzvh
    public final boolean zzp() {
        zztm zztmVar = this.zzd;
        if (zztmVar != null && zztmVar.zzp()) {
            return true;
        }
        return false;
    }

    public final long zzq() {
        return this.zzb;
    }

    public final void zzr(zzto zztoVar) {
        long zzv = zzv(this.zzb);
        zztq zztqVar = this.zzc;
        zztqVar.getClass();
        zztm zzH = zztqVar.zzH(zztoVar, this.zzg, zzv);
        this.zzd = zzH;
        if (this.zze != null) {
            zzH.zzl(this, zzv);
        }
    }

    public final void zzs(long j4) {
        this.zzf = j4;
    }

    public final void zzt() {
        zztm zztmVar = this.zzd;
        if (zztmVar != null) {
            zztq zztqVar = this.zzc;
            zztqVar.getClass();
            zztqVar.zzF(zztmVar);
        }
    }

    public final void zzu(zztq zztqVar) {
        boolean z3;
        if (this.zzc == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzdy.zzf(z3);
        this.zzc = zztqVar;
    }
}
