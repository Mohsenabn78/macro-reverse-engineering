package com.google.android.gms.internal.ads;

import android.media.metrics.LogSessionId;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzoc {
    public static final zzoc zza;
    @Nullable
    private final zzob zzb;

    static {
        zzoc zzocVar;
        if (zzfj.zza < 31) {
            zzocVar = new zzoc();
        } else {
            zzocVar = new zzoc(zzob.zza);
        }
        zza = zzocVar;
    }

    private zzoc(@Nullable zzob zzobVar) {
        this.zzb = zzobVar;
    }

    @RequiresApi(31)
    public final LogSessionId zza() {
        zzob zzobVar = this.zzb;
        zzobVar.getClass();
        return zzobVar.zzb;
    }

    public zzoc() {
        this.zzb = null;
        zzdy.zzf(zzfj.zza < 31);
    }

    @RequiresApi(31)
    public zzoc(LogSessionId logSessionId) {
        this.zzb = new zzob(logSessionId);
    }
}
