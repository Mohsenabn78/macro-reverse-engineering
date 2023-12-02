package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.CameraPosition;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzt extends com.google.android.gms.maps.internal.zzm {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ GoogleMap.OnCameraChangeListener f21409a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzt(GoogleMap googleMap, GoogleMap.OnCameraChangeListener onCameraChangeListener) {
        this.f21409a = onCameraChangeListener;
    }

    @Override // com.google.android.gms.maps.internal.zzl
    public final void onCameraChange(CameraPosition cameraPosition) {
        this.f21409a.onCameraChange(cameraPosition);
    }
}
