package com.google.android.gms.internal.places;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzbq<K> implements Iterator<Map.Entry<K, Object>> {
    private Iterator<Map.Entry<K, Object>> zzjx;

    public zzbq(Iterator<Map.Entry<K, Object>> it) {
        this.zzjx = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzjx.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        Map.Entry<K, Object> next = this.zzjx.next();
        if (next.getValue() instanceof zzbl) {
            return new zzbn(next);
        }
        return next;
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.zzjx.remove();
    }
}
