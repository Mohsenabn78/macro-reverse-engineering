package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.signature.ObjectKey;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class GifFrameLoader {

    /* renamed from: a  reason: collision with root package name */
    private final GifDecoder f17311a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f17312b;

    /* renamed from: c  reason: collision with root package name */
    private final List<FrameCallback> f17313c;

    /* renamed from: d  reason: collision with root package name */
    final RequestManager f17314d;

    /* renamed from: e  reason: collision with root package name */
    private final BitmapPool f17315e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f17316f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f17317g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f17318h;

    /* renamed from: i  reason: collision with root package name */
    private RequestBuilder<Bitmap> f17319i;

    /* renamed from: j  reason: collision with root package name */
    private a f17320j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f17321k;

    /* renamed from: l  reason: collision with root package name */
    private a f17322l;

    /* renamed from: m  reason: collision with root package name */
    private Bitmap f17323m;

    /* renamed from: n  reason: collision with root package name */
    private Transformation<Bitmap> f17324n;

    /* renamed from: o  reason: collision with root package name */
    private a f17325o;

    /* loaded from: classes3.dex */
    public interface FrameCallback {
        void onFrameReady();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes3.dex */
    public static class a extends SimpleTarget<Bitmap> {

        /* renamed from: d  reason: collision with root package name */
        private final Handler f17326d;

        /* renamed from: e  reason: collision with root package name */
        final int f17327e;

        /* renamed from: f  reason: collision with root package name */
        private final long f17328f;

        /* renamed from: g  reason: collision with root package name */
        private Bitmap f17329g;

        a(Handler handler, int i4, long j4) {
            this.f17326d = handler;
            this.f17327e = i4;
            this.f17328f = j4;
        }

        Bitmap a() {
            return this.f17329g;
        }

        @Override // com.bumptech.glide.request.target.Target
        public /* bridge */ /* synthetic */ void onResourceReady(@NonNull Object obj, @Nullable Transition transition) {
            onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
        }

        public void onResourceReady(@NonNull Bitmap bitmap, @Nullable Transition<? super Bitmap> transition) {
            this.f17329g = bitmap;
            this.f17326d.sendMessageAtTime(this.f17326d.obtainMessage(1, this), this.f17328f);
        }
    }

    /* loaded from: classes3.dex */
    private class b implements Handler.Callback {
        b() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i4 = message.what;
            if (i4 == 1) {
                GifFrameLoader.this.p((a) message.obj);
                return true;
            } else if (i4 == 2) {
                GifFrameLoader.this.f17314d.clear((a) message.obj);
                return false;
            } else {
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GifFrameLoader(Glide glide, GifDecoder gifDecoder, int i4, int i5, Transformation<Bitmap> transformation, Bitmap bitmap) {
        this(glide.getBitmapPool(), Glide.with(glide.getContext()), gifDecoder, null, l(Glide.with(glide.getContext()), i4, i5), transformation, bitmap);
    }

    private static Key g() {
        return new ObjectKey(Double.valueOf(Math.random()));
    }

    private int h() {
        return Util.getBitmapByteSize(c().getWidth(), c().getHeight(), c().getConfig());
    }

    private static RequestBuilder<Bitmap> l(RequestManager requestManager, int i4, int i5) {
        return requestManager.asBitmap().apply((BaseRequestOptions<?>) RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE).useAnimationPool(true).skipMemoryCache(true).override(i4, i5));
    }

    private void o() {
        boolean z3;
        if (this.f17316f && !this.f17317g) {
            if (this.f17318h) {
                if (this.f17325o == null) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Preconditions.checkArgument(z3, "Pending target must be null when starting from the first frame");
                this.f17311a.resetFrameIndex();
                this.f17318h = false;
            }
            a aVar = this.f17325o;
            if (aVar != null) {
                this.f17325o = null;
                p(aVar);
                return;
            }
            this.f17317g = true;
            long uptimeMillis = SystemClock.uptimeMillis() + this.f17311a.getNextDelay();
            this.f17311a.advance();
            this.f17322l = new a(this.f17312b, this.f17311a.getCurrentFrameIndex(), uptimeMillis);
            this.f17319i.apply((BaseRequestOptions<?>) RequestOptions.signatureOf(g())).m4151load((Object) this.f17311a).into((RequestBuilder<Bitmap>) this.f17322l);
        }
    }

    private void q() {
        Bitmap bitmap = this.f17323m;
        if (bitmap != null) {
            this.f17315e.put(bitmap);
            this.f17323m = null;
        }
    }

    private void t() {
        if (this.f17316f) {
            return;
        }
        this.f17316f = true;
        this.f17321k = false;
        o();
    }

    private void u() {
        this.f17316f = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f17313c.clear();
        q();
        u();
        a aVar = this.f17320j;
        if (aVar != null) {
            this.f17314d.clear(aVar);
            this.f17320j = null;
        }
        a aVar2 = this.f17322l;
        if (aVar2 != null) {
            this.f17314d.clear(aVar2);
            this.f17322l = null;
        }
        a aVar3 = this.f17325o;
        if (aVar3 != null) {
            this.f17314d.clear(aVar3);
            this.f17325o = null;
        }
        this.f17311a.clear();
        this.f17321k = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteBuffer b() {
        return this.f17311a.getData().asReadOnlyBuffer();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bitmap c() {
        a aVar = this.f17320j;
        if (aVar != null) {
            return aVar.a();
        }
        return this.f17323m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        a aVar = this.f17320j;
        if (aVar != null) {
            return aVar.f17327e;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bitmap e() {
        return this.f17323m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f17311a.getFrameCount();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Transformation<Bitmap> i() {
        return this.f17324n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j() {
        return c().getHeight();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k() {
        return this.f17311a.getTotalIterationCount();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m() {
        return this.f17311a.getByteSize() + h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int n() {
        return c().getWidth();
    }

    @VisibleForTesting
    void p(a aVar) {
        this.f17317g = false;
        if (this.f17321k) {
            this.f17312b.obtainMessage(2, aVar).sendToTarget();
        } else if (!this.f17316f) {
            this.f17325o = aVar;
        } else {
            if (aVar.a() != null) {
                q();
                a aVar2 = this.f17320j;
                this.f17320j = aVar;
                for (int size = this.f17313c.size() - 1; size >= 0; size--) {
                    this.f17313c.get(size).onFrameReady();
                }
                if (aVar2 != null) {
                    this.f17312b.obtainMessage(2, aVar2).sendToTarget();
                }
            }
            o();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(Transformation<Bitmap> transformation, Bitmap bitmap) {
        this.f17324n = (Transformation) Preconditions.checkNotNull(transformation);
        this.f17323m = (Bitmap) Preconditions.checkNotNull(bitmap);
        this.f17319i = this.f17319i.apply((BaseRequestOptions<?>) new RequestOptions().transform(transformation));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s() {
        Preconditions.checkArgument(!this.f17316f, "Can't restart a running animation");
        this.f17318h = true;
        a aVar = this.f17325o;
        if (aVar != null) {
            this.f17314d.clear(aVar);
            this.f17325o = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(FrameCallback frameCallback) {
        if (!this.f17321k) {
            if (!this.f17313c.contains(frameCallback)) {
                boolean isEmpty = this.f17313c.isEmpty();
                this.f17313c.add(frameCallback);
                if (isEmpty) {
                    t();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(FrameCallback frameCallback) {
        this.f17313c.remove(frameCallback);
        if (this.f17313c.isEmpty()) {
            u();
        }
    }

    GifFrameLoader(BitmapPool bitmapPool, RequestManager requestManager, GifDecoder gifDecoder, Handler handler, RequestBuilder<Bitmap> requestBuilder, Transformation<Bitmap> transformation, Bitmap bitmap) {
        this.f17313c = new ArrayList();
        this.f17314d = requestManager;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new b()) : handler;
        this.f17315e = bitmapPool;
        this.f17312b = handler;
        this.f17319i = requestBuilder;
        this.f17311a = gifDecoder;
        r(transformation, bitmap);
    }
}
