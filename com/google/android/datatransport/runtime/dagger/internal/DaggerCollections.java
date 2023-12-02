package com.google.android.datatransport.runtime.dagger.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

/* loaded from: classes.dex */
public final class DaggerCollections {
    private DaggerCollections() {
    }

    private static int a(int i4) {
        if (i4 < 3) {
            return i4 + 1;
        }
        if (i4 < 1073741824) {
            return (int) ((i4 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> HashSet<T> b(int i4) {
        return new HashSet<>(a(i4));
    }

    public static boolean hasDuplicates(List<?> list) {
        if (list.size() < 2) {
            return false;
        }
        if (list.size() == new HashSet(list).size()) {
            return false;
        }
        return true;
    }

    public static <K, V> LinkedHashMap<K, V> newLinkedHashMapWithExpectedSize(int i4) {
        return new LinkedHashMap<>(a(i4));
    }

    public static <T> List<T> presizedList(int i4) {
        if (i4 == 0) {
            return Collections.emptyList();
        }
        return new ArrayList(i4);
    }
}
