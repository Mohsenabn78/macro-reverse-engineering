package com.google.android.gms.maps;

import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

/* loaded from: classes4.dex */
final class zzg extends com.google.android.gms.maps.internal.zzi {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ GoogleMap.InfoWindowAdapter f21396a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzg(GoogleMap googleMap, GoogleMap.InfoWindowAdapter infoWindowAdapter) {
        this.f21396a = infoWindowAdapter;
    }

    @Override // com.google.android.gms.maps.internal.zzh
    public final IObjectWrapper zzh(com.google.android.gms.internal.maps.zzt zztVar) {
        return ObjectWrapper.wrap(this.f21396a.getInfoWindow(new Marker(zztVar)));
    }

    @Override // com.google.android.gms.maps.internal.zzh
    public final IObjectWrapper zzi(com.google.android.gms.internal.maps.zzt zztVar) {
        return ObjectWrapper.wrap(this.f21396a.getInfoContents(new Marker(zztVar)));
    }
}
