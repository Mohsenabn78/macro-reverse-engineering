package com.twofortyfouram.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes6.dex */
public @interface VisibleForTesting {

    /* loaded from: classes6.dex */
    public enum Visibility {
        PUBLIC,
        PACKAGE,
        PROTECTED,
        PRIVATE,
        TEST
    }

    Visibility value();
}
