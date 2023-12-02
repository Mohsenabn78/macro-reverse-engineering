package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public abstract class zzow extends zzb implements zzox {
    public zzow() {
        super("com.google.android.gms.nearby.uwb.internal.IRangingSessionCallback");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean zza(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        if (i4 != 2) {
            if (i4 != 3) {
                if (i4 != 4) {
                    return false;
                }
                zzc.zzc(parcel);
                zzf((zzpp) zzc.zza(parcel, zzpp.CREATOR));
                return true;
            }
            zzc.zzc(parcel);
            zze((zzpn) zzc.zza(parcel, zzpn.CREATOR));
            return true;
        }
        zzc.zzc(parcel);
        zzd((zzpl) zzc.zza(parcel, zzpl.CREATOR));
        return true;
    }
}
