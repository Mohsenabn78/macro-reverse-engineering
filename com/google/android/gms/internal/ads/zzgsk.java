package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzgsk implements Iterator {
    final Iterator zza;
    final /* synthetic */ zzgsl zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgsk(zzgsl zzgslVar) {
        zzgqe zzgqeVar;
        this.zzb = zzgslVar;
        zzgqeVar = zzgslVar.zza;
        this.zza = zzgqeVar.iterator();
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
