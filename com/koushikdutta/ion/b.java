package com.koushikdutta.ion;

import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.parser.ByteBufferListParser;
import com.koushikdutta.async.util.FileCache;
import com.koushikdutta.async.util.HashList;
import com.koushikdutta.ion.bitmap.BitmapInfo;
import com.koushikdutta.ion.bitmap.PostProcess;
import com.koushikdutta.ion.bitmap.Transform;
import com.koushikdutta.ion.l;
import com.koushikdutta.ion.loader.MediaFile;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BitmapFetcher.java */
/* loaded from: classes6.dex */
public class b implements l.j {

    /* renamed from: a  reason: collision with root package name */
    String f35790a;

    /* renamed from: b  reason: collision with root package name */
    String f35791b;

    /* renamed from: c  reason: collision with root package name */
    BitmapInfo f35792c;

    /* renamed from: d  reason: collision with root package name */
    boolean f35793d;

    /* renamed from: e  reason: collision with root package name */
    ArrayList<Transform> f35794e;

    /* renamed from: f  reason: collision with root package name */
    l f35795f;

    /* renamed from: g  reason: collision with root package name */
    int f35796g;

    /* renamed from: h  reason: collision with root package name */
    int f35797h;

    /* renamed from: i  reason: collision with root package name */
    boolean f35798i;

    /* renamed from: j  reason: collision with root package name */
    boolean f35799j;

    /* renamed from: k  reason: collision with root package name */
    ArrayList<PostProcess> f35800k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BitmapFetcher.java */
    /* loaded from: classes6.dex */
    public class a implements FutureCallback<BitmapInfo> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.koushikdutta.ion.a f35801a;

        a(com.koushikdutta.ion.a aVar) {
            this.f35801a = aVar;
        }

        @Override // com.koushikdutta.async.future.FutureCallback
        /* renamed from: a */
        public void onCompleted(Exception exc, BitmapInfo bitmapInfo) {
            this.f35801a.c(exc, bitmapInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BitmapFetcher.java */
    /* renamed from: com.koushikdutta.ion.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class RunnableC0204b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Ion f35803a;

        /* compiled from: BitmapFetcher.java */
        /* renamed from: com.koushikdutta.ion.b$b$a */
        /* loaded from: classes6.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                RunnableC0204b runnableC0204b = RunnableC0204b.this;
                runnableC0204b.f35803a.f35737s.remove(b.this.f35790a);
            }
        }

        RunnableC0204b(Ion ion) {
            this.f35803a = ion;
        }

        @Override // java.lang.Runnable
        public void run() {
            AsyncServer.post(Ion.f35718z, new a());
        }
    }

    private void d(Ion ion) {
        if (this.f35793d && ion.f35737s.tag(this.f35791b) == null) {
            HashList<FutureCallback<BitmapInfo>> hashList = ion.f35737s;
            String str = this.f35790a;
            hashList.add(str, new q(ion, this.f35791b, str, this.f35794e, this.f35800k));
        }
    }

    private boolean e(String str) {
        Ion ion = this.f35795f.f35938a;
        if (this.f35799j) {
            if (str == null || !str.startsWith("file:/")) {
                return false;
            }
            File file = new File(URI.create(str));
            if (!file.exists()) {
                return false;
            }
            MediaFile.MediaFileType fileType = MediaFile.getFileType(file.getAbsolutePath());
            if (fileType == null || !MediaFile.isVideoFileType(fileType.fileType)) {
                new LoadDeepZoom(ion, this.f35790a, this.f35798i, null).onCompleted((Exception) null, new Response<>(null, ResponseServedFrom.LOADED_FROM_CACHE, null, null, file));
                return true;
            }
        }
        boolean z3 = !this.f35793d;
        for (Loader loader : ion.configure().getLoaders()) {
            Future<BitmapInfo> loadBitmap = loader.loadBitmap(this.f35795f.f35939b.b(), ion, this.f35790a, str, this.f35796g, this.f35797h, this.f35798i);
            if (loadBitmap != null) {
                loadBitmap.setCallback(new a(new LoadBitmapBase(ion, this.f35790a, z3)));
                return true;
            }
        }
        return false;
    }

    public static boolean g(Ion ion) {
        if (ion.f35737s.keySet().size() <= 5) {
            return false;
        }
        int i4 = 0;
        for (String str : ion.f35737s.keySet()) {
            if ((ion.f35737s.tag(str) instanceof LoadBitmapBase) && (i4 = i4 + 1) > 5) {
                return true;
            }
        }
        return false;
    }

    @Override // com.koushikdutta.ion.l.j
    public boolean a(AsyncHttpRequest asyncHttpRequest) {
        return !e(asyncHttpRequest.getUri().toString());
    }

    public DeferredLoadBitmap b() {
        DeferredLoadBitmap deferredLoadBitmap = new DeferredLoadBitmap(this.f35795f.f35938a, this.f35790a, this);
        d(this.f35795f.f35938a);
        return deferredLoadBitmap;
    }

    public void c() {
        Ion ion = this.f35795f.f35938a;
        FileCache fileCache = ion.f35722d.getFileCache();
        if (!this.f35795f.f35945h && fileCache.exists(this.f35791b) && !this.f35799j) {
            com.koushikdutta.ion.a.getBitmapSnapshot(ion, this.f35791b, this.f35800k);
            return;
        }
        if (ion.f35737s.tag(this.f35790a) == null && !e(this.f35795f.f35942e)) {
            this.f35795f.setHandler(null);
            l lVar = this.f35795f;
            lVar.f35950m = this;
            if (!this.f35799j) {
                lVar.l(new ByteBufferListParser(), new RunnableC0204b(ion)).withResponse().setCallback(new m(ion, this.f35790a, !this.f35793d, this.f35796g, this.f35797h, this.f35798i));
            } else {
                this.f35795f.write(fileCache.getTempFile()).withResponse().setCallback(new LoadDeepZoom(ion, this.f35790a, this.f35798i, fileCache));
            }
        }
        d(ion);
    }

    public void f() {
        String computeDecodeKey = i.computeDecodeKey(this.f35795f, this.f35796g, this.f35797h, this.f35798i, this.f35799j);
        this.f35790a = computeDecodeKey;
        this.f35791b = i.computeBitmapKey(computeDecodeKey, this.f35794e);
    }
}
