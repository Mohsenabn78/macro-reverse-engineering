package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;

/* loaded from: classes4.dex */
final class zzw extends com.google.android.gms.maps.internal.zzq {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ GoogleMap.OnCameraMoveCanceledListener f21412a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzw(GoogleMap googleMap, GoogleMap.OnCameraMoveCanceledListener onCameraMoveCanceledListener) {
        this.f21412a = onCameraMoveCanceledListener;
    }

    @Override // com.google.android.gms.maps.internal.zzp
    public final void onCameraMoveCanceled() {
        this.f21412a.onCameraMoveCanceled();
    }
}
