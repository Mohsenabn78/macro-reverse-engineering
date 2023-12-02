package com.google.android.gms.internal.identity;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.identity.intents.UserAddressRequest;

/* compiled from: com.google.android.gms:play-services-identity@@17.0.1 */
/* loaded from: classes4.dex */
public final class zzh extends zza {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.identity.intents.internal.IAddressService");
    }

    public final void zzc(zzg zzgVar, UserAddressRequest userAddressRequest, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, zzgVar);
        zzc.zzb(zza, userAddressRequest);
        zzc.zzb(zza, bundle);
        zzb(2, zza);
    }
}
