package com.google.android.gms.nearby.connection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class BandwidthInfo {

    /* renamed from: a  reason: collision with root package name */
    private final int f22144a;

    /* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes4.dex */
    public @interface Quality {
        public static final int HIGH = 3;
        public static final int LOW = 1;
        public static final int MEDIUM = 2;
        public static final int UNKNOWN = 0;
    }

    public int getQuality() {
        return this.f22144a;
    }
}
