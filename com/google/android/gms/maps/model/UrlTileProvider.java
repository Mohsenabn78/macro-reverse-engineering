package com.google.android.gms.maps.model;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/* loaded from: classes4.dex */
public abstract class UrlTileProvider implements TileProvider {

    /* renamed from: a  reason: collision with root package name */
    private final int f21375a;

    /* renamed from: b  reason: collision with root package name */
    private final int f21376b;

    public UrlTileProvider(int i4, int i5) {
        this.f21375a = i4;
        this.f21376b = i5;
    }

    @Override // com.google.android.gms.maps.model.TileProvider
    public final Tile getTile(int i4, int i5, int i6) {
        URL tileUrl = getTileUrl(i4, i5, i6);
        if (tileUrl == null) {
            return TileProvider.NO_TILE;
        }
        try {
            int i7 = this.f21375a;
            int i8 = this.f21376b;
            InputStream openStream = tileUrl.openStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[4096];
            while (true) {
                int read = openStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    return new Tile(i7, i8, byteArrayOutputStream.toByteArray());
                }
            }
        } catch (IOException unused) {
            return null;
        }
    }

    public abstract URL getTileUrl(int i4, int i5, int i6);
}
