package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public abstract class zzbeq extends zzatr implements zzber {
    public zzbeq() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    public static zzber zzg(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
        if (queryLocalInterface instanceof zzber) {
            return (zzber) queryLocalInterface;
        }
        return new zzbep(iBinder);
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
                        int zzc = zzc();
                        parcel2.writeNoException();
                        parcel2.writeInt(zzc);
                    } else {
                        int zzd = zzd();
                        parcel2.writeNoException();
                        parcel2.writeInt(zzd);
                    }
                } else {
                    double zzb = zzb();
                    parcel2.writeNoException();
                    parcel2.writeDouble(zzb);
                }
            } else {
                Uri zze = zze();
                parcel2.writeNoException();
                zzats.zze(parcel2, zze);
            }
        } else {
            IObjectWrapper zzf = zzf();
            parcel2.writeNoException();
            zzats.zzf(parcel2, zzf);
        }
        return true;
    }
}
