package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzss implements zzvf {
    public final zzvf zza;
    final /* synthetic */ zzst zzb;
    private boolean zzc;

    public zzss(zzst zzstVar, zzvf zzvfVar) {
        this.zzb = zzstVar;
        this.zza = zzvfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final int zza(zzkj zzkjVar, zzhp zzhpVar, int i4) {
        if (this.zzb.zzq()) {
            return -3;
        }
        if (this.zzc) {
            zzhpVar.zzc(4);
            return -4;
        }
        int zza = this.zza.zza(zzkjVar, zzhpVar, i4);
        if (zza == -5) {
            zzam zzamVar = zzkjVar.zza;
            zzamVar.getClass();
            int i5 = zzamVar.zzC;
            int i6 = 0;
            if (i5 == 0) {
                if (zzamVar.zzD != 0) {
                    i5 = 0;
                }
                return -5;
            }
            if (this.zzb.zzb == Long.MIN_VALUE) {
                i6 = zzamVar.zzD;
            }
            zzak zzb = zzamVar.zzb();
            zzb.zzC(i5);
            zzb.zzD(i6);
            zzkjVar.zza = zzb.zzY();
            return -5;
        }
        zzst zzstVar = this.zzb;
        long j4 = zzstVar.zzb;
        if (j4 != Long.MIN_VALUE && ((zza == -4 && zzhpVar.zzd >= j4) || (zza == -3 && zzstVar.zzb() == Long.MIN_VALUE && !zzhpVar.zzc))) {
            zzhpVar.zzb();
            zzhpVar.zzc(4);
            this.zzc = true;
            return -4;
        }
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final int zzb(long j4) {
        if (this.zzb.zzq()) {
            return -3;
        }
        return this.zza.zzb(j4);
    }

    public final void zzc() {
        this.zzc = false;
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final void zzd() throws IOException {
        this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final boolean zze() {
        if (!this.zzb.zzq() && this.zza.zze()) {
            return true;
        }
        return false;
    }
}
