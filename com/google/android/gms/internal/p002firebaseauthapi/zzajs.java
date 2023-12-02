package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzajs  reason: invalid package */
/* loaded from: classes4.dex */
final class zzajs implements Iterator {
    final Iterator zza;
    final /* synthetic */ zzajt zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzajs(zzajt zzajtVar) {
        zzahq zzahqVar;
        this.zzb = zzajtVar;
        zzahqVar = zzajtVar.zza;
        this.zza = zzahqVar.iterator();
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
