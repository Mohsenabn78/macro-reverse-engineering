package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.NonNull;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes4.dex */
public interface IGmsCallbacks extends IInterface {
    void onPostInitComplete(int i4, @NonNull IBinder iBinder, @NonNull Bundle bundle) throws RemoteException;

    void zzb(int i4, @NonNull Bundle bundle) throws RemoteException;

    void zzc(int i4, IBinder iBinder, zzj zzjVar) throws RemoteException;
}
