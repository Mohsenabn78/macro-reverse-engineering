package com.koushikdutta.ion;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.ImageView;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.util.FileCache;
import com.koushikdutta.ion.bitmap.BitmapInfo;
import com.koushikdutta.ion.gif.GifDecoder;
import com.koushikdutta.ion.gif.GifFrame;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IonDrawable.java */
/* loaded from: classes6.dex */
public class j extends LayerDrawable {
    private static final double A = Math.log(2.0d);

    /* renamed from: a  reason: collision with root package name */
    private Paint f35898a;

    /* renamed from: b  reason: collision with root package name */
    private int f35899b;

    /* renamed from: c  reason: collision with root package name */
    private BitmapInfo f35900c;

    /* renamed from: d  reason: collision with root package name */
    private int f35901d;

    /* renamed from: e  reason: collision with root package name */
    private Drawable f35902e;

    /* renamed from: f  reason: collision with root package name */
    private int f35903f;

    /* renamed from: g  reason: collision with root package name */
    private Drawable f35904g;

    /* renamed from: h  reason: collision with root package name */
    private Resources f35905h;

    /* renamed from: i  reason: collision with root package name */
    private ResponseServedFrom f35906i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f35907j;

    /* renamed from: k  reason: collision with root package name */
    private int f35908k;

    /* renamed from: l  reason: collision with root package name */
    private int f35909l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f35910m;

    /* renamed from: n  reason: collision with root package name */
    private Ion f35911n;

    /* renamed from: o  reason: collision with root package name */
    private com.koushikdutta.ion.b f35912o;

    /* renamed from: p  reason: collision with root package name */
    private b f35913p;

    /* renamed from: q  reason: collision with root package name */
    private FutureCallback<j> f35914q;

    /* renamed from: r  reason: collision with root package name */
    private c f35915r;

    /* renamed from: s  reason: collision with root package name */
    private Drawable f35916s;

    /* renamed from: t  reason: collision with root package name */
    private int f35917t;

    /* renamed from: u  reason: collision with root package name */
    private int f35918u;

    /* renamed from: v  reason: collision with root package name */
    private BitmapDrawableFactory f35919v;

    /* renamed from: w  reason: collision with root package name */
    private final Drawable f35920w;

    /* renamed from: x  reason: collision with root package name */
    private final Drawable f35921x;

    /* renamed from: y  reason: collision with root package name */
    private final Drawable f35922y;

    /* renamed from: z  reason: collision with root package name */
    private FutureCallback<BitmapInfo> f35923z;

    /* compiled from: IonDrawable.java */
    /* loaded from: classes6.dex */
    class a implements FutureCallback<BitmapInfo> {
        a() {
        }

        @Override // com.koushikdutta.async.future.FutureCallback
        /* renamed from: a */
        public void onCompleted(Exception exc, BitmapInfo bitmapInfo) {
            j.this.invalidateSelf();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IonDrawable.java */
    /* loaded from: classes6.dex */
    public static class b implements FutureCallback<BitmapInfo> {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<j> f35925a;

        /* renamed from: b  reason: collision with root package name */
        private String f35926b;

        /* renamed from: c  reason: collision with root package name */
        private Ion f35927c;

        public b(j jVar) {
            this.f35925a = new WeakReference<>(jVar);
        }

        private void c(Ion ion, String str) {
            if (str == null) {
                return;
            }
            if (ion.f35737s.removeItem(str, this)) {
                Object tag = ion.f35737s.tag(str);
                if (tag instanceof q) {
                    q qVar = (q) tag;
                    ion.f35737s.remove(qVar.f35780a);
                    if (ion.f35737s.removeItem(qVar.f36106f, qVar)) {
                        tag = ion.f35737s.tag(qVar.f36106f);
                    }
                }
                if (tag instanceof DeferredLoadBitmap) {
                    ion.f35737s.remove(((DeferredLoadBitmap) tag).f35780a);
                }
            }
            ion.d();
        }

        @Override // com.koushikdutta.async.future.FutureCallback
        /* renamed from: a */
        public void onCompleted(Exception exc, BitmapInfo bitmapInfo) {
            j jVar = this.f35925a.get();
            if (jVar == null) {
                return;
            }
            jVar.j(bitmapInfo, bitmapInfo.servedFrom).v();
            FutureCallback futureCallback = jVar.f35914q;
            if (futureCallback != null) {
                futureCallback.onCompleted(exc, jVar);
            }
        }

        public void b(Ion ion, String str) {
            String str2 = this.f35926b;
            Ion ion2 = this.f35927c;
            if (TextUtils.equals(str2, str) && this.f35927c == ion) {
                return;
            }
            this.f35927c = ion;
            this.f35926b = str;
            if (ion != null) {
                ion.f35737s.add(str, this);
            }
            c(ion2, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IonDrawable.java */
    /* loaded from: classes6.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        GifDecoder f35928a;

        /* renamed from: b  reason: collision with root package name */
        Exception f35929b;

        /* renamed from: c  reason: collision with root package name */
        GifFrame f35930c;

        /* renamed from: d  reason: collision with root package name */
        long f35931d;

        /* renamed from: e  reason: collision with root package name */
        Runnable f35932e = new a();

        /* renamed from: f  reason: collision with root package name */
        Runnable f35933f = new b();

        /* renamed from: g  reason: collision with root package name */
        boolean f35934g;

        /* compiled from: IonDrawable.java */
        /* loaded from: classes6.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    c.this.f35928a.nextFrame();
                } catch (Exception e4) {
                    c.this.f35929b = e4;
                } catch (OutOfMemoryError e5) {
                    c.this.f35929b = new Exception(e5);
                }
                Ion.f35718z.post(c.this.f35933f);
            }
        }

        /* compiled from: IonDrawable.java */
        /* loaded from: classes6.dex */
        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c cVar = c.this;
                cVar.f35934g = false;
                j.this.invalidateSelf();
            }
        }

        public c(BitmapInfo bitmapInfo) {
            GifDecoder mutate = bitmapInfo.gifDecoder.mutate();
            this.f35928a = mutate;
            this.f35930c = mutate.getLastFrame();
        }

        public GifFrame a() {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f35931d == 0) {
                this.f35931d = b() + currentTimeMillis;
                c();
            }
            if (currentTimeMillis >= this.f35931d) {
                if (this.f35928a.getLastFrame() != this.f35930c) {
                    this.f35930c = this.f35928a.getLastFrame();
                    if (currentTimeMillis > this.f35931d + b()) {
                        this.f35931d = currentTimeMillis + b();
                    } else {
                        this.f35931d += b();
                    }
                }
                c();
            }
            return this.f35930c;
        }

        long b() {
            GifFrame gifFrame = this.f35930c;
            if (gifFrame == null) {
                return 100L;
            }
            long j4 = gifFrame.delay;
            if (j4 == 0) {
                return 100L;
            }
            return j4;
        }

        public synchronized void c() {
            if (this.f35934g) {
                return;
            }
            if (this.f35929b != null) {
                return;
            }
            if (this.f35928a.getStatus() == -1 && j.this.f35910m) {
                this.f35928a.restart();
            }
            this.f35934g = true;
            Ion.getBitmapLoadExecutorService().execute(this.f35932e);
        }
    }

    public j(Resources resources) {
        super(new Drawable[]{new BitmapDrawable((Bitmap) null), new BitmapDrawable((Bitmap) null), new BitmapDrawable((Bitmap) null)});
        this.f35899b = 255;
        this.f35923z = new a();
        setId(0, 0);
        setId(1, 1);
        setId(2, 2);
        this.f35920w = getDrawable(0);
        this.f35921x = getDrawable(1);
        this.f35922y = getDrawable(2);
        this.f35905h = resources;
        this.f35898a = new Paint(6);
        this.f35913p = new b(this);
    }

    private void d(Canvas canvas) {
        int i4;
        int i5;
        Rect rect;
        int i6;
        int i7;
        int i8;
        Rect rect2;
        int i9;
        BitmapInfo bitmapInfo;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        BitmapInfo bitmapInfo2;
        int i16;
        Bitmap bitmap;
        Rect clipBounds = canvas.getClipBounds();
        Rect bounds = getBounds();
        float width = canvas.getWidth() / clipBounds.width();
        double log = Math.log((bounds.width() * width) / 256.0f);
        double d4 = A;
        double max = Math.max(log / d4, Math.log((width * bounds.height()) / 256.0f) / d4);
        int max2 = Math.max(0, clipBounds.left);
        int min = Math.min(bounds.width(), clipBounds.right);
        int max3 = Math.max(0, clipBounds.top);
        int min2 = Math.min(bounds.height(), clipBounds.bottom);
        int max4 = Math.max(Math.min(this.f35918u, (int) Math.floor(max)), 0);
        int i17 = 1 << max4;
        int i18 = this.f35917t / i17;
        Bitmap bitmap2 = this.f35900c.bitmap;
        if (bitmap2 != null) {
            canvas.drawBitmap(bitmap2, (Rect) null, getBounds(), this.f35898a);
        } else {
            this.f35898a.setColor(-16777216);
            canvas.drawRect(getBounds(), this.f35898a);
        }
        int i19 = 1;
        while (i18 / i19 > 256) {
            i19 <<= 1;
        }
        int i20 = 0;
        while (i20 < i17) {
            int i21 = i18 * i20;
            int i22 = i20 + 1;
            int min3 = Math.min(i18 * i22, bounds.bottom);
            if (min3 >= max3) {
                if (i21 <= min2) {
                    int i23 = 0;
                    while (i23 < i17) {
                        int i24 = i18 * i23;
                        int i25 = i23 + 1;
                        i4 = min2;
                        i5 = max3;
                        int min4 = Math.min(i18 * i25, bounds.right);
                        if (min4 < max2) {
                            rect2 = bounds;
                            i15 = max4;
                            i9 = min3;
                        } else if (i24 > min) {
                            rect = bounds;
                            i6 = max4;
                            i7 = max2;
                            i8 = min;
                            break;
                        } else {
                            Rect rect3 = new Rect(i24, i21, min4, min3);
                            String str = ",";
                            String keyString = FileCache.toKeyString(this.f35900c.key, ",", Integer.valueOf(max4), ",", Integer.valueOf(i23), ",", Integer.valueOf(i20));
                            rect2 = bounds;
                            BitmapInfo bitmapInfo3 = this.f35911n.f35739u.get(keyString);
                            i9 = min3;
                            if (bitmapInfo3 != null && (bitmap = bitmapInfo3.bitmap) != null) {
                                canvas.drawBitmap(bitmap, (Rect) null, rect3, this.f35898a);
                                i15 = max4;
                            } else {
                                if (this.f35911n.f35737s.tag(keyString) == null) {
                                    bitmapInfo = bitmapInfo3;
                                    i10 = max2;
                                    i11 = min;
                                    i12 = i23;
                                    new LoadBitmapRegion(this.f35911n, keyString, this.f35900c.decoder, rect3, i19);
                                } else {
                                    bitmapInfo = bitmapInfo3;
                                    i10 = max2;
                                    i11 = min;
                                    i12 = i23;
                                }
                                this.f35911n.f35737s.add(keyString, this.f35923z);
                                int i26 = max4 - 1;
                                if (i12 % 2 == 1) {
                                    i13 = 1;
                                } else {
                                    i13 = 0;
                                }
                                if (i20 % 2 == 1) {
                                    i14 = 1;
                                } else {
                                    i14 = 0;
                                }
                                int i27 = i12 >> 1;
                                int i28 = i20 >> 1;
                                int i29 = 1;
                                while (true) {
                                    i15 = max4;
                                    if (i26 >= 0) {
                                        bitmapInfo2 = this.f35911n.f35739u.get(FileCache.toKeyString(this.f35900c.key, str, Integer.valueOf(i26), str, Integer.valueOf(i27), str, Integer.valueOf(i28)));
                                        if (bitmapInfo2 != null && bitmapInfo2.bitmap != null) {
                                            break;
                                        }
                                        String str2 = str;
                                        if (i27 % 2 == 1) {
                                            i13 += 1 << i29;
                                        }
                                        if (i28 % 2 == 1) {
                                            i14 += 1 << i29;
                                        }
                                        i26--;
                                        i29++;
                                        i27 >>= 1;
                                        i28 >>= 1;
                                        bitmapInfo = bitmapInfo2;
                                        max4 = i15;
                                        str = str2;
                                    } else {
                                        bitmapInfo2 = bitmapInfo;
                                        break;
                                    }
                                }
                                if (bitmapInfo2 != null && bitmapInfo2.bitmap != null) {
                                    int i30 = this.f35917t / (1 << i26);
                                    int i31 = 1;
                                    while (true) {
                                        i16 = i30 / i31;
                                        if (i16 <= 256) {
                                            break;
                                        }
                                        i31 <<= 1;
                                    }
                                    int i32 = i16 >> i29;
                                    int i33 = i13 * i32;
                                    int i34 = i14 * i32;
                                    canvas.drawBitmap(bitmapInfo2.bitmap, new Rect(i33, i34, i33 + i32, i32 + i34), rect3, this.f35898a);
                                }
                                max4 = i15;
                                i23 = i25;
                                min2 = i4;
                                max3 = i5;
                                bounds = rect2;
                                min3 = i9;
                                max2 = i10;
                                min = i11;
                            }
                        }
                        i10 = max2;
                        i11 = min;
                        max4 = i15;
                        i23 = i25;
                        min2 = i4;
                        max3 = i5;
                        bounds = rect2;
                        min3 = i9;
                        max2 = i10;
                        min = i11;
                    }
                } else {
                    return;
                }
            }
            i4 = min2;
            rect = bounds;
            i6 = max4;
            i7 = max2;
            i8 = min;
            i5 = max3;
            max4 = i6;
            i20 = i22;
            min2 = i4;
            max3 = i5;
            bounds = rect;
            max2 = i7;
            min = i8;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j h(ImageView imageView) {
        j jVar;
        Drawable drawable = imageView.getDrawable();
        if (drawable != null && (drawable instanceof j)) {
            jVar = (j) drawable;
        } else {
            jVar = new j(imageView.getResources());
        }
        imageView.setImageDrawable(null);
        return jVar;
    }

    private Drawable s() {
        Bitmap bitmap;
        Drawable drawable = this.f35916s;
        if (drawable != null) {
            return drawable;
        }
        BitmapInfo bitmapInfo = this.f35900c;
        if (bitmapInfo == null || bitmapInfo.gifDecoder != null || bitmapInfo.decoder != null || (bitmap = bitmapInfo.bitmap) == null) {
            return null;
        }
        Drawable fromBitmap = this.f35919v.fromBitmap(this.f35905h, bitmap);
        this.f35916s = fromBitmap;
        return fromBitmap;
    }

    private Drawable t() {
        Drawable drawable = this.f35904g;
        if (drawable != null) {
            return drawable;
        }
        int i4 = this.f35903f;
        if (i4 == 0) {
            return null;
        }
        Drawable drawable2 = this.f35905h.getDrawable(i4);
        this.f35904g = drawable2;
        return drawable2;
    }

    private Drawable u() {
        Drawable drawable = this.f35902e;
        if (drawable != null) {
            return drawable;
        }
        int i4 = this.f35901d;
        if (i4 == 0) {
            return null;
        }
        Drawable drawable2 = this.f35905h.getDrawable(i4);
        this.f35902e = drawable2;
        return drawable2;
    }

    public void c() {
        this.f35913p.b(null, null);
        this.f35912o = null;
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        BitmapInfo bitmapInfo = this.f35900c;
        if (bitmapInfo == null) {
            super.draw(canvas);
            com.koushikdutta.ion.b bVar = this.f35912o;
            if (bVar != null) {
                if (bVar.f35796g == 0 && bVar.f35797h == 0) {
                    if (canvas.getWidth() != 1) {
                        this.f35912o.f35796g = canvas.getWidth();
                    }
                    if (canvas.getHeight() != 1) {
                        this.f35912o.f35797h = canvas.getHeight();
                    }
                    this.f35912o.f();
                    BitmapInfo bitmapInfo2 = this.f35911n.f35739u.get(this.f35912o.f35791b);
                    if (bitmapInfo2 != null) {
                        this.f35912o = null;
                        this.f35913p.onCompleted(null, bitmapInfo2);
                        return;
                    }
                }
                this.f35913p.b(this.f35911n, this.f35912o.f35791b);
                if (com.koushikdutta.ion.b.g(this.f35911n)) {
                    this.f35912o.b();
                } else {
                    this.f35912o.c();
                }
                this.f35912o = null;
            }
        } else if (bitmapInfo.decoder != null) {
            d(canvas);
        } else {
            if (bitmapInfo.drawTime == 0) {
                bitmapInfo.drawTime = SystemClock.uptimeMillis();
            }
            long j4 = this.f35899b;
            if (this.f35907j) {
                j4 = Math.min(((SystemClock.uptimeMillis() - this.f35900c.drawTime) << 8) / 200, this.f35899b);
            }
            if (j4 == this.f35899b) {
                if (this.f35902e != null) {
                    this.f35902e = null;
                    setDrawableByLayerId(0, this.f35920w);
                }
            } else if (this.f35902e != null) {
                invalidateSelf();
            }
            BitmapInfo bitmapInfo3 = this.f35900c;
            if (bitmapInfo3.gifDecoder != null) {
                super.draw(canvas);
                GifFrame a4 = this.f35915r.a();
                if (a4 != null) {
                    this.f35898a.setAlpha((int) j4);
                    canvas.drawBitmap(a4.image, (Rect) null, getBounds(), this.f35898a);
                    this.f35898a.setAlpha(this.f35899b);
                    invalidateSelf();
                    return;
                }
                return;
            }
            if (bitmapInfo3.bitmap != null) {
                Drawable drawable = this.f35916s;
                if (drawable != null) {
                    drawable.setAlpha((int) j4);
                }
            } else {
                Drawable drawable2 = this.f35904g;
                if (drawable2 != null) {
                    drawable2.setAlpha((int) j4);
                }
            }
            super.draw(canvas);
        }
    }

    public BitmapInfo e() {
        return this.f35900c;
    }

    public Drawable f() {
        int i4;
        BitmapInfo bitmapInfo = this.f35900c;
        if (bitmapInfo == null && (i4 = this.f35901d) != 0) {
            return this.f35905h.getDrawable(i4);
        }
        if (bitmapInfo != null) {
            if (bitmapInfo.bitmap != null) {
                return new BitmapDrawable(this.f35905h, this.f35900c.bitmap);
            }
            GifDecoder gifDecoder = bitmapInfo.gifDecoder;
            if (gifDecoder != null) {
                GifFrame lastFrame = gifDecoder.getLastFrame();
                if (lastFrame != null) {
                    return new BitmapDrawable(this.f35905h, lastFrame.image);
                }
                int i5 = this.f35901d;
                if (i5 == 0) {
                    return null;
                }
                return this.f35905h.getDrawable(i5);
            }
        }
        int i6 = this.f35903f;
        if (i6 == 0) {
            return null;
        }
        return this.f35905h.getDrawable(i6);
    }

    public FutureCallback<j> g() {
        return this.f35914q;
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable t3;
        BitmapInfo bitmapInfo = this.f35900c;
        if (bitmapInfo != null) {
            if (bitmapInfo.decoder != null) {
                return bitmapInfo.originalSize.y;
            }
            Bitmap bitmap = bitmapInfo.bitmap;
            if (bitmap != null) {
                return bitmap.getScaledHeight(this.f35905h.getDisplayMetrics().densityDpi);
            }
        }
        c cVar = this.f35915r;
        if (cVar != null) {
            return cVar.f35928a.getHeight();
        }
        int i4 = this.f35909l;
        if (i4 > 0) {
            return i4;
        }
        if (bitmapInfo != null && (t3 = t()) != null) {
            return t3.getIntrinsicHeight();
        }
        Drawable u3 = u();
        if (u3 != null) {
            return u3.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable t3;
        BitmapInfo bitmapInfo = this.f35900c;
        if (bitmapInfo != null) {
            if (bitmapInfo.decoder != null) {
                return bitmapInfo.originalSize.x;
            }
            Bitmap bitmap = bitmapInfo.bitmap;
            if (bitmap != null) {
                return bitmap.getScaledWidth(this.f35905h.getDisplayMetrics().densityDpi);
            }
        }
        c cVar = this.f35915r;
        if (cVar != null) {
            return cVar.f35928a.getWidth();
        }
        int i4 = this.f35908k;
        if (i4 > 0) {
            return i4;
        }
        if (bitmapInfo != null && (t3 = t()) != null) {
            return t3.getIntrinsicWidth();
        }
        Drawable u3 = u();
        if (u3 != null) {
            return u3.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public int getOpacity() {
        Bitmap bitmap;
        BitmapInfo bitmapInfo = this.f35900c;
        if (bitmapInfo != null && (bitmap = bitmapInfo.bitmap) != null && !bitmap.hasAlpha() && this.f35898a.getAlpha() >= 255) {
            return super.getOpacity();
        }
        return -3;
    }

    public j i(Ion ion) {
        if (ion != null) {
            this.f35911n = ion;
            return this;
        }
        throw new AssertionError("null ion");
    }

    public j j(BitmapInfo bitmapInfo, ResponseServedFrom responseServedFrom) {
        if (this.f35900c == bitmapInfo) {
            return this;
        }
        c();
        this.f35906i = responseServedFrom;
        this.f35900c = bitmapInfo;
        this.f35915r = null;
        this.f35916s = null;
        invalidateSelf();
        if (bitmapInfo == null) {
            return this;
        }
        if (bitmapInfo.decoder != null) {
            Point point = bitmapInfo.originalSize;
            int ceil = (int) Math.ceil(Math.log(Math.max(point.x / 256.0d, point.y / 256.0d)) / A);
            this.f35918u = ceil;
            this.f35917t = 256 << ceil;
        } else if (bitmapInfo.gifDecoder != null) {
            this.f35915r = new c(bitmapInfo);
        }
        return this;
    }

    public j k(BitmapDrawableFactory bitmapDrawableFactory) {
        this.f35919v = bitmapDrawableFactory;
        return this;
    }

    public j l(com.koushikdutta.ion.b bVar) {
        this.f35912o = bVar;
        if (this.f35911n != null) {
            return this;
        }
        throw new AssertionError("null ion");
    }

    public j m(int i4, Drawable drawable) {
        if ((drawable != null && drawable == this.f35904g) || (i4 != 0 && i4 == this.f35903f)) {
            return this;
        }
        this.f35903f = i4;
        this.f35904g = drawable;
        return this;
    }

    public j n(boolean z3) {
        this.f35907j = z3;
        return this;
    }

    public j o(FutureCallback<j> futureCallback) {
        this.f35914q = futureCallback;
        return this;
    }

    public j p(int i4, Drawable drawable) {
        if ((drawable != null && drawable == this.f35902e) || (i4 != 0 && i4 == this.f35901d)) {
            return this;
        }
        this.f35901d = i4;
        this.f35902e = drawable;
        return this;
    }

    public j q(boolean z3) {
        this.f35910m = z3;
        return this;
    }

    public j r(int i4, int i5) {
        if (this.f35908k == i4 && this.f35909l == i5) {
            return this;
        }
        this.f35908k = i4;
        this.f35909l = i5;
        invalidateSelf();
        return this;
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int i4) {
        super.setAlpha(i4);
        this.f35899b = i4;
        this.f35898a.setAlpha(i4);
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
        this.f35898a.setColorFilter(colorFilter);
    }

    public j v() {
        u();
        Drawable drawable = this.f35902e;
        if (drawable == null) {
            setDrawableByLayerId(0, this.f35920w);
        } else {
            setDrawableByLayerId(0, drawable);
        }
        BitmapInfo bitmapInfo = this.f35900c;
        if (bitmapInfo == null) {
            setDrawableByLayerId(1, this.f35921x);
            setDrawableByLayerId(2, this.f35922y);
            return this;
        } else if (bitmapInfo.bitmap == null && bitmapInfo.decoder == null && bitmapInfo.gifDecoder == null) {
            setDrawableByLayerId(1, this.f35921x);
            t();
            Drawable drawable2 = this.f35904g;
            if (drawable2 == null) {
                setDrawableByLayerId(2, this.f35922y);
            } else {
                setDrawableByLayerId(2, drawable2);
            }
            return this;
        } else {
            if (bitmapInfo.decoder == null && bitmapInfo.gifDecoder == null) {
                s();
                setDrawableByLayerId(1, this.f35916s);
            } else {
                setDrawableByLayerId(1, this.f35921x);
            }
            setDrawableByLayerId(2, this.f35922y);
            return this;
        }
    }
}
