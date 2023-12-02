package com.google.android.gms.location.places;

import android.os.RemoteException;
import com.google.android.gms.location.places.internal.zzy;

/* loaded from: classes4.dex */
public final class zzf extends zzy {

    /* renamed from: a  reason: collision with root package name */
    private final zzg f21169a;

    /* renamed from: b  reason: collision with root package name */
    private final zze f21170b;

    public zzf(zzg zzgVar) {
        this.f21169a = zzgVar;
        this.f21170b = null;
    }

    @Override // com.google.android.gms.location.places.internal.zzv
    public final void zzb(PlacePhotoMetadataResult placePhotoMetadataResult) throws RemoteException {
        this.f21169a.setResult((zzg) placePhotoMetadataResult);
    }

    @Override // com.google.android.gms.location.places.internal.zzv
    public final void zzb(PlacePhotoResult placePhotoResult) throws RemoteException {
        this.f21170b.setResult((zze) placePhotoResult);
    }

    public zzf(zze zzeVar) {
        this.f21169a = null;
        this.f21170b = zzeVar;
    }
}
