package com.google.firebase.appindexing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.IStatusCallback;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes5.dex */
public final class zzv extends com.google.android.gms.internal.icing.zza {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzv(IBinder iBinder) {
        super(iBinder, "com.google.firebase.appindexing.internal.IAppIndexingService");
    }

    public final zzg zzd(IStatusCallback iStatusCallback, zzz zzzVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.icing.zzc.zzc(zza, iStatusCallback);
        com.google.android.gms.internal.icing.zzc.zzb(zza, zzzVar);
        Parcel zzb = zzb(8, zza);
        zzg zzgVar = (zzg) com.google.android.gms.internal.icing.zzc.zza(zzb, zzg.CREATOR);
        zzb.recycle();
        return zzgVar;
    }
}
