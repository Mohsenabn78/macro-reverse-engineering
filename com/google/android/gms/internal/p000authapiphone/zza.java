package com.google.android.gms.internal.p000authapiphone;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-auth-api-phone@@17.4.0 */
/* renamed from: com.google.android.gms.internal.auth-api-phone.zza  reason: invalid package */
/* loaded from: classes4.dex */
public class zza extends Binder implements IInterface {
    private static zzc zza;

    /* JADX INFO: Access modifiers changed from: protected */
    public zza(String str) {
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
        return zza(i4, parcel, parcel2, i5);
    }

    protected boolean zza(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        return false;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }
}
