package com.google.android.gms.location;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
@Target({ElementType.TYPE_USE})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes4.dex */
public @interface Granularity {
    public static final int GRANULARITY_COARSE = 1;
    public static final int GRANULARITY_FINE = 2;
    public static final int GRANULARITY_PERMISSION_LEVEL = 0;
}
