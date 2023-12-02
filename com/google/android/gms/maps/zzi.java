package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zzaw;

/* loaded from: classes4.dex */
final class zzi extends zzaw {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ GoogleMap.OnMyLocationButtonClickListener f21398a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzi(GoogleMap googleMap, GoogleMap.OnMyLocationButtonClickListener onMyLocationButtonClickListener) {
        this.f21398a = onMyLocationButtonClickListener;
    }

    @Override // com.google.android.gms.maps.internal.zzav
    public final boolean onMyLocationButtonClick() throws RemoteException {
        return this.f21398a.onMyLocationButtonClick();
    }
}
