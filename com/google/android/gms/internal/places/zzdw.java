package com.google.android.gms.internal.places;

import java.util.ListIterator;

/* loaded from: classes4.dex */
final class zzdw implements ListIterator<String> {
    private final /* synthetic */ int zzbp;
    private final /* synthetic */ zzdt zzml;
    private ListIterator<String> zzmm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdw(zzdt zzdtVar, int i4) {
        zzbr zzbrVar;
        this.zzml = zzdtVar;
        this.zzbp = i4;
        zzbrVar = zzdtVar.zzmj;
        this.zzmm = zzbrVar.listIterator(i4);
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void add(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.zzmm.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.zzmm.hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final /* synthetic */ Object next() {
        return this.zzmm.next();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.zzmm.nextIndex();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ String previous() {
        return this.zzmm.previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.zzmm.previousIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void set(String str) {
        throw new UnsupportedOperationException();
    }
}
