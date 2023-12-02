package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzpn {
    private boolean zzb;
    @Nullable
    private zzpp zzd;
    private zzph zze;
    private zzoe zza = zzoe.zza;
    private final zzpm zzc = zzpm.zza;

    @Deprecated
    public final zzpn zzc(zzoe zzoeVar) {
        this.zza = zzoeVar;
        return this;
    }

    public final zzpn zzd(zzdr[] zzdrVarArr) {
        this.zzd = new zzpp(zzdrVarArr);
        return this;
    }

    public final zzpz zze() {
        zzdy.zzf(!this.zzb);
        this.zzb = true;
        if (this.zzd == null) {
            this.zzd = new zzpp(new zzdr[0]);
        }
        if (this.zze == null) {
            this.zze = new zzph(null);
        }
        return new zzpz(this, null);
    }
}
