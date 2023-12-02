package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.J2ktIncompatible;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class Platform {
    private Platform() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T[] a(Object[] objArr, int i4, int i5, T[] tArr) {
        return (T[]) Arrays.copyOfRange(objArr, i4, i5, tArr.getClass());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E extends Enum<E>> Class<E> b(E e4) {
        return e4.getDeclaringClass();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T[] c(T[] tArr, int i4) {
        if (tArr.length != 0) {
            tArr = (T[]) Arrays.copyOf(tArr, 0);
        }
        return (T[]) Arrays.copyOf(tArr, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> Map<K, V> d(int i4) {
        return CompactHashMap.z(i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> Set<E> e(int i4) {
        return CompactHashSet.i(i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> Map<K, V> f(int i4) {
        return CompactLinkedHashMap.d0(i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> Set<E> g(int i4) {
        return CompactLinkedHashSet.E(i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> Set<E> h() {
        return CompactHashSet.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> Map<K, V> i() {
        return CompactHashMap.u();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @J2ktIncompatible
    public static MapMaker j(MapMaker mapMaker) {
        return mapMaker.weakKeys();
    }
}
