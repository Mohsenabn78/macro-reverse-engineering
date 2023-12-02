package com.twofortyfouram.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes6.dex */
public @interface Slow {

    /* loaded from: classes6.dex */
    public enum Speed {
        MILLISECONDS,
        SECONDS,
        MINUTES
    }

    Speed value();
}
