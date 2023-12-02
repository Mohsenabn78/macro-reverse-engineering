package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public interface Predicate<T> {
    boolean apply(@ParametricNullness T t3);

    boolean equals(@CheckForNull Object obj);
}
