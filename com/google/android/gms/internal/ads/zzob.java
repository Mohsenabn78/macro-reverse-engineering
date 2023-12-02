package com.google.android.gms.internal.ads;

import android.media.metrics.LogSessionId;
import androidx.annotation.RequiresApi;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@RequiresApi(31)
/* loaded from: classes4.dex */
final class zzob {
    public static final zzob zza;
    public final LogSessionId zzb;

    static {
        LogSessionId logSessionId;
        logSessionId = LogSessionId.LOG_SESSION_ID_NONE;
        zza = new zzob(logSessionId);
    }

    public zzob(LogSessionId logSessionId) {
        this.zzb = logSessionId;
    }
}
