package com.twofortyfouram.assertion;

import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
/* loaded from: classes6.dex */
public final class Assertions {
    private Assertions() {
        throw new UnsupportedOperationException("This class is non-instantiable");
    }

    @NonNull
    private static String a(@NonNull String str, @NonNull Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static void assertInRangeInclusive(int i4, int i5, int i6, @NonNull String str) {
        if (i5 > i6) {
            throw new IllegalArgumentException("maxInclusive is not >= minInclusive");
        }
        if (i4 < i5 || i4 > i6) {
            throw new AssertionError(a("%s=%d is not in the range [%d, %d]", str, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)));
        }
    }

    public static void assertInSet(@Nullable Object obj, @NonNull Object... objArr) {
        boolean z3;
        assertNotNull(objArr, "set");
        for (Object obj2 : objArr) {
            if (obj2 == null) {
                if (obj == null) {
                    z3 = true;
                    break;
                }
            } else if (obj2.equals(obj)) {
                z3 = true;
                break;
            }
        }
        z3 = false;
        if (z3) {
            return;
        }
        throw new AssertionError(a("%s is not in set %s", obj, objArr));
    }

    public static void assertIsMainThread() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        throw new AssertionError("Current thread is not the main thread");
    }

    public static void assertNoNullElements(@Nullable Object[] objArr, @Nullable String str) {
        assertNotNull(objArr, str);
        for (Object obj : objArr) {
            if (obj == null) {
                throw new AssertionError(a("%s cannot contain null elements", str));
            }
        }
    }

    public static void assertNotEmpty(@Nullable String str, @NonNull String str2) {
        if (str == null || str.length() == 0) {
            throw new AssertionError(a("%s cannot be null or empty", str2));
        }
    }

    public static void assertNotNull(@Nullable Object obj, @NonNull String str) {
        if (obj != null) {
            return;
        }
        throw new AssertionError(a("%s cannot be null", str));
    }

    public static void assertNoNullElements(@Nullable Collection<?> collection, @Nullable String str) {
        assertNotNull(collection, str);
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new AssertionError(a("%s cannot contain null elements", str));
            }
        }
    }

    public static void assertNotEmpty(@Nullable Collection<?> collection, @NonNull String str) {
        assertNotNull(collection, str);
        if (collection.isEmpty()) {
            throw new AssertionError(a("%s cannot be empty", str));
        }
    }

    public static void assertInRangeInclusive(long j4, long j5, long j6, @NonNull String str) {
        if (j5 > j6) {
            throw new IllegalArgumentException("maxInclusive is not >= minInclusive");
        }
        if (j4 < j5 || j4 > j6) {
            throw new AssertionError(a("%s=%d is not in the range [%d, %d]", str, Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6)));
        }
    }

    public static void assertNoNullElements(@Nullable Map<?, ?> map, @Nullable String str) {
        assertNotNull(map, str);
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (entry.getKey() != null) {
                if (entry.getValue() == null) {
                    throw new AssertionError(a("%s cannot contain null values", str));
                }
            } else {
                throw new AssertionError(a("%s cannot contain null keys", str));
            }
        }
    }

    public static void assertNotEmpty(@Nullable Map<?, ?> map, @NonNull String str) {
        assertNotNull(map, str);
        if (map.isEmpty()) {
            throw new AssertionError(a("%s cannot be empty", str));
        }
    }

    public static void assertInRangeInclusive(float f4, float f5, float f6, @NonNull String str) {
        if (Float.compare(f5, f6) <= 0) {
            if (Float.compare(f4, f5) < 0 || Float.compare(f4, f6) > 0) {
                throw new AssertionError(a("%s=%f is not in the range [%f, %f]", str, Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)));
            }
            return;
        }
        throw new IllegalArgumentException("maxInclusive is not >= minInclusive");
    }

    public static void assertInRangeInclusive(double d4, double d5, double d6, @NonNull String str) {
        if (Double.compare(d5, d6) <= 0) {
            if (Double.compare(d4, d5) < 0 || Double.compare(d4, d6) > 0) {
                throw new AssertionError(a("%s=%f is not in the range [%f, %f]", str, Double.valueOf(d4), Double.valueOf(d5), Double.valueOf(d6)));
            }
            return;
        }
        throw new IllegalArgumentException("maxInclusive is not >= minInclusive");
    }
}
