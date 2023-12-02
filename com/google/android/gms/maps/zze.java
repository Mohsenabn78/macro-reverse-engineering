package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

/* loaded from: classes4.dex */
final class zze extends com.google.android.gms.maps.internal.zzag {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ GoogleMap.OnInfoWindowLongClickListener f21394a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zze(GoogleMap googleMap, GoogleMap.OnInfoWindowLongClickListener onInfoWindowLongClickListener) {
        this.f21394a = onInfoWindowLongClickListener;
    }

    @Override // com.google.android.gms.maps.internal.zzaf
    public final void zzf(com.google.android.gms.internal.maps.zzt zztVar) {
        this.f21394a.onInfoWindowLongClick(new Marker(zztVar));
    }
}
