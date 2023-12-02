package com.google.android.gms.maps;

import android.location.Location;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zzba;

/* loaded from: classes4.dex */
final class zzj extends zzba {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ GoogleMap.OnMyLocationClickListener f21399a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzj(GoogleMap googleMap, GoogleMap.OnMyLocationClickListener onMyLocationClickListener) {
        this.f21399a = onMyLocationClickListener;
    }

    @Override // com.google.android.gms.maps.internal.zzaz
    public final void onMyLocationClick(@NonNull Location location) throws RemoteException {
        this.f21399a.onMyLocationClick(location);
    }
}
