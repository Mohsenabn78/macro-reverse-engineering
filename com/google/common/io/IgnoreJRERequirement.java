package com.google.common.io;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@ElementTypesAreNonnullByDefault
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.TYPE})
/* loaded from: classes5.dex */
@interface IgnoreJRERequirement {
}
