package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zzbg;
import com.google.android.gms.maps.model.Polyline;

/* loaded from: classes4.dex */
final class zzq extends zzbg {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ GoogleMap.OnPolylineClickListener f21406a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzq(GoogleMap googleMap, GoogleMap.OnPolylineClickListener onPolylineClickListener) {
        this.f21406a = onPolylineClickListener;
    }

    @Override // com.google.android.gms.maps.internal.zzbf
    public final void zza(com.google.android.gms.internal.maps.zzz zzzVar) {
        this.f21406a.onPolylineClick(new Polyline(zzzVar));
    }
}
