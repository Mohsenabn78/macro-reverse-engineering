package com.google.android.gms.internal.wearable;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
final class zzei implements Iterator {
    final Iterator zza;
    final /* synthetic */ zzej zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzei(zzej zzejVar) {
        zzck zzckVar;
        this.zzb = zzejVar;
        zzckVar = zzejVar.zza;
        this.zza = zzckVar.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.zza.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
