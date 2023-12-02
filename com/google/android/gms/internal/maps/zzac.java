package com.google.android.gms.internal.maps;

import android.os.IInterface;
import android.os.RemoteException;

/* loaded from: classes4.dex */
public interface zzac extends IInterface {
    void clearTileCache() throws RemoteException;

    boolean getFadeIn() throws RemoteException;

    String getId() throws RemoteException;

    float getTransparency() throws RemoteException;

    float getZIndex() throws RemoteException;

    boolean isVisible() throws RemoteException;

    void remove() throws RemoteException;

    void setFadeIn(boolean z3) throws RemoteException;

    void setTransparency(float f4) throws RemoteException;

    void setVisible(boolean z3) throws RemoteException;

    void setZIndex(float f4) throws RemoteException;

    boolean zza(zzac zzacVar) throws RemoteException;

    int zzj() throws RemoteException;
}
