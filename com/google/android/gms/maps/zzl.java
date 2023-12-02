package com.google.android.gms.maps;

import com.google.android.gms.maps.internal.ILocationSourceDelegate;

/* loaded from: classes4.dex */
final class zzl extends ILocationSourceDelegate.zza {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ LocationSource f21401a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzl(GoogleMap googleMap, LocationSource locationSource) {
        this.f21401a = locationSource;
    }

    @Override // com.google.android.gms.maps.internal.ILocationSourceDelegate
    public final void activate(com.google.android.gms.maps.internal.zzah zzahVar) {
        this.f21401a.activate(new zzm(this, zzahVar));
    }

    @Override // com.google.android.gms.maps.internal.ILocationSourceDelegate
    public final void deactivate() {
        this.f21401a.deactivate();
    }
}
