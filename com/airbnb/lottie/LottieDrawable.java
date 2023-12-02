package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.airbnb.lottie.manager.FontAssetManager;
import com.airbnb.lottie.manager.ImageAssetManager;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.Marker;
import com.airbnb.lottie.model.layer.CompositionLayer;
import com.airbnb.lottie.parser.LayerParser;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.LottieValueAnimator;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.SimpleLottieValueCallback;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class LottieDrawable extends Drawable implements Drawable.Callback, Animatable {
    public static final int INFINITE = -1;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;

    /* renamed from: a  reason: collision with root package name */
    private final Matrix f1305a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    private LottieComposition f1306b;

    /* renamed from: c  reason: collision with root package name */
    private final LottieValueAnimator f1307c;

    /* renamed from: d  reason: collision with root package name */
    private float f1308d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1309e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1310f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1311g;

    /* renamed from: h  reason: collision with root package name */
    private final ArrayList<r> f1312h;

    /* renamed from: i  reason: collision with root package name */
    private final ValueAnimator.AnimatorUpdateListener f1313i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private ImageAssetManager f1314j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private ImageAssetManager f1315k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private String f1316l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private ImageAssetDelegate f1317m;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    private FontAssetManager f1318n;
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    FontAssetDelegate f1319o;
    @Nullable

    /* renamed from: p  reason: collision with root package name */
    TextDelegate f1320p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f1321q;
    @Nullable

    /* renamed from: r  reason: collision with root package name */
    private CompositionLayer f1322r;

    /* renamed from: s  reason: collision with root package name */
    private int f1323s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f1324t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f1325u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f1326v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f1327w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f1328x;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface RepeatMode {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements r {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f1329a;

        a(String str) {
            this.f1329a = str;
        }

        @Override // com.airbnb.lottie.LottieDrawable.r
        public void a(LottieComposition lottieComposition) {
            LottieDrawable.this.setMinAndMaxFrame(this.f1329a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements r {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f1331a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f1332b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f1333c;

        b(String str, String str2, boolean z3) {
            this.f1331a = str;
            this.f1332b = str2;
            this.f1333c = z3;
        }

        @Override // com.airbnb.lottie.LottieDrawable.r
        public void a(LottieComposition lottieComposition) {
            LottieDrawable.this.setMinAndMaxFrame(this.f1331a, this.f1332b, this.f1333c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements r {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f1335a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f1336b;

        c(int i4, int i5) {
            this.f1335a = i4;
            this.f1336b = i5;
        }

        @Override // com.airbnb.lottie.LottieDrawable.r
        public void a(LottieComposition lottieComposition) {
            LottieDrawable.this.setMinAndMaxFrame(this.f1335a, this.f1336b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements r {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ float f1338a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ float f1339b;

        d(float f4, float f5) {
            this.f1338a = f4;
            this.f1339b = f5;
        }

        @Override // com.airbnb.lottie.LottieDrawable.r
        public void a(LottieComposition lottieComposition) {
            LottieDrawable.this.setMinAndMaxProgress(this.f1338a, this.f1339b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements r {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f1341a;

        e(int i4) {
            this.f1341a = i4;
        }

        @Override // com.airbnb.lottie.LottieDrawable.r
        public void a(LottieComposition lottieComposition) {
            LottieDrawable.this.setFrame(this.f1341a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class f implements r {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ float f1343a;

        f(float f4) {
            this.f1343a = f4;
        }

        @Override // com.airbnb.lottie.LottieDrawable.r
        public void a(LottieComposition lottieComposition) {
            LottieDrawable.this.setProgress(this.f1343a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class g implements r {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ KeyPath f1345a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f1346b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ LottieValueCallback f1347c;

        g(KeyPath keyPath, Object obj, LottieValueCallback lottieValueCallback) {
            this.f1345a = keyPath;
            this.f1346b = obj;
            this.f1347c = lottieValueCallback;
        }

        @Override // com.airbnb.lottie.LottieDrawable.r
        public void a(LottieComposition lottieComposition) {
            LottieDrawable.this.addValueCallback(this.f1345a, (KeyPath) this.f1346b, (LottieValueCallback<KeyPath>) this.f1347c);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes2.dex */
    class h<T> extends LottieValueCallback<T> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ SimpleLottieValueCallback f1349d;

        h(SimpleLottieValueCallback simpleLottieValueCallback) {
            this.f1349d = simpleLottieValueCallback;
        }

        @Override // com.airbnb.lottie.value.LottieValueCallback
        public T getValue(LottieFrameInfo<T> lottieFrameInfo) {
            return (T) this.f1349d.getValue(lottieFrameInfo);
        }
    }

    /* loaded from: classes2.dex */
    class i implements ValueAnimator.AnimatorUpdateListener {
        i() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (LottieDrawable.this.f1322r != null) {
                LottieDrawable.this.f1322r.setProgress(LottieDrawable.this.f1307c.getAnimatedValueAbsolute());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class j implements r {
        j() {
        }

        @Override // com.airbnb.lottie.LottieDrawable.r
        public void a(LottieComposition lottieComposition) {
            LottieDrawable.this.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class k implements r {
        k() {
        }

        @Override // com.airbnb.lottie.LottieDrawable.r
        public void a(LottieComposition lottieComposition) {
            LottieDrawable.this.resumeAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class l implements r {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f1354a;

        l(int i4) {
            this.f1354a = i4;
        }

        @Override // com.airbnb.lottie.LottieDrawable.r
        public void a(LottieComposition lottieComposition) {
            LottieDrawable.this.setMinFrame(this.f1354a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class m implements r {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ float f1356a;

        m(float f4) {
            this.f1356a = f4;
        }

        @Override // com.airbnb.lottie.LottieDrawable.r
        public void a(LottieComposition lottieComposition) {
            LottieDrawable.this.setMinProgress(this.f1356a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class n implements r {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f1358a;

        n(int i4) {
            this.f1358a = i4;
        }

        @Override // com.airbnb.lottie.LottieDrawable.r
        public void a(LottieComposition lottieComposition) {
            LottieDrawable.this.setMaxFrame(this.f1358a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class o implements r {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ float f1360a;

        o(float f4) {
            this.f1360a = f4;
        }

        @Override // com.airbnb.lottie.LottieDrawable.r
        public void a(LottieComposition lottieComposition) {
            LottieDrawable.this.setMaxProgress(this.f1360a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class p implements r {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f1362a;

        p(String str) {
            this.f1362a = str;
        }

        @Override // com.airbnb.lottie.LottieDrawable.r
        public void a(LottieComposition lottieComposition) {
            LottieDrawable.this.setMinFrame(this.f1362a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class q implements r {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f1364a;

        q(String str) {
            this.f1364a = str;
        }

        @Override // com.airbnb.lottie.LottieDrawable.r
        public void a(LottieComposition lottieComposition) {
            LottieDrawable.this.setMaxFrame(this.f1364a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface r {
        void a(LottieComposition lottieComposition);
    }

    public LottieDrawable() {
        LottieValueAnimator lottieValueAnimator = new LottieValueAnimator();
        this.f1307c = lottieValueAnimator;
        this.f1308d = 1.0f;
        this.f1309e = true;
        this.f1310f = false;
        this.f1311g = false;
        this.f1312h = new ArrayList<>();
        i iVar = new i();
        this.f1313i = iVar;
        this.f1323s = 255;
        this.f1327w = true;
        this.f1328x = false;
        lottieValueAnimator.addUpdateListener(iVar);
    }

    private boolean c() {
        if (!this.f1309e && !this.f1310f) {
            return false;
        }
        return true;
    }

    private float d(Rect rect) {
        return rect.width() / rect.height();
    }

    private boolean e() {
        LottieComposition lottieComposition = this.f1306b;
        if (lottieComposition == null || getBounds().isEmpty() || d(getBounds()) == d(lottieComposition.getBounds())) {
            return true;
        }
        return false;
    }

    private void f() {
        CompositionLayer compositionLayer = new CompositionLayer(this, LayerParser.parse(this.f1306b), this.f1306b.getLayers(), this.f1306b);
        this.f1322r = compositionLayer;
        if (this.f1325u) {
            compositionLayer.setOutlineMasksAndMattes(true);
        }
    }

    private void g(@NonNull Canvas canvas) {
        if (!e()) {
            h(canvas);
        } else {
            i(canvas);
        }
    }

    private void h(Canvas canvas) {
        float f4;
        if (this.f1322r == null) {
            return;
        }
        Rect bounds = getBounds();
        float width = bounds.width() / this.f1306b.getBounds().width();
        float height = bounds.height() / this.f1306b.getBounds().height();
        int i4 = -1;
        if (this.f1327w) {
            float min = Math.min(width, height);
            if (min < 1.0f) {
                f4 = 1.0f / min;
                width /= f4;
                height /= f4;
            } else {
                f4 = 1.0f;
            }
            if (f4 > 1.0f) {
                i4 = canvas.save();
                float width2 = bounds.width() / 2.0f;
                float height2 = bounds.height() / 2.0f;
                float f5 = width2 * min;
                float f6 = min * height2;
                canvas.translate(width2 - f5, height2 - f6);
                canvas.scale(f4, f4, f5, f6);
            }
        }
        this.f1305a.reset();
        this.f1305a.preScale(width, height);
        this.f1322r.draw(canvas, this.f1305a, this.f1323s);
        if (i4 > 0) {
            canvas.restoreToCount(i4);
        }
    }

    private void i(Canvas canvas) {
        float f4;
        int i4;
        if (this.f1322r == null) {
            return;
        }
        float f5 = this.f1308d;
        float m4 = m(canvas);
        if (f5 > m4) {
            f4 = this.f1308d / m4;
        } else {
            m4 = f5;
            f4 = 1.0f;
        }
        if (f4 > 1.0f) {
            i4 = canvas.save();
            float width = this.f1306b.getBounds().width() / 2.0f;
            float height = this.f1306b.getBounds().height() / 2.0f;
            float f6 = width * m4;
            float f7 = height * m4;
            canvas.translate((getScale() * width) - f6, (getScale() * height) - f7);
            canvas.scale(f4, f4, f6, f7);
        } else {
            i4 = -1;
        }
        this.f1305a.reset();
        this.f1305a.preScale(m4, m4);
        this.f1322r.draw(canvas, this.f1305a, this.f1323s);
        if (i4 > 0) {
            canvas.restoreToCount(i4);
        }
    }

    @Nullable
    private Context j() {
        Drawable.Callback callback = getCallback();
        if (callback == null || !(callback instanceof View)) {
            return null;
        }
        return ((View) callback).getContext();
    }

    private FontAssetManager k() {
        if (getCallback() == null) {
            return null;
        }
        if (this.f1318n == null) {
            this.f1318n = new FontAssetManager(getCallback(), this.f1319o);
        }
        return this.f1318n;
    }

    private ImageAssetManager l() {
        ImageAssetManager imageAssetManager = this.f1314j;
        if (imageAssetManager != null) {
            return imageAssetManager;
        }
        if (getCallback() == null) {
            return null;
        }
        ImageAssetManager imageAssetManager2 = this.f1315k;
        if (imageAssetManager2 != null && !imageAssetManager2.hasSameContext(j())) {
            this.f1315k = null;
        }
        if (this.f1315k == null) {
            this.f1315k = new ImageAssetManager(getCallback(), this.f1316l, this.f1317m, this.f1306b.getImages());
        }
        return this.f1315k;
    }

    private float m(@NonNull Canvas canvas) {
        return Math.min(canvas.getWidth() / this.f1306b.getBounds().width(), canvas.getHeight() / this.f1306b.getBounds().height());
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.f1307c.addListener(animatorListener);
    }

    @RequiresApi(api = 19)
    public void addAnimatorPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f1307c.addPauseListener(animatorPauseListener);
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f1307c.addUpdateListener(animatorUpdateListener);
    }

    public <T> void addValueCallback(KeyPath keyPath, T t3, LottieValueCallback<T> lottieValueCallback) {
        CompositionLayer compositionLayer = this.f1322r;
        if (compositionLayer == null) {
            this.f1312h.add(new g(keyPath, t3, lottieValueCallback));
            return;
        }
        boolean z3 = true;
        if (keyPath == KeyPath.COMPOSITION) {
            compositionLayer.addValueCallback(t3, lottieValueCallback);
        } else if (keyPath.getResolvedElement() != null) {
            keyPath.getResolvedElement().addValueCallback(t3, lottieValueCallback);
        } else {
            List<KeyPath> resolveKeyPath = resolveKeyPath(keyPath);
            for (int i4 = 0; i4 < resolveKeyPath.size(); i4++) {
                resolveKeyPath.get(i4).getResolvedElement().addValueCallback(t3, lottieValueCallback);
            }
            z3 = true ^ resolveKeyPath.isEmpty();
        }
        if (z3) {
            invalidateSelf();
            if (t3 == LottieProperty.TIME_REMAP) {
                setProgress(getProgress());
            }
        }
    }

    public void cancelAnimation() {
        this.f1312h.clear();
        this.f1307c.cancel();
    }

    public void clearComposition() {
        if (this.f1307c.isRunning()) {
            this.f1307c.cancel();
        }
        this.f1306b = null;
        this.f1322r = null;
        this.f1315k = null;
        this.f1307c.clearComposition();
        invalidateSelf();
    }

    public void disableExtraScaleModeInFitXY() {
        this.f1327w = false;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.f1328x = false;
        L.beginSection("Drawable#draw");
        if (this.f1311g) {
            try {
                g(canvas);
            } catch (Throwable th) {
                Logger.error("Lottie crashed in draw!", th);
            }
        } else {
            g(canvas);
        }
        L.endSection("Drawable#draw");
    }

    public boolean enableMergePathsForKitKatAndAbove() {
        return this.f1321q;
    }

    @MainThread
    public void endAnimation() {
        this.f1312h.clear();
        this.f1307c.endAnimation();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f1323s;
    }

    public LottieComposition getComposition() {
        return this.f1306b;
    }

    public int getFrame() {
        return (int) this.f1307c.getFrame();
    }

    @Nullable
    public Bitmap getImageAsset(String str) {
        ImageAssetManager l4 = l();
        if (l4 != null) {
            return l4.bitmapForId(str);
        }
        return null;
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.f1316l;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        LottieComposition lottieComposition = this.f1306b;
        if (lottieComposition == null) {
            return -1;
        }
        return (int) (lottieComposition.getBounds().height() * getScale());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        LottieComposition lottieComposition = this.f1306b;
        if (lottieComposition == null) {
            return -1;
        }
        return (int) (lottieComposition.getBounds().width() * getScale());
    }

    public float getMaxFrame() {
        return this.f1307c.getMaxFrame();
    }

    public float getMinFrame() {
        return this.f1307c.getMinFrame();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Nullable
    public PerformanceTracker getPerformanceTracker() {
        LottieComposition lottieComposition = this.f1306b;
        if (lottieComposition != null) {
            return lottieComposition.getPerformanceTracker();
        }
        return null;
    }

    @FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = 1.0d)
    public float getProgress() {
        return this.f1307c.getAnimatedValueAbsolute();
    }

    public int getRepeatCount() {
        return this.f1307c.getRepeatCount();
    }

    public int getRepeatMode() {
        return this.f1307c.getRepeatMode();
    }

    public float getScale() {
        return this.f1308d;
    }

    public float getSpeed() {
        return this.f1307c.getSpeed();
    }

    @Nullable
    public TextDelegate getTextDelegate() {
        return this.f1320p;
    }

    @Nullable
    public Typeface getTypeface(String str, String str2) {
        FontAssetManager k4 = k();
        if (k4 != null) {
            return k4.getTypeface(str, str2);
        }
        return null;
    }

    public boolean hasMasks() {
        CompositionLayer compositionLayer = this.f1322r;
        if (compositionLayer != null && compositionLayer.hasMasks()) {
            return true;
        }
        return false;
    }

    public boolean hasMatte() {
        CompositionLayer compositionLayer = this.f1322r;
        if (compositionLayer != null && compositionLayer.hasMatte()) {
            return true;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.f1328x) {
            return;
        }
        this.f1328x = true;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public boolean isAnimating() {
        LottieValueAnimator lottieValueAnimator = this.f1307c;
        if (lottieValueAnimator == null) {
            return false;
        }
        return lottieValueAnimator.isRunning();
    }

    public boolean isApplyingOpacityToLayersEnabled() {
        return this.f1326v;
    }

    public boolean isLooping() {
        if (this.f1307c.getRepeatCount() == -1) {
            return true;
        }
        return false;
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.f1321q;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return isAnimating();
    }

    @Deprecated
    public void loop(boolean z3) {
        int i4;
        LottieValueAnimator lottieValueAnimator = this.f1307c;
        if (z3) {
            i4 = -1;
        } else {
            i4 = 0;
        }
        lottieValueAnimator.setRepeatCount(i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(Boolean bool) {
        this.f1309e = bool.booleanValue();
    }

    public void pauseAnimation() {
        this.f1312h.clear();
        this.f1307c.pauseAnimation();
    }

    @MainThread
    public void playAnimation() {
        float maxFrame;
        if (this.f1322r == null) {
            this.f1312h.add(new j());
            return;
        }
        if (c() || getRepeatCount() == 0) {
            this.f1307c.playAnimation();
        }
        if (!c()) {
            if (getSpeed() < 0.0f) {
                maxFrame = getMinFrame();
            } else {
                maxFrame = getMaxFrame();
            }
            setFrame((int) maxFrame);
            this.f1307c.endAnimation();
        }
    }

    public void removeAllAnimatorListeners() {
        this.f1307c.removeAllListeners();
    }

    public void removeAllUpdateListeners() {
        this.f1307c.removeAllUpdateListeners();
        this.f1307c.addUpdateListener(this.f1313i);
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.f1307c.removeListener(animatorListener);
    }

    @RequiresApi(api = 19)
    public void removeAnimatorPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f1307c.removePauseListener(animatorPauseListener);
    }

    public void removeAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f1307c.removeUpdateListener(animatorUpdateListener);
    }

    public List<KeyPath> resolveKeyPath(KeyPath keyPath) {
        if (this.f1322r == null) {
            Logger.warning("Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.f1322r.resolveKeyPath(keyPath, 0, arrayList, new KeyPath(new String[0]));
        return arrayList;
    }

    @MainThread
    public void resumeAnimation() {
        float maxFrame;
        if (this.f1322r == null) {
            this.f1312h.add(new k());
            return;
        }
        if (c() || getRepeatCount() == 0) {
            this.f1307c.resumeAnimation();
        }
        if (!c()) {
            if (getSpeed() < 0.0f) {
                maxFrame = getMinFrame();
            } else {
                maxFrame = getMaxFrame();
            }
            setFrame((int) maxFrame);
            this.f1307c.endAnimation();
        }
    }

    public void reverseAnimationSpeed() {
        this.f1307c.reverseAnimationSpeed();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j4) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i4) {
        this.f1323s = i4;
        invalidateSelf();
    }

    public void setApplyingOpacityToLayersEnabled(boolean z3) {
        this.f1326v = z3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        Logger.warning("Use addColorFilter instead.");
    }

    public boolean setComposition(LottieComposition lottieComposition) {
        if (this.f1306b == lottieComposition) {
            return false;
        }
        this.f1328x = false;
        clearComposition();
        this.f1306b = lottieComposition;
        f();
        this.f1307c.setComposition(lottieComposition);
        setProgress(this.f1307c.getAnimatedFraction());
        setScale(this.f1308d);
        Iterator it = new ArrayList(this.f1312h).iterator();
        while (it.hasNext()) {
            r rVar = (r) it.next();
            if (rVar != null) {
                rVar.a(lottieComposition);
            }
            it.remove();
        }
        this.f1312h.clear();
        lottieComposition.setPerformanceTrackingEnabled(this.f1324t);
        Drawable.Callback callback = getCallback();
        if (callback instanceof ImageView) {
            ImageView imageView = (ImageView) callback;
            imageView.setImageDrawable(null);
            imageView.setImageDrawable(this);
            return true;
        }
        return true;
    }

    public void setFontAssetDelegate(FontAssetDelegate fontAssetDelegate) {
        this.f1319o = fontAssetDelegate;
        FontAssetManager fontAssetManager = this.f1318n;
        if (fontAssetManager != null) {
            fontAssetManager.setDelegate(fontAssetDelegate);
        }
    }

    public void setFrame(int i4) {
        if (this.f1306b == null) {
            this.f1312h.add(new e(i4));
        } else {
            this.f1307c.setFrame(i4);
        }
    }

    public void setIgnoreDisabledSystemAnimations(boolean z3) {
        this.f1310f = z3;
    }

    public void setImageAssetDelegate(ImageAssetDelegate imageAssetDelegate) {
        this.f1317m = imageAssetDelegate;
        ImageAssetManager imageAssetManager = this.f1315k;
        if (imageAssetManager != null) {
            imageAssetManager.setDelegate(imageAssetDelegate);
        }
    }

    public void setImagesAssetsFolder(@Nullable String str) {
        this.f1316l = str;
    }

    public void setMaxFrame(int i4) {
        if (this.f1306b == null) {
            this.f1312h.add(new n(i4));
        } else {
            this.f1307c.setMaxFrame(i4 + 0.99f);
        }
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f4) {
        LottieComposition lottieComposition = this.f1306b;
        if (lottieComposition == null) {
            this.f1312h.add(new o(f4));
        } else {
            setMaxFrame((int) MiscUtils.lerp(lottieComposition.getStartFrame(), this.f1306b.getEndFrame(), f4));
        }
    }

    public void setMinAndMaxFrame(String str) {
        LottieComposition lottieComposition = this.f1306b;
        if (lottieComposition == null) {
            this.f1312h.add(new a(str));
            return;
        }
        Marker marker = lottieComposition.getMarker(str);
        if (marker != null) {
            int i4 = (int) marker.startFrame;
            setMinAndMaxFrame(i4, ((int) marker.durationFrames) + i4);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f4, @FloatRange(from = 0.0d, to = 1.0d) float f5) {
        LottieComposition lottieComposition = this.f1306b;
        if (lottieComposition == null) {
            this.f1312h.add(new d(f4, f5));
        } else {
            setMinAndMaxFrame((int) MiscUtils.lerp(lottieComposition.getStartFrame(), this.f1306b.getEndFrame(), f4), (int) MiscUtils.lerp(this.f1306b.getStartFrame(), this.f1306b.getEndFrame(), f5));
        }
    }

    public void setMinFrame(int i4) {
        if (this.f1306b == null) {
            this.f1312h.add(new l(i4));
        } else {
            this.f1307c.setMinFrame(i4);
        }
    }

    public void setMinProgress(float f4) {
        LottieComposition lottieComposition = this.f1306b;
        if (lottieComposition == null) {
            this.f1312h.add(new m(f4));
        } else {
            setMinFrame((int) MiscUtils.lerp(lottieComposition.getStartFrame(), this.f1306b.getEndFrame(), f4));
        }
    }

    public void setOutlineMasksAndMattes(boolean z3) {
        if (this.f1325u == z3) {
            return;
        }
        this.f1325u = z3;
        CompositionLayer compositionLayer = this.f1322r;
        if (compositionLayer != null) {
            compositionLayer.setOutlineMasksAndMattes(z3);
        }
    }

    public void setPerformanceTrackingEnabled(boolean z3) {
        this.f1324t = z3;
        LottieComposition lottieComposition = this.f1306b;
        if (lottieComposition != null) {
            lottieComposition.setPerformanceTrackingEnabled(z3);
        }
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f4) {
        if (this.f1306b == null) {
            this.f1312h.add(new f(f4));
            return;
        }
        L.beginSection("Drawable#setProgress");
        this.f1307c.setFrame(MiscUtils.lerp(this.f1306b.getStartFrame(), this.f1306b.getEndFrame(), f4));
        L.endSection("Drawable#setProgress");
    }

    public void setRepeatCount(int i4) {
        this.f1307c.setRepeatCount(i4);
    }

    public void setRepeatMode(int i4) {
        this.f1307c.setRepeatMode(i4);
    }

    public void setSafeMode(boolean z3) {
        this.f1311g = z3;
    }

    public void setScale(float f4) {
        this.f1308d = f4;
    }

    public void setSpeed(float f4) {
        this.f1307c.setSpeed(f4);
    }

    public void setTextDelegate(TextDelegate textDelegate) {
        this.f1320p = textDelegate;
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void start() {
        Drawable.Callback callback = getCallback();
        if ((callback instanceof View) && !((View) callback).isInEditMode()) {
            playAnimation();
        }
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void stop() {
        endAnimation();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    @Nullable
    public Bitmap updateBitmap(String str, @Nullable Bitmap bitmap) {
        ImageAssetManager l4 = l();
        if (l4 == null) {
            Logger.warning("Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap updateBitmap = l4.updateBitmap(str, bitmap);
        invalidateSelf();
        return updateBitmap;
    }

    public boolean useTextGlyphs() {
        if (this.f1320p == null && this.f1306b.getCharacters().size() > 0) {
            return true;
        }
        return false;
    }

    public void enableMergePathsForKitKatAndAbove(boolean z3) {
        if (this.f1321q == z3) {
            return;
        }
        this.f1321q = z3;
        if (this.f1306b != null) {
            f();
        }
    }

    public void setMaxFrame(String str) {
        LottieComposition lottieComposition = this.f1306b;
        if (lottieComposition == null) {
            this.f1312h.add(new q(str));
            return;
        }
        Marker marker = lottieComposition.getMarker(str);
        if (marker != null) {
            setMaxFrame((int) (marker.startFrame + marker.durationFrames));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void setMinFrame(String str) {
        LottieComposition lottieComposition = this.f1306b;
        if (lottieComposition == null) {
            this.f1312h.add(new p(str));
            return;
        }
        Marker marker = lottieComposition.getMarker(str);
        if (marker != null) {
            setMinFrame((int) marker.startFrame);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void setMinAndMaxFrame(String str, String str2, boolean z3) {
        LottieComposition lottieComposition = this.f1306b;
        if (lottieComposition == null) {
            this.f1312h.add(new b(str, str2, z3));
            return;
        }
        Marker marker = lottieComposition.getMarker(str);
        if (marker != null) {
            int i4 = (int) marker.startFrame;
            Marker marker2 = this.f1306b.getMarker(str2);
            if (marker2 != null) {
                setMinAndMaxFrame(i4, (int) (marker2.startFrame + (z3 ? 1.0f : 0.0f)));
                return;
            }
            throw new IllegalArgumentException("Cannot find marker with name " + str2 + ".");
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public <T> void addValueCallback(KeyPath keyPath, T t3, SimpleLottieValueCallback<T> simpleLottieValueCallback) {
        addValueCallback(keyPath, (KeyPath) t3, (LottieValueCallback<KeyPath>) new h(simpleLottieValueCallback));
    }

    public void setMinAndMaxFrame(int i4, int i5) {
        if (this.f1306b == null) {
            this.f1312h.add(new c(i4, i5));
        } else {
            this.f1307c.setMinAndMaxFrames(i4, i5 + 0.99f);
        }
    }
}
