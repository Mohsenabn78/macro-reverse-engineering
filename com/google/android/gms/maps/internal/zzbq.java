package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes4.dex */
public abstract class zzbq extends com.google.android.gms.internal.maps.zzb implements zzbp {
    public zzbq() {
        super("com.google.android.gms.maps.internal.IOnStreetViewPanoramaReadyCallback");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    protected final boolean dispatchTransaction(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        IStreetViewPanoramaDelegate zzbuVar;
        if (i4 == 1) {
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder == null) {
                zzbuVar = null;
            } else {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                if (queryLocalInterface instanceof IStreetViewPanoramaDelegate) {
                    zzbuVar = (IStreetViewPanoramaDelegate) queryLocalInterface;
                } else {
                    zzbuVar = new zzbu(readStrongBinder);
                }
            }
            zza(zzbuVar);
            parcel2.writeNoException();
            return true;
        }
        return false;
    }
}
