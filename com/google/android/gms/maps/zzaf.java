package com.google.android.gms.maps;

import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.internal.zzbm;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

/* loaded from: classes4.dex */
final class zzaf extends zzbm {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ StreetViewPanorama.OnStreetViewPanoramaClickListener f21385a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaf(StreetViewPanorama streetViewPanorama, StreetViewPanorama.OnStreetViewPanoramaClickListener onStreetViewPanoramaClickListener) {
        this.f21385a = onStreetViewPanoramaClickListener;
    }

    @Override // com.google.android.gms.maps.internal.zzbl
    public final void onStreetViewPanoramaClick(StreetViewPanoramaOrientation streetViewPanoramaOrientation) {
        this.f21385a.onStreetViewPanoramaClick(streetViewPanoramaOrientation);
    }
}
