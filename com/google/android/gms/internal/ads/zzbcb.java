package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@ParametersAreNonnullByDefault
@Deprecated
/* loaded from: classes4.dex */
public final class zzbcb {
    private final long zza;
    @Nullable
    private final String zzb;
    @Nullable
    private final zzbcb zzc;

    public zzbcb(long j4, @Nullable String str, @Nullable zzbcb zzbcbVar) {
        this.zza = j4;
        this.zzb = str;
        this.zzc = zzbcbVar;
    }

    public final long zza() {
        return this.zza;
    }

    @Nullable
    public final zzbcb zzb() {
        return this.zzc;
    }

    public final String zzc() {
        return this.zzb;
    }
}
