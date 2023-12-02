package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.zzaq;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzac extends zzaq {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ OnMapReadyCallback f21382a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzac(MapView.zza zzaVar, OnMapReadyCallback onMapReadyCallback) {
        this.f21382a = onMapReadyCallback;
    }

    @Override // com.google.android.gms.maps.internal.zzap
    public final void zza(IGoogleMapDelegate iGoogleMapDelegate) throws RemoteException {
        this.f21382a.onMapReady(new GoogleMap(iGoogleMapDelegate));
    }
}
