package com.google.android.gms.maps;

import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.internal.zzbi;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

/* loaded from: classes4.dex */
final class zzae extends zzbi {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ StreetViewPanorama.OnStreetViewPanoramaCameraChangeListener f21384a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzae(StreetViewPanorama streetViewPanorama, StreetViewPanorama.OnStreetViewPanoramaCameraChangeListener onStreetViewPanoramaCameraChangeListener) {
        this.f21384a = onStreetViewPanoramaCameraChangeListener;
    }

    @Override // com.google.android.gms.maps.internal.zzbh
    public final void onStreetViewPanoramaCameraChange(StreetViewPanoramaCamera streetViewPanoramaCamera) {
        this.f21384a.onStreetViewPanoramaCameraChange(streetViewPanoramaCamera);
    }
}
