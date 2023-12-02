package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.exposurenotification.ExposureSummary;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class zzdd extends zza implements zzdf {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.exposurenotification.internal.IExposureSummaryCallback");
    }

    @Override // com.google.android.gms.internal.nearby.zzdf
    public final void zzb(Status status, ExposureSummary exposureSummary) throws RemoteException {
        throw null;
    }
}
