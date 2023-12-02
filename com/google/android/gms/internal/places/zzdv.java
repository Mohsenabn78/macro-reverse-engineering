package com.google.android.gms.internal.places;

import java.util.Iterator;

/* loaded from: classes4.dex */
final class zzdv implements Iterator<String> {
    private Iterator<String> zzmk;
    private final /* synthetic */ zzdt zzml;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdv(zzdt zzdtVar) {
        zzbr zzbrVar;
        this.zzml = zzdtVar;
        zzbrVar = zzdtVar.zzmj;
        this.zzmk = zzbrVar.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzmk.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.zzmk.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
