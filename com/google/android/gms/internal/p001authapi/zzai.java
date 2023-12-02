package com.google.android.gms.internal.p001authapi;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.identity.GetSignInIntentRequest;
import com.google.android.gms.common.api.internal.IStatusCallback;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* renamed from: com.google.android.gms.internal.auth-api.zzai  reason: invalid package */
/* loaded from: classes4.dex */
public interface zzai extends IInterface {
    void zzc(IStatusCallback iStatusCallback, String str) throws RemoteException;

    void zzc(zzaa zzaaVar, BeginSignInRequest beginSignInRequest) throws RemoteException;

    void zzc(zzae zzaeVar, GetSignInIntentRequest getSignInIntentRequest) throws RemoteException;
}
