package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.exposurenotification.PackageConfiguration;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class zzds extends zza implements zzdu {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzds(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.exposurenotification.internal.IPackageConfigurationCallback");
    }

    @Override // com.google.android.gms.internal.nearby.zzdu
    public final void zzb(Status status, PackageConfiguration packageConfiguration) throws RemoteException {
        throw null;
    }
}
