package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public abstract class zzcn extends zzb implements zzco {
    public zzcn() {
        super("com.google.android.gms.nearby.exposurenotification.internal.IBooleanCallback");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean zza(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        if (i4 == 1) {
            boolean zze = zzc.zze(parcel);
            zzc.zzc(parcel);
            zzb((Status) zzc.zza(parcel, Status.CREATOR), zze);
            return true;
        }
        return false;
    }
}
