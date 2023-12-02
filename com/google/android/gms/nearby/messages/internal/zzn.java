package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public abstract class zzn extends com.google.android.gms.internal.nearby.zzb implements zzo {
    public zzn() {
        super("com.google.android.gms.nearby.messages.internal.IMessageListener");
    }

    @Override // com.google.android.gms.internal.nearby.zzb
    protected final boolean zza(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 4) {
                    return false;
                }
                ArrayList createTypedArrayList = parcel.createTypedArrayList(Update.CREATOR);
                com.google.android.gms.internal.nearby.zzc.zzc(parcel);
                zzd(createTypedArrayList);
            } else {
                zzae zzaeVar = (zzae) com.google.android.gms.internal.nearby.zzc.zza(parcel, zzae.CREATOR);
                com.google.android.gms.internal.nearby.zzc.zzc(parcel);
            }
        } else {
            zzae zzaeVar2 = (zzae) com.google.android.gms.internal.nearby.zzc.zza(parcel, zzae.CREATOR);
            com.google.android.gms.internal.nearby.zzc.zzc(parcel);
        }
        return true;
    }
}
