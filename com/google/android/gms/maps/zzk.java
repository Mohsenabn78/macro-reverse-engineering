package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zzam;

/* loaded from: classes4.dex */
final class zzk extends zzam {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ GoogleMap.OnMapLoadedCallback f21400a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzk(GoogleMap googleMap, GoogleMap.OnMapLoadedCallback onMapLoadedCallback) {
        this.f21400a = onMapLoadedCallback;
    }

    @Override // com.google.android.gms.maps.internal.zzal
    public final void onMapLoaded() throws RemoteException {
        this.f21400a.onMapLoaded();
    }
}
