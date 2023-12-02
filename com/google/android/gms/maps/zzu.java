package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;

/* loaded from: classes4.dex */
final class zzu extends com.google.android.gms.maps.internal.zzu {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ GoogleMap.OnCameraMoveStartedListener f21410a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzu(GoogleMap googleMap, GoogleMap.OnCameraMoveStartedListener onCameraMoveStartedListener) {
        this.f21410a = onCameraMoveStartedListener;
    }

    @Override // com.google.android.gms.maps.internal.zzt
    public final void onCameraMoveStarted(int i4) {
        this.f21410a.onCameraMoveStarted(i4);
    }
}
