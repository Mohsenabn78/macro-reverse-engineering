package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zzbc;
import com.google.android.gms.maps.model.PointOfInterest;

/* loaded from: classes4.dex */
final class zzs extends zzbc {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ GoogleMap.OnPoiClickListener f21408a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzs(GoogleMap googleMap, GoogleMap.OnPoiClickListener onPoiClickListener) {
        this.f21408a = onPoiClickListener;
    }

    @Override // com.google.android.gms.maps.internal.zzbb
    public final void zza(PointOfInterest pointOfInterest) throws RemoteException {
        this.f21408a.onPoiClick(pointOfInterest);
    }
}
