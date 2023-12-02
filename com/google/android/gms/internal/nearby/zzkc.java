package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public abstract class zzkc extends zzb implements zzkd {
    public zzkc() {
        super("com.google.android.gms.nearby.internal.connection.IDiscoveryListener");
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
                    zzb((zzld) zzc.zza(parcel, zzld.CREATOR));
                    return true;
                }
                zzlr zzlrVar = (zzlr) zzc.zza(parcel, zzlr.CREATOR);
                zzc.zzc(parcel);
                return true;
            }
            zzc.zzc(parcel);
            zzd((zzlh) zzc.zza(parcel, zzlh.CREATOR));
            return true;
        }
        zzc.zzc(parcel);
        zzc((zzlf) zzc.zza(parcel, zzlf.CREATOR));
        return true;
    }
}
