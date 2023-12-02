package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.GroundOverlay;

/* loaded from: classes4.dex */
final class zzn extends com.google.android.gms.maps.internal.zzy {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ GoogleMap.OnGroundOverlayClickListener f21403a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzn(GoogleMap googleMap, GoogleMap.OnGroundOverlayClickListener onGroundOverlayClickListener) {
        this.f21403a = onGroundOverlayClickListener;
    }

    @Override // com.google.android.gms.maps.internal.zzx
    public final void zza(com.google.android.gms.internal.maps.zzk zzkVar) {
        this.f21403a.onGroundOverlayClick(new GroundOverlay(zzkVar));
    }
}
