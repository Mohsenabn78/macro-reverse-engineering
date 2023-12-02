package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
final class SortedLists {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public enum KeyAbsentBehavior {
        NEXT_LOWER { // from class: com.google.common.collect.SortedLists.KeyAbsentBehavior.1
            @Override // com.google.common.collect.SortedLists.KeyAbsentBehavior
            int b(int i4) {
                return i4 - 1;
            }
        },
        NEXT_HIGHER { // from class: com.google.common.collect.SortedLists.KeyAbsentBehavior.2
            @Override // com.google.common.collect.SortedLists.KeyAbsentBehavior
            public int b(int i4) {
                return i4;
            }
        },
        INVERTED_INSERTION_INDEX { // from class: com.google.common.collect.SortedLists.KeyAbsentBehavior.3
            @Override // com.google.common.collect.SortedLists.KeyAbsentBehavior
            public int b(int i4) {
                return ~i4;
            }
        };

        abstract int b(int i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public enum KeyPresentBehavior {
        ANY_PRESENT { // from class: com.google.common.collect.SortedLists.KeyPresentBehavior.1
            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            <E> int b(Comparator<? super E> comparator, @ParametricNullness E e4, List<? extends E> list, int i4) {
                return i4;
            }
        },
        LAST_PRESENT { // from class: com.google.common.collect.SortedLists.KeyPresentBehavior.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            <E> int b(Comparator<? super E> comparator, @ParametricNullness E e4, List<? extends E> list, int i4) {
                int size = list.size() - 1;
                while (i4 < size) {
                    int i5 = ((i4 + size) + 1) >>> 1;
                    if (comparator.compare((E) list.get(i5), e4) > 0) {
                        size = i5 - 1;
                    } else {
                        i4 = i5;
                    }
                }
                return i4;
            }
        },
        FIRST_PRESENT { // from class: com.google.common.collect.SortedLists.KeyPresentBehavior.3
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            <E> int b(Comparator<? super E> comparator, @ParametricNullness E e4, List<? extends E> list, int i4) {
                int i5 = 0;
                while (i5 < i4) {
                    int i6 = (i5 + i4) >>> 1;
                    if (comparator.compare((E) list.get(i6), e4) < 0) {
                        i5 = i6 + 1;
                    } else {
                        i4 = i6;
                    }
                }
                return i5;
            }
        },
        FIRST_AFTER { // from class: com.google.common.collect.SortedLists.KeyPresentBehavior.4
            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            public <E> int b(Comparator<? super E> comparator, @ParametricNullness E e4, List<? extends E> list, int i4) {
                return KeyPresentBehavior.LAST_PRESENT.b(comparator, e4, list, i4) + 1;
            }
        },
        LAST_BEFORE { // from class: com.google.common.collect.SortedLists.KeyPresentBehavior.5
            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            public <E> int b(Comparator<? super E> comparator, @ParametricNullness E e4, List<? extends E> list, int i4) {
                return KeyPresentBehavior.FIRST_PRESENT.b(comparator, e4, list, i4) - 1;
            }
        };

        abstract <E> int b(Comparator<? super E> comparator, @ParametricNullness E e4, List<? extends E> list, int i4);
    }

    private SortedLists() {
    }

    public static <E, K extends Comparable> int a(List<E> list, Function<? super E, K> function, K k4, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        Preconditions.checkNotNull(k4);
        return b(list, function, k4, Ordering.natural(), keyPresentBehavior, keyAbsentBehavior);
    }

    public static <E, K> int b(List<E> list, Function<? super E, K> function, @ParametricNullness K k4, Comparator<? super K> comparator, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        return c(Lists.transform(list, function), k4, comparator, keyPresentBehavior, keyAbsentBehavior);
    }

    public static <E> int c(List<? extends E> list, @ParametricNullness E e4, Comparator<? super E> comparator, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        Preconditions.checkNotNull(comparator);
        Preconditions.checkNotNull(list);
        Preconditions.checkNotNull(keyPresentBehavior);
        Preconditions.checkNotNull(keyAbsentBehavior);
        if (!(list instanceof RandomAccess)) {
            list = Lists.newArrayList(list);
        }
        int size = list.size() - 1;
        int i4 = 0;
        while (i4 <= size) {
            int i5 = (i4 + size) >>> 1;
            int compare = comparator.compare(e4, (E) list.get(i5));
            if (compare < 0) {
                size = i5 - 1;
            } else if (compare > 0) {
                i4 = i5 + 1;
            } else {
                return i4 + keyPresentBehavior.b(comparator, e4, list.subList(i4, size + 1), i5 - i4);
            }
        }
        return keyAbsentBehavior.b(i4);
    }
}
