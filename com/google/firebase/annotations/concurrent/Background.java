package com.google.firebase.annotations.concurrent;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import javax.inject.Qualifier;

@Target({ElementType.PARAMETER, ElementType.METHOD, ElementType.FIELD})
@Qualifier
/* loaded from: classes5.dex */
public @interface Background {
}
