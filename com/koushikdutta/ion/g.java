package com.koushikdutta.ion;

import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.koushikdutta.async.future.Cancellable;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.future.SimpleFuture;
import com.koushikdutta.async.future.TransformFuture;
import com.koushikdutta.ion.bitmap.BitmapInfo;
import com.koushikdutta.ion.d;
import com.koushikdutta.ion.future.ImageViewFuture;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImageViewFutureImpl.java */
/* loaded from: classes6.dex */
public class g extends TransformFuture<ImageView, j> implements ImageViewFuture {

    /* renamed from: m  reason: collision with root package name */
    public static final g f35836m = new a();

    /* renamed from: i  reason: collision with root package name */
    private p f35837i;

    /* renamed from: j  reason: collision with root package name */
    private Animation f35838j;

    /* renamed from: k  reason: collision with root package name */
    private int f35839k;

    /* renamed from: l  reason: collision with root package name */
    private d.C0205d f35840l;

    /* compiled from: ImageViewFutureImpl.java */
    /* loaded from: classes6.dex */
    static class a extends g {
        a() {
            setComplete((Exception) new NullPointerException("uri"));
        }

        @Override // com.koushikdutta.ion.g, com.koushikdutta.async.future.TransformFuture
        protected /* bridge */ /* synthetic */ void k(j jVar) throws Exception {
            super.k(jVar);
        }
    }

    /* compiled from: ImageViewFutureImpl.java */
    /* loaded from: classes6.dex */
    class b implements FutureCallback<ImageView> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SimpleFuture f35841a;

        b(SimpleFuture simpleFuture) {
            this.f35841a = simpleFuture;
        }

        @Override // com.koushikdutta.async.future.FutureCallback
        /* renamed from: a */
        public void onCompleted(Exception exc, ImageView imageView) {
            Drawable drawable;
            ImageViewBitmapInfo imageViewBitmapInfo = new ImageViewBitmapInfo();
            if (imageView != null) {
                drawable = imageView.getDrawable();
            } else {
                drawable = null;
            }
            if (drawable instanceof j) {
                imageViewBitmapInfo.f35717c = ((j) drawable).e();
            }
            imageViewBitmapInfo.f35715a = exc;
            imageViewBitmapInfo.f35716b = imageView;
            this.f35841a.setComplete((SimpleFuture) imageViewBitmapInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ImageViewFutureImpl.java */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f35843a;

        static {
            int[] iArr = new int[p.values().length];
            f35843a = iArr;
            try {
                iArr[p.CenterCrop.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35843a[p.FitCenter.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f35843a[p.CenterInside.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f35843a[p.FitXY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    g() {
    }

    public static void l(ImageView imageView, p pVar) {
        if (pVar == null) {
            return;
        }
        int i4 = c.f35843a[pVar.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 == 4) {
                        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        return;
                    }
                    return;
                }
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                return;
            }
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            return;
        }
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    public static g m(d.C0205d c0205d, j jVar) {
        g gVar;
        if (jVar.g() instanceof g) {
            gVar = (g) jVar.g();
        } else {
            gVar = new g();
        }
        jVar.o(gVar);
        gVar.f35840l = c0205d;
        return gVar;
    }

    public g n(Animation animation, int i4) {
        this.f35838j = animation;
        this.f35839k = i4;
        return this;
    }

    public g o(p pVar) {
        this.f35837i = pVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.koushikdutta.async.future.TransformFuture
    /* renamed from: p */
    public void k(j jVar) throws Exception {
        ImageView imageView = this.f35840l.get();
        if (this.f35840l.c() == null && imageView != null) {
            if (imageView.getDrawable() != jVar) {
                cancelSilently();
                return;
            }
            BitmapInfo e4 = jVar.e();
            if (e4 != null && e4.exception == null) {
                l(imageView, this.f35837i);
            }
            i.c(imageView, this.f35838j, this.f35839k);
            imageView.setImageDrawable(null);
            imageView.setImageDrawable(jVar);
            setComplete((g) imageView);
            return;
        }
        cancelSilently();
    }

    @Override // com.koushikdutta.ion.future.ImageViewFuture
    public Future<ImageViewBitmapInfo> withBitmapInfo() {
        SimpleFuture simpleFuture = new SimpleFuture();
        setCallback((FutureCallback) new b(simpleFuture));
        simpleFuture.setParent((Cancellable) this);
        return simpleFuture;
    }
}
