package com.google.android.gms.location.places.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.PlaceReport;

/* loaded from: classes4.dex */
public interface zzr extends IInterface {
    void zzb(PlaceFilter placeFilter, zzau zzauVar, zzx zzxVar) throws RemoteException;

    void zzb(PlaceReport placeReport, zzau zzauVar, zzx zzxVar) throws RemoteException;
}
