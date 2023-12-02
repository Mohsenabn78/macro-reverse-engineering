package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public abstract class zzkg extends zzb implements zzkh {
    public zzkg() {
        super("com.google.android.gms.nearby.internal.connection.IPayloadListener");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean zza(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        if (i4 != 2) {
            if (i4 != 3) {
                return false;
            }
            zzc.zzc(parcel);
            zzc((zzll) zzc.zza(parcel, zzll.CREATOR));
            return true;
        }
        zzc.zzc(parcel);
        zzb((zzlj) zzc.zza(parcel, zzlj.CREATOR));
        return true;
    }
}
