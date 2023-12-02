package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zzas;
import com.google.android.gms.maps.model.Marker;

/* loaded from: classes4.dex */
final class zzb extends zzas {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ GoogleMap.OnMarkerClickListener f21391a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzb(GoogleMap googleMap, GoogleMap.OnMarkerClickListener onMarkerClickListener) {
        this.f21391a = onMarkerClickListener;
    }

    @Override // com.google.android.gms.maps.internal.zzar
    public final boolean zza(com.google.android.gms.internal.maps.zzt zztVar) {
        return this.f21391a.onMarkerClick(new Marker(zztVar));
    }
}
