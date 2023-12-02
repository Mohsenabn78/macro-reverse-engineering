package com.bumptech.glide.load.engine.bitmap_recycle;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes3.dex */
public class LruBitmapPool implements BitmapPool {

    /* renamed from: k  reason: collision with root package name */
    private static final Bitmap.Config f16845k = Bitmap.Config.ARGB_8888;

    /* renamed from: a  reason: collision with root package name */
    private final d f16846a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<Bitmap.Config> f16847b;

    /* renamed from: c  reason: collision with root package name */
    private final long f16848c;

    /* renamed from: d  reason: collision with root package name */
    private final a f16849d;

    /* renamed from: e  reason: collision with root package name */
    private long f16850e;

    /* renamed from: f  reason: collision with root package name */
    private long f16851f;

    /* renamed from: g  reason: collision with root package name */
    private int f16852g;

    /* renamed from: h  reason: collision with root package name */
    private int f16853h;

    /* renamed from: i  reason: collision with root package name */
    private int f16854i;

    /* renamed from: j  reason: collision with root package name */
    private int f16855j;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public interface a {
        void a(Bitmap bitmap);

        void b(Bitmap bitmap);
    }

    LruBitmapPool(long j4, d dVar, Set<Bitmap.Config> set) {
        this.f16848c = j4;
        this.f16850e = j4;
        this.f16846a = dVar;
        this.f16847b = set;
        this.f16849d = new b();
    }

    @TargetApi(26)
    private static void a(Bitmap.Config config) {
        Bitmap.Config config2;
        if (Build.VERSION.SDK_INT >= 26) {
            config2 = Bitmap.Config.HARDWARE;
            if (config != config2) {
                return;
            }
            throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        }
    }

    @NonNull
    private static Bitmap b(int i4, int i5, @Nullable Bitmap.Config config) {
        if (config == null) {
            config = f16845k;
        }
        return Bitmap.createBitmap(i4, i5, config);
    }

    private void c() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            d();
        }
    }

    private void d() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hits=");
        sb.append(this.f16852g);
        sb.append(", misses=");
        sb.append(this.f16853h);
        sb.append(", puts=");
        sb.append(this.f16854i);
        sb.append(", evictions=");
        sb.append(this.f16855j);
        sb.append(", currentSize=");
        sb.append(this.f16851f);
        sb.append(", maxSize=");
        sb.append(this.f16850e);
        sb.append("\nStrategy=");
        sb.append(this.f16846a);
    }

    private void e() {
        k(this.f16850e);
    }

    @TargetApi(26)
    private static Set<Bitmap.Config> f() {
        Bitmap.Config config;
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        int i4 = Build.VERSION.SDK_INT;
        hashSet.add(null);
        if (i4 >= 26) {
            config = Bitmap.Config.HARDWARE;
            hashSet.remove(config);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    private static d g() {
        return new SizeConfigStrategy();
    }

    @Nullable
    private synchronized Bitmap h(int i4, int i5, @Nullable Bitmap.Config config) {
        Bitmap.Config config2;
        Bitmap bitmap;
        a(config);
        d dVar = this.f16846a;
        if (config != null) {
            config2 = config;
        } else {
            config2 = f16845k;
        }
        bitmap = dVar.get(i4, i5, config2);
        if (bitmap == null) {
            if (Log.isLoggable("LruBitmapPool", 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Missing bitmap=");
                sb.append(this.f16846a.logBitmap(i4, i5, config));
            }
            this.f16853h++;
        } else {
            this.f16852g++;
            this.f16851f -= this.f16846a.getSize(bitmap);
            this.f16849d.b(bitmap);
            j(bitmap);
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Get bitmap=");
            sb2.append(this.f16846a.logBitmap(i4, i5, config));
        }
        c();
        return bitmap;
    }

    @TargetApi(19)
    private static void i(Bitmap bitmap) {
        bitmap.setPremultiplied(true);
    }

    private static void j(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        i(bitmap);
    }

    private synchronized void k(long j4) {
        while (this.f16851f > j4) {
            Bitmap removeLast = this.f16846a.removeLast();
            if (removeLast == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    Log.w("LruBitmapPool", "Size mismatch, resetting");
                    d();
                }
                this.f16851f = 0L;
                return;
            }
            this.f16849d.b(removeLast);
            this.f16851f -= this.f16846a.getSize(removeLast);
            this.f16855j++;
            if (Log.isLoggable("LruBitmapPool", 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Evicting bitmap=");
                sb.append(this.f16846a.logBitmap(removeLast));
            }
            c();
            removeLast.recycle();
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public void clearMemory() {
        Log.isLoggable("LruBitmapPool", 3);
        k(0L);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    @NonNull
    public Bitmap get(int i4, int i5, Bitmap.Config config) {
        Bitmap h4 = h(i4, i5, config);
        if (h4 != null) {
            h4.eraseColor(0);
            return h4;
        }
        return b(i4, i5, config);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    @NonNull
    public Bitmap getDirty(int i4, int i5, Bitmap.Config config) {
        Bitmap h4 = h(i4, i5, config);
        if (h4 == null) {
            return b(i4, i5, config);
        }
        return h4;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public long getMaxSize() {
        return this.f16850e;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public synchronized void put(Bitmap bitmap) {
        try {
            if (bitmap != null) {
                if (!bitmap.isRecycled()) {
                    if (bitmap.isMutable() && this.f16846a.getSize(bitmap) <= this.f16850e && this.f16847b.contains(bitmap.getConfig())) {
                        int size = this.f16846a.getSize(bitmap);
                        this.f16846a.put(bitmap);
                        this.f16849d.a(bitmap);
                        this.f16854i++;
                        this.f16851f += size;
                        if (Log.isLoggable("LruBitmapPool", 2)) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Put bitmap in pool=");
                            sb.append(this.f16846a.logBitmap(bitmap));
                        }
                        c();
                        e();
                        return;
                    }
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Reject bitmap from pool, bitmap: ");
                        sb2.append(this.f16846a.logBitmap(bitmap));
                        sb2.append(", is mutable: ");
                        sb2.append(bitmap.isMutable());
                        sb2.append(", is allowed config: ");
                        sb2.append(this.f16847b.contains(bitmap.getConfig()));
                    }
                    bitmap.recycle();
                    return;
                }
                throw new IllegalStateException("Cannot pool recycled bitmap");
            }
            throw new NullPointerException("Bitmap must not be null");
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public synchronized void setSizeMultiplier(float f4) {
        this.f16850e = Math.round(((float) this.f16848c) * f4);
        e();
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    @SuppressLint({"InlinedApi"})
    public void trimMemory(int i4) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("trimMemory, level=");
            sb.append(i4);
        }
        if (i4 >= 40) {
            clearMemory();
        } else if (i4 >= 20 || i4 == 15) {
            k(getMaxSize() / 2);
        }
    }

    public LruBitmapPool(long j4) {
        this(j4, g(), f());
    }

    public LruBitmapPool(long j4, Set<Bitmap.Config> set) {
        this(j4, g(), set);
    }

    /* loaded from: classes3.dex */
    private static final class b implements a {
        b() {
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.a
        public void a(Bitmap bitmap) {
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.a
        public void b(Bitmap bitmap) {
        }
    }
}
