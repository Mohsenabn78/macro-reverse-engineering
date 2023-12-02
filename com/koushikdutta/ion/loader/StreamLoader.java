package com.koushikdutta.ion.loader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.text.TextUtils;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.SimpleFuture;
import com.koushikdutta.async.util.StreamUtility;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.ResponseServedFrom;
import com.koushikdutta.ion.bitmap.BitmapInfo;
import com.koushikdutta.ion.bitmap.IonBitmapCache;
import com.koushikdutta.ion.gif.GifDecoder;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public class StreamLoader extends SimpleLoader {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f36067a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f36068b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Ion f36069c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f36070d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f36071e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ boolean f36072f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ String f36073g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ SimpleFuture f36074h;

        a(Context context, String str, Ion ion, int i4, int i5, boolean z3, String str2, SimpleFuture simpleFuture) {
            this.f36067a = context;
            this.f36068b = str;
            this.f36069c = ion;
            this.f36070d = i4;
            this.f36071e = i5;
            this.f36072f = z3;
            this.f36073g = str2;
            this.f36074h = simpleFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th;
            InputStream inputStream;
            Exception e4;
            BitmapInfo bitmapInfo;
            try {
                try {
                    inputStream = StreamLoader.this.a(this.f36067a, this.f36068b);
                } catch (Exception e5) {
                    inputStream = null;
                    e4 = e5;
                } catch (OutOfMemoryError e6) {
                    e = e6;
                    inputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    StreamUtility.closeQuietly(null);
                    throw th;
                }
                try {
                    BitmapFactory.Options prepareBitmapOptions = this.f36069c.getBitmapCache().prepareBitmapOptions(inputStream, this.f36070d, this.f36071e);
                    StreamUtility.closeQuietly(inputStream);
                    Point point = new Point(prepareBitmapOptions.outWidth, prepareBitmapOptions.outHeight);
                    InputStream a4 = StreamLoader.this.a(this.f36067a, this.f36068b);
                    if (this.f36072f && TextUtils.equals("image/gif", prepareBitmapOptions.outMimeType)) {
                        bitmapInfo = StreamLoader.this.b(this.f36073g, point, a4, prepareBitmapOptions);
                    } else {
                        Bitmap loadBitmap = IonBitmapCache.loadBitmap(a4, prepareBitmapOptions);
                        if (loadBitmap != null) {
                            bitmapInfo = new BitmapInfo(this.f36073g, prepareBitmapOptions.outMimeType, loadBitmap, point);
                        } else {
                            throw new Exception("Bitmap failed to load");
                        }
                    }
                    bitmapInfo.servedFrom = ResponseServedFrom.LOADED_FROM_CACHE;
                    this.f36074h.setComplete((SimpleFuture) bitmapInfo);
                    StreamUtility.closeQuietly(a4);
                } catch (Exception e7) {
                    e4 = e7;
                    this.f36074h.setComplete(e4);
                    StreamUtility.closeQuietly(inputStream);
                } catch (OutOfMemoryError e8) {
                    e = e8;
                    this.f36074h.setComplete(new Exception(e), null);
                    StreamUtility.closeQuietly(inputStream);
                }
            } catch (Throwable th3) {
                th = th3;
                StreamUtility.closeQuietly(null);
                throw th;
            }
        }
    }

    protected InputStream a(Context context, String str) throws Exception {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BitmapInfo b(String str, Point point, InputStream inputStream, BitmapFactory.Options options) throws Exception {
        GifDecoder gifDecoder = new GifDecoder(ByteBuffer.wrap(StreamUtility.readToEndAsArray(inputStream)));
        BitmapInfo bitmapInfo = new BitmapInfo(str, options.outMimeType, gifDecoder.nextFrame().image, point);
        bitmapInfo.gifDecoder = gifDecoder;
        return bitmapInfo;
    }

    @Override // com.koushikdutta.ion.loader.SimpleLoader, com.koushikdutta.ion.Loader
    public Future<BitmapInfo> loadBitmap(Context context, Ion ion, String str, String str2, int i4, int i5, boolean z3) {
        SimpleFuture simpleFuture = new SimpleFuture();
        Ion.getBitmapLoadExecutorService().execute(new a(context, str2, ion, i4, i5, z3, str, simpleFuture));
        return simpleFuture;
    }
}
