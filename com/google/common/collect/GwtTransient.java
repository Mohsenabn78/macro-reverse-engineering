package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@GwtCompatible
@ElementTypesAreNonnullByDefault
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes5.dex */
@interface GwtTransient {
}
