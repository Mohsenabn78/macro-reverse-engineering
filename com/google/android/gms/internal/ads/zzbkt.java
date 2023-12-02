package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public abstract class zzbkt extends zzatr implements zzbku {
    public zzbkt() {
        super("com.google.android.gms.ads.internal.instream.client.IInstreamAd");
    }

    @Override // com.google.android.gms.internal.ads.zzatr
    protected final boolean zzbE(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        zzbkx zzbkvVar;
        if (i4 != 3) {
            if (i4 != 4) {
                if (i4 != 5) {
                    if (i4 != 6) {
                        if (i4 != 7) {
                            return false;
                        }
                        zzbeo zzc = zzc();
                        parcel2.writeNoException();
                        zzats.zzf(parcel2, zzc);
                        return true;
                    }
                    IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    zzats.zzc(parcel);
                    zze(asInterface);
                    parcel2.writeNoException();
                    return true;
                }
                IObjectWrapper asInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzbkvVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.instream.client.IInstreamAdCallback");
                    if (queryLocalInterface instanceof zzbkx) {
                        zzbkvVar = (zzbkx) queryLocalInterface;
                    } else {
                        zzbkvVar = new zzbkv(readStrongBinder);
                    }
                }
                zzats.zzc(parcel);
                zzf(asInterface2, zzbkvVar);
                parcel2.writeNoException();
                return true;
            }
            zzd();
            parcel2.writeNoException();
            return true;
        }
        com.google.android.gms.ads.internal.client.zzdq zzb = zzb();
        parcel2.writeNoException();
        zzats.zzf(parcel2, zzb);
        return true;
    }
}
