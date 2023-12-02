package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.places.PlacePhotoMetadataResult;
import com.google.android.gms.location.places.PlacePhotoResult;

/* loaded from: classes4.dex */
public abstract class zzy extends com.google.android.gms.internal.places.zzb implements zzv {
    public zzy() {
        super("com.google.android.gms.location.places.internal.IPhotosCallbacks");
    }

    @Override // com.google.android.gms.internal.places.zzb
    protected final boolean dispatchTransaction(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        if (i4 != 2) {
            if (i4 != 3) {
                return false;
            }
            zzb((PlacePhotoMetadataResult) com.google.android.gms.internal.places.zze.zzb(parcel, PlacePhotoMetadataResult.CREATOR));
            return true;
        }
        zzb((PlacePhotoResult) com.google.android.gms.internal.places.zze.zzb(parcel, PlacePhotoResult.CREATOR));
        return true;
    }
}
