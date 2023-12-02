package com.google.errorprone.annotations.concurrent;

import com.google.errorprone.annotations.IncompatibleModifiers;
import com.google.errorprone.annotations.Modifier;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@IncompatibleModifiers(modifier = {Modifier.FINAL})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes5.dex */
public @interface LazyInit {
}
