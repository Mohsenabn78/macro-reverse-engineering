package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.RequiresApi;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewCompat;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.SimpleLottieValueCallback;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public class LottieAnimationView extends AppCompatImageView {

    /* renamed from: t  reason: collision with root package name */
    private static final LottieListener<Throwable> f1217t = new a();

    /* renamed from: a  reason: collision with root package name */
    private final LottieListener<LottieComposition> f1218a;

    /* renamed from: b  reason: collision with root package name */
    private final LottieListener<Throwable> f1219b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private LottieListener<Throwable> f1220c;
    @DrawableRes

    /* renamed from: d  reason: collision with root package name */
    private int f1221d;

    /* renamed from: e  reason: collision with root package name */
    private final LottieDrawable f1222e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1223f;

    /* renamed from: g  reason: collision with root package name */
    private String f1224g;
    @RawRes

    /* renamed from: h  reason: collision with root package name */
    private int f1225h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f1226i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f1227j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f1228k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f1229l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f1230m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f1231n;

    /* renamed from: o  reason: collision with root package name */
    private RenderMode f1232o;

    /* renamed from: p  reason: collision with root package name */
    private final Set<LottieOnCompositionLoadedListener> f1233p;

    /* renamed from: q  reason: collision with root package name */
    private int f1234q;
    @Nullable

    /* renamed from: r  reason: collision with root package name */
    private LottieTask<LottieComposition> f1235r;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    private LottieComposition f1236s;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        String f1237a;

        /* renamed from: b  reason: collision with root package name */
        int f1238b;

        /* renamed from: c  reason: collision with root package name */
        float f1239c;

        /* renamed from: d  reason: collision with root package name */
        boolean f1240d;

        /* renamed from: e  reason: collision with root package name */
        String f1241e;

        /* renamed from: f  reason: collision with root package name */
        int f1242f;

        /* renamed from: g  reason: collision with root package name */
        int f1243g;

        /* loaded from: classes2.dex */
        class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public SavedState[] newArray(int i4) {
                return new SavedState[i4];
            }
        }

        /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeString(this.f1237a);
            parcel.writeFloat(this.f1239c);
            parcel.writeInt(this.f1240d ? 1 : 0);
            parcel.writeString(this.f1241e);
            parcel.writeInt(this.f1242f);
            parcel.writeInt(this.f1243g);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f1237a = parcel.readString();
            this.f1239c = parcel.readFloat();
            this.f1240d = parcel.readInt() == 1;
            this.f1241e = parcel.readString();
            this.f1242f = parcel.readInt();
            this.f1243g = parcel.readInt();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements LottieListener<Throwable> {
        a() {
        }

        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public void onResult(Throwable th) {
            if (Utils.isNetworkException(th)) {
                Logger.warning("Unable to load composition.", th);
                return;
            }
            throw new IllegalStateException("Unable to parse composition", th);
        }
    }

    /* loaded from: classes2.dex */
    class b implements LottieListener<LottieComposition> {
        b() {
        }

        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public void onResult(LottieComposition lottieComposition) {
            LottieAnimationView.this.setComposition(lottieComposition);
        }
    }

    /* loaded from: classes2.dex */
    class c implements LottieListener<Throwable> {
        c() {
        }

        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public void onResult(Throwable th) {
            if (LottieAnimationView.this.f1221d != 0) {
                LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                lottieAnimationView.setImageResource(lottieAnimationView.f1221d);
            }
            (LottieAnimationView.this.f1220c == null ? LottieAnimationView.f1217t : LottieAnimationView.this.f1220c).onResult(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements Callable<LottieResult<LottieComposition>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f1246a;

        d(int i4) {
            this.f1246a = i4;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public LottieResult<LottieComposition> call() {
            if (LottieAnimationView.this.f1231n) {
                return LottieCompositionFactory.fromRawResSync(LottieAnimationView.this.getContext(), this.f1246a);
            }
            return LottieCompositionFactory.fromRawResSync(LottieAnimationView.this.getContext(), this.f1246a, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements Callable<LottieResult<LottieComposition>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f1248a;

        e(String str) {
            this.f1248a = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public LottieResult<LottieComposition> call() {
            if (LottieAnimationView.this.f1231n) {
                return LottieCompositionFactory.fromAssetSync(LottieAnimationView.this.getContext(), this.f1248a);
            }
            return LottieCompositionFactory.fromAssetSync(LottieAnimationView.this.getContext(), this.f1248a, null);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes2.dex */
    class f<T> extends LottieValueCallback<T> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ SimpleLottieValueCallback f1250d;

        f(SimpleLottieValueCallback simpleLottieValueCallback) {
            this.f1250d = simpleLottieValueCallback;
        }

        @Override // com.airbnb.lottie.value.LottieValueCallback
        public T getValue(LottieFrameInfo<T> lottieFrameInfo) {
            return (T) this.f1250d.getValue(lottieFrameInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class g {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1252a;

        static {
            int[] iArr = new int[RenderMode.values().length];
            f1252a = iArr;
            try {
                iArr[RenderMode.HARDWARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1252a[RenderMode.SOFTWARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1252a[RenderMode.AUTOMATIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.f1218a = new b();
        this.f1219b = new c();
        this.f1221d = 0;
        this.f1222e = new LottieDrawable();
        this.f1226i = false;
        this.f1227j = false;
        this.f1228k = false;
        this.f1229l = false;
        this.f1230m = false;
        this.f1231n = true;
        this.f1232o = RenderMode.AUTOMATIC;
        this.f1233p = new HashSet();
        this.f1234q = 0;
        j(null, R.attr.lottieAnimationViewStyle);
    }

    private void e() {
        LottieTask<LottieComposition> lottieTask = this.f1235r;
        if (lottieTask != null) {
            lottieTask.removeListener(this.f1218a);
            this.f1235r.removeFailureListener(this.f1219b);
        }
    }

    private void f() {
        this.f1236s = null;
        this.f1222e.clearComposition();
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x003f, code lost:
        if (r3 != false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void g() {
        /*
            r5 = this;
            int[] r0 = com.airbnb.lottie.LottieAnimationView.g.f1252a
            com.airbnb.lottie.RenderMode r1 = r5.f1232o
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 2
            r2 = 1
            if (r0 == r2) goto L41
            if (r0 == r1) goto L13
            r3 = 3
            if (r0 == r3) goto L15
        L13:
            r1 = 1
            goto L41
        L15:
            com.airbnb.lottie.LottieComposition r0 = r5.f1236s
            r3 = 0
            if (r0 == 0) goto L27
            boolean r0 = r0.hasDashPattern()
            if (r0 == 0) goto L27
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 28
            if (r0 >= r4) goto L27
            goto L3f
        L27:
            com.airbnb.lottie.LottieComposition r0 = r5.f1236s
            if (r0 == 0) goto L33
            int r0 = r0.getMaskAndMatteCount()
            r4 = 4
            if (r0 <= r4) goto L33
            goto L3f
        L33:
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 24
            if (r0 == r4) goto L3f
            r4 = 25
            if (r0 != r4) goto L3e
            goto L3f
        L3e:
            r3 = 1
        L3f:
            if (r3 == 0) goto L13
        L41:
            int r0 = r5.getLayerType()
            if (r1 == r0) goto L4b
            r0 = 0
            r5.setLayerType(r1, r0)
        L4b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.LottieAnimationView.g():void");
    }

    private LottieTask<LottieComposition> h(String str) {
        if (isInEditMode()) {
            return new LottieTask<>(new e(str), true);
        }
        if (this.f1231n) {
            return LottieCompositionFactory.fromAsset(getContext(), str);
        }
        return LottieCompositionFactory.fromAsset(getContext(), str, null);
    }

    private LottieTask<LottieComposition> i(@RawRes int i4) {
        if (isInEditMode()) {
            return new LottieTask<>(new d(i4), true);
        }
        if (this.f1231n) {
            return LottieCompositionFactory.fromRawRes(getContext(), i4);
        }
        return LottieCompositionFactory.fromRawRes(getContext(), i4, null);
    }

    private void j(@Nullable AttributeSet attributeSet, @AttrRes int i4) {
        String string;
        boolean z3 = false;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.LottieAnimationView, i4, 0);
        this.f1231n = obtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_cacheComposition, true);
        int i5 = R.styleable.LottieAnimationView_lottie_rawRes;
        boolean hasValue = obtainStyledAttributes.hasValue(i5);
        int i6 = R.styleable.LottieAnimationView_lottie_fileName;
        boolean hasValue2 = obtainStyledAttributes.hasValue(i6);
        int i7 = R.styleable.LottieAnimationView_lottie_url;
        boolean hasValue3 = obtainStyledAttributes.hasValue(i7);
        if (hasValue && hasValue2) {
            throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
        }
        if (hasValue) {
            int resourceId = obtainStyledAttributes.getResourceId(i5, 0);
            if (resourceId != 0) {
                setAnimation(resourceId);
            }
        } else if (hasValue2) {
            String string2 = obtainStyledAttributes.getString(i6);
            if (string2 != null) {
                setAnimation(string2);
            }
        } else if (hasValue3 && (string = obtainStyledAttributes.getString(i7)) != null) {
            setAnimationFromUrl(string);
        }
        setFallbackResource(obtainStyledAttributes.getResourceId(R.styleable.LottieAnimationView_lottie_fallbackRes, 0));
        if (obtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_autoPlay, false)) {
            this.f1228k = true;
            this.f1230m = true;
        }
        if (obtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_loop, false)) {
            this.f1222e.setRepeatCount(-1);
        }
        int i8 = R.styleable.LottieAnimationView_lottie_repeatMode;
        if (obtainStyledAttributes.hasValue(i8)) {
            setRepeatMode(obtainStyledAttributes.getInt(i8, 1));
        }
        int i9 = R.styleable.LottieAnimationView_lottie_repeatCount;
        if (obtainStyledAttributes.hasValue(i9)) {
            setRepeatCount(obtainStyledAttributes.getInt(i9, -1));
        }
        int i10 = R.styleable.LottieAnimationView_lottie_speed;
        if (obtainStyledAttributes.hasValue(i10)) {
            setSpeed(obtainStyledAttributes.getFloat(i10, 1.0f));
        }
        setImageAssetsFolder(obtainStyledAttributes.getString(R.styleable.LottieAnimationView_lottie_imageAssetsFolder));
        setProgress(obtainStyledAttributes.getFloat(R.styleable.LottieAnimationView_lottie_progress, 0.0f));
        enableMergePathsForKitKatAndAbove(obtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
        int i11 = R.styleable.LottieAnimationView_lottie_colorFilter;
        if (obtainStyledAttributes.hasValue(i11)) {
            addValueCallback(new KeyPath("**"), (KeyPath) LottieProperty.COLOR_FILTER, (LottieValueCallback<KeyPath>) new LottieValueCallback(new SimpleColorFilter(AppCompatResources.getColorStateList(getContext(), obtainStyledAttributes.getResourceId(i11, -1)).getDefaultColor())));
        }
        int i12 = R.styleable.LottieAnimationView_lottie_scale;
        if (obtainStyledAttributes.hasValue(i12)) {
            this.f1222e.setScale(obtainStyledAttributes.getFloat(i12, 1.0f));
        }
        int i13 = R.styleable.LottieAnimationView_lottie_renderMode;
        if (obtainStyledAttributes.hasValue(i13)) {
            RenderMode renderMode = RenderMode.AUTOMATIC;
            int i14 = obtainStyledAttributes.getInt(i13, renderMode.ordinal());
            if (i14 >= RenderMode.values().length) {
                i14 = renderMode.ordinal();
            }
            setRenderMode(RenderMode.values()[i14]);
        }
        setIgnoreDisabledSystemAnimations(obtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_ignoreDisabledSystemAnimations, false));
        obtainStyledAttributes.recycle();
        LottieDrawable lottieDrawable = this.f1222e;
        if (Utils.getAnimationScale(getContext()) != 0.0f) {
            z3 = true;
        }
        lottieDrawable.n(Boolean.valueOf(z3));
        g();
        this.f1223f = true;
    }

    private void k() {
        boolean isAnimating = isAnimating();
        setImageDrawable(null);
        setImageDrawable(this.f1222e);
        if (isAnimating) {
            this.f1222e.resumeAnimation();
        }
    }

    private void setCompositionTask(LottieTask<LottieComposition> lottieTask) {
        f();
        e();
        this.f1235r = lottieTask.addListener(this.f1218a).addFailureListener(this.f1219b);
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.f1222e.addAnimatorListener(animatorListener);
    }

    @RequiresApi(api = 19)
    public void addAnimatorPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f1222e.addAnimatorPauseListener(animatorPauseListener);
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f1222e.addAnimatorUpdateListener(animatorUpdateListener);
    }

    public boolean addLottieOnCompositionLoadedListener(@NonNull LottieOnCompositionLoadedListener lottieOnCompositionLoadedListener) {
        LottieComposition lottieComposition = this.f1236s;
        if (lottieComposition != null) {
            lottieOnCompositionLoadedListener.onCompositionLoaded(lottieComposition);
        }
        return this.f1233p.add(lottieOnCompositionLoadedListener);
    }

    public <T> void addValueCallback(KeyPath keyPath, T t3, LottieValueCallback<T> lottieValueCallback) {
        this.f1222e.addValueCallback(keyPath, (KeyPath) t3, (LottieValueCallback<KeyPath>) lottieValueCallback);
    }

    @Override // android.view.View
    public void buildDrawingCache(boolean z3) {
        L.beginSection("buildDrawingCache");
        this.f1234q++;
        super.buildDrawingCache(z3);
        if (this.f1234q == 1 && getWidth() > 0 && getHeight() > 0 && getLayerType() == 1 && getDrawingCache(z3) == null) {
            setRenderMode(RenderMode.HARDWARE);
        }
        this.f1234q--;
        L.endSection("buildDrawingCache");
    }

    @MainThread
    public void cancelAnimation() {
        this.f1228k = false;
        this.f1227j = false;
        this.f1226i = false;
        this.f1222e.cancelAnimation();
        g();
    }

    public void disableExtraScaleModeInFitXY() {
        this.f1222e.disableExtraScaleModeInFitXY();
    }

    public void enableMergePathsForKitKatAndAbove(boolean z3) {
        this.f1222e.enableMergePathsForKitKatAndAbove(z3);
    }

    @Nullable
    public LottieComposition getComposition() {
        return this.f1236s;
    }

    public long getDuration() {
        LottieComposition lottieComposition = this.f1236s;
        if (lottieComposition != null) {
            return lottieComposition.getDuration();
        }
        return 0L;
    }

    public int getFrame() {
        return this.f1222e.getFrame();
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.f1222e.getImageAssetsFolder();
    }

    public float getMaxFrame() {
        return this.f1222e.getMaxFrame();
    }

    public float getMinFrame() {
        return this.f1222e.getMinFrame();
    }

    @Nullable
    public PerformanceTracker getPerformanceTracker() {
        return this.f1222e.getPerformanceTracker();
    }

    @FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = 1.0d)
    public float getProgress() {
        return this.f1222e.getProgress();
    }

    public int getRepeatCount() {
        return this.f1222e.getRepeatCount();
    }

    public int getRepeatMode() {
        return this.f1222e.getRepeatMode();
    }

    public float getScale() {
        return this.f1222e.getScale();
    }

    public float getSpeed() {
        return this.f1222e.getSpeed();
    }

    public boolean hasMasks() {
        return this.f1222e.hasMasks();
    }

    public boolean hasMatte() {
        return this.f1222e.hasMatte();
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable drawable2 = getDrawable();
        LottieDrawable lottieDrawable = this.f1222e;
        if (drawable2 == lottieDrawable) {
            super.invalidateDrawable(lottieDrawable);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    public boolean isAnimating() {
        return this.f1222e.isAnimating();
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.f1222e.isMergePathsEnabledForKitKatAndAbove();
    }

    @Deprecated
    public void loop(boolean z3) {
        int i4;
        LottieDrawable lottieDrawable = this.f1222e;
        if (z3) {
            i4 = -1;
        } else {
            i4 = 0;
        }
        lottieDrawable.setRepeatCount(i4);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode() && (this.f1230m || this.f1228k)) {
            playAnimation();
            this.f1230m = false;
            this.f1228k = false;
        }
        if (Build.VERSION.SDK_INT < 23) {
            onVisibilityChanged(this, getVisibility());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        if (isAnimating()) {
            cancelAnimation();
            this.f1228k = true;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        String str = savedState.f1237a;
        this.f1224g = str;
        if (!TextUtils.isEmpty(str)) {
            setAnimation(this.f1224g);
        }
        int i4 = savedState.f1238b;
        this.f1225h = i4;
        if (i4 != 0) {
            setAnimation(i4);
        }
        setProgress(savedState.f1239c);
        if (savedState.f1240d) {
            playAnimation();
        }
        this.f1222e.setImagesAssetsFolder(savedState.f1241e);
        setRepeatMode(savedState.f1242f);
        setRepeatCount(savedState.f1243g);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        boolean z3;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1237a = this.f1224g;
        savedState.f1238b = this.f1225h;
        savedState.f1239c = this.f1222e.getProgress();
        if (!this.f1222e.isAnimating() && (ViewCompat.isAttachedToWindow(this) || !this.f1228k)) {
            z3 = false;
        } else {
            z3 = true;
        }
        savedState.f1240d = z3;
        savedState.f1241e = this.f1222e.getImageAssetsFolder();
        savedState.f1242f = this.f1222e.getRepeatMode();
        savedState.f1243g = this.f1222e.getRepeatCount();
        return savedState;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i4) {
        if (!this.f1223f) {
            return;
        }
        if (isShown()) {
            if (this.f1227j) {
                resumeAnimation();
            } else if (this.f1226i) {
                playAnimation();
            }
            this.f1227j = false;
            this.f1226i = false;
        } else if (isAnimating()) {
            pauseAnimation();
            this.f1227j = true;
        }
    }

    @MainThread
    public void pauseAnimation() {
        this.f1230m = false;
        this.f1228k = false;
        this.f1227j = false;
        this.f1226i = false;
        this.f1222e.pauseAnimation();
        g();
    }

    @MainThread
    public void playAnimation() {
        if (isShown()) {
            this.f1222e.playAnimation();
            g();
            return;
        }
        this.f1226i = true;
    }

    public void removeAllAnimatorListeners() {
        this.f1222e.removeAllAnimatorListeners();
    }

    public void removeAllLottieOnCompositionLoadedListener() {
        this.f1233p.clear();
    }

    public void removeAllUpdateListeners() {
        this.f1222e.removeAllUpdateListeners();
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.f1222e.removeAnimatorListener(animatorListener);
    }

    @RequiresApi(api = 19)
    public void removeAnimatorPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f1222e.removeAnimatorPauseListener(animatorPauseListener);
    }

    public boolean removeLottieOnCompositionLoadedListener(@NonNull LottieOnCompositionLoadedListener lottieOnCompositionLoadedListener) {
        return this.f1233p.remove(lottieOnCompositionLoadedListener);
    }

    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f1222e.removeAnimatorUpdateListener(animatorUpdateListener);
    }

    public List<KeyPath> resolveKeyPath(KeyPath keyPath) {
        return this.f1222e.resolveKeyPath(keyPath);
    }

    @MainThread
    public void resumeAnimation() {
        if (isShown()) {
            this.f1222e.resumeAnimation();
            g();
            return;
        }
        this.f1226i = false;
        this.f1227j = true;
    }

    public void reverseAnimationSpeed() {
        this.f1222e.reverseAnimationSpeed();
    }

    public void setAnimation(@RawRes int i4) {
        this.f1225h = i4;
        this.f1224g = null;
        setCompositionTask(i(i4));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        setAnimationFromJson(str, null);
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(this.f1231n ? LottieCompositionFactory.fromUrl(getContext(), str) : LottieCompositionFactory.fromUrl(getContext(), str, null));
    }

    public void setApplyingOpacityToLayersEnabled(boolean z3) {
        this.f1222e.setApplyingOpacityToLayersEnabled(z3);
    }

    public void setCacheComposition(boolean z3) {
        this.f1231n = z3;
    }

    public void setComposition(@NonNull LottieComposition lottieComposition) {
        if (L.DBG) {
            StringBuilder sb = new StringBuilder();
            sb.append("Set Composition \n");
            sb.append(lottieComposition);
        }
        this.f1222e.setCallback(this);
        this.f1236s = lottieComposition;
        this.f1229l = true;
        boolean composition = this.f1222e.setComposition(lottieComposition);
        this.f1229l = false;
        g();
        if (getDrawable() == this.f1222e && !composition) {
            return;
        }
        if (!composition) {
            k();
        }
        onVisibilityChanged(this, getVisibility());
        requestLayout();
        for (LottieOnCompositionLoadedListener lottieOnCompositionLoadedListener : this.f1233p) {
            lottieOnCompositionLoadedListener.onCompositionLoaded(lottieComposition);
        }
    }

    public void setFailureListener(@Nullable LottieListener<Throwable> lottieListener) {
        this.f1220c = lottieListener;
    }

    public void setFallbackResource(@DrawableRes int i4) {
        this.f1221d = i4;
    }

    public void setFontAssetDelegate(FontAssetDelegate fontAssetDelegate) {
        this.f1222e.setFontAssetDelegate(fontAssetDelegate);
    }

    public void setFrame(int i4) {
        this.f1222e.setFrame(i4);
    }

    public void setIgnoreDisabledSystemAnimations(boolean z3) {
        this.f1222e.setIgnoreDisabledSystemAnimations(z3);
    }

    public void setImageAssetDelegate(ImageAssetDelegate imageAssetDelegate) {
        this.f1222e.setImageAssetDelegate(imageAssetDelegate);
    }

    public void setImageAssetsFolder(String str) {
        this.f1222e.setImagesAssetsFolder(str);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        e();
        super.setImageBitmap(bitmap);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        e();
        super.setImageDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i4) {
        e();
        super.setImageResource(i4);
    }

    public void setMaxFrame(int i4) {
        this.f1222e.setMaxFrame(i4);
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f4) {
        this.f1222e.setMaxProgress(f4);
    }

    public void setMinAndMaxFrame(String str) {
        this.f1222e.setMinAndMaxFrame(str);
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f4, @FloatRange(from = 0.0d, to = 1.0d) float f5) {
        this.f1222e.setMinAndMaxProgress(f4, f5);
    }

    public void setMinFrame(int i4) {
        this.f1222e.setMinFrame(i4);
    }

    public void setMinProgress(float f4) {
        this.f1222e.setMinProgress(f4);
    }

    public void setOutlineMasksAndMattes(boolean z3) {
        this.f1222e.setOutlineMasksAndMattes(z3);
    }

    public void setPerformanceTrackingEnabled(boolean z3) {
        this.f1222e.setPerformanceTrackingEnabled(z3);
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f4) {
        this.f1222e.setProgress(f4);
    }

    public void setRenderMode(RenderMode renderMode) {
        this.f1232o = renderMode;
        g();
    }

    public void setRepeatCount(int i4) {
        this.f1222e.setRepeatCount(i4);
    }

    public void setRepeatMode(int i4) {
        this.f1222e.setRepeatMode(i4);
    }

    public void setSafeMode(boolean z3) {
        this.f1222e.setSafeMode(z3);
    }

    public void setScale(float f4) {
        this.f1222e.setScale(f4);
        if (getDrawable() == this.f1222e) {
            k();
        }
    }

    public void setSpeed(float f4) {
        this.f1222e.setSpeed(f4);
    }

    public void setTextDelegate(TextDelegate textDelegate) {
        this.f1222e.setTextDelegate(textDelegate);
    }

    @Override // android.view.View
    public void unscheduleDrawable(Drawable drawable) {
        LottieDrawable lottieDrawable;
        if (!this.f1229l && drawable == (lottieDrawable = this.f1222e) && lottieDrawable.isAnimating()) {
            pauseAnimation();
        } else if (!this.f1229l && (drawable instanceof LottieDrawable)) {
            LottieDrawable lottieDrawable2 = (LottieDrawable) drawable;
            if (lottieDrawable2.isAnimating()) {
                lottieDrawable2.pauseAnimation();
            }
        }
        super.unscheduleDrawable(drawable);
    }

    @Nullable
    public Bitmap updateBitmap(String str, @Nullable Bitmap bitmap) {
        return this.f1222e.updateBitmap(str, bitmap);
    }

    public <T> void addValueCallback(KeyPath keyPath, T t3, SimpleLottieValueCallback<T> simpleLottieValueCallback) {
        this.f1222e.addValueCallback(keyPath, (KeyPath) t3, (LottieValueCallback<KeyPath>) new f(simpleLottieValueCallback));
    }

    public void setAnimationFromJson(String str, @Nullable String str2) {
        setAnimation(new ByteArrayInputStream(str.getBytes()), str2);
    }

    public void setMaxFrame(String str) {
        this.f1222e.setMaxFrame(str);
    }

    public void setMinAndMaxFrame(String str, String str2, boolean z3) {
        this.f1222e.setMinAndMaxFrame(str, str2, z3);
    }

    public void setMinFrame(String str) {
        this.f1222e.setMinFrame(str);
    }

    public void setMinAndMaxFrame(int i4, int i5) {
        this.f1222e.setMinAndMaxFrame(i4, i5);
    }

    public void setAnimation(String str) {
        this.f1224g = str;
        this.f1225h = 0;
        setCompositionTask(h(str));
    }

    public void setAnimationFromUrl(String str, @Nullable String str2) {
        setCompositionTask(LottieCompositionFactory.fromUrl(getContext(), str, str2));
    }

    public void setAnimation(InputStream inputStream, @Nullable String str) {
        setCompositionTask(LottieCompositionFactory.fromJsonInputStream(inputStream, str));
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1218a = new b();
        this.f1219b = new c();
        this.f1221d = 0;
        this.f1222e = new LottieDrawable();
        this.f1226i = false;
        this.f1227j = false;
        this.f1228k = false;
        this.f1229l = false;
        this.f1230m = false;
        this.f1231n = true;
        this.f1232o = RenderMode.AUTOMATIC;
        this.f1233p = new HashSet();
        this.f1234q = 0;
        j(attributeSet, R.attr.lottieAnimationViewStyle);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f1218a = new b();
        this.f1219b = new c();
        this.f1221d = 0;
        this.f1222e = new LottieDrawable();
        this.f1226i = false;
        this.f1227j = false;
        this.f1228k = false;
        this.f1229l = false;
        this.f1230m = false;
        this.f1231n = true;
        this.f1232o = RenderMode.AUTOMATIC;
        this.f1233p = new HashSet();
        this.f1234q = 0;
        j(attributeSet, i4);
    }
}
