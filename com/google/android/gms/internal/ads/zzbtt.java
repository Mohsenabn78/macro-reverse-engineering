package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public abstract class zzbtt extends zzatr implements zzbtu {
    public zzbtt() {
        super("com.google.android.gms.ads.internal.request.IAdsService");
    }

    @Override // com.google.android.gms.internal.ads.zzatr
    protected final boolean zzbE(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        zzbtx zzbtxVar = null;
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    return false;
                }
                zzbtm zzbtmVar = (zzbtm) zzats.zza(parcel, zzbtm.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdsServiceResponseListener");
                    if (queryLocalInterface instanceof zzbtx) {
                        zzbtxVar = (zzbtx) queryLocalInterface;
                    } else {
                        zzbtxVar = new zzbtv(readStrongBinder);
                    }
                }
                zzats.zzc(parcel);
                zze(zzbtmVar, zzbtxVar);
            } else {
                zzbti zzbtiVar = (zzbti) zzats.zza(parcel, zzbti.CREATOR);
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdsServiceResponseListener");
                    if (queryLocalInterface2 instanceof zzbtx) {
                        zzbtx zzbtxVar2 = (zzbtx) queryLocalInterface2;
                    }
                }
                zzats.zzc(parcel);
            }
        } else {
            zzbti zzbtiVar2 = (zzbti) zzats.zza(parcel, zzbti.CREATOR);
            IBinder readStrongBinder3 = parcel.readStrongBinder();
            if (readStrongBinder3 != null) {
                IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdsServiceResponseListener");
                if (queryLocalInterface3 instanceof zzbtx) {
                    zzbtxVar = (zzbtx) queryLocalInterface3;
                } else {
                    zzbtxVar = new zzbtv(readStrongBinder3);
                }
            }
            zzats.zzc(parcel);
            zzf(zzbtiVar2, zzbtxVar);
        }
        parcel2.writeNoException();
        return true;
    }
}
