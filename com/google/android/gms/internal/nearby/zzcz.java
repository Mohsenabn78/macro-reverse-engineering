package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class zzcz extends zza implements zzdb {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.exposurenotification.internal.IExposureInformationListCallback");
    }

    @Override // com.google.android.gms.internal.nearby.zzdb
    public final void zzb(Status status, List list) throws RemoteException {
        throw null;
    }
}
