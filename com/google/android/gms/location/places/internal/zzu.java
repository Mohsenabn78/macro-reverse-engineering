package com.google.android.gms.location.places.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.PlaceReport;

/* loaded from: classes4.dex */
public final class zzu extends com.google.android.gms.internal.places.zzc implements zzr {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
    }

    @Override // com.google.android.gms.location.places.internal.zzr
    public final void zzb(PlaceFilter placeFilter, zzau zzauVar, zzx zzxVar) throws RemoteException {
        Parcel zzb = zzb();
        com.google.android.gms.internal.places.zze.zzb(zzb, placeFilter);
        com.google.android.gms.internal.places.zze.zzb(zzb, zzauVar);
        com.google.android.gms.internal.places.zze.zzb(zzb, zzxVar);
        zzb(6, zzb);
    }

    @Override // com.google.android.gms.location.places.internal.zzr
    public final void zzb(PlaceReport placeReport, zzau zzauVar, zzx zzxVar) throws RemoteException {
        Parcel zzb = zzb();
        com.google.android.gms.internal.places.zze.zzb(zzb, placeReport);
        com.google.android.gms.internal.places.zze.zzb(zzb, zzauVar);
        com.google.android.gms.internal.places.zze.zzb(zzb, zzxVar);
        zzb(7, zzb);
    }
}
