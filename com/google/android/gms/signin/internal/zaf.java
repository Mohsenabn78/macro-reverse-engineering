package com.google.android.gms.signin.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.IAccountAccessor;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class zaf extends com.google.android.gms.internal.base.zaa {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zaf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    public final void zae(int i4) throws RemoteException {
        Parcel zaa = zaa();
        zaa.writeInt(i4);
        zac(7, zaa);
    }

    public final void zaf(IAccountAccessor iAccountAccessor, int i4, boolean z3) throws RemoteException {
        Parcel zaa = zaa();
        com.google.android.gms.internal.base.zac.zae(zaa, iAccountAccessor);
        zaa.writeInt(i4);
        com.google.android.gms.internal.base.zac.zac(zaa, z3);
        zac(9, zaa);
    }

    public final void zag(zai zaiVar, zae zaeVar) throws RemoteException {
        Parcel zaa = zaa();
        com.google.android.gms.internal.base.zac.zad(zaa, zaiVar);
        com.google.android.gms.internal.base.zac.zae(zaa, zaeVar);
        zac(12, zaa);
    }
}
