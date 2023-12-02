package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public abstract class zzcu extends zzb implements zzcv {
    public zzcu() {
        super("com.google.android.gms.nearby.exposurenotification.internal.IDiagnosisKeyFileSupplier");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean zza(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    return false;
                }
                parcel2.writeNoException();
                int i6 = zzc.zza;
                parcel2.writeInt(1);
            } else {
                ParcelFileDescriptor zzb = zzb();
                parcel2.writeNoException();
                int i7 = zzc.zza;
                if (zzb == null) {
                    parcel2.writeInt(0);
                } else {
                    parcel2.writeInt(1);
                    zzb.writeToParcel(parcel2, 1);
                }
            }
        } else {
            boolean zzc = zzc();
            parcel2.writeNoException();
            int i8 = zzc.zza;
            parcel2.writeInt(zzc ? 1 : 0);
        }
        return true;
    }
}
