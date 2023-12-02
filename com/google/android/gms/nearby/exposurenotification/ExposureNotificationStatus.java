package com.google.android.gms.nearby.exposurenotification;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.gms.internal.nearby.zzsu;
import com.google.android.gms.internal.nearby.zzsv;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public enum ExposureNotificationStatus {
    ACTIVATED(1),
    INACTIVATED(2),
    BLUETOOTH_DISABLED(4),
    LOCATION_DISABLED(8),
    NO_CONSENT(16),
    NOT_IN_ALLOWLIST(32),
    BLUETOOTH_SUPPORT_UNKNOWN(64),
    HW_NOT_SUPPORT(128),
    FOCUS_LOST(256),
    LOW_STORAGE(512),
    UNKNOWN(1024),
    EN_NOT_SUPPORT(PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH),
    USER_PROFILE_NOT_SUPPORT(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM);
    
    private final long zzb;

    ExposureNotificationStatus(long j4) {
        this.zzb = j4;
    }

    public static zzsv zza(long j4) {
        ExposureNotificationStatus[] values;
        zzsu zzsuVar = new zzsu();
        for (ExposureNotificationStatus exposureNotificationStatus : values()) {
            if ((exposureNotificationStatus.zzb & j4) != 0) {
                zzsuVar.zza(exposureNotificationStatus);
            }
        }
        return zzsuVar.zzb();
    }
}
