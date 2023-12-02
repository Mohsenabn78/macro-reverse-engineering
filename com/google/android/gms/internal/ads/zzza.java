package com.google.android.gms.internal.ads;

import android.view.Surface;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@RequiresApi(30)
/* loaded from: classes4.dex */
final class zzza {
    @DoNotInline
    public static void zza(Surface surface, float f4) {
        int i4;
        if (f4 == 0.0f) {
            i4 = 0;
        } else {
            i4 = 1;
        }
        try {
            surface.setFrameRate(f4, i4);
        } catch (IllegalStateException e4) {
            zzer.zzd("VideoFrameReleaseHelper", "Failed to call Surface.setFrameRate", e4);
        }
    }
}
