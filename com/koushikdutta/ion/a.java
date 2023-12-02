package com.koushikdutta.ion;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.util.FileCache;
import com.koushikdutta.ion.bitmap.BitmapInfo;
import com.koushikdutta.ion.bitmap.IonBitmapCache;
import com.koushikdutta.ion.bitmap.PostProcess;
import com.miguelbcr.ui.rx_paparazzo2.interactors.ImageUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CancellationException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BitmapCallback.java */
/* loaded from: classes6.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    final String f35780a;

    /* renamed from: b  reason: collision with root package name */
    final Ion f35781b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f35782c;

    /* compiled from: BitmapCallback.java */
    /* renamed from: com.koushikdutta.ion.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    static class RunnableC0203a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Ion f35783a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f35784b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ a f35785c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ArrayList f35786d;

        RunnableC0203a(Ion ion, String str, a aVar, ArrayList arrayList) {
            this.f35783a = ion;
            this.f35784b = str;
            this.f35785c = aVar;
            this.f35786d = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f35783a.f35737s.tag(this.f35784b) != this.f35785c) {
                return;
            }
            try {
                Bitmap loadBitmap = IonBitmapCache.loadBitmap(this.f35783a.f35722d.getFileCache().getFile(this.f35784b), (BitmapFactory.Options) null);
                if (loadBitmap != null) {
                    BitmapInfo bitmapInfo = new BitmapInfo(this.f35784b, ImageUtils.MIME_TYPE_JPEG, loadBitmap, null);
                    bitmapInfo.servedFrom = ResponseServedFrom.LOADED_FROM_CACHE;
                    ArrayList arrayList = this.f35786d;
                    if (arrayList != null) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            ((PostProcess) it.next()).postProcess(bitmapInfo);
                        }
                    }
                    this.f35785c.c(null, bitmapInfo);
                    return;
                }
                throw new Exception("Bitmap failed to load");
            } catch (Exception e4) {
                this.f35785c.c(e4, null);
                try {
                    this.f35783a.f35722d.getFileCache().remove(this.f35784b);
                } catch (Exception unused) {
                }
            } catch (OutOfMemoryError e5) {
                this.f35785c.c(new Exception(e5), null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BitmapCallback.java */
    /* loaded from: classes6.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BitmapInfo f35787a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Exception f35788b;

        b(BitmapInfo bitmapInfo, Exception exc) {
            this.f35787a = bitmapInfo;
            this.f35788b = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            BitmapInfo bitmapInfo = this.f35787a;
            if (bitmapInfo == null) {
                bitmapInfo = new BitmapInfo(a.this.f35780a, null, null, new Point());
                Exception exc = this.f35788b;
                bitmapInfo.exception = exc;
                if (!(exc instanceof CancellationException)) {
                    a.this.f35781b.getBitmapCache().put(bitmapInfo);
                }
            } else if (a.this.b()) {
                a.this.f35781b.getBitmapCache().put(bitmapInfo);
            } else {
                a.this.f35781b.getBitmapCache().putSoft(bitmapInfo);
            }
            a aVar = a.this;
            ArrayList<FutureCallback<BitmapInfo>> remove = aVar.f35781b.f35737s.remove(aVar.f35780a);
            if (remove != null && remove.size() != 0) {
                Iterator<FutureCallback<BitmapInfo>> it = remove.iterator();
                while (it.hasNext()) {
                    it.next().onCompleted(this.f35788b, bitmapInfo);
                }
                a.this.a();
                return;
            }
            a.this.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Ion ion, String str, boolean z3) {
        this.f35780a = str;
        this.f35782c = z3;
        this.f35781b = ion;
        ion.f35737s.tag(str, this);
    }

    public static void getBitmapSnapshot(Ion ion, String str, ArrayList<PostProcess> arrayList) {
        if (ion.f35737s.tag(str) != null) {
            return;
        }
        Ion.getBitmapLoadExecutorService().execute(new RunnableC0203a(ion, str, new LoadBitmapBase(ion, str, true), arrayList));
    }

    public static void saveBitmapSnapshot(Ion ion, BitmapInfo bitmapInfo) {
        FileCache fileCache;
        Bitmap.CompressFormat compressFormat;
        if (bitmapInfo.bitmap == null || (fileCache = ion.f35722d.getFileCache()) == null) {
            return;
        }
        File tempFile = fileCache.getTempFile();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(tempFile);
            if (bitmapInfo.bitmap.hasAlpha()) {
                compressFormat = Bitmap.CompressFormat.PNG;
            } else {
                compressFormat = Bitmap.CompressFormat.JPEG;
            }
            bitmapInfo.bitmap.compress(compressFormat, 100, fileOutputStream);
            fileOutputStream.close();
            fileCache.commitTempFiles(bitmapInfo.key, tempFile);
        } catch (Exception unused) {
        } catch (Throwable th) {
            tempFile.delete();
            throw th;
        }
        tempFile.delete();
    }

    protected void a() {
        this.f35781b.d();
    }

    boolean b() {
        return this.f35782c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(Exception exc, BitmapInfo bitmapInfo) {
        AsyncServer.post(Ion.f35718z, new b(bitmapInfo, exc));
        if (bitmapInfo != null && bitmapInfo.originalSize != null && bitmapInfo.decoder == null && this.f35782c && bitmapInfo.bitmap != null && bitmapInfo.gifDecoder == null && bitmapInfo.sizeOf() <= 1048576) {
            saveBitmapSnapshot(this.f35781b, bitmapInfo);
        }
    }
}
