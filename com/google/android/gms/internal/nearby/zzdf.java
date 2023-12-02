package com.google.android.gms.internal.nearby;

import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.exposurenotification.ExposureSummary;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public interface zzdf extends IInterface {
    void zzb(Status status, @Nullable ExposureSummary exposureSummary) throws RemoteException;
}
