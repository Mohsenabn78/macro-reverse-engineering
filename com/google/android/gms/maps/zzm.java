package com.google.android.gms.maps;

import android.location.Location;
import android.os.RemoteException;
import com.google.android.gms.maps.LocationSource;
import com.google.android.gms.maps.model.RuntimeRemoteException;

/* loaded from: classes4.dex */
final class zzm implements LocationSource.OnLocationChangedListener {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ com.google.android.gms.maps.internal.zzah f21402a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzm(zzl zzlVar, com.google.android.gms.maps.internal.zzah zzahVar) {
        this.f21402a = zzahVar;
    }

    @Override // com.google.android.gms.maps.LocationSource.OnLocationChangedListener
    public final void onLocationChanged(Location location) {
        try {
            this.f21402a.zza(location);
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }
}
