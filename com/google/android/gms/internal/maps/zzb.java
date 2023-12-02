package com.google.android.gms.internal.maps;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes4.dex */
public class zzb extends Binder implements IInterface {
    private static zzd zzc;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzb(String str) {
        attachInterface(this, str);
    }

    protected boolean dispatchTransaction(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        return false;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        boolean z3;
        if (i4 > 16777215) {
            z3 = super.onTransact(i4, parcel, parcel2, i5);
        } else {
            parcel.enforceInterface(getInterfaceDescriptor());
            z3 = false;
        }
        if (z3) {
            return true;
        }
        return dispatchTransaction(i4, parcel, parcel2, i5);
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }
}
