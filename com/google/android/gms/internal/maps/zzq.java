package com.google.android.gms.internal.maps;

import android.os.IInterface;
import android.os.RemoteException;

/* loaded from: classes4.dex */
public interface zzq extends IInterface {
    void activate() throws RemoteException;

    String getName() throws RemoteException;

    String getShortName() throws RemoteException;

    boolean zzb(zzq zzqVar) throws RemoteException;

    int zzj() throws RemoteException;
}
