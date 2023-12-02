package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzv extends com.google.android.gms.maps.internal.zzs {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ GoogleMap.OnCameraMoveListener f21411a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzv(GoogleMap googleMap, GoogleMap.OnCameraMoveListener onCameraMoveListener) {
        this.f21411a = onCameraMoveListener;
    }

    @Override // com.google.android.gms.maps.internal.zzr
    public final void onCameraMove() {
        this.f21411a.onCameraMove();
    }
}
