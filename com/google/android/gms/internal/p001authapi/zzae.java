package com.google.android.gms.internal.p001authapi;

import android.app.PendingIntent;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* renamed from: com.google.android.gms.internal.auth-api.zzae  reason: invalid package */
/* loaded from: classes4.dex */
public interface zzae extends IInterface {
    void zzc(Status status, PendingIntent pendingIntent) throws RemoteException;
}
