package com.google.android.gms.internal.p001authapi;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* renamed from: com.google.android.gms.internal.auth-api.zzc  reason: invalid package */
/* loaded from: classes4.dex */
public class zzc extends Binder implements IInterface {
    private static zze zzc;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzc(String str) {
        attachInterface(this, str);
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
        return zzc(i4, parcel, parcel2, i5);
    }

    protected boolean zzc(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        return false;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }
}
