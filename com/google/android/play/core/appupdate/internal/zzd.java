package com.google.android.play.core.appupdate.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.play:app-update@@2.0.1 */
/* loaded from: classes5.dex */
public final class zzd extends zza implements zzf {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzd(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.appupdate.protocol.IAppUpdateService");
    }

    @Override // com.google.android.play.core.appupdate.internal.zzf
    public final void zzc(String str, Bundle bundle, zzh zzhVar) throws RemoteException {
        Parcel a4 = a();
        a4.writeString(str);
        zzc.zzc(a4, bundle);
        zzc.zzd(a4, zzhVar);
        b(3, a4);
    }

    @Override // com.google.android.play.core.appupdate.internal.zzf
    public final void zzd(String str, Bundle bundle, zzh zzhVar) throws RemoteException {
        Parcel a4 = a();
        a4.writeString(str);
        zzc.zzc(a4, bundle);
        zzc.zzd(a4, zzhVar);
        b(2, a4);
    }
}
