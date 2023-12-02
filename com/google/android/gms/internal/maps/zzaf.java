package com.google.android.gms.internal.maps;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.maps.model.Tile;

/* loaded from: classes4.dex */
public interface zzaf extends IInterface {
    Tile getTile(int i4, int i5, int i6) throws RemoteException;
}
