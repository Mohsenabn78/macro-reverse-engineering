package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdgx {
    @Nullable
    private zzbeo zza;

    public zzdgx(zzdgj zzdgjVar) {
        this.zza = zzdgjVar;
    }

    @Nullable
    public final synchronized zzbeo zza() {
        return this.zza;
    }

    public final synchronized void zzb(@Nullable zzbeo zzbeoVar) {
        this.zza = zzbeoVar;
    }
}
