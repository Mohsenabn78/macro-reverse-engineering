package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;

/* loaded from: classes4.dex */
final class zzx extends com.google.android.gms.maps.internal.zzo {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ GoogleMap.OnCameraIdleListener f21413a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzx(GoogleMap googleMap, GoogleMap.OnCameraIdleListener onCameraIdleListener) {
        this.f21413a = onCameraIdleListener;
    }

    @Override // com.google.android.gms.maps.internal.zzn
    public final void onCameraIdle() {
        this.f21413a.onCameraIdle();
    }
}
