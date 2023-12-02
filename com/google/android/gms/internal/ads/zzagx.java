package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzagx {
    public final zzahc zza;
    public final zzahf zzb;
    public final zzabz zzc;
    @Nullable
    public final zzaca zzd;
    public int zze;

    public zzagx(zzahc zzahcVar, zzahf zzahfVar, zzabz zzabzVar) {
        zzaca zzacaVar;
        this.zza = zzahcVar;
        this.zzb = zzahfVar;
        this.zzc = zzabzVar;
        if ("audio/true-hd".equals(zzahcVar.zzf.zzm)) {
            zzacaVar = new zzaca();
        } else {
            zzacaVar = null;
        }
        this.zzd = zzacaVar;
    }
}
