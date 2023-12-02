package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public abstract class zzjv extends zzb implements zzjw {
    public zzjv() {
        super("com.google.android.gms.nearby.internal.connection.IConnectionLifecycleListener");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean zza(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        if (i4 != 2) {
            if (i4 != 3) {
                if (i4 != 4) {
                    if (i4 != 5) {
                        return false;
                    }
                    zzc.zzc(parcel);
                    zzb((zzkr) zzc.zza(parcel, zzkr.CREATOR));
                    return true;
                }
                zzc.zzc(parcel);
                zze((zzlb) zzc.zza(parcel, zzlb.CREATOR));
                return true;
            }
            zzc.zzc(parcel);
            zzd((zzkz) zzc.zza(parcel, zzkz.CREATOR));
            return true;
        }
        zzc.zzc(parcel);
        zzc((zzkt) zzc.zza(parcel, zzkt.CREATOR));
        return true;
    }
}
