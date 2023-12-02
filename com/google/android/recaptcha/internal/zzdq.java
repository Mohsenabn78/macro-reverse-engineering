package com.google.android.recaptcha.internal;

import java.util.Collection;
import java.util.Iterator;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public abstract class zzdq extends zzdr implements Collection {
    public boolean add(Object obj) {
        return zzc().add(obj);
    }

    public boolean addAll(Collection collection) {
        return zzc().addAll(collection);
    }

    @Override // java.util.Collection
    public final void clear() {
        zzc().clear();
    }

    @Override // java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        return zzc().contains(obj);
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
        return zzc().containsAll(collection);
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return zzc().isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return zzc().iterator();
    }

    @Override // java.util.Collection
    public final boolean remove(@CheckForNull Object obj) {
        return zzc().remove(obj);
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        return zzc().removeAll(collection);
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        return zzc().retainAll(collection);
    }

    @Override // java.util.Collection
    public final int size() {
        return zzc().size();
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return zzc().toArray();
    }

    @Override // com.google.android.recaptcha.internal.zzdr
    protected /* bridge */ /* synthetic */ Object zzb() {
        throw null;
    }

    protected abstract Collection zzc();

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        return zzc().toArray(objArr);
    }
}
