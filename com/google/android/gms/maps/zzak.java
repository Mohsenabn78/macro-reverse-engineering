package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.zzaq;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzak extends zzaq {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ OnMapReadyCallback f21389a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzak(SupportMapFragment.zza zzaVar, OnMapReadyCallback onMapReadyCallback) {
        this.f21389a = onMapReadyCallback;
    }

    @Override // com.google.android.gms.maps.internal.zzap
    public final void zza(IGoogleMapDelegate iGoogleMapDelegate) throws RemoteException {
        this.f21389a.onMapReady(new GoogleMap(iGoogleMapDelegate));
    }
}
