package com.google.android.gms.nearby.messages;

import androidx.annotation.NonNull;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public interface Distance extends Comparable<Distance> {
    @NonNull
    public static final Distance UNKNOWN = new com.google.android.gms.nearby.messages.internal.zze(1, Double.NaN);

    /* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes4.dex */
    public @interface Accuracy {
        public static final int LOW = 1;
    }

    int compareTo(@NonNull Distance distance);

    int getAccuracy();

    double getMeters();
}
