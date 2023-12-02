package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzif implements zzkl {
    private final zzlp zza;
    private final zzie zzb;
    @Nullable
    private zzli zzc;
    @Nullable
    private zzkl zzd;
    private boolean zze = true;
    private boolean zzf;

    public zzif(zzie zzieVar, zzdz zzdzVar) {
        this.zzb = zzieVar;
        this.zza = new zzlp(zzdzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzkl
    public final long zza() {
        throw null;
    }

    public final long zzb(boolean z3) {
        zzli zzliVar = this.zzc;
        if (zzliVar != null && !zzliVar.zzP() && (this.zzc.zzQ() || (!z3 && !this.zzc.zzJ()))) {
            zzkl zzklVar = this.zzd;
            zzklVar.getClass();
            long zza = zzklVar.zza();
            if (this.zze) {
                if (zza < this.zza.zza()) {
                    this.zza.zze();
                } else {
                    this.zze = false;
                    if (this.zzf) {
                        this.zza.zzd();
                    }
                }
            }
            this.zza.zzb(zza);
            zzch zzc = zzklVar.zzc();
            if (!zzc.equals(this.zza.zzc())) {
                this.zza.zzg(zzc);
                this.zzb.zza(zzc);
            }
        } else {
            this.zze = true;
            if (this.zzf) {
                this.zza.zzd();
            }
        }
        if (this.zze) {
            return this.zza.zza();
        }
        zzkl zzklVar2 = this.zzd;
        zzklVar2.getClass();
        return zzklVar2.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzkl
    public final zzch zzc() {
        zzkl zzklVar = this.zzd;
        if (zzklVar != null) {
            return zzklVar.zzc();
        }
        return this.zza.zzc();
    }

    public final void zzd(zzli zzliVar) {
        if (zzliVar == this.zzc) {
            this.zzd = null;
            this.zzc = null;
            this.zze = true;
        }
    }

    public final void zze(zzli zzliVar) throws zzih {
        zzkl zzklVar;
        zzkl zzi = zzliVar.zzi();
        if (zzi != null && zzi != (zzklVar = this.zzd)) {
            if (zzklVar == null) {
                this.zzd = zzi;
                this.zzc = zzliVar;
                zzi.zzg(this.zza.zzc());
                return;
            }
            throw zzih.zzd(new IllegalStateException("Multiple renderer media clocks enabled."), 1000);
        }
    }

    public final void zzf(long j4) {
        this.zza.zzb(j4);
    }

    @Override // com.google.android.gms.internal.ads.zzkl
    public final void zzg(zzch zzchVar) {
        zzkl zzklVar = this.zzd;
        if (zzklVar != null) {
            zzklVar.zzg(zzchVar);
            zzchVar = this.zzd.zzc();
        }
        this.zza.zzg(zzchVar);
    }

    public final void zzh() {
        this.zzf = true;
        this.zza.zzd();
    }

    public final void zzi() {
        this.zzf = false;
        this.zza.zze();
    }
}
