package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public abstract class zzdl extends zzb implements zzdm {
    public zzdl() {
        super("com.google.android.gms.nearby.exposurenotification.internal.IIntCallback");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean zza(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        if (i4 == 1) {
            int readInt = parcel.readInt();
            zzc.zzc(parcel);
            zzb((Status) zzc.zza(parcel, Status.CREATOR), readInt);
            return true;
        }
        return false;
    }
}
