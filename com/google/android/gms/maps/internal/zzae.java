package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes4.dex */
public abstract class zzae extends com.google.android.gms.internal.maps.zzb implements zzad {
    public zzae() {
        super("com.google.android.gms.maps.internal.IOnInfoWindowCloseListener");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    protected final boolean dispatchTransaction(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        if (i4 == 1) {
            zzg(com.google.android.gms.internal.maps.zzu.zzg(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }
        return false;
    }
}
