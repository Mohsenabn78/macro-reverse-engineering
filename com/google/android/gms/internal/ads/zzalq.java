package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzalq {
    @Nullable
    public final Object zza;
    @Nullable
    public final zzakt zzb;
    @Nullable
    public final zzalt zzc;
    public boolean zzd;

    private zzalq(zzalt zzaltVar) {
        this.zzd = false;
        this.zza = null;
        this.zzb = null;
        this.zzc = zzaltVar;
    }

    public static zzalq zza(zzalt zzaltVar) {
        return new zzalq(zzaltVar);
    }

    public static zzalq zzb(@Nullable Object obj, @Nullable zzakt zzaktVar) {
        return new zzalq(obj, zzaktVar);
    }

    public final boolean zzc() {
        if (this.zzc == null) {
            return true;
        }
        return false;
    }

    private zzalq(@Nullable Object obj, @Nullable zzakt zzaktVar) {
        this.zzd = false;
        this.zza = obj;
        this.zzb = zzaktVar;
        this.zzc = null;
    }
}
