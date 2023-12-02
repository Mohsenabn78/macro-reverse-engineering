package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public abstract class zzbrl extends zzatr implements zzbrm {
    public zzbrl() {
        super("com.google.android.gms.ads.internal.offline.IOfflineUtils");
    }

    public static zzbrm zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.offline.IOfflineUtils");
        if (queryLocalInterface instanceof zzbrm) {
            return (zzbrm) queryLocalInterface;
        }
        return new zzbrk(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzatr
    protected final boolean zzbE(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 != 4) {
                        if (i4 != 5) {
                            return false;
                        }
                        String[] createStringArray = parcel.createStringArray();
                        int[] createIntArray = parcel.createIntArray();
                        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                        zzats.zzc(parcel);
                        zzf(createStringArray, createIntArray, asInterface);
                    } else {
                        IObjectWrapper asInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                        zzats.zzc(parcel);
                        zzg(asInterface2);
                    }
                } else {
                    zzh();
                }
            } else {
                IObjectWrapper asInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                zzats.zzc(parcel);
                zzi(asInterface3, readString, readString2);
            }
        } else {
            zzats.zzc(parcel);
            zze((Intent) zzats.zza(parcel, Intent.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
