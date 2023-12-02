package com.google.android.gms.internal.icing;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes4.dex */
public final class zzau extends zza {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzau(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.search.internal.ISearchAuthService");
    }

    public final void zzd(zzat zzatVar, String str, String str2) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, zzatVar);
        zza.writeString(str);
        zza.writeString(str2);
        zzc(1, zza);
    }

    public final void zze(zzat zzatVar, String str, String str2) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, zzatVar);
        zza.writeString(str);
        zza.writeString(str2);
        zzc(2, zza);
    }
}
