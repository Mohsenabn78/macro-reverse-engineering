package com.google.android.gms.location.places.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.places.AddPlaceRequest;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzw extends com.google.android.gms.internal.places.zzc implements zzt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.places.internal.IGooglePlacesService");
    }

    @Override // com.google.android.gms.location.places.internal.zzt
    public final void zzb(List<String> list, zzau zzauVar, zzx zzxVar) throws RemoteException {
        Parcel zzb = zzb();
        zzb.writeStringList(list);
        com.google.android.gms.internal.places.zze.zzb(zzb, zzauVar);
        com.google.android.gms.internal.places.zze.zzb(zzb, zzxVar);
        zzb(17, zzb);
    }

    @Override // com.google.android.gms.location.places.internal.zzt
    public final void zzb(String str, LatLngBounds latLngBounds, int i4, AutocompleteFilter autocompleteFilter, zzau zzauVar, zzx zzxVar) throws RemoteException {
        Parcel zzb = zzb();
        zzb.writeString(str);
        com.google.android.gms.internal.places.zze.zzb(zzb, latLngBounds);
        zzb.writeInt(i4);
        com.google.android.gms.internal.places.zze.zzb(zzb, autocompleteFilter);
        com.google.android.gms.internal.places.zze.zzb(zzb, zzauVar);
        com.google.android.gms.internal.places.zze.zzb(zzb, zzxVar);
        zzb(28, zzb);
    }

    @Override // com.google.android.gms.location.places.internal.zzt
    public final void zzb(AddPlaceRequest addPlaceRequest, zzau zzauVar, zzx zzxVar) throws RemoteException {
        Parcel zzb = zzb();
        com.google.android.gms.internal.places.zze.zzb(zzb, addPlaceRequest);
        com.google.android.gms.internal.places.zze.zzb(zzb, zzauVar);
        com.google.android.gms.internal.places.zze.zzb(zzb, zzxVar);
        zzb(14, zzb);
    }

    @Override // com.google.android.gms.location.places.internal.zzt
    public final void zzb(String str, zzau zzauVar, zzv zzvVar) throws RemoteException {
        Parcel zzb = zzb();
        zzb.writeString(str);
        com.google.android.gms.internal.places.zze.zzb(zzb, zzauVar);
        com.google.android.gms.internal.places.zze.zzb(zzb, zzvVar);
        zzb(19, zzb);
    }

    @Override // com.google.android.gms.location.places.internal.zzt
    public final void zzb(String str, int i4, int i5, int i6, zzau zzauVar, zzv zzvVar) throws RemoteException {
        Parcel zzb = zzb();
        zzb.writeString(str);
        zzb.writeInt(i4);
        zzb.writeInt(i5);
        zzb.writeInt(i6);
        com.google.android.gms.internal.places.zze.zzb(zzb, zzauVar);
        com.google.android.gms.internal.places.zze.zzb(zzb, zzvVar);
        zzb(20, zzb);
    }
}
