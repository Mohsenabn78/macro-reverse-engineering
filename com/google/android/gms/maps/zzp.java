package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zzbe;
import com.google.android.gms.maps.model.Polygon;

/* loaded from: classes4.dex */
final class zzp extends zzbe {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ GoogleMap.OnPolygonClickListener f21405a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzp(GoogleMap googleMap, GoogleMap.OnPolygonClickListener onPolygonClickListener) {
        this.f21405a = onPolygonClickListener;
    }

    @Override // com.google.android.gms.maps.internal.zzbd
    public final void zza(com.google.android.gms.internal.maps.zzw zzwVar) {
        this.f21405a.onPolygonClick(new Polygon(zzwVar));
    }
}
