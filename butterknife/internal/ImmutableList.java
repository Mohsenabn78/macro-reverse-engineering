package butterknife.internal;

import java.util.AbstractList;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
final class ImmutableList<T> extends AbstractList<T> implements RandomAccess {
    private final T[] views;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableList(T[] tArr) {
        this.views = tArr;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        for (T t3 : this.views) {
            if (t3 == obj) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i4) {
        return this.views[i4];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.views.length;
    }
}
