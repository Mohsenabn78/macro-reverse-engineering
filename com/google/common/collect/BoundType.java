package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public enum BoundType {
    OPEN(false),
    CLOSED(true);
    
    final boolean inclusive;

    BoundType(boolean z3) {
        this.inclusive = z3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BoundType b(boolean z3) {
        if (z3) {
            return CLOSED;
        }
        return OPEN;
    }
}
