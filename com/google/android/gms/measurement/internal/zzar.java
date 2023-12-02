package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
final class zzar implements Iterator {

    /* renamed from: a  reason: collision with root package name */
    final Iterator f21482a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzas f21483b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzar(zzas zzasVar) {
        Bundle bundle;
        this.f21483b = zzasVar;
        bundle = zzasVar.f21484a;
        this.f21482a = bundle.keySet().iterator();
    }

    @Override // java.util.Iterator
    /* renamed from: a */
    public final String next() {
        return (String) this.f21482a.next();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f21482a.hasNext();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}
