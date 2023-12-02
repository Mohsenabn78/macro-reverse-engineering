package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.Iterator;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class Comparators {
    private Comparators() {
    }

    public static <T> boolean isInOrder(Iterable<? extends T> iterable, Comparator<T> comparator) {
        Preconditions.checkNotNull(comparator);
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            while (it.hasNext()) {
                T next2 = it.next();
                if (comparator.compare(next, next2) > 0) {
                    return false;
                }
                next = next2;
            }
            return true;
        }
        return true;
    }

    public static <T> boolean isInStrictOrder(Iterable<? extends T> iterable, Comparator<T> comparator) {
        Preconditions.checkNotNull(comparator);
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            while (it.hasNext()) {
                T next2 = it.next();
                if (comparator.compare(next, next2) >= 0) {
                    return false;
                }
                next = next2;
            }
            return true;
        }
        return true;
    }

    public static <T, S extends T> Comparator<Iterable<S>> lexicographical(Comparator<T> comparator) {
        return new LexicographicalOrdering((Comparator) Preconditions.checkNotNull(comparator));
    }

    public static <T extends Comparable<? super T>> T max(T t3, T t4) {
        return t3.compareTo(t4) >= 0 ? t3 : t4;
    }

    public static <T extends Comparable<? super T>> T min(T t3, T t4) {
        return t3.compareTo(t4) <= 0 ? t3 : t4;
    }

    @ParametricNullness
    public static <T> T max(@ParametricNullness T t3, @ParametricNullness T t4, Comparator<T> comparator) {
        return comparator.compare(t3, t4) >= 0 ? t3 : t4;
    }

    @ParametricNullness
    public static <T> T min(@ParametricNullness T t3, @ParametricNullness T t4, Comparator<T> comparator) {
        return comparator.compare(t3, t4) <= 0 ? t3 : t4;
    }
}
