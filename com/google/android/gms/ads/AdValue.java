package com.google.android.gms.ads;

import androidx.annotation.NonNull;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class AdValue {

    /* renamed from: a  reason: collision with root package name */
    private final int f18970a;

    /* renamed from: b  reason: collision with root package name */
    private final String f18971b;

    /* renamed from: c  reason: collision with root package name */
    private final long f18972c;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes4.dex */
    public @interface PrecisionType {
        public static final int ESTIMATED = 1;
        public static final int PRECISE = 3;
        public static final int PUBLISHER_PROVIDED = 2;
        public static final int UNKNOWN = 0;
    }

    private AdValue(int i4, String str, long j4) {
        this.f18970a = i4;
        this.f18971b = str;
        this.f18972c = j4;
    }

    @NonNull
    public static AdValue zza(int i4, @NonNull String str, long j4) {
        return new AdValue(i4, str, j4);
    }

    @NonNull
    public String getCurrencyCode() {
        return this.f18971b;
    }

    public int getPrecisionType() {
        return this.f18970a;
    }

    public long getValueMicros() {
        return this.f18972c;
    }
}
