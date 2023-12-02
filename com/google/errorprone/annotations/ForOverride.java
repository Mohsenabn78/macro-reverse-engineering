package com.google.errorprone.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@IncompatibleModifiers(modifier = {Modifier.PUBLIC, Modifier.PRIVATE, Modifier.STATIC, Modifier.FINAL})
@Target({ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes5.dex */
public @interface ForOverride {
}
