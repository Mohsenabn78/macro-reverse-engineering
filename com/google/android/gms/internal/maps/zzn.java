package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import java.util.List;

/* loaded from: classes4.dex */
public interface zzn extends IInterface {
    int getActiveLevelIndex() throws RemoteException;

    int getDefaultLevelIndex() throws RemoteException;

    List<IBinder> getLevels() throws RemoteException;

    boolean isUnderground() throws RemoteException;

    boolean zzb(zzn zznVar) throws RemoteException;

    int zzj() throws RemoteException;
}
