package com.koushikdutta.ion.loader;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.net.Uri;
import android.text.TextUtils;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.future.SimpleFuture;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.stream.InputStreamDataEmitter;
import com.koushikdutta.async.util.StreamUtility;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.Loader;
import com.koushikdutta.ion.ResponseServedFrom;
import com.koushikdutta.ion.bitmap.BitmapInfo;
import com.koushikdutta.ion.bitmap.IonBitmapCache;
import java.io.InputStream;

/* loaded from: classes6.dex */
public class ResourceLoader extends StreamLoader {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f36051a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f36052b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Ion f36053c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f36054d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f36055e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ boolean f36056f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ String f36057g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ SimpleFuture f36058h;

        a(Context context, String str, Ion ion, int i4, int i5, boolean z3, String str2, SimpleFuture simpleFuture) {
            this.f36051a = context;
            this.f36052b = str;
            this.f36053c = ion;
            this.f36054d = i4;
            this.f36055e = i5;
            this.f36056f = z3;
            this.f36057g = str2;
            this.f36058h = simpleFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            BitmapInfo bitmapInfo;
            try {
                c d4 = ResourceLoader.d(this.f36051a, this.f36052b);
                BitmapFactory.Options prepareBitmapOptions = this.f36053c.getBitmapCache().prepareBitmapOptions(d4.f36065a, d4.f36066b, this.f36054d, this.f36055e);
                Point point = new Point(prepareBitmapOptions.outWidth, prepareBitmapOptions.outHeight);
                if (this.f36056f && TextUtils.equals("image/gif", prepareBitmapOptions.outMimeType)) {
                    InputStream openRawResource = d4.f36065a.openRawResource(d4.f36066b);
                    bitmapInfo = ResourceLoader.this.b(this.f36057g, point, openRawResource, prepareBitmapOptions);
                    StreamUtility.closeQuietly(openRawResource);
                } else {
                    Bitmap loadBitmap = IonBitmapCache.loadBitmap(d4.f36065a, d4.f36066b, prepareBitmapOptions);
                    if (loadBitmap != null) {
                        bitmapInfo = new BitmapInfo(this.f36057g, prepareBitmapOptions.outMimeType, loadBitmap, point);
                    } else {
                        throw new Exception("Bitmap failed to load");
                    }
                }
                bitmapInfo.servedFrom = ResponseServedFrom.LOADED_FROM_CACHE;
                this.f36058h.setComplete((SimpleFuture) bitmapInfo);
            } catch (Exception e4) {
                this.f36058h.setComplete(e4);
            } catch (OutOfMemoryError e5) {
                this.f36058h.setComplete(new Exception(e5), null);
            }
        }
    }

    /* loaded from: classes6.dex */
    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Ion f36060a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AsyncHttpRequest f36061b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.koushikdutta.ion.loader.a f36062c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ FutureCallback f36063d;

        b(Ion ion, AsyncHttpRequest asyncHttpRequest, com.koushikdutta.ion.loader.a aVar, FutureCallback futureCallback) {
            this.f36060a = ion;
            this.f36061b = asyncHttpRequest;
            this.f36062c = aVar;
            this.f36063d = futureCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                c d4 = ResourceLoader.d(this.f36060a.getContext(), this.f36061b.getUri().toString());
                InputStream openRawResource = d4.f36065a.openRawResource(d4.f36066b);
                if (openRawResource != null) {
                    int available = openRawResource.available();
                    InputStreamDataEmitter inputStreamDataEmitter = new InputStreamDataEmitter(this.f36060a.getHttpClient().getServer(), openRawResource);
                    this.f36062c.setComplete((com.koushikdutta.ion.loader.a) inputStreamDataEmitter);
                    this.f36063d.onCompleted(null, new Loader.LoaderEmitter(inputStreamDataEmitter, available, ResponseServedFrom.LOADED_FROM_CACHE, null, null));
                    return;
                }
                throw new Exception("Unable to load content stream");
            } catch (Exception e4) {
                this.f36062c.setComplete(e4);
                this.f36063d.onCompleted(e4, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        Resources f36065a;

        /* renamed from: b  reason: collision with root package name */
        int f36066b;

        private c() {
        }

        /* synthetic */ c(a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static c d(Context context, String str) throws Exception {
        int identifier;
        Uri parse = Uri.parse(str);
        if (parse.getPathSegments() != null) {
            String authority = parse.getAuthority();
            Resources resources = context.createPackageContext(authority, 0).getResources();
            if (parse.getPathSegments().size() == 1) {
                identifier = Integer.valueOf(parse.getPathSegments().get(0)).intValue();
            } else if (parse.getPathSegments().size() == 2) {
                identifier = resources.getIdentifier(parse.getPathSegments().get(1), parse.getPathSegments().get(0), authority);
                if (identifier == 0) {
                    throw new IllegalArgumentException("resource not found in given package");
                }
            } else {
                throw new IllegalArgumentException("uri is not a valid resource uri");
            }
            c cVar = new c(null);
            cVar.f36065a = resources;
            cVar.f36066b = identifier;
            return cVar;
        }
        throw new IllegalArgumentException("uri is not a valid resource uri");
    }

    @Override // com.koushikdutta.ion.loader.SimpleLoader, com.koushikdutta.ion.Loader
    public Future<DataEmitter> load(Ion ion, AsyncHttpRequest asyncHttpRequest, FutureCallback<Loader.LoaderEmitter> futureCallback) {
        if (!asyncHttpRequest.getUri().getScheme().equals("android.resource")) {
            return null;
        }
        com.koushikdutta.ion.loader.a aVar = new com.koushikdutta.ion.loader.a();
        ion.getHttpClient().getServer().post(new b(ion, asyncHttpRequest, aVar, futureCallback));
        return aVar;
    }

    @Override // com.koushikdutta.ion.loader.StreamLoader, com.koushikdutta.ion.loader.SimpleLoader, com.koushikdutta.ion.Loader
    public Future<BitmapInfo> loadBitmap(Context context, Ion ion, String str, String str2, int i4, int i5, boolean z3) {
        if (str2 != null && str2.startsWith("android.resource:/")) {
            SimpleFuture simpleFuture = new SimpleFuture();
            Ion.getBitmapLoadExecutorService().execute(new a(context, str2, ion, i4, i5, z3, str, simpleFuture));
            return simpleFuture;
        }
        return null;
    }
}
