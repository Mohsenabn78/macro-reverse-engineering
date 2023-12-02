package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public abstract class zzet extends com.google.android.gms.internal.wearable.zzb implements zzeu {
    public zzet() {
        super("com.google.android.gms.wearable.internal.IChannelStreamCallbacks");
    }

    @Override // com.google.android.gms.internal.wearable.zzb
    protected final boolean zza(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        if (i4 == 2) {
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            com.google.android.gms.internal.wearable.zzc.zzb(parcel);
            zzb(readInt, readInt2);
            parcel2.writeNoException();
            return true;
        }
        return false;
    }
}
