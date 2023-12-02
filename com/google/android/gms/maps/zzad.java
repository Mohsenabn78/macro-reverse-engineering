package com.google.android.gms.maps;

import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.internal.zzbk;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;

/* loaded from: classes4.dex */
final class zzad extends zzbk {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ StreetViewPanorama.OnStreetViewPanoramaChangeListener f21383a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzad(StreetViewPanorama streetViewPanorama, StreetViewPanorama.OnStreetViewPanoramaChangeListener onStreetViewPanoramaChangeListener) {
        this.f21383a = onStreetViewPanoramaChangeListener;
    }

    @Override // com.google.android.gms.maps.internal.zzbj
    public final void onStreetViewPanoramaChange(StreetViewPanoramaLocation streetViewPanoramaLocation) {
        this.f21383a.onStreetViewPanoramaChange(streetViewPanoramaLocation);
    }
}
