package com.google.common.escape;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Map;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class ArrayBasedEscaperMap {

    /* renamed from: b  reason: collision with root package name */
    private static final char[][] f27611b = (char[][]) Array.newInstance(Character.TYPE, 0, 0);

    /* renamed from: a  reason: collision with root package name */
    private final char[][] f27612a;

    private ArrayBasedEscaperMap(char[][] cArr) {
        this.f27612a = cArr;
    }

    @VisibleForTesting
    static char[][] a(Map<Character, String> map) {
        Preconditions.checkNotNull(map);
        if (map.isEmpty()) {
            return f27611b;
        }
        char[][] cArr = new char[((Character) Collections.max(map.keySet())).charValue() + 1];
        for (Character ch : map.keySet()) {
            cArr[ch.charValue()] = map.get(ch).toCharArray();
        }
        return cArr;
    }

    public static ArrayBasedEscaperMap create(Map<Character, String> map) {
        return new ArrayBasedEscaperMap(a(map));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public char[][] b() {
        return this.f27612a;
    }
}
