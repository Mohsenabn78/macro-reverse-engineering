package com.google.android.gms.maps;

import android.location.Location;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zzay;

/* loaded from: classes4.dex */
final class zzh extends zzay {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ GoogleMap.OnMyLocationChangeListener f21397a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzh(GoogleMap googleMap, GoogleMap.OnMyLocationChangeListener onMyLocationChangeListener) {
        this.f21397a = onMyLocationChangeListener;
    }

    @Override // com.google.android.gms.maps.internal.zzax
    public final void zza(IObjectWrapper iObjectWrapper) {
        this.f21397a.onMyLocationChange((Location) ObjectWrapper.unwrap(iObjectWrapper));
    }
}
