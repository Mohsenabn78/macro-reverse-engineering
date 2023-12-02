package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public final class zzauq {
    @VisibleForTesting
    int zza;
    private final Object zzb = new Object();
    private final List zzc = new LinkedList();

    @Nullable
    public final zzaup zza(boolean z3) {
        int i4;
        synchronized (this.zzb) {
            zzaup zzaupVar = null;
            if (this.zzc.isEmpty()) {
                zzbzr.zze("Queue empty");
                return null;
            }
            int i5 = 0;
            if (this.zzc.size() >= 2) {
                int i6 = Integer.MIN_VALUE;
                int i7 = 0;
                for (zzaup zzaupVar2 : this.zzc) {
                    int zzb = zzaupVar2.zzb();
                    if (zzb > i6) {
                        i5 = i7;
                    }
                    if (zzb > i6) {
                        i4 = zzb;
                    } else {
                        i4 = i6;
                    }
                    if (zzb > i6) {
                        zzaupVar = zzaupVar2;
                    }
                    i7++;
                    i6 = i4;
                }
                this.zzc.remove(i5);
                return zzaupVar;
            }
            zzaup zzaupVar3 = (zzaup) this.zzc.get(0);
            if (z3) {
                this.zzc.remove(0);
            } else {
                zzaupVar3.zzi();
            }
            return zzaupVar3;
        }
    }

    public final void zzb(zzaup zzaupVar) {
        synchronized (this.zzb) {
            if (this.zzc.size() >= 10) {
                int size = this.zzc.size();
                zzbzr.zze("Queue is full, current size = " + size);
                this.zzc.remove(0);
            }
            int i4 = this.zza;
            this.zza = i4 + 1;
            zzaupVar.zzj(i4);
            zzaupVar.zzn();
            this.zzc.add(zzaupVar);
        }
    }

    public final boolean zzc(zzaup zzaupVar) {
        synchronized (this.zzb) {
            Iterator it = this.zzc.iterator();
            while (it.hasNext()) {
                zzaup zzaupVar2 = (zzaup) it.next();
                if (!com.google.android.gms.ads.internal.zzt.zzo().zzh().zzM()) {
                    if (!zzaupVar.equals(zzaupVar2) && zzaupVar2.zzd().equals(zzaupVar.zzd())) {
                        it.remove();
                        return true;
                    }
                } else if (!com.google.android.gms.ads.internal.zzt.zzo().zzh().zzN() && !zzaupVar.equals(zzaupVar2) && zzaupVar2.zzf().equals(zzaupVar.zzf())) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }
    }

    public final boolean zzd(zzaup zzaupVar) {
        synchronized (this.zzb) {
            if (this.zzc.contains(zzaupVar)) {
                return true;
            }
            return false;
        }
    }
}
