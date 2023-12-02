package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfhn {
    private final zzfiu zza;
    private final String zzb;
    private final zzfhc zzc;
    private final String zzd = "Ad overlay";

    public zzfhn(View view, zzfhc zzfhcVar, @Nullable String str) {
        this.zza = new zzfiu(view);
        this.zzb = view.getClass().getCanonicalName();
        this.zzc = zzfhcVar;
    }

    public final zzfhc zza() {
        return this.zzc;
    }

    public final zzfiu zzb() {
        return this.zza;
    }

    public final String zzc() {
        return this.zzd;
    }

    public final String zzd() {
        return this.zzb;
    }
}
