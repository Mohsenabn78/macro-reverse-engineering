package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.metrics.LogSessionId;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@RequiresApi(31)
/* loaded from: classes4.dex */
public final class zzjo {
    @DoNotInline
    public static zzoc zza(Context context, zzjx zzjxVar, boolean z3) {
        LogSessionId logSessionId;
        zzny zzb = zzny.zzb(context);
        if (zzb == null) {
            zzer.zzf("ExoPlayerImpl", "MediaMetricsService unavailable.");
            logSessionId = LogSessionId.LOG_SESSION_ID_NONE;
            return new zzoc(logSessionId);
        }
        if (z3) {
            zzjxVar.zzz(zzb);
        }
        return new zzoc(zzb.zza());
    }
}
