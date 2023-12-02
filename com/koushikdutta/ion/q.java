package com.koushikdutta.ion;

import android.graphics.Bitmap;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.bitmap.BitmapInfo;
import com.koushikdutta.ion.bitmap.PostProcess;
import com.koushikdutta.ion.bitmap.Transform;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TransformBitmap.java */
/* loaded from: classes6.dex */
public class q extends com.koushikdutta.ion.a implements FutureCallback<BitmapInfo> {

    /* renamed from: d  reason: collision with root package name */
    ArrayList<Transform> f36104d;

    /* renamed from: e  reason: collision with root package name */
    ArrayList<PostProcess> f36105e;

    /* renamed from: f  reason: collision with root package name */
    String f36106f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TransformBitmap.java */
    /* loaded from: classes6.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BitmapInfo f36107a;

        a(BitmapInfo bitmapInfo) {
            this.f36107a = bitmapInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            q qVar = q.this;
            Object tag = qVar.f35781b.f35737s.tag(qVar.f35780a);
            q qVar2 = q.this;
            if (tag != qVar2) {
                return;
            }
            try {
                Bitmap bitmap = this.f36107a.bitmap;
                Iterator<Transform> it = qVar2.f36104d.iterator();
                while (it.hasNext()) {
                    bitmap = it.next().transform(bitmap);
                    if (bitmap == null) {
                        throw new Exception("failed to transform bitmap");
                    }
                }
                String str = q.this.f35780a;
                BitmapInfo bitmapInfo = this.f36107a;
                BitmapInfo bitmapInfo2 = new BitmapInfo(str, bitmapInfo.mimeType, bitmap, bitmapInfo.originalSize);
                bitmapInfo2.servedFrom = this.f36107a.servedFrom;
                ArrayList<PostProcess> arrayList = q.this.f36105e;
                if (arrayList != null) {
                    Iterator<PostProcess> it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        it2.next().postProcess(bitmapInfo2);
                    }
                }
                q.this.c(null, bitmapInfo2);
            } catch (Exception e4) {
                q.this.c(e4, null);
            } catch (OutOfMemoryError e5) {
                q.this.c(new Exception(e5), null);
            }
        }
    }

    public q(Ion ion, String str, String str2, ArrayList<Transform> arrayList, ArrayList<PostProcess> arrayList2) {
        super(ion, str, true);
        this.f36104d = arrayList;
        this.f36106f = str2;
        this.f36105e = arrayList2;
    }

    @Override // com.koushikdutta.async.future.FutureCallback
    /* renamed from: d */
    public void onCompleted(Exception exc, BitmapInfo bitmapInfo) {
        if (exc != null) {
            c(exc, null);
        } else if (this.f35781b.f35737s.tag(this.f35780a) != this) {
        } else {
            Ion.getBitmapLoadExecutorService().execute(new a(bitmapInfo));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TransformBitmap.java */
    /* loaded from: classes6.dex */
    public static class b implements Transform {

        /* renamed from: a  reason: collision with root package name */
        String f36109a;

        public b(String str) {
            this.f36109a = str;
        }

        @Override // com.koushikdutta.ion.bitmap.Transform
        public String key() {
            return this.f36109a;
        }

        @Override // com.koushikdutta.ion.bitmap.Transform
        public Bitmap transform(Bitmap bitmap) {
            return bitmap;
        }
    }
}
