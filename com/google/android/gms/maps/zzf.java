package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

/* loaded from: classes4.dex */
final class zzf extends com.google.android.gms.maps.internal.zzae {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ GoogleMap.OnInfoWindowCloseListener f21395a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzf(GoogleMap googleMap, GoogleMap.OnInfoWindowCloseListener onInfoWindowCloseListener) {
        this.f21395a = onInfoWindowCloseListener;
    }

    @Override // com.google.android.gms.maps.internal.zzad
    public final void zzg(com.google.android.gms.internal.maps.zzt zztVar) {
        this.f21395a.onInfoWindowClose(new Marker(zztVar));
    }
}
