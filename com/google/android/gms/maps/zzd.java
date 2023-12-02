package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

/* loaded from: classes4.dex */
final class zzd extends com.google.android.gms.maps.internal.zzac {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ GoogleMap.OnInfoWindowClickListener f21393a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzd(GoogleMap googleMap, GoogleMap.OnInfoWindowClickListener onInfoWindowClickListener) {
        this.f21393a = onInfoWindowClickListener;
    }

    @Override // com.google.android.gms.maps.internal.zzab
    public final void zze(com.google.android.gms.internal.maps.zzt zztVar) {
        this.f21393a.onInfoWindowClick(new Marker(zztVar));
    }
}
