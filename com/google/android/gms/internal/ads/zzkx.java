package com.google.android.gms.internal.ads;

import android.util.Pair;
import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzkx implements zzty, zzqp {
    final /* synthetic */ zzlb zza;
    private final zzkz zzb;

    public zzkx(zzlb zzlbVar, zzkz zzkzVar) {
        this.zza = zzlbVar;
        this.zzb = zzkzVar;
    }

    @Nullable
    private final Pair zzf(int i4, @Nullable zzto zztoVar) {
        zzto zztoVar2;
        zzto zztoVar3 = null;
        if (zztoVar != null) {
            zzkz zzkzVar = this.zzb;
            int i5 = 0;
            while (true) {
                if (i5 < zzkzVar.zzc.size()) {
                    if (((zzto) zzkzVar.zzc.get(i5)).zzd == zztoVar.zzd) {
                        zztoVar2 = zztoVar.zzc(Pair.create(zzkzVar.zzb, zztoVar.zza));
                        break;
                    }
                    i5++;
                } else {
                    zztoVar2 = null;
                    break;
                }
            }
            if (zztoVar2 == null) {
                return null;
            }
            zztoVar3 = zztoVar2;
        }
        return Pair.create(Integer.valueOf(this.zzb.zzd), zztoVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzty
    public final void zzac(int i4, @Nullable zzto zztoVar, final zztk zztkVar) {
        zzei zzeiVar;
        final Pair zzf = zzf(0, zztoVar);
        if (zzf != null) {
            zzeiVar = this.zza.zzi;
            zzeiVar.zzh(new Runnable() { // from class: com.google.android.gms.internal.ads.zzkv
                @Override // java.lang.Runnable
                public final void run() {
                    zzls zzlsVar;
                    zzkx zzkxVar = zzkx.this;
                    Pair pair = zzf;
                    zztk zztkVar2 = zztkVar;
                    zzlsVar = zzkxVar.zza.zzh;
                    zzlsVar.zzac(((Integer) pair.first).intValue(), (zzto) pair.second, zztkVar2);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzty
    public final void zzad(int i4, @Nullable zzto zztoVar, final zztf zztfVar, final zztk zztkVar) {
        zzei zzeiVar;
        final Pair zzf = zzf(0, zztoVar);
        if (zzf != null) {
            zzeiVar = this.zza.zzi;
            zzeiVar.zzh(new Runnable() { // from class: com.google.android.gms.internal.ads.zzku
                @Override // java.lang.Runnable
                public final void run() {
                    zzls zzlsVar;
                    zzkx zzkxVar = zzkx.this;
                    Pair pair = zzf;
                    zztf zztfVar2 = zztfVar;
                    zztk zztkVar2 = zztkVar;
                    zzlsVar = zzkxVar.zza.zzh;
                    zzlsVar.zzad(((Integer) pair.first).intValue(), (zzto) pair.second, zztfVar2, zztkVar2);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzty
    public final void zzae(int i4, @Nullable zzto zztoVar, final zztf zztfVar, final zztk zztkVar) {
        zzei zzeiVar;
        final Pair zzf = zzf(0, zztoVar);
        if (zzf != null) {
            zzeiVar = this.zza.zzi;
            zzeiVar.zzh(new Runnable() { // from class: com.google.android.gms.internal.ads.zzkt
                @Override // java.lang.Runnable
                public final void run() {
                    zzls zzlsVar;
                    zzkx zzkxVar = zzkx.this;
                    Pair pair = zzf;
                    zztf zztfVar2 = zztfVar;
                    zztk zztkVar2 = zztkVar;
                    zzlsVar = zzkxVar.zza.zzh;
                    zzlsVar.zzae(((Integer) pair.first).intValue(), (zzto) pair.second, zztfVar2, zztkVar2);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzty
    public final void zzaf(int i4, @Nullable zzto zztoVar, final zztf zztfVar, final zztk zztkVar, final IOException iOException, final boolean z3) {
        zzei zzeiVar;
        final Pair zzf = zzf(0, zztoVar);
        if (zzf != null) {
            zzeiVar = this.zza.zzi;
            zzeiVar.zzh(new Runnable() { // from class: com.google.android.gms.internal.ads.zzks
                @Override // java.lang.Runnable
                public final void run() {
                    zzls zzlsVar;
                    zzkx zzkxVar = zzkx.this;
                    Pair pair = zzf;
                    zztf zztfVar2 = zztfVar;
                    zztk zztkVar2 = zztkVar;
                    IOException iOException2 = iOException;
                    boolean z4 = z3;
                    zzlsVar = zzkxVar.zza.zzh;
                    zzlsVar.zzaf(((Integer) pair.first).intValue(), (zzto) pair.second, zztfVar2, zztkVar2, iOException2, z4);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzty
    public final void zzag(int i4, @Nullable zzto zztoVar, final zztf zztfVar, final zztk zztkVar) {
        zzei zzeiVar;
        final Pair zzf = zzf(0, zztoVar);
        if (zzf != null) {
            zzeiVar = this.zza.zzi;
            zzeiVar.zzh(new Runnable() { // from class: com.google.android.gms.internal.ads.zzkw
                @Override // java.lang.Runnable
                public final void run() {
                    zzls zzlsVar;
                    zzkx zzkxVar = zzkx.this;
                    Pair pair = zzf;
                    zztf zztfVar2 = zztfVar;
                    zztk zztkVar2 = zztkVar;
                    zzlsVar = zzkxVar.zza.zzh;
                    zzlsVar.zzag(((Integer) pair.first).intValue(), (zzto) pair.second, zztfVar2, zztkVar2);
                }
            });
        }
    }
}
