package com.google.android.gms.common.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@KeepForSdk
/* loaded from: classes4.dex */
public final class CollectionUtils {
    private CollectionUtils() {
    }

    private static Map a(int i4, boolean z3) {
        if (i4 <= 256) {
            return new ArrayMap(i4);
        }
        return new HashMap(i4, 1.0f);
    }

    private static Set b(int i4, boolean z3) {
        float f4;
        int i5;
        if (true != z3) {
            f4 = 1.0f;
        } else {
            f4 = 0.75f;
        }
        if (true != z3) {
            i5 = 256;
        } else {
            i5 = 128;
        }
        if (i4 <= i5) {
            return new ArraySet(i4);
        }
        return new HashSet(i4, f4);
    }

    @KeepForSdk
    public static boolean isEmpty(@Nullable Collection<?> collection) {
        if (collection == null) {
            return true;
        }
        return collection.isEmpty();
    }

    @NonNull
    @KeepForSdk
    @Deprecated
    public static <T> List<T> listOf() {
        return Collections.emptyList();
    }

    @NonNull
    @KeepForSdk
    public static <K, V> Map<K, V> mapOf(@NonNull K k4, @NonNull V v3, @NonNull K k5, @NonNull V v4, @NonNull K k6, @NonNull V v5) {
        Map a4 = a(3, false);
        a4.put(k4, v3);
        a4.put(k5, v4);
        a4.put(k6, v5);
        return Collections.unmodifiableMap(a4);
    }

    @NonNull
    @KeepForSdk
    public static <K, V> Map<K, V> mapOfKeyValueArrays(@NonNull K[] kArr, @NonNull V[] vArr) {
        int length = kArr.length;
        int length2 = vArr.length;
        if (length == length2) {
            if (length != 0) {
                if (length != 1) {
                    Map a4 = a(length, false);
                    for (int i4 = 0; i4 < kArr.length; i4++) {
                        a4.put(kArr[i4], vArr[i4]);
                    }
                    return Collections.unmodifiableMap(a4);
                }
                return Collections.singletonMap(kArr[0], vArr[0]);
            }
            return Collections.emptyMap();
        }
        throw new IllegalArgumentException("Key and values array lengths not equal: " + length + " != " + length2);
    }

    @NonNull
    @KeepForSdk
    public static <T> Set<T> mutableSetOfWithSize(int i4) {
        if (i4 == 0) {
            return new ArraySet();
        }
        return b(i4, true);
    }

    @NonNull
    @KeepForSdk
    @Deprecated
    public static <T> Set<T> setOf(@NonNull T t3, @NonNull T t4, @NonNull T t5) {
        Set b4 = b(3, false);
        b4.add(t3);
        b4.add(t4);
        b4.add(t5);
        return Collections.unmodifiableSet(b4);
    }

    @NonNull
    @KeepForSdk
    @Deprecated
    public static <T> List<T> listOf(@NonNull T t3) {
        return Collections.singletonList(t3);
    }

    @NonNull
    @KeepForSdk
    @Deprecated
    public static <T> List<T> listOf(@NonNull T... tArr) {
        int length = tArr.length;
        if (length != 0) {
            if (length != 1) {
                return Collections.unmodifiableList(Arrays.asList(tArr));
            }
            return listOf(tArr[0]);
        }
        return listOf();
    }

    @NonNull
    @KeepForSdk
    public static <K, V> Map<K, V> mapOf(@NonNull K k4, @NonNull V v3, @NonNull K k5, @NonNull V v4, @NonNull K k6, @NonNull V v5, @NonNull K k7, @NonNull V v6, @NonNull K k8, @NonNull V v7, @NonNull K k9, @NonNull V v8) {
        Map a4 = a(6, false);
        a4.put(k4, v3);
        a4.put(k5, v4);
        a4.put(k6, v5);
        a4.put(k7, v6);
        a4.put(k8, v7);
        a4.put(k9, v8);
        return Collections.unmodifiableMap(a4);
    }

    @NonNull
    @KeepForSdk
    @Deprecated
    public static <T> Set<T> setOf(@NonNull T... tArr) {
        int length = tArr.length;
        if (length != 0) {
            if (length != 1) {
                if (length == 2) {
                    T t3 = tArr[0];
                    T t4 = tArr[1];
                    Set b4 = b(2, false);
                    b4.add(t3);
                    b4.add(t4);
                    return Collections.unmodifiableSet(b4);
                } else if (length != 3) {
                    if (length != 4) {
                        Set b5 = b(length, false);
                        Collections.addAll(b5, tArr);
                        return Collections.unmodifiableSet(b5);
                    }
                    T t5 = tArr[0];
                    T t6 = tArr[1];
                    T t7 = tArr[2];
                    T t8 = tArr[3];
                    Set b6 = b(4, false);
                    b6.add(t5);
                    b6.add(t6);
                    b6.add(t7);
                    b6.add(t8);
                    return Collections.unmodifiableSet(b6);
                } else {
                    return setOf(tArr[0], tArr[1], tArr[2]);
                }
            }
            return Collections.singleton(tArr[0]);
        }
        return Collections.emptySet();
    }
}
