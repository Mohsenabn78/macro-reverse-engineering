package com.google.android.gms.internal.places;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzdj implements Iterator {
    private int pos;
    private Iterator zzlz;
    private final /* synthetic */ zzdb zzma;
    private boolean zzmd;

    private zzdj(zzdb zzdbVar) {
        this.zzma = zzdbVar;
        this.pos = -1;
    }

    private final Iterator zzde() {
        Map map;
        if (this.zzlz == null) {
            map = this.zzma.zzlr;
            this.zzlz = map.entrySet().iterator();
        }
        return this.zzlz;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        Map map;
        int i4 = this.pos + 1;
        list = this.zzma.zzlq;
        if (i4 >= list.size()) {
            map = this.zzma.zzlr;
            if (map.isEmpty() || !zzde().hasNext()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        List list;
        List list2;
        this.zzmd = true;
        int i4 = this.pos + 1;
        this.pos = i4;
        list = this.zzma.zzlq;
        if (i4 < list.size()) {
            list2 = this.zzma.zzlq;
            return (Map.Entry) list2.get(this.pos);
        }
        return (Map.Entry) zzde().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        List list;
        if (this.zzmd) {
            this.zzmd = false;
            this.zzma.zzcx();
            int i4 = this.pos;
            list = this.zzma.zzlq;
            if (i4 < list.size()) {
                zzdb zzdbVar = this.zzma;
                int i5 = this.pos;
                this.pos = i5 - 1;
                zzdbVar.zzan(i5);
                return;
            }
            zzde().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzdj(zzdb zzdbVar, zzde zzdeVar) {
        this(zzdbVar);
    }
}
