package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.internal.maps.zzaf;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzs implements TileProvider {

    /* renamed from: a  reason: collision with root package name */
    private final zzaf f21377a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ TileOverlayOptions f21378b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzs(TileOverlayOptions tileOverlayOptions) {
        zzaf zzafVar;
        this.f21378b = tileOverlayOptions;
        zzafVar = tileOverlayOptions.f21369a;
        this.f21377a = zzafVar;
    }

    @Override // com.google.android.gms.maps.model.TileProvider
    public final Tile getTile(int i4, int i5, int i6) {
        try {
            return this.f21377a.getTile(i4, i5, i6);
        } catch (RemoteException unused) {
            return null;
        }
    }
}
