package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class zabd extends zabw {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference f20191a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zabd(zabe zabeVar) {
        this.f20191a = new WeakReference(zabeVar);
    }

    @Override // com.google.android.gms.common.api.internal.zabw
    public final void zaa() {
        zabe zabeVar = (zabe) this.f20191a.get();
        if (zabeVar == null) {
            return;
        }
        zabe.f(zabeVar);
    }
}
