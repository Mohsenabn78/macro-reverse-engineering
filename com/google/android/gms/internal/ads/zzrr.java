package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@RequiresApi(29)
/* loaded from: classes4.dex */
public final class zzrr {
    @DoNotInline
    public static int zza(MediaCodecInfo.VideoCapabilities videoCapabilities, int i4, int i5, double d4) {
        List supportedPerformancePoints;
        boolean covers;
        supportedPerformancePoints = videoCapabilities.getSupportedPerformancePoints();
        if (supportedPerformancePoints != null && !supportedPerformancePoints.isEmpty()) {
            String str = zzfj.zzb;
            if (!str.equals("sabrina") && !str.equals("boreal")) {
                String str2 = zzfj.zzd;
                if (!str2.startsWith("Lenovo TB-X605") && !str2.startsWith("Lenovo TB-X606") && !str2.startsWith("Lenovo TB-X616")) {
                    MediaCodecInfo.VideoCapabilities.PerformancePoint performancePoint = new MediaCodecInfo.VideoCapabilities.PerformancePoint(i4, i5, (int) d4);
                    for (int i6 = 0; i6 < supportedPerformancePoints.size(); i6++) {
                        covers = ((MediaCodecInfo.VideoCapabilities.PerformancePoint) supportedPerformancePoints.get(i6)).covers(performancePoint);
                        if (covers) {
                            return 2;
                        }
                    }
                    return 1;
                }
            }
        }
        return 0;
    }
}
