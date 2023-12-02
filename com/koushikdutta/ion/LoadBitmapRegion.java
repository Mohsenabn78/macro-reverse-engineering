package com.koushikdutta.ion;

import android.graphics.Bitmap;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Point;
import android.graphics.Rect;
import com.koushikdutta.ion.bitmap.BitmapInfo;
import com.koushikdutta.ion.bitmap.IonBitmapCache;

/* loaded from: classes6.dex */
public class LoadBitmapRegion extends com.koushikdutta.ion.a {

    /* loaded from: classes6.dex */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BitmapRegionDecoder f35760a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Rect f35761b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f35762c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f35763d;

        a(BitmapRegionDecoder bitmapRegionDecoder, Rect rect, int i4, String str) {
            this.f35760a = bitmapRegionDecoder;
            this.f35761b = rect;
            this.f35762c = i4;
            this.f35763d = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Bitmap loadRegion = IonBitmapCache.loadRegion(this.f35760a, this.f35761b, this.f35762c);
                if (loadRegion != null) {
                    LoadBitmapRegion.this.c(null, new BitmapInfo(this.f35763d, null, loadRegion, new Point(loadRegion.getWidth(), loadRegion.getHeight())));
                    return;
                }
                throw new Exception("failed to load bitmap region");
            } catch (Exception e4) {
                LoadBitmapRegion.this.c(e4, null);
            }
        }
    }

    public LoadBitmapRegion(Ion ion, String str, BitmapRegionDecoder bitmapRegionDecoder, Rect rect, int i4) {
        super(ion, str, true);
        Ion.getBitmapLoadExecutorService().execute(new a(bitmapRegionDecoder, rect, i4, str));
    }
}
