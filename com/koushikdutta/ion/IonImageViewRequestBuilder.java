package com.koushikdutta.ion;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.ion.bitmap.BitmapInfo;
import com.koushikdutta.ion.bitmap.LocallyCachedStatus;
import com.koushikdutta.ion.bitmap.PostProcess;
import com.koushikdutta.ion.bitmap.Transform;
import com.koushikdutta.ion.builder.AnimateGifMode;
import com.koushikdutta.ion.builder.Builders;
import com.koushikdutta.ion.builder.ImageViewFutureBuilder;
import com.koushikdutta.ion.d;
import com.koushikdutta.ion.future.ImageViewFuture;

/* loaded from: classes6.dex */
public class IonImageViewRequestBuilder extends i implements Builders.IV.F, ImageViewFutureBuilder {

    /* renamed from: k  reason: collision with root package name */
    Drawable f35748k;

    /* renamed from: l  reason: collision with root package name */
    int f35749l;

    /* renamed from: m  reason: collision with root package name */
    Drawable f35750m;

    /* renamed from: n  reason: collision with root package name */
    int f35751n;

    /* renamed from: o  reason: collision with root package name */
    Animation f35752o;

    /* renamed from: p  reason: collision with root package name */
    Animation f35753p;

    /* renamed from: q  reason: collision with root package name */
    int f35754q;

    /* renamed from: r  reason: collision with root package name */
    int f35755r;

    /* renamed from: s  reason: collision with root package name */
    d.C0205d f35756s;

    /* renamed from: t  reason: collision with root package name */
    boolean f35757t;

    /* renamed from: u  reason: collision with root package name */
    boolean f35758u;

    /* renamed from: v  reason: collision with root package name */
    BitmapDrawableFactory f35759v;

    public IonImageViewRequestBuilder(l lVar) {
        super(lVar);
        this.f35757t = true;
        this.f35759v = BitmapDrawableFactory.DEFAULT;
    }

    private static boolean i(ImageView imageView) {
        if (j(imageView)) {
            return true;
        }
        return false;
    }

    @TargetApi(16)
    private static boolean j(ImageView imageView) {
        return imageView.getAdjustViewBounds();
    }

    private Drawable k() {
        ImageView imageView = this.f35756s.get();
        if (imageView == null) {
            return null;
        }
        return imageView.getDrawable();
    }

    private j l(ImageView imageView, b bVar, ResponseServedFrom responseServedFrom) {
        BitmapInfo bitmapInfo;
        boolean z3;
        if (bVar != null) {
            bitmapInfo = bVar.f35792c;
        } else {
            bitmapInfo = null;
        }
        if (bitmapInfo != null) {
            bVar = null;
        }
        j l4 = j.h(imageView).i(this.f35887b).j(bitmapInfo, responseServedFrom).l(bVar);
        boolean z4 = true;
        if (this.f35892g == AnimateGifMode.ANIMATE) {
            z3 = true;
        } else {
            z3 = false;
        }
        j p4 = l4.q(z3).r(this.f35890e, this.f35891f).m(this.f35751n, this.f35750m).p(this.f35749l, this.f35748k);
        if (!this.f35757t && !this.f35758u) {
            z4 = false;
        }
        j v3 = p4.n(z4).k(this.f35759v).v();
        imageView.setImageDrawable(v3);
        return v3;
    }

    @Override // com.koushikdutta.ion.i
    public /* bridge */ /* synthetic */ void addDefaultTransform() {
        super.addDefaultTransform();
    }

    @Override // com.koushikdutta.ion.i, com.koushikdutta.ion.builder.ImageViewBuilder
    public /* bridge */ /* synthetic */ i animateGif(AnimateGifMode animateGifMode) {
        return super.animateGif(animateGifMode);
    }

    @Override // com.koushikdutta.ion.i, com.koushikdutta.ion.builder.BitmapFutureBuilder
    public /* bridge */ /* synthetic */ Future asBitmap() {
        return super.asBitmap();
    }

    @Override // com.koushikdutta.ion.i, com.koushikdutta.ion.builder.BitmapFutureBuilder
    public /* bridge */ /* synthetic */ BitmapInfo asCachedBitmap() {
        return super.asCachedBitmap();
    }

    @Override // com.koushikdutta.ion.i, com.koushikdutta.ion.builder.BitmapBuilder
    public /* bridge */ /* synthetic */ i centerCrop() {
        return super.centerCrop();
    }

    @Override // com.koushikdutta.ion.i, com.koushikdutta.ion.builder.BitmapBuilder
    public /* bridge */ /* synthetic */ i centerInside() {
        return super.centerInside();
    }

    @Override // com.koushikdutta.ion.i
    public /* bridge */ /* synthetic */ String computeBitmapKey(String str) {
        return super.computeBitmapKey(str);
    }

    @Override // com.koushikdutta.ion.i, com.koushikdutta.ion.builder.ImageViewBuilder
    public /* bridge */ /* synthetic */ i deepZoom() {
        return super.deepZoom();
    }

    @Override // com.koushikdutta.ion.i, com.koushikdutta.ion.builder.BitmapBuilder
    public /* bridge */ /* synthetic */ i fitCenter() {
        return super.fitCenter();
    }

    @Override // com.koushikdutta.ion.i, com.koushikdutta.ion.builder.BitmapBuilder
    public /* bridge */ /* synthetic */ i fitXY() {
        return super.fitXY();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.koushikdutta.ion.i
    public void g() {
        super.g();
        this.f35757t = true;
        this.f35758u = false;
        this.f35756s = null;
        this.f35748k = null;
        this.f35759v = BitmapDrawableFactory.DEFAULT;
        this.f35749l = 0;
        this.f35750m = null;
        this.f35751n = 0;
        this.f35752o = null;
        this.f35755r = 0;
        this.f35753p = null;
        this.f35754q = 0;
    }

    @Override // com.koushikdutta.ion.builder.Builders.IV.F
    public Bitmap getBitmap() {
        Drawable k4 = k();
        if (k4 == null) {
            return null;
        }
        if (k4 instanceof BitmapDrawable) {
            return ((BitmapDrawable) k4).getBitmap();
        }
        if (!(k4 instanceof j)) {
            return null;
        }
        Drawable f4 = ((j) k4).f();
        if (!(f4 instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) f4).getBitmap();
    }

    @Override // com.koushikdutta.ion.builder.Builders.IV.F
    public BitmapInfo getBitmapInfo() {
        Drawable k4 = k();
        if (k4 == null || !(k4 instanceof j)) {
            return null;
        }
        return ((j) k4).e();
    }

    protected l h() {
        if (this.f35886a == null) {
            this.f35886a = new l(d.a(this.f35756s.b().getApplicationContext()), this.f35887b);
        }
        return this.f35886a;
    }

    @Override // com.koushikdutta.ion.builder.ImageViewFutureBuilder
    public ImageViewFuture intoImageView(ImageView imageView) {
        if (imageView != null) {
            if (this.f35886a.f35942e == null) {
                l(imageView, null, ResponseServedFrom.LOADED_FROM_NETWORK).c();
                return g.f35836m;
            }
            m(imageView);
            if (this.f35758u) {
                Drawable drawable = imageView.getDrawable();
                if (drawable instanceof j) {
                    drawable = ((j) drawable).f();
                }
                placeholder(drawable);
            }
            int i4 = this.f35890e;
            int i5 = this.f35891f;
            if (i5 == 0 && i4 == 0 && !i(imageView)) {
                i4 = imageView.getMeasuredWidth();
                i5 = imageView.getMeasuredHeight();
            } else {
                addDefaultTransform();
            }
            b e4 = e(i4, i5);
            if (e4.f35792c != null) {
                i.c(imageView, null, 0);
                j l4 = l(imageView, e4, ResponseServedFrom.LOADED_FROM_MEMORY);
                l4.c();
                g o4 = g.m(this.f35756s, l4).n(this.f35752o, this.f35755r).o(this.f35889d);
                g.l(imageView, this.f35889d);
                o4.reset();
                o4.setComplete(e4.f35792c.exception, imageView);
                return o4;
            }
            j l5 = l(imageView, e4, ResponseServedFrom.LOADED_FROM_NETWORK);
            i.c(imageView, this.f35753p, this.f35754q);
            g o5 = g.m(this.f35756s, l5).n(this.f35752o, this.f35755r).o(this.f35889d);
            o5.reset();
            return o5;
        }
        throw new NullPointerException("imageView");
    }

    @Override // com.koushikdutta.ion.i, com.koushikdutta.ion.builder.BitmapFutureBuilder
    public /* bridge */ /* synthetic */ LocallyCachedStatus isLocallyCached() {
        return super.isLocallyCached();
    }

    @Override // com.koushikdutta.ion.builder.LoadImageViewFutureBuilder
    public ImageViewFuture load(String str) {
        h();
        this.f35886a.load(str);
        return intoImageView(this.f35756s.get());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IonImageViewRequestBuilder m(ImageView imageView) {
        d.C0205d c0205d = this.f35756s;
        if (c0205d == null || c0205d.get() != imageView) {
            this.f35756s = new d.C0205d(imageView);
        }
        return this;
    }

    @Override // com.koushikdutta.ion.i, com.koushikdutta.ion.builder.BitmapBuilder
    public /* bridge */ /* synthetic */ i postProcess(PostProcess postProcess) {
        return super.postProcess(postProcess);
    }

    @Override // com.koushikdutta.ion.i, com.koushikdutta.ion.builder.BitmapFutureBuilder
    public /* bridge */ /* synthetic */ void removeCachedBitmap() {
        super.removeCachedBitmap();
    }

    @Override // com.koushikdutta.ion.i, com.koushikdutta.ion.builder.BitmapBuilder
    public /* bridge */ /* synthetic */ i resize(int i4, int i5) {
        return super.resize(i4, i5);
    }

    @Override // com.koushikdutta.ion.i, com.koushikdutta.ion.builder.BitmapBuilder
    public /* bridge */ /* synthetic */ i resizeHeight(int i4) {
        return super.resizeHeight(i4);
    }

    @Override // com.koushikdutta.ion.i, com.koushikdutta.ion.builder.BitmapBuilder
    public /* bridge */ /* synthetic */ i resizeWidth(int i4) {
        return super.resizeWidth(i4);
    }

    @Override // com.koushikdutta.ion.i, com.koushikdutta.ion.builder.BitmapBuilder
    public /* bridge */ /* synthetic */ i smartSize(boolean z3) {
        return super.smartSize(z3);
    }

    @Override // com.koushikdutta.ion.i, com.koushikdutta.ion.builder.BitmapBuilder
    public /* bridge */ /* synthetic */ i transform(Transform transform) {
        return super.transform(transform);
    }

    @Override // com.koushikdutta.ion.builder.ImageViewBuilder
    public IonImageViewRequestBuilder bitmapDrawableFactory(BitmapDrawableFactory bitmapDrawableFactory) {
        this.f35759v = bitmapDrawableFactory;
        return this;
    }

    @Override // com.koushikdutta.ion.builder.ImageViewBuilder
    public IonImageViewRequestBuilder crossfade(boolean z3) {
        this.f35758u = z3;
        return this;
    }

    @Override // com.koushikdutta.ion.builder.ImageViewBuilder
    public i fadeIn(boolean z3) {
        this.f35757t = z3;
        return this;
    }

    @Override // com.koushikdutta.ion.builder.ImageViewBuilder
    public IonImageViewRequestBuilder animateIn(Animation animation) {
        this.f35752o = animation;
        return this;
    }

    @Override // com.koushikdutta.ion.builder.ImageViewBuilder
    public IonImageViewRequestBuilder animateLoad(Animation animation) {
        this.f35753p = animation;
        return this;
    }

    @Override // com.koushikdutta.ion.builder.ImageViewBuilder
    public IonImageViewRequestBuilder error(Drawable drawable) {
        this.f35750m = drawable;
        return this;
    }

    @Override // com.koushikdutta.ion.builder.ImageViewBuilder
    public IonImageViewRequestBuilder placeholder(Drawable drawable) {
        this.f35748k = drawable;
        return this;
    }

    public IonImageViewRequestBuilder(Ion ion) {
        super(ion);
        this.f35757t = true;
        this.f35759v = BitmapDrawableFactory.DEFAULT;
    }

    @Override // com.koushikdutta.ion.builder.ImageViewBuilder
    public IonImageViewRequestBuilder animateIn(int i4) {
        this.f35755r = i4;
        return this;
    }

    @Override // com.koushikdutta.ion.builder.ImageViewBuilder
    public IonImageViewRequestBuilder animateLoad(int i4) {
        this.f35754q = i4;
        return this;
    }

    @Override // com.koushikdutta.ion.builder.ImageViewBuilder
    public IonImageViewRequestBuilder error(int i4) {
        this.f35751n = i4;
        return this;
    }

    @Override // com.koushikdutta.ion.builder.LoadImageViewFutureBuilder
    public Future<ImageView> load(String str, String str2) {
        h();
        this.f35886a.load(str, str2);
        return intoImageView(this.f35756s.get());
    }

    @Override // com.koushikdutta.ion.builder.ImageViewBuilder
    public IonImageViewRequestBuilder placeholder(int i4) {
        this.f35749l = i4;
        return this;
    }
}
