package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public abstract class zzjs extends zzb implements zzjt {
    public zzjs() {
        super("com.google.android.gms.nearby.internal.connection.IConnectionEventListener");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean zza(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        if (i4 != 2) {
            if (i4 != 3) {
                if (i4 != 4) {
                    return false;
                }
                zzll zzllVar = (zzll) zzc.zza(parcel, zzll.CREATOR);
                zzc.zzc(parcel);
                return true;
            }
            zzc.zzc(parcel);
            zzc((zzlb) zzc.zza(parcel, zzlb.CREATOR));
            return true;
        }
        zzc.zzc(parcel);
        zzd((zzlj) zzc.zza(parcel, zzlj.CREATOR));
        return true;
    }
}
