package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public abstract class zzop extends zzb implements zzoq {
    public zzop() {
        super("com.google.android.gms.nearby.uwb.internal.IBooleanResultListener");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean zza(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        if (i4 == 1) {
            boolean zze = zzc.zze(parcel);
            zzc.zzc(parcel);
            zzd(zze);
            return true;
        }
        return false;
    }
}
