package com.google.android.gms.internal.icing;

import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
@ShowFirstParty
@VisibleForTesting
/* loaded from: classes4.dex */
public final class zzw {
    private zzi zza;
    private zzg zzd;
    private long zzb = -1;
    private int zzc = -1;
    private boolean zze = false;
    private int zzf = 0;

    public final zzw zza(zzi zziVar) {
        this.zza = zziVar;
        return this;
    }

    public final zzw zzb(long j4) {
        this.zzb = j4;
        return this;
    }

    public final zzw zzc(int i4) {
        this.zzc = i4;
        return this;
    }

    public final zzw zzd(zzg zzgVar) {
        this.zzd = zzgVar;
        return this;
    }

    public final zzw zze(boolean z3) {
        this.zze = z3;
        return this;
    }

    public final zzw zzf(int i4) {
        this.zzf = i4;
        return this;
    }

    public final zzx zzg() {
        return new zzx(this.zza, this.zzb, this.zzc, null, this.zzd, this.zze, -1, this.zzf, null);
    }
}
