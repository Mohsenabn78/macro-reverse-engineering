package com.koushikdutta.ion.loader;

import android.content.Context;
import android.net.Uri;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.stream.InputStreamDataEmitter;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.Loader;
import com.koushikdutta.ion.ResponseServedFrom;
import com.koushikdutta.ion.bitmap.BitmapInfo;
import java.io.InputStream;

/* loaded from: classes6.dex */
public class AssetLoader extends StreamLoader {

    /* loaded from: classes6.dex */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Ion f36015a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AsyncHttpRequest f36016b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.koushikdutta.ion.loader.a f36017c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ FutureCallback f36018d;

        a(Ion ion, AsyncHttpRequest asyncHttpRequest, com.koushikdutta.ion.loader.a aVar, FutureCallback futureCallback) {
            this.f36015a = ion;
            this.f36016b = asyncHttpRequest;
            this.f36017c = aVar;
            this.f36018d = futureCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                InputStream a4 = AssetLoader.this.a(this.f36015a.getContext(), this.f36016b.getUri().toString());
                if (a4 != null) {
                    int available = a4.available();
                    InputStreamDataEmitter inputStreamDataEmitter = new InputStreamDataEmitter(this.f36015a.getHttpClient().getServer(), a4);
                    this.f36017c.setComplete((com.koushikdutta.ion.loader.a) inputStreamDataEmitter);
                    this.f36018d.onCompleted(null, new Loader.LoaderEmitter(inputStreamDataEmitter, available, ResponseServedFrom.LOADED_FROM_CACHE, null, null));
                    return;
                }
                throw new Exception("Unable to load content stream");
            } catch (Exception e4) {
                this.f36017c.setComplete(e4);
                this.f36018d.onCompleted(e4, null);
            }
        }
    }

    @Override // com.koushikdutta.ion.loader.StreamLoader
    protected InputStream a(Context context, String str) throws Exception {
        return context.getAssets().open(Uri.parse(str).getPath().replaceFirst("^/android_asset/", ""));
    }

    @Override // com.koushikdutta.ion.loader.SimpleLoader, com.koushikdutta.ion.Loader
    public Future<DataEmitter> load(Ion ion, AsyncHttpRequest asyncHttpRequest, FutureCallback<Loader.LoaderEmitter> futureCallback) {
        if (!asyncHttpRequest.getUri().toString().startsWith("file:///android_asset/")) {
            return null;
        }
        com.koushikdutta.ion.loader.a aVar = new com.koushikdutta.ion.loader.a();
        ion.getHttpClient().getServer().post(new a(ion, asyncHttpRequest, aVar, futureCallback));
        return aVar;
    }

    @Override // com.koushikdutta.ion.loader.StreamLoader, com.koushikdutta.ion.loader.SimpleLoader, com.koushikdutta.ion.Loader
    public Future<BitmapInfo> loadBitmap(Context context, Ion ion, String str, String str2, int i4, int i5, boolean z3) {
        if (!str2.startsWith("file:///android_asset/")) {
            return null;
        }
        return super.loadBitmap(context, ion, str, str2, i4, i5, z3);
    }
}
