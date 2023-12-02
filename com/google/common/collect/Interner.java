package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.errorprone.annotations.DoNotMock;

@GwtIncompatible
@DoNotMock("Use Interners.new*Interner")
@J2ktIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public interface Interner<E> {
    E intern(E e4);
}
