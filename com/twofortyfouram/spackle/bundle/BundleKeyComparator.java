package com.twofortyfouram.spackle.bundle;

import androidx.annotation.Nullable;
import java.io.Serializable;
import java.util.Comparator;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
/* loaded from: classes6.dex */
public final class BundleKeyComparator implements Comparator<String>, Serializable {
    private static final long serialVersionUID = 1;

    @Override // java.util.Comparator
    public int compare(@Nullable String str, @Nullable String str2) {
        if (str == null && str2 == null) {
            return 0;
        }
        if (str == null) {
            return -1;
        }
        if (str2 == null) {
            return 1;
        }
        return str.compareToIgnoreCase(str2);
    }
}
