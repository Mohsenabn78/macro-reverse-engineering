package com.google.android.gms.common.internal.service;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
final class zad extends zaa {

    /* renamed from: a  reason: collision with root package name */
    private final BaseImplementation.ResultHolder f20500a;

    public zad(BaseImplementation.ResultHolder resultHolder) {
        this.f20500a = resultHolder;
    }

    @Override // com.google.android.gms.common.internal.service.zaa, com.google.android.gms.common.internal.service.zak
    public final void zab(int i4) throws RemoteException {
        this.f20500a.setResult(new Status(i4));
    }
}
