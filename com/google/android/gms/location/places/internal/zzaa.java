package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

/* loaded from: classes4.dex */
public abstract class zzaa extends com.google.android.gms.internal.places.zzb implements zzx {
    public zzaa() {
        super("com.google.android.gms.location.places.internal.IPlacesCallbacks");
    }

    @Override // com.google.android.gms.internal.places.zzb
    protected final boolean dispatchTransaction(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 != 4) {
                        if (i4 != 5) {
                            return false;
                        }
                        zze((DataHolder) com.google.android.gms.internal.places.zze.zzb(parcel, DataHolder.CREATOR));
                    } else {
                        zzb((Status) com.google.android.gms.internal.places.zze.zzb(parcel, Status.CREATOR));
                    }
                } else {
                    zzd((DataHolder) com.google.android.gms.internal.places.zze.zzb(parcel, DataHolder.CREATOR));
                }
            } else {
                zzc((DataHolder) com.google.android.gms.internal.places.zze.zzb(parcel, DataHolder.CREATOR));
            }
        } else {
            zzb((DataHolder) com.google.android.gms.internal.places.zze.zzb(parcel, DataHolder.CREATOR));
        }
        return true;
    }
}
