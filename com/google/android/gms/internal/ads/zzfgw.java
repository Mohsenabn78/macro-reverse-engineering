package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public abstract class zzfgw {
    public static zzfgw zza(zzfgx zzfgxVar, zzfgy zzfgyVar) {
        if (zzfgu.zzb()) {
            return new zzfha(zzfgxVar, zzfgyVar);
        }
        throw new IllegalStateException("Method called before OM SDK activation");
    }

    public abstract void zzb(View view, zzfhc zzfhcVar, @Nullable String str);

    public abstract void zzc();

    public abstract void zzd(View view);

    public abstract void zze();
}
