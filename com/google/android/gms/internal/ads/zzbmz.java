package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public final class zzbmz {
    @VisibleForTesting
    static final com.google.android.gms.ads.internal.util.zzbb zza = new zzbmx();
    @VisibleForTesting
    static final com.google.android.gms.ads.internal.util.zzbb zzb = new zzbmy();
    private final zzbml zzc;

    public zzbmz(Context context, zzbzx zzbzxVar, String str, @Nullable zzfgb zzfgbVar) {
        this.zzc = new zzbml(context, zzbzxVar, str, zza, zzb, zzfgbVar);
    }

    public final zzbmp zza(String str, zzbms zzbmsVar, zzbmr zzbmrVar) {
        return new zzbnd(this.zzc, str, zzbmsVar, zzbmrVar);
    }

    public final zzbni zzb() {
        return new zzbni(this.zzc);
    }
}
