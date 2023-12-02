package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public abstract class zzbnv extends zzatr implements zzbnw {
    public zzbnv() {
        super("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    public static zzbnw zzf(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        if (queryLocalInterface instanceof zzbnw) {
            return (zzbnw) queryLocalInterface;
        }
        return new zzbnu(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzatr
    protected final boolean zzbE(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 != 4) {
                        return false;
                    }
                    String readString = parcel.readString();
                    zzats.zzc(parcel);
                    boolean zzd = zzd(readString);
                    parcel2.writeNoException();
                    parcel2.writeInt(zzd ? 1 : 0);
                } else {
                    String readString2 = parcel.readString();
                    zzats.zzc(parcel);
                    zzbpt zzc = zzc(readString2);
                    parcel2.writeNoException();
                    zzats.zzf(parcel2, zzc);
                }
            } else {
                String readString3 = parcel.readString();
                zzats.zzc(parcel);
                boolean zze = zze(readString3);
                parcel2.writeNoException();
                parcel2.writeInt(zze ? 1 : 0);
            }
        } else {
            String readString4 = parcel.readString();
            zzats.zzc(parcel);
            zzbnz zzb = zzb(readString4);
            parcel2.writeNoException();
            zzats.zzf(parcel2, zzb);
        }
        return true;
    }
}
