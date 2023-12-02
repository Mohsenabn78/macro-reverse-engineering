package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.internal.base.zam;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
final class zac implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f20412a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final Bitmap f20413b;

    /* renamed from: c  reason: collision with root package name */
    private final CountDownLatch f20414c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ ImageManager f20415d;

    public zac(ImageManager imageManager, @Nullable Uri uri, Bitmap bitmap, boolean z3, CountDownLatch countDownLatch) {
        this.f20415d = imageManager;
        this.f20412a = uri;
        this.f20413b = bitmap;
        this.f20414c = countDownLatch;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Map map;
        Object obj;
        HashSet hashSet;
        ArrayList arrayList;
        Map map2;
        zam zamVar;
        Map map3;
        Asserts.checkMainThread("OnBitmapLoadedRunnable must be executed in the main thread");
        Bitmap bitmap = this.f20413b;
        map = this.f20415d.f20396f;
        ImageManager.ImageReceiver imageReceiver = (ImageManager.ImageReceiver) map.remove(this.f20412a);
        if (imageReceiver != null) {
            arrayList = imageReceiver.f20399b;
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                zag zagVar = (zag) arrayList.get(i4);
                Bitmap bitmap2 = this.f20413b;
                if (bitmap2 == null || bitmap == null) {
                    map2 = this.f20415d.f20397g;
                    map2.put(this.f20412a, Long.valueOf(SystemClock.elapsedRealtime()));
                    ImageManager imageManager = this.f20415d;
                    Context context = imageManager.f20391a;
                    zamVar = imageManager.f20394d;
                    zagVar.b(context, zamVar, false);
                } else {
                    zagVar.c(this.f20415d.f20391a, bitmap2, false);
                }
                if (!(zagVar instanceof zaf)) {
                    map3 = this.f20415d.f20395e;
                    map3.remove(zagVar);
                }
            }
        }
        this.f20414c.countDown();
        obj = ImageManager.f20388h;
        synchronized (obj) {
            hashSet = ImageManager.f20389i;
            hashSet.remove(this.f20412a);
        }
    }
}
