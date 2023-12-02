package com.koushikdutta.ion;

import android.graphics.Bitmap;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.SimpleFuture;
import com.koushikdutta.async.util.FileCache;
import com.koushikdutta.ion.bitmap.BitmapInfo;
import com.koushikdutta.ion.bitmap.LocallyCachedStatus;
import com.koushikdutta.ion.bitmap.PostProcess;
import com.koushikdutta.ion.bitmap.Transform;
import com.koushikdutta.ion.builder.AnimateGifMode;
import com.koushikdutta.ion.builder.BitmapFutureBuilder;
import com.koushikdutta.ion.builder.Builders;
import com.koushikdutta.ion.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IonBitmapRequestBuilder.java */
/* loaded from: classes6.dex */
public abstract class i implements BitmapFutureBuilder, Builders.Any.BF {

    /* renamed from: j  reason: collision with root package name */
    private static final SimpleFuture<Bitmap> f35885j = new a();

    /* renamed from: a  reason: collision with root package name */
    l f35886a;

    /* renamed from: b  reason: collision with root package name */
    Ion f35887b;

    /* renamed from: c  reason: collision with root package name */
    ArrayList<Transform> f35888c;

    /* renamed from: d  reason: collision with root package name */
    p f35889d;

    /* renamed from: e  reason: collision with root package name */
    int f35890e;

    /* renamed from: f  reason: collision with root package name */
    int f35891f;

    /* renamed from: g  reason: collision with root package name */
    AnimateGifMode f35892g = AnimateGifMode.ANIMATE;

    /* renamed from: h  reason: collision with root package name */
    boolean f35893h;

    /* renamed from: i  reason: collision with root package name */
    ArrayList<PostProcess> f35894i;

    /* compiled from: IonBitmapRequestBuilder.java */
    /* loaded from: classes6.dex */
    static class a extends SimpleFuture<Bitmap> {
        a() {
            setComplete((Exception) new NullPointerException("uri"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IonBitmapRequestBuilder.java */
    /* loaded from: classes6.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.koushikdutta.ion.b f35895a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f35896b;

        b(com.koushikdutta.ion.b bVar, c cVar) {
            this.f35895a = bVar;
            this.f35896b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f35895a.c();
            i.this.f35887b.f35737s.add(this.f35895a.f35791b, this.f35896b);
        }
    }

    public i(l lVar) {
        this.f35886a = lVar;
        this.f35887b = lVar.f35938a;
    }

    private void a(String str) {
        if (!f()) {
            return;
        }
        throw new IllegalStateException("Can't apply " + str + " after transform has been called." + str + " is applied to the original resized bitmap.");
    }

    private String b() {
        boolean z3;
        l lVar = this.f35886a;
        int i4 = this.f35890e;
        int i5 = this.f35891f;
        if (this.f35892g != AnimateGifMode.NO_ANIMATE) {
            z3 = true;
        } else {
            z3 = false;
        }
        return computeDecodeKey(lVar, i4, i5, z3, this.f35893h);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(ImageView imageView, Animation animation, int i4) {
        if (imageView == null) {
            return;
        }
        if (animation == null && i4 != 0) {
            animation = AnimationUtils.loadAnimation(imageView.getContext(), i4);
        }
        if (animation == null) {
            imageView.setAnimation(null);
        } else {
            imageView.startAnimation(animation);
        }
    }

    public static String computeDecodeKey(l lVar, int i4, int i5, boolean z3, boolean z4) {
        String str = lVar.f35942e + "resize=" + i4 + "," + i5;
        if (!z3) {
            str = str + ":noAnimate";
        }
        if (z4) {
            str = str + ":deepZoom";
        }
        return FileCache.toKeyString(str);
    }

    public void addDefaultTransform() {
        if (this.f35891f <= 0 && this.f35890e <= 0) {
            if (this.f35889d != null) {
                throw new IllegalStateException("Must call resize when using " + this.f35889d);
            }
            return;
        }
        if (this.f35888c == null) {
            this.f35888c = new ArrayList<>();
        }
        this.f35888c.add(0, new f(this.f35890e, this.f35891f, this.f35889d));
    }

    @Override // com.koushikdutta.ion.builder.BitmapFutureBuilder
    public Future<Bitmap> asBitmap() {
        if (this.f35886a.f35942e == null) {
            return f35885j;
        }
        addDefaultTransform();
        com.koushikdutta.ion.b d4 = d();
        if (d4.f35792c != null) {
            SimpleFuture simpleFuture = new SimpleFuture();
            BitmapInfo bitmapInfo = d4.f35792c;
            simpleFuture.setComplete(bitmapInfo.exception, bitmapInfo.bitmap);
            return simpleFuture;
        }
        c cVar = new c(this.f35886a.f35939b);
        AsyncServer.post(Ion.f35718z, new b(d4, cVar));
        return cVar;
    }

    @Override // com.koushikdutta.ion.builder.BitmapFutureBuilder
    public BitmapInfo asCachedBitmap() {
        String b4 = b();
        addDefaultTransform();
        return this.f35886a.f35938a.f35739u.get(computeBitmapKey(b4));
    }

    public String computeBitmapKey(String str) {
        return computeBitmapKey(str, this.f35888c);
    }

    com.koushikdutta.ion.b d() {
        return e(this.f35890e, this.f35891f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.koushikdutta.ion.b e(int i4, int i5) {
        boolean z3;
        BitmapInfo bitmapInfo;
        String b4 = b();
        String computeBitmapKey = computeBitmapKey(b4);
        com.koushikdutta.ion.b bVar = new com.koushikdutta.ion.b();
        bVar.f35791b = computeBitmapKey;
        bVar.f35790a = b4;
        bVar.f35793d = f();
        bVar.f35796g = i4;
        bVar.f35797h = i5;
        l lVar = this.f35886a;
        bVar.f35795f = lVar;
        bVar.f35794e = this.f35888c;
        if (this.f35892g != AnimateGifMode.NO_ANIMATE) {
            z3 = true;
        } else {
            z3 = false;
        }
        bVar.f35798i = z3;
        bVar.f35799j = this.f35893h;
        bVar.f35800k = this.f35894i;
        if (!lVar.f35945h && (bitmapInfo = lVar.f35938a.f35739u.get(computeBitmapKey)) != null) {
            bVar.f35792c = bitmapInfo;
        }
        return bVar;
    }

    boolean f() {
        ArrayList<Transform> arrayList = this.f35888c;
        if (arrayList != null && arrayList.size() > 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        this.f35887b = null;
        this.f35888c = null;
        this.f35889d = null;
        this.f35890e = 0;
        this.f35891f = 0;
        this.f35892g = AnimateGifMode.ANIMATE;
        this.f35886a = null;
        this.f35893h = false;
        this.f35894i = null;
    }

    @Override // com.koushikdutta.ion.builder.BitmapFutureBuilder
    public LocallyCachedStatus isLocallyCached() {
        if (!this.f35886a.f35945h && !this.f35893h) {
            String b4 = b();
            addDefaultTransform();
            String computeBitmapKey = computeBitmapKey(b4);
            BitmapInfo bitmapInfo = this.f35886a.f35938a.f35739u.get(computeBitmapKey);
            if (bitmapInfo != null && bitmapInfo.exception == null) {
                return LocallyCachedStatus.CACHED;
            }
            FileCache fileCache = this.f35887b.f35722d.getFileCache();
            if (f() && fileCache.exists(computeBitmapKey)) {
                return LocallyCachedStatus.CACHED;
            }
            if (fileCache.exists(b4)) {
                return LocallyCachedStatus.MAYBE_CACHED;
            }
            return LocallyCachedStatus.NOT_CACHED;
        }
        return LocallyCachedStatus.NOT_CACHED;
    }

    @Override // com.koushikdutta.ion.builder.BitmapFutureBuilder
    public void removeCachedBitmap() {
        String b4 = b();
        addDefaultTransform();
        String computeBitmapKey = computeBitmapKey(b4);
        this.f35887b.f35722d.getFileCache().remove(b4);
        this.f35887b.f35722d.getFileCache().remove(computeBitmapKey);
        this.f35886a.f35938a.f35739u.remove(computeBitmapKey);
        this.f35886a.f35938a.f35739u.remove(b4);
    }

    public static String computeBitmapKey(String str, List<Transform> list) {
        Iterator<Transform> it;
        if (list == null || list.size() <= 0) {
            return str;
        }
        while (list.iterator().hasNext()) {
            str = str + it.next().key();
        }
        return FileCache.toKeyString(str);
    }

    public i animateGif(AnimateGifMode animateGifMode) {
        this.f35892g = animateGifMode;
        return this;
    }

    public i centerCrop() {
        a("centerCrop");
        this.f35889d = p.CenterCrop;
        return this;
    }

    public i centerInside() {
        a("centerInside");
        this.f35889d = p.CenterInside;
        return this;
    }

    public i deepZoom() {
        this.f35893h = true;
        if (this.f35890e <= 0 && this.f35891f <= 0) {
            if (!f()) {
                this.f35890e = 0;
                this.f35891f = 0;
                return this;
            }
            throw new IllegalStateException("Can't deepZoom with transforms.");
        }
        throw new IllegalStateException("Can't deepZoom with resize.");
    }

    public i fitCenter() {
        a("fitCenter");
        this.f35889d = p.FitCenter;
        return this;
    }

    public i fitXY() {
        a("fitXY");
        this.f35889d = p.FitXY;
        return this;
    }

    public i postProcess(PostProcess postProcess) {
        if (this.f35894i == null) {
            this.f35894i = new ArrayList<>();
        }
        this.f35894i.add(postProcess);
        return transform((Transform) new q.b(postProcess.key()));
    }

    public i resize(int i4, int i5) {
        if (!f()) {
            if (!this.f35893h) {
                this.f35890e = i4;
                this.f35891f = i5;
                return this;
            }
            throw new IllegalStateException("Can not resize with deepZoom.");
        }
        throw new IllegalStateException("Can't apply resize after transform has been called.resize is applied to the original bitmap.");
    }

    public i resizeHeight(int i4) {
        return resize(0, i4);
    }

    public i resizeWidth(int i4) {
        return resize(i4, 0);
    }

    public i smartSize(boolean z3) {
        if (this.f35890e <= 0 && this.f35891f <= 0) {
            if (this.f35893h) {
                throw new IllegalStateException("Can not smartSize with deepZoom.");
            }
            if (!z3) {
                this.f35890e = -1;
                this.f35891f = -1;
            } else {
                this.f35890e = 0;
                this.f35891f = 0;
            }
            return this;
        }
        throw new IllegalStateException("Can't set smart size after resize has been called.");
    }

    public i transform(Transform transform) {
        if (transform == null) {
            return this;
        }
        if (this.f35888c == null) {
            this.f35888c = new ArrayList<>();
        }
        this.f35888c.add(transform);
        return this;
    }

    public i(Ion ion) {
        this.f35887b = ion;
    }
}
