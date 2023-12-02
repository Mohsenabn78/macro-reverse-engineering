package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.errorprone.annotations.DoNotMock;

@GwtIncompatible
@DoNotMock("Use an instance of one of the Finalizable*Reference classes")
@J2ktIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public interface FinalizableReference {
    void finalizeReferent();
}
