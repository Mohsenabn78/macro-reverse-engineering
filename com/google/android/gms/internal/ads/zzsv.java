package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzsv implements zzty, zzqp {
    final /* synthetic */ zzsx zza;
    private final Object zzb;
    private zztx zzc;
    private zzqo zzd;

    public zzsv(zzsx zzsxVar, Object obj) {
        this.zza = zzsxVar;
        this.zzc = zzsxVar.zze(null);
        this.zzd = zzsxVar.zzc(null);
        this.zzb = obj;
    }

    private final zztk zzf(zztk zztkVar) {
        zzsx zzsxVar = this.zza;
        Object obj = this.zzb;
        long j4 = zztkVar.zzc;
        zzsxVar.zzw(obj, j4);
        zzsx zzsxVar2 = this.zza;
        Object obj2 = this.zzb;
        long j5 = zztkVar.zzd;
        zzsxVar2.zzw(obj2, j5);
        if (j4 == zztkVar.zzc && j5 == zztkVar.zzd) {
            return zztkVar;
        }
        return new zztk(1, zztkVar.zza, zztkVar.zzb, 0, null, j4, j5);
    }

    private final boolean zzg(int i4, @Nullable zzto zztoVar) {
        zzto zztoVar2;
        if (zztoVar != null) {
            zztoVar2 = this.zza.zzx(this.zzb, zztoVar);
            if (zztoVar2 == null) {
                return false;
            }
        } else {
            zztoVar2 = null;
        }
        this.zza.zzv(this.zzb, 0);
        zztx zztxVar = this.zzc;
        int i5 = zztxVar.zza;
        if (!zzfj.zzC(zztxVar.zzb, zztoVar2)) {
            this.zzc = this.zza.zzf(0, zztoVar2);
        }
        zzqo zzqoVar = this.zzd;
        int i6 = zzqoVar.zza;
        if (!zzfj.zzC(zzqoVar.zzb, zztoVar2)) {
            this.zzd = this.zza.zzd(0, zztoVar2);
            return true;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzty
    public final void zzac(int i4, @Nullable zzto zztoVar, zztk zztkVar) {
        if (zzg(0, zztoVar)) {
            this.zzc.zzc(zzf(zztkVar));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzty
    public final void zzad(int i4, @Nullable zzto zztoVar, zztf zztfVar, zztk zztkVar) {
        if (zzg(0, zztoVar)) {
            this.zzc.zzd(zztfVar, zzf(zztkVar));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzty
    public final void zzae(int i4, @Nullable zzto zztoVar, zztf zztfVar, zztk zztkVar) {
        if (zzg(0, zztoVar)) {
            this.zzc.zze(zztfVar, zzf(zztkVar));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzty
    public final void zzaf(int i4, @Nullable zzto zztoVar, zztf zztfVar, zztk zztkVar, IOException iOException, boolean z3) {
        if (zzg(0, zztoVar)) {
            this.zzc.zzf(zztfVar, zzf(zztkVar), iOException, z3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzty
    public final void zzag(int i4, @Nullable zzto zztoVar, zztf zztfVar, zztk zztkVar) {
        if (zzg(0, zztoVar)) {
            this.zzc.zzg(zztfVar, zzf(zztkVar));
        }
    }
}
