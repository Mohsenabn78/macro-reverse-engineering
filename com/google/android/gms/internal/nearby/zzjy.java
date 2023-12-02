package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public abstract class zzjy extends zzb implements zzjz {
    public zzjy() {
        super("com.google.android.gms.nearby.internal.connection.IConnectionResponseListener");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean zza(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        if (i4 == 2) {
            zzc.zzc(parcel);
            zzb((zzkx) zzc.zza(parcel, zzkx.CREATOR));
            return true;
        }
        return false;
    }
}
