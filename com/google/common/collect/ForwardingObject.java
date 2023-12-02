package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public abstract class ForwardingObject {
    protected abstract Object e();

    public String toString() {
        return e().toString();
    }
}
