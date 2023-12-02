package com.koushikdutta.ion.loader;

import android.content.Context;
import android.net.Uri;
import com.google.firebase.analytics.FirebaseAnalytics;
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
public class ContentLoader extends StreamLoader {

    /* loaded from: classes6.dex */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Ion f36020a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AsyncHttpRequest f36021b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.koushikdutta.ion.loader.a f36022c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ FutureCallback f36023d;

        a(Ion ion, AsyncHttpRequest asyncHttpRequest, com.koushikdutta.ion.loader.a aVar, FutureCallback futureCallback) {
            this.f36020a = ion;
            this.f36021b = asyncHttpRequest;
            this.f36022c = aVar;
            this.f36023d = futureCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                InputStream openInputStream = this.f36020a.getContext().getContentResolver().openInputStream(Uri.parse(this.f36021b.getUri().toString()));
                if (openInputStream != null) {
                    int available = openInputStream.available();
                    InputStreamDataEmitter inputStreamDataEmitter = new InputStreamDataEmitter(this.f36020a.getHttpClient().getServer(), openInputStream);
                    this.f36022c.setComplete((com.koushikdutta.ion.loader.a) inputStreamDataEmitter);
                    this.f36023d.onCompleted(null, new Loader.LoaderEmitter(inputStreamDataEmitter, available, ResponseServedFrom.LOADED_FROM_CACHE, null, null));
                    return;
                }
                throw new Exception("Unable to load content stream");
            } catch (Exception e4) {
                this.f36022c.setComplete(e4);
                this.f36023d.onCompleted(e4, null);
            }
        }
    }

    @Override // com.koushikdutta.ion.loader.StreamLoader
    protected InputStream a(Context context, String str) throws Exception {
        return context.getContentResolver().openInputStream(Uri.parse(str));
    }

    @Override // com.koushikdutta.ion.loader.SimpleLoader, com.koushikdutta.ion.Loader
    public Future<DataEmitter> load(Ion ion, AsyncHttpRequest asyncHttpRequest, FutureCallback<Loader.LoaderEmitter> futureCallback) {
        if (!asyncHttpRequest.getUri().getScheme().startsWith(FirebaseAnalytics.Param.CONTENT)) {
            return null;
        }
        com.koushikdutta.ion.loader.a aVar = new com.koushikdutta.ion.loader.a();
        ion.getHttpClient().getServer().post(new a(ion, asyncHttpRequest, aVar, futureCallback));
        return aVar;
    }

    @Override // com.koushikdutta.ion.loader.StreamLoader, com.koushikdutta.ion.loader.SimpleLoader, com.koushikdutta.ion.Loader
    public Future<BitmapInfo> loadBitmap(Context context, Ion ion, String str, String str2, int i4, int i5, boolean z3) {
        if (!str2.startsWith("content:/")) {
            return null;
        }
        return super.loadBitmap(context, ion, str, str2, i4, i5, z3);
    }
}
