package com.google.android.gms.maps.model;

/* loaded from: classes4.dex */
public interface TileProvider {
    public static final Tile NO_TILE = new Tile(-1, -1, null);

    Tile getTile(int i4, int i5, int i6);
}
