package com.koushikdutta.ion.loader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.text.TextUtils;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.FileDataEmitter;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.future.SimpleFuture;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.util.StreamUtility;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.Loader;
import com.koushikdutta.ion.ResponseServedFrom;
import com.koushikdutta.ion.bitmap.BitmapInfo;
import com.koushikdutta.ion.bitmap.IonBitmapCache;
import java.io.File;
import java.io.FileInputStream;
import java.net.URI;

/* loaded from: classes6.dex */
public class FileLoader extends StreamLoader {

    /* loaded from: classes6.dex */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SimpleFuture f36025a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f36026b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Ion f36027c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f36028d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f36029e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ boolean f36030f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ String f36031g;

        a(SimpleFuture simpleFuture, String str, Ion ion, int i4, int i5, boolean z3, String str2) {
            this.f36025a = simpleFuture;
            this.f36026b = str;
            this.f36027c = ion;
            this.f36028d = i4;
            this.f36029e = i5;
            this.f36030f = z3;
            this.f36031g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            BitmapInfo bitmapInfo;
            if (this.f36025a.isCancelled()) {
                return;
            }
            try {
                File file = new File(URI.create(this.f36026b));
                BitmapFactory.Options prepareBitmapOptions = this.f36027c.getBitmapCache().prepareBitmapOptions(file, this.f36028d, this.f36029e);
                Point point = new Point(prepareBitmapOptions.outWidth, prepareBitmapOptions.outHeight);
                if (this.f36030f && TextUtils.equals("image/gif", prepareBitmapOptions.outMimeType)) {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    bitmapInfo = FileLoader.this.b(this.f36031g, point, fileInputStream, prepareBitmapOptions);
                    StreamUtility.closeQuietly(fileInputStream);
                } else {
                    Bitmap loadBitmap = IonBitmapCache.loadBitmap(file, prepareBitmapOptions);
                    if (loadBitmap != null) {
                        bitmapInfo = new BitmapInfo(this.f36031g, prepareBitmapOptions.outMimeType, loadBitmap, point);
                    } else {
                        throw new Exception("Bitmap failed to load");
                    }
                }
                bitmapInfo.servedFrom = ResponseServedFrom.LOADED_FROM_CACHE;
                this.f36025a.setComplete((SimpleFuture) bitmapInfo);
            } catch (Exception e4) {
                this.f36025a.setComplete(e4);
            } catch (OutOfMemoryError e5) {
                this.f36025a.setComplete(new Exception(e5), null);
            }
        }
    }

    /* loaded from: classes6.dex */
    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AsyncHttpRequest f36033a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Ion f36034b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ c f36035c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ FutureCallback f36036d;

        b(AsyncHttpRequest asyncHttpRequest, Ion ion, c cVar, FutureCallback futureCallback) {
            this.f36033a = asyncHttpRequest;
            this.f36034b = ion;
            this.f36035c = cVar;
            this.f36036d = futureCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            File file = new File(URI.create(this.f36033a.getUri().toString()));
            FileDataEmitter fileDataEmitter = new FileDataEmitter(this.f36034b.getHttpClient().getServer(), file);
            this.f36035c.setComplete((c) fileDataEmitter);
            this.f36036d.onCompleted(null, new Loader.LoaderEmitter(fileDataEmitter, (int) file.length(), ResponseServedFrom.LOADED_FROM_CACHE, null, this.f36033a));
        }
    }

    /* loaded from: classes6.dex */
    private static final class c extends SimpleFuture<DataEmitter> {
        private c() {
        }

        /* synthetic */ c(a aVar) {
            this();
        }
    }

    @Override // com.koushikdutta.ion.loader.SimpleLoader, com.koushikdutta.ion.Loader
    public Future<DataEmitter> load(Ion ion, AsyncHttpRequest asyncHttpRequest, FutureCallback<Loader.LoaderEmitter> futureCallback) {
        if (!asyncHttpRequest.getUri().getScheme().startsWith("file")) {
            return null;
        }
        c cVar = new c(null);
        ion.getHttpClient().getServer().post(new b(asyncHttpRequest, ion, cVar, futureCallback));
        return cVar;
    }

    @Override // com.koushikdutta.ion.loader.StreamLoader, com.koushikdutta.ion.loader.SimpleLoader, com.koushikdutta.ion.Loader
    public Future<BitmapInfo> loadBitmap(Context context, Ion ion, String str, String str2, int i4, int i5, boolean z3) {
        if (str2 != null && str2.startsWith("file:/")) {
            SimpleFuture simpleFuture = new SimpleFuture();
            Ion.getBitmapLoadExecutorService().execute(new a(simpleFuture, str2, ion, i4, i5, z3, str));
            return simpleFuture;
        }
        return null;
    }
}
