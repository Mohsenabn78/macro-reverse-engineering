package com.google.android.gms.maps;

import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.internal.zzbo;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

/* loaded from: classes4.dex */
final class zzag extends zzbo {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ StreetViewPanorama.OnStreetViewPanoramaLongClickListener f21386a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzag(StreetViewPanorama streetViewPanorama, StreetViewPanorama.OnStreetViewPanoramaLongClickListener onStreetViewPanoramaLongClickListener) {
        this.f21386a = onStreetViewPanoramaLongClickListener;
    }

    @Override // com.google.android.gms.maps.internal.zzbn
    public final void onStreetViewPanoramaLongClick(StreetViewPanoramaOrientation streetViewPanoramaOrientation) {
        this.f21386a.onStreetViewPanoramaLongClick(streetViewPanoramaOrientation);
    }
}
