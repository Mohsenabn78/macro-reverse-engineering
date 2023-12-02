package com.google.android.gms.maps.model;

import com.google.android.gms.internal.maps.zzag;

/* loaded from: classes4.dex */
final class zzt extends zzag {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ TileProvider f21379a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzt(TileOverlayOptions tileOverlayOptions, TileProvider tileProvider) {
        this.f21379a = tileProvider;
    }

    @Override // com.google.android.gms.internal.maps.zzaf
    public final Tile getTile(int i4, int i5, int i6) {
        return this.f21379a.getTile(i4, i5, i6);
    }
}
