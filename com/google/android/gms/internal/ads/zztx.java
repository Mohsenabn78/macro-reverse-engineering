package com.google.android.gms.internal.ads;

import android.os.Handler;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zztx {
    public final int zza;
    @Nullable
    public final zzto zzb;
    private final CopyOnWriteArrayList zzc;

    private zztx(CopyOnWriteArrayList copyOnWriteArrayList, int i4, @Nullable zzto zztoVar) {
        this.zzc = copyOnWriteArrayList;
        this.zza = 0;
        this.zzb = zztoVar;
    }

    @CheckResult
    public final zztx zza(int i4, @Nullable zzto zztoVar) {
        return new zztx(this.zzc, 0, zztoVar);
    }

    public final void zzb(Handler handler, zzty zztyVar) {
        this.zzc.add(new zztw(handler, zztyVar));
    }

    public final void zzc(final zztk zztkVar) {
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            zztw zztwVar = (zztw) it.next();
            final zzty zztyVar = zztwVar.zzb;
            zzfj.zzF(zztwVar.zza, new Runnable() { // from class: com.google.android.gms.internal.ads.zztr
                @Override // java.lang.Runnable
                public final void run() {
                    zztx zztxVar = zztx.this;
                    zztyVar.zzac(0, zztxVar.zzb, zztkVar);
                }
            });
        }
    }

    public final void zzd(final zztf zztfVar, final zztk zztkVar) {
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            zztw zztwVar = (zztw) it.next();
            final zzty zztyVar = zztwVar.zzb;
            zzfj.zzF(zztwVar.zza, new Runnable() { // from class: com.google.android.gms.internal.ads.zzts
                @Override // java.lang.Runnable
                public final void run() {
                    zztx zztxVar = zztx.this;
                    zztyVar.zzad(0, zztxVar.zzb, zztfVar, zztkVar);
                }
            });
        }
    }

    public final void zze(final zztf zztfVar, final zztk zztkVar) {
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            zztw zztwVar = (zztw) it.next();
            final zzty zztyVar = zztwVar.zzb;
            zzfj.zzF(zztwVar.zza, new Runnable() { // from class: com.google.android.gms.internal.ads.zztv
                @Override // java.lang.Runnable
                public final void run() {
                    zztx zztxVar = zztx.this;
                    zztyVar.zzae(0, zztxVar.zzb, zztfVar, zztkVar);
                }
            });
        }
    }

    public final void zzf(final zztf zztfVar, final zztk zztkVar, final IOException iOException, final boolean z3) {
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            zztw zztwVar = (zztw) it.next();
            final zzty zztyVar = zztwVar.zzb;
            zzfj.zzF(zztwVar.zza, new Runnable() { // from class: com.google.android.gms.internal.ads.zztt
                @Override // java.lang.Runnable
                public final void run() {
                    zztx zztxVar = zztx.this;
                    zztyVar.zzaf(0, zztxVar.zzb, zztfVar, zztkVar, iOException, z3);
                }
            });
        }
    }

    public final void zzg(final zztf zztfVar, final zztk zztkVar) {
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            zztw zztwVar = (zztw) it.next();
            final zzty zztyVar = zztwVar.zzb;
            zzfj.zzF(zztwVar.zza, new Runnable() { // from class: com.google.android.gms.internal.ads.zztu
                @Override // java.lang.Runnable
                public final void run() {
                    zztx zztxVar = zztx.this;
                    zztyVar.zzag(0, zztxVar.zzb, zztfVar, zztkVar);
                }
            });
        }
    }

    public final void zzh(zzty zztyVar) {
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            zztw zztwVar = (zztw) it.next();
            if (zztwVar.zzb == zztyVar) {
                this.zzc.remove(zztwVar);
            }
        }
    }

    public zztx() {
        this(new CopyOnWriteArrayList(), 0, null);
    }
}
