package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.exposurenotification.ExposureWindow;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public abstract class zzdi extends zzb implements zzdj {
    public zzdi() {
        super("com.google.android.gms.nearby.exposurenotification.internal.IExposureWindowListCallback");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean zza(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        if (i4 == 1) {
            ArrayList createTypedArrayList = parcel.createTypedArrayList(ExposureWindow.CREATOR);
            zzc.zzc(parcel);
            zzb((Status) zzc.zza(parcel, Status.CREATOR), createTypedArrayList);
            return true;
        }
        return false;
    }
}
