package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public abstract class zzjp extends zzb implements zzjq {
    public zzjp() {
        super("com.google.android.gms.nearby.internal.connection.IAdvertisingCallback");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean zza(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        if (i4 != 2) {
            if (i4 != 3) {
                return false;
            }
            zzlp zzlpVar = (zzlp) zzc.zza(parcel, zzlp.CREATOR);
            zzc.zzc(parcel);
            return true;
        }
        zzc.zzc(parcel);
        zzb((zzkv) zzc.zza(parcel, zzkv.CREATOR));
        return true;
    }
}
