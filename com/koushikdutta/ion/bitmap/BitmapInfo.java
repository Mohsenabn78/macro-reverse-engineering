package com.koushikdutta.ion.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Point;
import com.koushikdutta.async.util.UntypedHashtable;
import com.koushikdutta.ion.ResponseServedFrom;
import com.koushikdutta.ion.gif.GifDecoder;
import java.io.File;

/* loaded from: classes6.dex */
public class BitmapInfo {
    public final Bitmap bitmap;
    public BitmapRegionDecoder decoder;
    public File decoderFile;
    public long drawTime;
    public Exception exception;
    public GifDecoder gifDecoder;
    public final String key;
    public final String mimeType;
    public final Point originalSize;
    public ResponseServedFrom servedFrom;
    public long loadTime = System.currentTimeMillis();
    public final UntypedHashtable extras = new UntypedHashtable();

    public BitmapInfo(String str, String str2, Bitmap bitmap, Point point) {
        this.originalSize = point;
        this.bitmap = bitmap;
        this.key = str;
        this.mimeType = str2;
    }

    public int sizeOf() {
        Bitmap bitmap = this.bitmap;
        if (bitmap != null) {
            return bitmap.getRowBytes() * this.bitmap.getHeight();
        }
        GifDecoder gifDecoder = this.gifDecoder;
        if (gifDecoder != null) {
            return gifDecoder.getGifDataLength();
        }
        return 0;
    }
}
