package com.google.android.gms.internal.play_billing;

import java.util.Iterator;

/* compiled from: com.android.billingclient:billing@@5.2.0 */
/* loaded from: classes4.dex */
final class zzek implements Iterator {
    final Iterator zza;
    final /* synthetic */ zzel zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzek(zzel zzelVar) {
        zzcn zzcnVar;
        this.zzb = zzelVar;
        zzcnVar = zzelVar.zza;
        this.zza = zzcnVar.iterator();
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
