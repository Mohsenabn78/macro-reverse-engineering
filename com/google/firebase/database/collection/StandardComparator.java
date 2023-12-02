package com.google.firebase.database.collection;

import java.lang.Comparable;
import java.util.Comparator;

/* loaded from: classes5.dex */
public class StandardComparator<A extends Comparable<A>> implements Comparator<A> {

    /* renamed from: a  reason: collision with root package name */
    private static StandardComparator f30070a = new StandardComparator();

    private StandardComparator() {
    }

    public static <T extends Comparable<T>> StandardComparator<T> getComparator(Class<T> cls) {
        return f30070a;
    }

    @Override // java.util.Comparator
    public int compare(A a4, A a5) {
        return a4.compareTo(a5);
    }
}
