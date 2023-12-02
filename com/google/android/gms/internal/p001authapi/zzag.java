package com.google.android.gms.internal.p001authapi;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.api.identity.SavePasswordResult;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* renamed from: com.google.android.gms.internal.auth-api.zzag  reason: invalid package */
/* loaded from: classes4.dex */
public interface zzag extends IInterface {
    void zzc(Status status, SavePasswordResult savePasswordResult) throws RemoteException;
}
