package com.koushikdutta.ion;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextUtils;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.util.FileCache;
import com.koushikdutta.async.util.StreamUtility;
import com.koushikdutta.ion.bitmap.BitmapInfo;
import com.koushikdutta.ion.gif.GifDecoder;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;

@TargetApi(10)
/* loaded from: classes6.dex */
public class LoadDeepZoom extends n implements FutureCallback<Response<File>> {

    /* renamed from: e  reason: collision with root package name */
    FileCache f35765e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ File f35766a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Response f35767b;

        a(File file, Response response) {
            this.f35766a = file;
            this.f35767b = response;
        }

        @Override // java.lang.Runnable
        public void run() {
            FileInputStream fileInputStream;
            File file;
            FileInputStream fileInputStream2 = null;
            try {
                LoadDeepZoom loadDeepZoom = LoadDeepZoom.this;
                FileCache fileCache = loadDeepZoom.f35765e;
                if (fileCache != null) {
                    fileCache.commitTempFiles(loadDeepZoom.f35780a, this.f35766a);
                    LoadDeepZoom loadDeepZoom2 = LoadDeepZoom.this;
                    file = loadDeepZoom2.f35765e.getFile(loadDeepZoom2.f35780a);
                } else {
                    file = this.f35766a;
                }
                BitmapFactory.Options prepareBitmapOptions = LoadDeepZoom.this.f35781b.getBitmapCache().prepareBitmapOptions(file, 0, 0);
                Point point = new Point(prepareBitmapOptions.outWidth, prepareBitmapOptions.outHeight);
                if (LoadDeepZoom.this.f36092d && TextUtils.equals("image/gif", prepareBitmapOptions.outMimeType)) {
                    LoadDeepZoom loadDeepZoom3 = LoadDeepZoom.this;
                    FileInputStream fileInputStream3 = loadDeepZoom3.f35765e.get(loadDeepZoom3.f35780a);
                    try {
                        GifDecoder gifDecoder = new GifDecoder(ByteBuffer.wrap(StreamUtility.readToEndAsArray(fileInputStream3)));
                        BitmapInfo bitmapInfo = new BitmapInfo(LoadDeepZoom.this.f35780a, prepareBitmapOptions.outMimeType, gifDecoder.nextFrame().image, point);
                        bitmapInfo.gifDecoder = gifDecoder;
                        LoadDeepZoom.this.c(null, bitmapInfo);
                        StreamUtility.closeQuietly(fileInputStream3);
                        return;
                    } catch (Exception e4) {
                        fileInputStream = fileInputStream3;
                        e = e4;
                        try {
                            LoadDeepZoom.this.c(e, null);
                            StreamUtility.closeQuietly(fileInputStream);
                            return;
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream2 = fileInputStream;
                            StreamUtility.closeQuietly(fileInputStream2);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream2 = fileInputStream3;
                        StreamUtility.closeQuietly(fileInputStream2);
                        throw th;
                    }
                }
                BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(file.toString(), false);
                Bitmap decodeRegion = newInstance.decodeRegion(new Rect(0, 0, point.x, point.y), prepareBitmapOptions);
                if (decodeRegion != null) {
                    BitmapInfo bitmapInfo2 = new BitmapInfo(LoadDeepZoom.this.f35780a, prepareBitmapOptions.outMimeType, decodeRegion, point);
                    bitmapInfo2.decoder = newInstance;
                    bitmapInfo2.decoderFile = file;
                    bitmapInfo2.servedFrom = this.f35767b.getServedFrom();
                    LoadDeepZoom.this.c(null, bitmapInfo2);
                    StreamUtility.closeQuietly(null);
                    return;
                }
                throw new Exception("unable to load decoder");
            } catch (Exception e5) {
                e = e5;
                fileInputStream = null;
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    public LoadDeepZoom(Ion ion, String str, boolean z3, FileCache fileCache) {
        super(ion, str, true, z3);
        this.f35765e = fileCache;
    }

    @Override // com.koushikdutta.async.future.FutureCallback
    public void onCompleted(Exception exc, Response<File> response) {
        if (exc == null) {
            exc = response.getException();
        }
        if (exc != null) {
            c(exc, null);
            return;
        }
        File result = response.getResult();
        if (this.f35781b.f35737s.tag(this.f35780a) != this) {
            return;
        }
        Ion.getBitmapLoadExecutorService().execute(new a(result, response));
    }
}
