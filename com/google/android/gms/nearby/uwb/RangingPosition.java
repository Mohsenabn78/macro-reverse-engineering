package com.google.android.gms.nearby.uwb;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.compose.animation.core.AnimationKt;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public class RangingPosition {
    public static final int RSSI_MAX = -1;
    public static final int RSSI_MIN = -127;
    public static final int RSSI_UNKNOWN = -128;

    /* renamed from: a  reason: collision with root package name */
    private final RangingMeasurement f22537a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final RangingMeasurement f22538b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final RangingMeasurement f22539c;

    /* renamed from: d  reason: collision with root package name */
    private final long f22540d;

    /* renamed from: e  reason: collision with root package name */
    private final int f22541e;

    public RangingPosition(@NonNull RangingMeasurement rangingMeasurement, @Nullable RangingMeasurement rangingMeasurement2, @Nullable RangingMeasurement rangingMeasurement3, long j4, @IntRange(from = -128, to = -1) int i4) {
        this.f22537a = rangingMeasurement;
        this.f22538b = rangingMeasurement2;
        this.f22539c = rangingMeasurement3;
        this.f22540d = j4;
        this.f22541e = i4;
    }

    @Nullable
    public RangingMeasurement getAzimuth() {
        return this.f22538b;
    }

    @NonNull
    public RangingMeasurement getDistance() {
        return this.f22537a;
    }

    public long getElapsedRealtimeNanos() {
        return this.f22540d;
    }

    @Nullable
    public RangingMeasurement getElevation() {
        return this.f22539c;
    }

    @IntRange(from = -128, to = -1)
    public int getRssiDbm() {
        return this.f22541e;
    }

    @NonNull
    public String toString() {
        Locale locale = Locale.US;
        String format = String.format(locale, "elapsedRealtime (ms) %d | distance (m) %f", Long.valueOf(this.f22540d / AnimationKt.MillisToNanos), Float.valueOf(this.f22537a.getValue()));
        RangingMeasurement rangingMeasurement = this.f22538b;
        if (rangingMeasurement != null) {
            format = String.valueOf(format).concat(String.valueOf(String.format(locale, " | azimuth: %f", Float.valueOf(rangingMeasurement.getValue()))));
        }
        RangingMeasurement rangingMeasurement2 = this.f22539c;
        if (rangingMeasurement2 != null) {
            format = String.valueOf(format).concat(String.valueOf(String.format(locale, " | elevation: %f", Float.valueOf(rangingMeasurement2.getValue()))));
        }
        return String.valueOf(format).concat(String.valueOf(String.format(locale, " | rssi: %d", Integer.valueOf(this.f22541e))));
    }
}
