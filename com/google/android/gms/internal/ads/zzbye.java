package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public abstract class zzbye extends zzatr implements zzbyf {
    public zzbye() {
        super("com.google.android.gms.ads.internal.signals.ISignalCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzatr
    protected final boolean zzbE(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    return false;
                }
                zzats.zzc(parcel);
                zzc(parcel.readString(), parcel.readString(), (Bundle) zzats.zza(parcel, Bundle.CREATOR));
            } else {
                String readString = parcel.readString();
                zzats.zzc(parcel);
                zzb(readString);
            }
        } else {
            parcel.readString();
            parcel.readString();
            zzats.zzc(parcel);
        }
        parcel2.writeNoException();
        return true;
    }
}
