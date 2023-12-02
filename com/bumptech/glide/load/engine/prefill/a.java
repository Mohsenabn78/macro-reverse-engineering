package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.util.Util;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BitmapPreFillRunner.java */
/* loaded from: classes3.dex */
public final class a implements Runnable {

    /* renamed from: i  reason: collision with root package name */
    private static final C0139a f17093i = new C0139a();

    /* renamed from: j  reason: collision with root package name */
    static final long f17094j = TimeUnit.SECONDS.toMillis(1);

    /* renamed from: a  reason: collision with root package name */
    private final BitmapPool f17095a;

    /* renamed from: b  reason: collision with root package name */
    private final MemoryCache f17096b;

    /* renamed from: c  reason: collision with root package name */
    private final com.bumptech.glide.load.engine.prefill.b f17097c;

    /* renamed from: d  reason: collision with root package name */
    private final C0139a f17098d;

    /* renamed from: e  reason: collision with root package name */
    private final Set<PreFillType> f17099e;

    /* renamed from: f  reason: collision with root package name */
    private final Handler f17100f;

    /* renamed from: g  reason: collision with root package name */
    private long f17101g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f17102h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BitmapPreFillRunner.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.engine.prefill.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0139a {
        C0139a() {
        }

        long a() {
            return SystemClock.currentThreadTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BitmapPreFillRunner.java */
    /* loaded from: classes3.dex */
    public static final class b implements Key {
        b() {
        }

        @Override // com.bumptech.glide.load.Key
        public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
            throw new UnsupportedOperationException();
        }
    }

    public a(BitmapPool bitmapPool, MemoryCache memoryCache, com.bumptech.glide.load.engine.prefill.b bVar) {
        this(bitmapPool, memoryCache, bVar, f17093i, new Handler(Looper.getMainLooper()));
    }

    private long c() {
        return this.f17096b.getMaxSize() - this.f17096b.getCurrentSize();
    }

    private long d() {
        long j4 = this.f17101g;
        this.f17101g = Math.min(4 * j4, f17094j);
        return j4;
    }

    private boolean e(long j4) {
        if (this.f17098d.a() - j4 >= 32) {
            return true;
        }
        return false;
    }

    @VisibleForTesting
    boolean a() {
        Bitmap createBitmap;
        long a4 = this.f17098d.a();
        while (!this.f17097c.a() && !e(a4)) {
            PreFillType b4 = this.f17097c.b();
            if (!this.f17099e.contains(b4)) {
                this.f17099e.add(b4);
                createBitmap = this.f17095a.getDirty(b4.d(), b4.b(), b4.a());
            } else {
                createBitmap = Bitmap.createBitmap(b4.d(), b4.b(), b4.a());
            }
            int bitmapByteSize = Util.getBitmapByteSize(createBitmap);
            if (c() >= bitmapByteSize) {
                this.f17096b.put(new b(), BitmapResource.obtain(createBitmap, this.f17095a));
            } else {
                this.f17095a.put(createBitmap);
            }
            if (Log.isLoggable("PreFillRunner", 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("allocated [");
                sb.append(b4.d());
                sb.append("x");
                sb.append(b4.b());
                sb.append("] ");
                sb.append(b4.a());
                sb.append(" size: ");
                sb.append(bitmapByteSize);
            }
        }
        if (!this.f17102h && !this.f17097c.a()) {
            return true;
        }
        return false;
    }

    public void b() {
        this.f17102h = true;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (a()) {
            this.f17100f.postDelayed(this, d());
        }
    }

    @VisibleForTesting
    a(BitmapPool bitmapPool, MemoryCache memoryCache, com.bumptech.glide.load.engine.prefill.b bVar, C0139a c0139a, Handler handler) {
        this.f17099e = new HashSet();
        this.f17101g = 40L;
        this.f17095a = bitmapPool;
        this.f17096b = memoryCache;
        this.f17097c = bVar;
        this.f17098d = c0139a;
        this.f17100f = handler;
    }
}
