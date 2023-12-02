package com.google.firebase.firestore.model;

import androidx.annotation.NonNull;
import com.google.firebase.firestore.model.BasePath;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Util;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public abstract class BasePath<B extends BasePath<B>> implements Comparable<B> {

    /* renamed from: a  reason: collision with root package name */
    final List<String> f30943a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BasePath(List<String> list) {
        this.f30943a = list;
    }

    abstract B a(List<String> list);

    public B append(String str) {
        ArrayList arrayList = new ArrayList(this.f30943a);
        arrayList.add(str);
        return a(arrayList);
    }

    public abstract String canonicalString();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(@NonNull Object obj) {
        return compareTo((BasePath<B>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof BasePath) && compareTo((BasePath<B>) obj) == 0) {
            return true;
        }
        return false;
    }

    public String getFirstSegment() {
        return this.f30943a.get(0);
    }

    public String getLastSegment() {
        return this.f30943a.get(length() - 1);
    }

    public String getSegment(int i4) {
        return this.f30943a.get(i4);
    }

    public int hashCode() {
        return ((getClass().hashCode() + 37) * 37) + this.f30943a.hashCode();
    }

    public boolean isEmpty() {
        if (length() == 0) {
            return true;
        }
        return false;
    }

    public boolean isImmediateParentOf(B b4) {
        if (length() + 1 != b4.length()) {
            return false;
        }
        for (int i4 = 0; i4 < length(); i4++) {
            if (!getSegment(i4).equals(b4.getSegment(i4))) {
                return false;
            }
        }
        return true;
    }

    public boolean isPrefixOf(B b4) {
        if (length() > b4.length()) {
            return false;
        }
        for (int i4 = 0; i4 < length(); i4++) {
            if (!getSegment(i4).equals(b4.getSegment(i4))) {
                return false;
            }
        }
        return true;
    }

    public B keepFirst(int i4) {
        return a(this.f30943a.subList(0, i4));
    }

    public int length() {
        return this.f30943a.size();
    }

    public B popFirst() {
        return popFirst(1);
    }

    public B popLast() {
        return a(this.f30943a.subList(0, length() - 1));
    }

    public String toString() {
        return canonicalString();
    }

    public int compareTo(@NonNull B b4) {
        int length = length();
        int length2 = b4.length();
        for (int i4 = 0; i4 < length && i4 < length2; i4++) {
            int compareTo = getSegment(i4).compareTo(b4.getSegment(i4));
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return Util.compareIntegers(length, length2);
    }

    public B popFirst(int i4) {
        int length = length();
        Assert.hardAssert(length >= i4, "Can't call popFirst with count > length() (%d > %d)", Integer.valueOf(i4), Integer.valueOf(length));
        return a(this.f30943a.subList(i4, length));
    }

    public B append(B b4) {
        ArrayList arrayList = new ArrayList(this.f30943a);
        arrayList.addAll(b4.f30943a);
        return a(arrayList);
    }
}
