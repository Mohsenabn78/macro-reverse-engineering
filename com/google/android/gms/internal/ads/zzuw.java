package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Looper;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzuw extends zzsp implements zzun {
    private final zzbp zza;
    private final zzbi zzb;
    private final zzgd zzc;
    private final zzqu zzd;
    private final int zze;
    private boolean zzf;
    private long zzg;
    private boolean zzh;
    private boolean zzi;
    @Nullable
    private zzhg zzj;
    private final zzut zzk;
    private final zzxt zzl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzuw(zzbp zzbpVar, zzgd zzgdVar, zzut zzutVar, zzqu zzquVar, zzxt zzxtVar, int i4, zzuv zzuvVar) {
        zzbi zzbiVar = zzbpVar.zzd;
        zzbiVar.getClass();
        this.zzb = zzbiVar;
        this.zza = zzbpVar;
        this.zzc = zzgdVar;
        this.zzk = zzutVar;
        this.zzd = zzquVar;
        this.zzl = zzxtVar;
        this.zze = i4;
        this.zzf = true;
        this.zzg = -9223372036854775807L;
    }

    private final void zzv() {
        zzbf zzbfVar;
        zzcw zzcwVar;
        long j4 = this.zzg;
        boolean z3 = this.zzh;
        boolean z4 = this.zzi;
        zzbp zzbpVar = this.zza;
        if (z4) {
            zzbfVar = zzbpVar.zzf;
        } else {
            zzbfVar = null;
        }
        zzvj zzvjVar = new zzvj(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L, j4, j4, 0L, 0L, z3, false, false, null, zzbpVar, zzbfVar);
        if (this.zzf) {
            zzcwVar = new zzus(this, zzvjVar);
        } else {
            zzcwVar = zzvjVar;
        }
        zzo(zzcwVar);
    }

    @Override // com.google.android.gms.internal.ads.zztq
    public final void zzF(zztm zztmVar) {
        ((zzur) zztmVar).zzM();
    }

    @Override // com.google.android.gms.internal.ads.zztq
    public final zztm zzH(zzto zztoVar, zzxp zzxpVar, long j4) {
        zzge zza = this.zzc.zza();
        zzhg zzhgVar = this.zzj;
        if (zzhgVar != null) {
            zza.zzf(zzhgVar);
        }
        Uri uri = this.zzb.zzb;
        zzut zzutVar = this.zzk;
        zzb();
        return new zzur(uri, zza, new zzsr(zzutVar.zza), this.zzd, zzc(zztoVar), this.zzl, zze(zztoVar), this, zzxpVar, null, this.zze);
    }

    @Override // com.google.android.gms.internal.ads.zztq
    public final zzbp zzI() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzun
    public final void zza(long j4, boolean z3, boolean z4) {
        if (j4 == -9223372036854775807L) {
            j4 = this.zzg;
        }
        if (!this.zzf && this.zzg == j4 && this.zzh == z3 && this.zzi == z4) {
            return;
        }
        this.zzg = j4;
        this.zzh = z3;
        this.zzi = z4;
        this.zzf = false;
        zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzsp
    protected final void zzn(@Nullable zzhg zzhgVar) {
        this.zzj = zzhgVar;
        Looper.myLooper().getClass();
        zzb();
        zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzsp
    protected final void zzq() {
    }

    @Override // com.google.android.gms.internal.ads.zztq
    public final void zzy() {
    }
}
