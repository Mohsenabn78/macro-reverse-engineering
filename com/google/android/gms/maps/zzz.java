package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zzao;
import com.google.android.gms.maps.model.LatLng;

/* loaded from: classes4.dex */
final class zzz extends zzao {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ GoogleMap.OnMapLongClickListener f21415a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzz(GoogleMap googleMap, GoogleMap.OnMapLongClickListener onMapLongClickListener) {
        this.f21415a = onMapLongClickListener;
    }

    @Override // com.google.android.gms.maps.internal.zzan
    public final void onMapLongClick(LatLng latLng) {
        this.f21415a.onMapLongClick(latLng);
    }
}
