package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
final class NullnessCasts {
    private NullnessCasts() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @ParametricNullness
    public static <T> T a(@CheckForNull T t3) {
        return t3;
    }
}
