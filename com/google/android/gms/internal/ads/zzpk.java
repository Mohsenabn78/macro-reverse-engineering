package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.media.metrics.LogSessionId;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@RequiresApi(31)
/* loaded from: classes4.dex */
final class zzpk {
    @DoNotInline
    public static void zza(AudioTrack audioTrack, zzoc zzocVar) {
        LogSessionId logSessionId;
        boolean equals;
        LogSessionId zza = zzocVar.zza();
        logSessionId = LogSessionId.LOG_SESSION_ID_NONE;
        equals = zza.equals(logSessionId);
        if (!equals) {
            audioTrack.setLogSessionId(zza);
        }
    }
}
