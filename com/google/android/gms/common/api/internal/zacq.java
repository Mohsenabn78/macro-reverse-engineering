package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class zacq implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zact f20280a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zacq(zact zactVar) {
        this.f20280a = zactVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zacs zacsVar;
        zacsVar = this.f20280a.f20290g;
        zacsVar.zae(new ConnectionResult(4));
    }
}
