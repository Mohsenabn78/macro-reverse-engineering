package com.koushikdutta.ion;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.text.TextUtils;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.bitmap.BitmapInfo;
import com.koushikdutta.ion.bitmap.IonBitmapCache;
import com.koushikdutta.ion.gif.GifDecoder;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LoadBitmap.java */
/* loaded from: classes6.dex */
public class m extends n implements FutureCallback<Response<ByteBufferList>> {

    /* renamed from: e  reason: collision with root package name */
    int f36083e;

    /* renamed from: f  reason: collision with root package name */
    int f36084f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoadBitmap.java */
    /* loaded from: classes6.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ByteBufferList f36085a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Response f36086b;

        a(ByteBufferList byteBufferList, Response response) {
            this.f36085a = byteBufferList;
            this.f36086b = response;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v15 */
        /* JADX WARN: Type inference failed for: r1v2, types: [com.koushikdutta.ion.m] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v7, types: [java.nio.ByteBuffer] */
        @Override // java.lang.Runnable
        public void run() {
            Throwable th;
            ByteBuffer byteBuffer;
            GifDecoder gifDecoder;
            ByteBuffer byteBuffer2;
            Bitmap bitmap;
            m mVar = m.this;
            Object tag = mVar.f35781b.f35737s.tag(mVar.f35780a);
            ?? r12 = m.this;
            if (tag != r12) {
                this.f36085a.recycle();
                return;
            }
            try {
                try {
                    byteBuffer = this.f36085a.getAll();
                    try {
                        IonBitmapCache ionBitmapCache = m.this.f35781b.f35739u;
                        byte[] array = byteBuffer.array();
                        int position = byteBuffer.position() + byteBuffer.arrayOffset();
                        int remaining = byteBuffer.remaining();
                        m mVar2 = m.this;
                        BitmapFactory.Options prepareBitmapOptions = ionBitmapCache.prepareBitmapOptions(array, position, remaining, mVar2.f36083e, mVar2.f36084f);
                        Point point = new Point(prepareBitmapOptions.outWidth, prepareBitmapOptions.outHeight);
                        if (m.this.f36092d && TextUtils.equals("image/gif", prepareBitmapOptions.outMimeType)) {
                            GifDecoder gifDecoder2 = new GifDecoder(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
                            bitmap = gifDecoder2.nextFrame().image;
                            gifDecoder = gifDecoder2;
                            byteBuffer2 = null;
                        } else {
                            Bitmap loadBitmap = IonBitmapCache.loadBitmap(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining(), prepareBitmapOptions);
                            if (loadBitmap != null) {
                                gifDecoder = null;
                                byteBuffer2 = byteBuffer;
                                bitmap = loadBitmap;
                            } else {
                                throw new Exception("failed to load bitmap");
                            }
                        }
                        try {
                            BitmapInfo bitmapInfo = new BitmapInfo(m.this.f35780a, prepareBitmapOptions.outMimeType, bitmap, point);
                            bitmapInfo.gifDecoder = gifDecoder;
                            bitmapInfo.servedFrom = this.f36086b.getServedFrom();
                            m.this.c(null, bitmapInfo);
                            ByteBufferList.reclaim(byteBuffer2);
                        } catch (Exception e4) {
                            e = e4;
                            byteBuffer = byteBuffer2;
                            m.this.c(e, null);
                            ByteBufferList.reclaim(byteBuffer);
                        } catch (OutOfMemoryError e5) {
                            e = e5;
                            byteBuffer = byteBuffer2;
                            m.this.c(new Exception(e), null);
                            ByteBufferList.reclaim(byteBuffer);
                        } catch (Throwable th2) {
                            th = th2;
                            r12 = byteBuffer2;
                            ByteBufferList.reclaim(r12);
                            throw th;
                        }
                    } catch (Exception e6) {
                        e = e6;
                    } catch (OutOfMemoryError e7) {
                        e = e7;
                    }
                } catch (Exception e8) {
                    e = e8;
                    byteBuffer = null;
                } catch (OutOfMemoryError e9) {
                    e = e9;
                    byteBuffer = null;
                } catch (Throwable th3) {
                    r12 = 0;
                    th = th3;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }
    }

    public m(Ion ion, String str, boolean z3, int i4, int i5, boolean z4) {
        super(ion, str, z3, z4);
        this.f36083e = i4;
        this.f36084f = i5;
    }

    @Override // com.koushikdutta.async.future.FutureCallback
    public void onCompleted(Exception exc, Response<ByteBufferList> response) {
        if (exc == null) {
            exc = response.getException();
        }
        if (exc != null) {
            c(exc, null);
            return;
        }
        ByteBufferList result = response.getResult();
        if (this.f35781b.f35737s.tag(this.f35780a) != this) {
            result.recycle();
        } else {
            Ion.getBitmapLoadExecutorService().execute(new a(result, response));
        }
    }
}
