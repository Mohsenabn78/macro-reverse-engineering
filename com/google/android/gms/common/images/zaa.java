package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Asserts;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
final class zaa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f20407a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final ParcelFileDescriptor f20408b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ ImageManager f20409c;

    public zaa(ImageManager imageManager, @Nullable Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
        this.f20409c = imageManager;
        this.f20407a = uri;
        this.f20408b = parcelFileDescriptor;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z3;
        Bitmap bitmap;
        Handler handler;
        Asserts.checkNotMainThread("LoadBitmapFromDiskRunnable can't be executed in the main thread");
        ParcelFileDescriptor parcelFileDescriptor = this.f20408b;
        boolean z4 = false;
        Bitmap bitmap2 = null;
        if (parcelFileDescriptor != null) {
            try {
                bitmap2 = BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor());
            } catch (OutOfMemoryError e4) {
                Log.e("ImageManager", "OOM while loading bitmap for uri: ".concat(String.valueOf(this.f20407a)), e4);
                z4 = true;
            }
            try {
                this.f20408b.close();
            } catch (IOException e5) {
                Log.e("ImageManager", "closed failed", e5);
            }
            z3 = z4;
            bitmap = bitmap2;
        } else {
            bitmap = null;
            z3 = false;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ImageManager imageManager = this.f20409c;
        handler = imageManager.f20392b;
        handler.post(new zac(imageManager, this.f20407a, bitmap, z3, countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
            Log.w("ImageManager", "Latch interrupted while posting ".concat(String.valueOf(this.f20407a)));
        }
    }
}
