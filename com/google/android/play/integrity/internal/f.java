package com.google.android.play.integrity.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
/* loaded from: classes5.dex */
public final class f extends a implements h {
    /* JADX INFO: Access modifiers changed from: package-private */
    public f(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.integrity.protocol.IIntegrityService");
    }

    @Override // com.google.android.play.integrity.internal.h
    public final void c(Bundle bundle, j jVar) throws RemoteException {
        Parcel a4 = a();
        c.c(a4, bundle);
        c.d(a4, jVar);
        b(2, a4);
    }
}
