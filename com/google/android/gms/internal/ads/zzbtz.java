package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public abstract class zzbtz extends zzatr implements zzbua {
    public zzbtz() {
        super("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
    }

    @Override // com.google.android.gms.internal.ads.zzatr
    protected final boolean zzbE(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        if (i4 != 1) {
            if (i4 != 2) {
                return false;
            }
            zzats.zzc(parcel);
            zze((com.google.android.gms.ads.internal.util.zzaz) zzats.zza(parcel, com.google.android.gms.ads.internal.util.zzaz.CREATOR));
        } else {
            zzats.zzc(parcel);
            zzf((ParcelFileDescriptor) zzats.zza(parcel, ParcelFileDescriptor.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
