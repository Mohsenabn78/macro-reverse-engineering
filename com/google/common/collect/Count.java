package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
final class Count implements Serializable {
    private int value;

    public boolean equals(@CheckForNull Object obj) {
        if ((obj instanceof Count) && ((Count) obj).value == this.value) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.value;
    }

    public String toString() {
        return Integer.toString(this.value);
    }
}
