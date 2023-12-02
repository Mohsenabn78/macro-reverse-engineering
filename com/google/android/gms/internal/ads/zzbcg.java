package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public abstract class zzbcg extends zzatr implements zzbch {
    public zzbcg() {
        super("com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
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
                        zzf();
                        parcel2.writeNoException();
                    } else {
                        zze();
                        parcel2.writeNoException();
                    }
                } else {
                    IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    zzats.zzc(parcel);
                    zzd(asInterface);
                    parcel2.writeNoException();
                }
            } else {
                String zzc = zzc();
                parcel2.writeNoException();
                parcel2.writeString(zzc);
            }
        } else {
            String zzb = zzb();
            parcel2.writeNoException();
            parcel2.writeString(zzb);
        }
        return true;
    }
}
