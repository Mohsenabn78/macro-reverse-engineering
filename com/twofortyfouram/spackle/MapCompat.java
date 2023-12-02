package com.twofortyfouram.spackle;

import android.annotation.TargetApi;
import android.util.ArrayMap;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import com.twofortyfouram.assertion.Assertions;
import java.util.HashMap;
import java.util.Map;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
/* loaded from: classes6.dex */
public final class MapCompat {
    private MapCompat() {
        throw new UnsupportedOperationException("This class is non-instantiable");
    }

    @NonNull
    @TargetApi(19)
    private static final <K, V> Map<K, V> a(@IntRange(from = 0) int i4) {
        return new ArrayMap(i4);
    }

    @NonNull
    public static final <K, V> Map<K, V> newMap(@IntRange(from = 0) int i4) {
        Assertions.assertInRangeInclusive(i4, 0, Integer.MAX_VALUE, "capacity");
        if (AndroidSdkVersion.isAtLeastSdk(19) && 500 >= i4) {
            return a(i4);
        }
        return new HashMap(i4);
    }
}
