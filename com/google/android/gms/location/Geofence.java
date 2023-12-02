package com.google.android.gms.location;

import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.location.zzdh;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
/* loaded from: classes4.dex */
public interface Geofence {
    public static final int GEOFENCE_TRANSITION_DWELL = 4;
    public static final int GEOFENCE_TRANSITION_ENTER = 1;
    public static final int GEOFENCE_TRANSITION_EXIT = 2;
    public static final long NEVER_EXPIRE = -1;

    /* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
    /* loaded from: classes4.dex */
    public static final class Builder {

        /* renamed from: e  reason: collision with root package name */
        private double f20910e;

        /* renamed from: f  reason: collision with root package name */
        private double f20911f;

        /* renamed from: g  reason: collision with root package name */
        private float f20912g;

        /* renamed from: a  reason: collision with root package name */
        private String f20906a = null;
        @TransitionTypes

        /* renamed from: b  reason: collision with root package name */
        private int f20907b = 0;

        /* renamed from: c  reason: collision with root package name */
        private long f20908c = Long.MIN_VALUE;

        /* renamed from: d  reason: collision with root package name */
        private short f20909d = -1;

        /* renamed from: h  reason: collision with root package name */
        private int f20913h = 0;

        /* renamed from: i  reason: collision with root package name */
        private int f20914i = -1;

        @NonNull
        public Geofence build() {
            if (this.f20906a != null) {
                int i4 = this.f20907b;
                if (i4 != 0) {
                    if ((i4 & 4) != 0 && this.f20914i < 0) {
                        throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELL.");
                    }
                    if (this.f20908c != Long.MIN_VALUE) {
                        if (this.f20909d != -1) {
                            if (this.f20913h >= 0) {
                                return new zzdh(this.f20906a, this.f20907b, (short) 1, this.f20910e, this.f20911f, this.f20912g, this.f20908c, this.f20913h, this.f20914i);
                            }
                            throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
                        }
                        throw new IllegalArgumentException("Geofence region not set.");
                    }
                    throw new IllegalArgumentException("Expiration not set.");
                }
                throw new IllegalArgumentException("Transitions types not set.");
            }
            throw new IllegalArgumentException("Request ID not set.");
        }

        @NonNull
        public Builder setCircularRegion(@FloatRange(from = -90.0d, to = 90.0d) double d4, @FloatRange(from = -180.0d, to = 180.0d) double d5, @FloatRange(from = 0.0d, fromInclusive = false) float f4) {
            boolean z3;
            boolean z4;
            boolean z5 = false;
            if (d4 >= -90.0d && d4 <= 90.0d) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "Invalid latitude: " + d4);
            if (d5 >= -180.0d && d5 <= 180.0d) {
                z4 = true;
            } else {
                z4 = false;
            }
            Preconditions.checkArgument(z4, "Invalid longitude: " + d5);
            if (f4 > 0.0f) {
                z5 = true;
            }
            Preconditions.checkArgument(z5, "Invalid radius: " + f4);
            this.f20909d = (short) 1;
            this.f20910e = d4;
            this.f20911f = d5;
            this.f20912g = f4;
            return this;
        }

        @NonNull
        public Builder setExpirationDuration(long j4) {
            if (j4 < 0) {
                this.f20908c = -1L;
            } else {
                this.f20908c = DefaultClock.getInstance().elapsedRealtime() + j4;
            }
            return this;
        }

        @NonNull
        public Builder setLoiteringDelay(int i4) {
            this.f20914i = i4;
            return this;
        }

        @NonNull
        public Builder setNotificationResponsiveness(@IntRange(from = 0) int i4) {
            this.f20913h = i4;
            return this;
        }

        @NonNull
        public Builder setRequestId(@NonNull String str) {
            this.f20906a = (String) Preconditions.checkNotNull(str, "Request ID can't be set to null");
            return this;
        }

        @NonNull
        public Builder setTransitionTypes(@TransitionTypes int i4) {
            this.f20907b = i4;
            return this;
        }
    }

    /* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
    /* loaded from: classes4.dex */
    public @interface GeofenceTransition {
    }

    /* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
    /* loaded from: classes4.dex */
    public @interface TransitionTypes {
    }

    long getExpirationTime();

    double getLatitude();

    int getLoiteringDelay();

    double getLongitude();

    int getNotificationResponsiveness();

    float getRadius();

    @NonNull
    String getRequestId();

    @TransitionTypes
    int getTransitionTypes();
}
