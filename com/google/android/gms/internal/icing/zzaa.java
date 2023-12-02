package com.google.android.gms.internal.icing;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes4.dex */
public final class zzaa extends zza {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaa(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
    }

    public final void zzd(zzac zzacVar, String str, zzx[] zzxVarArr) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, zzacVar);
        zza.writeString(null);
        zza.writeTypedArray(zzxVarArr, 0);
        zzc(1, zza);
    }

    public final void zze(zzac zzacVar, com.google.firebase.appindexing.internal.zzc[] zzcVarArr) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, zzacVar);
        zza.writeTypedArray(zzcVarArr, 0);
        zzc(7, zza);
    }
}
