package com.google.android.gms.internal.icing;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes4.dex */
public abstract class zzab extends zzb implements zzac {
    public zzab() {
        super("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
    }

    @Override // com.google.android.gms.internal.icing.zzb
    protected final boolean zza(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 4) {
                    return false;
                }
                zzo zzoVar = (zzo) zzc.zza(parcel, zzo.CREATOR);
            } else {
                Status status = (Status) zzc.zza(parcel, Status.CREATOR);
                ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) zzc.zza(parcel, ParcelFileDescriptor.CREATOR);
            }
        } else {
            zzb((Status) zzc.zza(parcel, Status.CREATOR));
        }
        return true;
    }
}
