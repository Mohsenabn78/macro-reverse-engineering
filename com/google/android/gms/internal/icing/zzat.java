package com.google.android.gms.internal.icing;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.search.GoogleNowAuthState;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes4.dex */
public interface zzat extends IInterface {
    void zzb(Status status, GoogleNowAuthState googleNowAuthState) throws RemoteException;

    void zzc(Status status) throws RemoteException;
}
