package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.IndoorBuilding;

/* loaded from: classes4.dex */
final class zza extends com.google.android.gms.maps.internal.zzaa {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ GoogleMap.OnIndoorStateChangeListener f21380a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zza(GoogleMap googleMap, GoogleMap.OnIndoorStateChangeListener onIndoorStateChangeListener) {
        this.f21380a = onIndoorStateChangeListener;
    }

    @Override // com.google.android.gms.maps.internal.zzz
    public final void onIndoorBuildingFocused() {
        this.f21380a.onIndoorBuildingFocused();
    }

    @Override // com.google.android.gms.maps.internal.zzz
    public final void zza(com.google.android.gms.internal.maps.zzn zznVar) {
        this.f21380a.onIndoorLevelActivated(new IndoorBuilding(zznVar));
    }
}
