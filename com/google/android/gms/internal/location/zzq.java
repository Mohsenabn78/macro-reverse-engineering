package com.google.android.gms.internal.location;

import android.location.Location;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
/* loaded from: classes4.dex */
public interface zzq extends IInterface {
    void zzb(Status status, Location location) throws RemoteException;
}
